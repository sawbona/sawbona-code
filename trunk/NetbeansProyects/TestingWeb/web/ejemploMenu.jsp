<%-- 
    Document   : ejemploMenu
    Created on : 23-Jul-2009, 17:07:14
    Author     : jacob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo menus</title>
        <script src="dropdowntabs.js"></script>
    </head>
    <body>
        <div id="menuPrincipal" class="bluetabs">
            <ul>
                <li>
                    <a href="index.html" rel="submenuUno" title="Menu principal">
                        Menu principal
                    </a>
                </li>
            </ul>
        </div>
        <div id="submenuUno">
            <a href="index.html" title="Submenu uno">
                Elemento submenu
            </a>
        </div>
        <script type="text/javascript">
            tabdropdown.init("menuPrincipal");
        </script>
        <h1>Hello World!</h1>
    </body>
</html>
