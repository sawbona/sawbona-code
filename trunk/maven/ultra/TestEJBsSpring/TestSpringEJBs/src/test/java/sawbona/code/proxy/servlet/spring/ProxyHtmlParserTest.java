/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbona.code.proxy.servlet.spring;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacob
 */
public class ProxyHtmlParserTest {

    public ProxyHtmlParserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parseEntry method, of class ProxyHtmlParser.
     */
    @Test
    public void testParseEntry() throws Exception {
        ProxyHtmlParser instancia = new ProxyHtmlParser();
        StringBuffer sb = new StringBuffer();
        InputStream resourceAsStream = ProxyHtmlParserTest.class.getClassLoader().getResourceAsStream("eol.html");
        BufferedReader dis = new BufferedReader(new InputStreamReader(resourceAsStream));
        String linea = null;
        while ((linea = dis.readLine()) != null) {
            sb.append(linea);
        }
        instancia.parseEntry(sb.toString(), "http://elotrolado.net", "http://localhost:7001/test.spring/Proxy");
    }
}