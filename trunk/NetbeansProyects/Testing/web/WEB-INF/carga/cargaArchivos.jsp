<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%-- 
    Document   : CargaArchivos
    Created on : 16-Jul-2009, 12:22:48
    Author     : jacob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carga archivos</title>
    </head>
    <body>
        <html:form action="/ArchivoA" enctype="multipart/form-data">
            <table align="center" width="100%">
                <tr>
                    <td>
                        Cargar archivo
                    </td>
                    <td>
                        <html:file property="archivo"/>
                    </td>
                </tr>
            </table>
            <html:submit property="accion" value="Importar Reactivos"/>
        </html:form>
    </body>
</html>
