<%@page pageEncoding="ISO-8859-1"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/dropdowntabs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/coolmenus4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/coolmenu4-config.js"></script>
<style>

            .dropmenudiv_b a {
                border-color:#918D8D;
                border-style:solid;
                border-width:0 0 1px;
                color:black;
                display:block;
                padding:2px 0;
                text-align:justify;
                text-decoration:none;
                text-indent:5px;
            }

</style>

<table width="100%" cellspacing="0" cellpadding="0" border="0" style="background-color:#EEEEEE">
    <tr>
        <td width="100%">

            <div id="bluemenu" class="bluetabs">
                <ul>
                            <li><a title="Catálogos" class="enlaceBarraIzq" rel="dropmenu1_b">Configuración</a></li>
                    <li><a style="background-image:none;" class="linkHoverMenu" href="${pageContext.request.contextPath}/ConsultaCatalogosA.do?action=consultaTemas" title="importarReactivos">elemento1</a> </li>
                    <li><a style="background-image:none;" class="linkHoverMenu" href="${pageContext.request.contextPath}/SalidaA.do" title="Salir">Salir</a></li>
                </ul>
            </div>

            <div id="dropmenu1_b" class="dropmenudiv_b">
                <a style="background-image:none;" class="linkHoverMenu" href="${pageContext.request.contextPath}/IniciaImportarExamenesA.do" >Importar Ex&aacute;menes</a>
                <a style="background-image:none;" class="linkHoverMenu" href="${pageContext.request.contextPath}/IniciaImportarReactivosA.do?modulo=importarReactivos">Importar Reactivos</a>
                <a style="background-image:none;" class="linkHoverMenu" href="${pageContext.request.contextPath}/IniciaImportarParametrosEstadisticos.do">
                        Importar Parámetros Estadísticos
                </a>
                <a style="background-image:none;" class="linkHoverMenu" href="${pageContext.request.contextPath}/IniciaPresentarTutorialA.do">
                        Presentar Tutorial
                </a>
            </div>


            <script type="text/javascript">
                tabdropdown.init("bluemenu");
            </script>
        </td>
    </tr>
</table>
