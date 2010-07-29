/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbona.code.proxy.servlet.spring;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.htmlparser.util.ParserException;

/**
 * Procesa las peticiones https.
 * @author jacob
 */
public class ProxyBean {

    protected ProxyHtmlParser parser;

    /**
     * Get the value of parser
     *
     * @return the value of parser
     */
    public ProxyHtmlParser getParser() {
        return parser;
    }

    /**
     * Set the value of parser
     *
     * @param parser new value of parser
     */
    public void setParser(ProxyHtmlParser parser) {
        this.parser = parser;
    }

    public void procesaHttps(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String datosEnviados = "1=1";
        boolean parametrosEnId = false;
        if (id == null) {
            id = "https://www.google.com";
        } else {
            int indexOf = id.indexOf("?");
            if (indexOf != -1) {
                parametrosEnId = true;
                String nuevoId = id.substring(0, indexOf);
                String parametros = id.substring(indexOf + 1);
                id = nuevoId;
                String[] llavesValores = parametros.split("&");
                for (String llaveValor : llavesValores) {
                    int indiceIgual = llaveValor.indexOf("=");
                    if (indiceIgual != -1) {
                        String llave = llaveValor.substring(0, indiceIgual);
                        String llaveEncode = URLEncoder.encode(llave, "UTF-8");
                        String valor = llaveValor.substring(indiceIgual + 1);
                        String valorEncode = URLEncoder.encode(valor, "UTF-8");
                        datosEnviados += "&" + llaveEncode + "=" + valorEncode;
                    }

                }
            }
        }
        URL url = new URL(id);
        /*
         * Obtenemos y enviamos los parametros que existan a la url solicitada
         */
        Map<String, String[]> llaveValor = request.getParameterMap();
        if (llaveValor != null) {
            Set<String> llaves = llaveValor.keySet();
            for (String llave : llaves) {
                if (llave.equals("id")) {
                    continue;
                }
                String llaveEncode = URLEncoder.encode(llave, "UTF-8");
                String[] valores = llaveValor.get(llave);
                for (String valor : valores) {
                    String valorEncode = URLEncoder.encode(valor, "UTF-8");
                    datosEnviados += "&" + llaveEncode + "=" + valorEncode;
                }
            }
        }
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        if ((llaveValor != null && llaveValor.size() > 1) || parametrosEnId) {
            /**
             * Escribimos los valores que recibimos
             */
            urlConnection.setDoOutput(true);
            OutputStreamWriter osw = new OutputStreamWriter(urlConnection.getOutputStream());
            osw.write(datosEnviados);
            osw.flush();
        }
//        System.out.println("Respuesta: " + urlConnection.getResponseMessage());
//        System.out.println("");
        /**
         * Verificamos que el contenttype de los objetos que nos estan pidiendo.
         */
        String contentType = urlConnection.getContentType();
//        System.out.println("CONTENT TYPE SOLICITADO: " + contentType);
        if (contentType.toLowerCase().contains("text/html")) {
            procesaHtml(urlConnection, response, id);
        } else {
            response.setContentType(contentType);
            procesaImagen(urlConnection, response, id);
        }
    }

    private String servletHomeURL;

    public void setServletHomeURL(String string) {
        this.servletHomeURL = string;
    }

    private void procesaHtml(HttpURLConnection urlConnection, HttpServletResponse response, String id) throws IOException {
        /**
         * Leemos la respuesta
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuffer respuestaSb = new StringBuffer();
        try {
            PrintWriter out = response.getWriter();
            while ((inputLine = in.readLine()) != null) {
                respuestaSb.append(inputLine);
            }
            inputLine = respuestaSb.toString();
            out.write(parser.parseEntry(inputLine, id, servletHomeURL));
        } catch (ParserException ex) {
            Logger.getLogger(ProxyBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            in.close();
            in.close();
        }
    }

    private void procesaImagen(HttpURLConnection urlConnection, HttpServletResponse response, String id) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(urlConnection.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        int b = -1;
        while((b = bis.read()) != -1){
            bos.write(b);
        }
        bis.close();
        bos.close();


    }
}
