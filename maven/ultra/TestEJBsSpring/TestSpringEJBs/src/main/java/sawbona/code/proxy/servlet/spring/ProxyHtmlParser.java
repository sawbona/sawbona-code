/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbona.code.proxy.servlet.spring;

import java.util.logging.Logger;
import org.htmlparser.Parser;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.lexer.Page;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 *
 * @author jacob
 */
public class ProxyHtmlParser {

    /**
     * Logger de la instancia
     */
    public static final Logger LOGGER = Logger.getLogger(ProxyHtmlParser.class.getName());

    public String parseEntry(final String original, String id, String servletHomeURL) throws ParserException {
        Parser parser = new Parser(new Lexer(new Page(original, "UTF-8")));
        NodeList list = parser.parse(null);
        NodeVisitorLinks worker = new NodeVisitorLinks();
        worker.setBaseVisitada(id);
        worker.setServletHome(servletHomeURL);
        list.visitAllNodesWith(worker);
//        for(Node node = todos.){
//
//        }
//        NodeList heads = todos.extractAllNodesThatMatch(new TagNameFilter("head"));
//        if (heads.size() > 0) // there may not be a HEAD tag
//        {
//            Node head = heads.elementAt(0); // there should be only one
////            head.removeAll(); // clean out the contents
//            Tag title = new TitleTag();
//            title.setTagName("title");
//            title.setChildren(new NodeList(new TextNode("The New Title")));
//            Tag title_end = new TitleTag();
//            title_end.setTagName("/title");
//            title.setEndTag(title_end);
////            head.add(title);
//        }
        return list.toHtml(); // output the modified HTML
    }
}
