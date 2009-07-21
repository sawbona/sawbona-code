<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<html>
    <head>
        <title>
            Prueba
        </title>
    </head>
    <body>
        <div>
            <a href="IniciaArchivoA.do">
                Carga un archivo
            </a>
            <a href="PruebaAppletA.do">
                Probar applet
            </a>
        </div>
            <logic:messagesPresent>
                <table>
                    <html:messages id="error">
                        <tr>
                            <td>
                                ${error}
                            </td>
                        </tr>
                    </html:messages>
                </table>
            </logic:messagesPresent>
            Contenido
        <div>
            Foot.
        </div>
    </body>
</html>