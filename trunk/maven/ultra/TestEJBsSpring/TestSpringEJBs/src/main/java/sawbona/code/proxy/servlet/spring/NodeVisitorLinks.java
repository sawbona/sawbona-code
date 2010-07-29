/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbona.code.proxy.servlet.spring;

import org.htmlparser.Tag;
import org.htmlparser.visitors.NodeVisitor;

/**
 *
 * @author jacob
 */
public class NodeVisitorLinks extends NodeVisitor {

    private String servletHome = "http://localhost:7001/test.spring/Proxy?id=";

    public String getServletHome() {
        return servletHome;
    }
    protected String baseVisitada = "http://elotrolado.net/";

    /**
     * Get the value of baseVisitada
     *
     * @return the value of baseVisitada
     */
    public String getBaseVisitada() {
        return baseVisitada;
    }

    /**
     * Set the value of baseVisitada
     *
     * @param baseVisitada new value of baseVisitada
     */
    public void setBaseVisitada(String baseVisitada) {
        this.baseVisitada = baseVisitada;
    }

    public void setServletHome(String servletHome) {
        this.servletHome = servletHome + "?id=";
    }

    @Override
    public void visitTag(Tag tag) {
        if (baseVisitada != null && !baseVisitada.endsWith("/")) {
            baseVisitada = baseVisitada + "/";
        }
        String nombreDelTag = tag.getTagName();
        if ("a".equalsIgnoreCase(nombreDelTag)) {
            String href = tag.getAttribute("href");
//            System.out.println("Encontrado: " + href);
            if (href != null) {
                tag.setAttribute("href", actualizaLink(href));
            }
        } else if ("img".equalsIgnoreCase(nombreDelTag)) {
            String src = tag.getAttribute("src");
            if (src != null) {
                tag.setAttribute("src", actualizaLink(src));
            }
        } else if(tag.getAttribute("href") != null){
            String href = tag.getAttribute("href");
            if(href != null){
                tag.setAttribute("href", actualizaLink(href));
            }
        }else if(tag.getAttribute("src") != null){
            String href = tag.getAttribute("src");
            if(href != null){
                tag.setAttribute("src", actualizaLink(href));
            }
        }else if(tag.getAttribute("action") != null){
            String href = tag.getAttribute("action");
            if(href != null){
                tag.setAttribute("action", actualizaLink(href));
            }
        }
    }

    private String actualizaLink(String href) {
        if (href.startsWith("http://")) {
            href = servletHome + href;
//            System.out.println("NUEVO HREF: " + href);
//            tag.setAttribute("href", href);
        } else if (href.startsWith("./")) {
            href = servletHome + baseVisitada + href.substring("./".length());
//            System.out.println("NUEVO HREF: " + href);
//            tag.setAttribute("href", href);
        } else if (href.startsWith("/")) {
            href = servletHome + baseVisitada + href.substring("/".length());
//            System.out.println("NUEVO HREF: " + href);
//            tag.setAttribute("href", href);
        } else {
            href = servletHome + baseVisitada + href;
//            System.out.println("NUEVO HREF: " + href);
        }
        return href;
    }
    /**
     *
     * final NodeVisitor linkVisitor = new NodeVisitor() {

    @Override
    public void visitTag(Tag tag) {
    String name = tag.getTagName();

    if ("a".equalsIgnoreCase(name)) {
    String hrefValue = tag.getAttribute("href");
    if (hrefValue != null && !hrefValue.startsWith("http://")) {
    if (!hrefValue.startsWith("/")) {
    hrefValue = "/" + hrefValue;
    }
    hrefValue = "http://javablogs.com" + hrefValue;
    //System.out.println("test, value="+hrefValue);
    }
    if (hrefValue != null) {
    hrefValue = hrefValue.replaceAll("&", "&amp;");
    tag.setAttribute("href", hrefValue);
    }
    }
    }
    };

    /**
     * Esta clase determina cuales de los nodos del html serán visitados
     * por el parser.
     */
//    NodeVisitor visitor = new NodeVisitor() {
//
//        @Override
//        public void visitTag(Tag tag) {
//            String name = tag.getTagName();
//            /**
//             * En este ejemplo los nodos que visita son aquellos cuyo nombre
//             * es span o class. Por ejemplo, el contenido de los siguientes
//             * tags/nodos seria visitado:
//             *
//            <div class="headerbar">
//            <div id="site-description">
//            <a href="./" title="ElOtroLado.net" id="logo">ElOtroLado.net</a>
//            <p class="hidden"><a href="#start_here">Saltar al contenido</a></p>
//            </div>
//             */
//            if ("span".equalsIgnoreCase(name) || "div".equalsIgnoreCase(name)) {
//                String classValue = tag.getAttribute("class");
////                LOGGER.debug("visittag name="+name+" class="+classValue+"children="+tag.getChildren().toHtml());
//                if ("blogentrydetails".equals(classValue)) {
//                    Pattern countPattern = Pattern.compile("Reads:\\s*([0-9]*)");
//                    Matcher matcher = countPattern.matcher(tag.getChildren().toHtml());
//                    if (matcher.find()) {
//                        String countStr = matcher.group(1);
//                        entry.count = new Integer(countStr).intValue();
//                    }
//
//                } else if ("headerbar".equals(classValue)) {
//                    try {
//                        tag.getChildren().visitAllNodesWith(linkVisitor);
//                    } catch (ParserException ex) {
//                        LOGGER.log(Level.SEVERE, null, ex);
//                    }
//                    entry.description = tag.getChildren().toHtml();
//                    entry.description = entry.description.replaceAll("\\s+", " ");
//                } else if ("blogentrytitle".equals(classValue)) {
//                    try {
//                        tag.getChildren().visitAllNodesWith(linkVisitor);
//                    } catch (ParserException pe) {
//                        LOGGER.log(Level.SEVERE, null, pe);
//                    }
//                    entry.title = tag.getChildren().toHtml();
//                    entry.title = entry.title.replaceAll("\\s+", " ");
//                }
//            }
//
//        }
//    };
}
