<html>
    <head>
        <title>
            Prueba Geolab HTML
        </title>
    </head>
    <body>
        Página para probar el applet GeoLab<br>
        <center>
            <applet
                archive = "GeoLab.jar"
                codebase = "${pageContext.request.contextPath}/"
                code     = "geolab.AppletGeolab.class"
                name     = "PruebaAppletGeolab"
                width    = "900"
                height   = "600"
                hspace   = "0"
                vspace   = "0"
                align    = "middle">
                <%--
                    <param name = "archivo" value = "DescargarArchivoA.do?id=trigonometria4.lab">
                --%>
                <param name = "archivo" value = "trigonometria4.lab"/>
                <param name = "propiedades" value = "geolab.properties"/>
            </applet>
        </center>
    </body>
</html>