










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Usuarios</title>
        <link rel="stylesheet" href="/serpaweb/css/serpaprosa.css" type="text/css">
        <script type="text/javascript" src="/serpaweb/scripts/serpaprosa.js"></script>

        <base href="http://132.147.160.232:8080/serpaweb/WEB-INF/tiles/LayoutPrincipal.jsp">
        <script>
<!--
function openHelp(aQuestion, aWidth, aHeight, aScrollbar,URL) {
		helpWindow = window.open(URL, "newWin", "toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=" + aScrollbar + ",resizable=no,width=" + aWidth + ",height=" + aHeight);
		if (helpWindow.opener == null) helpWindow.opener = self;
}


function summitProcess(mensaje,URL,form){
	var sMessage = mensaje;

	question = confirm(sMessage)
	if (question) {
	    document.forms[form].action = "/serpaweb" + URL;
        document.forms[form].submit();
//	}else{
//        return 0;
    }
}
function summitProcess2(URL,form){

    document.forms[form].action = "/serpaweb" + URL;
    document.forms[form].submit();

}

function popWindow(URL){
 window.open("/serpaweb" + URL,"","width=700,height=500,menubar=yes");
}

function confirmaBorrar(boton,radio){
    document.getElementById('buttonSubmit').value = "Nuevo Registro";
    if (boton == "Eliminar" && ningunoElegido(radio)) {
        alert("Seleccione un registro.");
        return false;
    }
    if (boton == "Eliminar") {
        var msg = "¿Está seguro de querer eliminar el registro?\n"
                + "Oprima Aceptar para borrar.\n"
                + "Oprima Cancelar para NO borrar.";
        return confirm(msg);
    }
}
function ningunoElegido(radio) {
    for(var i = 0; i < radio.length; i++) {
	if(radio[i].checked) {
            return false;
        }
    }
    return true;
}

function abrirVentana(URL){
  window.open(URL,'new', "toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=0,width=300,height=400");
}
//-->

</script>
        <script language=JavaScript>
var datePickerDivID = "datepicker";
var iFrameDivID = "datepickeriframe";

var dayArrayShort = new Array('Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa');
var dayArrayMed = new Array('Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab');
var dayArrayLong = new Array('Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado');
var monthArrayShort = new Array('En', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic');
var monthArrayMed = new Array('Ene', 'Feb', 'Mar', 'Abr', 'May', 'Junio', 'Julio', 'Ago', 'Sept', 'Oct', 'Nov', 'Dic');
var monthArrayLong = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre');

// these variables define the date formatting we're expecting and outputting.
// If you want to use a different format by default, change the defaultDateSeparator
// and defaultDateFormat variables either here or on your HTML page.
var defaultDateSeparator = "/";        // common values would be "/" or "."
var defaultDateFormat = "dmy"    // valid values are "mdy", "dmy", and "ymd"
var dateSeparator = defaultDateSeparator;
var dateFormat = defaultDateFormat;


function displayDatePicker(dateFieldName, displayBelowThisObject, dtFormat, dtSep)
{
  var targetDateField = document.getElementsByName (dateFieldName).item(0);

  // if we weren't told what node to display the datepicker beneath, just display it
  // beneath the date field we're updating
  if (!displayBelowThisObject)
    displayBelowThisObject = targetDateField;

  // if a date separator character was given, update the dateSeparator variable
  if (dtSep)
    dateSeparator = dtSep;
  else
    dateSeparator = defaultDateSeparator;

  // if a date format was given, update the dateFormat variable
  if (dtFormat)
    dateFormat = dtFormat;
  else
    dateFormat = defaultDateFormat;

  var x = displayBelowThisObject.offsetLeft;
  var y = displayBelowThisObject.offsetTop + displayBelowThisObject.offsetHeight ;

  // deal with elements inside tables and such
  var parent = displayBelowThisObject;
  while (parent.offsetParent) {
    parent = parent.offsetParent;
    x += parent.offsetLeft;
    y += parent.offsetTop ;
  }

  drawDatePicker(targetDateField, x, y);
}


/**
Draw the datepicker object (which is just a table with calendar elements) at the
specified x and y coordinates, using the targetDateField object as the input tag
that will ultimately be populated with a date.

This function will normally be called by the displayDatePicker function.
*/
function drawDatePicker(targetDateField, x, y)
{
  var dt = getFieldDate(targetDateField.value );

  // the datepicker table will be drawn inside of a <div> with an ID defined by the
  // global datePickerDivID variable. If such a div doesn't yet exist on the HTML
  // document we're working with, add one.
  if (!document.getElementById(datePickerDivID)) {
    // don't use innerHTML to update the body, because it can cause global variables
    // that are currently pointing to objects on the page to have bad references
    //document.body.innerHTML += "<div id='" + datePickerDivID + "' class='dpDiv'></div>";
    var newNode = document.createElement("div");
    newNode.setAttribute("id", datePickerDivID);
    newNode.setAttribute("class", "dpDiv");
    newNode.setAttribute("style", "visibility: hidden;");
    document.body.appendChild(newNode);
  }

  // move the datepicker div to the proper x,y coordinate and toggle the visiblity
  var pickerDiv = document.getElementById(datePickerDivID);
  pickerDiv.style.position = "absolute";
  pickerDiv.style.left = x + "px";
  pickerDiv.style.top = y + "px";
  pickerDiv.style.visibility = (pickerDiv.style.visibility == "visible" ? "hidden" : "visible");
  pickerDiv.style.display = (pickerDiv.style.display == "block" ? "none" : "block");
  pickerDiv.style.zIndex = 10000;

  // draw the datepicker table
  refreshDatePicker(targetDateField.name, dt.getFullYear(), dt.getMonth(), dt.getDate());
}


/**
This is the function that actually draws the datepicker calendar.
*/
function refreshDatePicker(dateFieldName, year, month, day)
{
  // if no arguments are passed, use today's date; otherwise, month and year
  // are required (if a day is passed, it will be highlighted later)
  var thisDay = new Date();

  if ((month >= 0) && (year > 0)) {
    thisDay = new Date(year, month, 1);
  } else {
    day = thisDay.getDate();
    thisDay.setDate(1);
  }

  // the calendar will be drawn as a table
  // you can customize the table elements with a global CSS style sheet,
  // or by hardcoding style and formatting elements below
  var crlf = "\r\n";
  var TABLE = "<table cols=7 class='dpTable'>" + crlf;
  var xTABLE = "</table>" + crlf;
  var TR = "<tr class='dpTR'>";
  var TR_title = "<tr class='dpTitleTR'>";
  var TR_days = "<tr class='dpDayTR'>";
  var TR_todaybutton = "<tr class='dpTodayButtonTR'>";
  var xTR = "</tr>" + crlf;
  var TD = "<td class='dpTD' onMouseOut='this.className=\"dpTD\";' onMouseOver=' this.className=\"dpTDHover\";' ";    // leave this tag open, because we'll be adding an onClick event
  var TD_title = "<td colspan=5 class='dpTitleTD'>";
  var TD_buttons = "<td class='dpButtonTD'>";
  var TD_todaybutton = "<td colspan=7 class='dpTodayButtonTD'>";
  var TD_days = "<td class='dpDayTD'>";
  var TD_selected = "<td class='dpDayHighlightTD' onMouseOut='this.className=\"dpDayHighlightTD\";' onMouseOver='this.className=\"dpTDHover\";' ";    // leave this tag open, because we'll be adding an onClick event
  var xTD = "</td>" + crlf;
  var DIV_title = "<div class='dpTitleText'>";
  var DIV_selected = "<div class='dpDayHighlight'>";
  var xDIV = "</div>";

  // start generating the code for the calendar table
  var html = TABLE;

  // this is the title bar, which displays the month and the buttons to
  // go back to a previous month or forward to the next month
  html += TR_title;
  html += TD_buttons + getButtonCode(dateFieldName, thisDay, -1, "&lt;") + xTD;
  html += TD_title + DIV_title + monthArrayLong[ thisDay.getMonth()] + " " + thisDay.getFullYear() + xDIV + xTD;
  html += TD_buttons + getButtonCode(dateFieldName, thisDay, 1, "&gt;") + xTD;
  html += xTR;

  // this is the row that indicates which day of the week we're on
  html += TR_days;
  for(i = 0; i < dayArrayShort.length; i++)
    html += TD_days + dayArrayShort[i] + xTD;
  html += xTR;

  // now we'll start populating the table with days of the month
  html += TR;

  // first, the leading blanks
  for (i = 0; i < thisDay.getDay(); i++)
    html += TD + "&nbsp;" + xTD;

  // now, the days of the month
  do {
    dayNum = thisDay.getDate();
    TD_onclick = " onclick=\"updateDateField('" + dateFieldName + "', '" + getDateString(thisDay) + "');\">";

    if (dayNum == day)
      html += TD_selected + TD_onclick + DIV_selected + dayNum + xDIV + xTD;
    else
      html += TD + TD_onclick + dayNum + xTD;

    // if this is a Saturday, start a new row
    if (thisDay.getDay() == 6)
      html += xTR + TR;

    // increment the day
    thisDay.setDate(thisDay.getDate() + 1);
  } while (thisDay.getDate() > 1)

  // fill in any trailing blanks
  if (thisDay.getDay() > 0) {
    for (i = 6; i > thisDay.getDay(); i--)
      html += TD + "&nbsp;" + xTD;
  }
  html += xTR;

  // add a button to allow the user to easily return to today, or close the calendar
  var today = new Date();
  var todayString = "Today is " + dayArrayMed[today.getDay()] + ", " + monthArrayMed[ today.getMonth()] + " " + today.getDate();
  html += TR_todaybutton + TD_todaybutton;
  html += "<button class='dpTodayButton' onClick='refreshDatePicker(\"" + dateFieldName + "\");'>este mes</button> ";
  html += "<button class='dpTodayButton' onClick='updateDateField(\"" + dateFieldName + "\");'>cerrar</button>";
  html += xTD + xTR;

  // and finally, close the table
  html += xTABLE;

  document.getElementById(datePickerDivID).innerHTML = html;
  // add an "iFrame shim" to allow the datepicker to display above selection lists
  adjustiFrame();
}


/**
Convenience function for writing the code for the buttons that bring us back or forward
a month.
*/
function getButtonCode(dateFieldName, dateVal, adjust, label)
{
  var newMonth = (dateVal.getMonth () + adjust) % 12;
  var newYear = dateVal.getFullYear() + parseInt((dateVal.getMonth() + adjust) / 12);
  if (newMonth < 0) {
    newMonth += 12;
    newYear += -1;
  }

  return "<button class='dpButton' onClick='refreshDatePicker(\"" + dateFieldName + "\", " + newYear + ", " + newMonth + ");'>" + label + "</button>";
}


/**
Convert a JavaScript Date object to a string, based on the dateFormat and dateSeparator
variables at the beginning of this script library.
*/
function getDateString(dateVal)
{
  var dayString = "00" + dateVal.getDate();
  var monthString = "00" + (dateVal.getMonth()+1);
  dayString = dayString.substring(dayString.length - 2);
  monthString = monthString.substring(monthString.length - 2);

  switch (dateFormat) {
    case "dmy" :
      return dayString + dateSeparator + monthString + dateSeparator + dateVal.getFullYear();
    case "ymd" :
      return dateVal.getFullYear() + dateSeparator + monthString + dateSeparator + dayString;
    case "mdy" :
    default :
      return monthString + dateSeparator + dayString + dateSeparator + dateVal.getFullYear();
  }
}


/**
Convert a string to a JavaScript Date object.
*/
function getFieldDate(dateString)
{
  var dateVal;
  var dArray;
  var d, m, y;

  try {
    dArray = splitDateString(dateString);
    if (dArray) {
      switch (dateFormat) {
        case "dmy" :
          d = parseInt(dArray[0], 10);
          m = parseInt(dArray[1], 10) - 1;
          y = parseInt(dArray[2], 10);
          break;
        case "ymd" :
          d = parseInt(dArray[2], 10);
          m = parseInt(dArray[1], 10) - 1;
          y = parseInt(dArray[0], 10);
          break;
        case "mdy" :
        default :
          d = parseInt(dArray[1], 10);
          m = parseInt(dArray[0], 10) - 1;
          y = parseInt(dArray[2], 10);
          break;
      }
      dateVal = new Date(y, m, d);
    } else if (dateString) {
      dateVal = new Date(dateString);
    } else {
      dateVal = new Date();
    }
  } catch(e) {
    dateVal = new Date();
  }

  return dateVal;
}


/**
Try to split a date string into an array of elements, using common date separators.
If the date is split, an array is returned; otherwise, we just return false.
*/
function splitDateString(dateString)
{
  var dArray;
  if (dateString.indexOf("/") >= 0)
    dArray = dateString.split("/");
  else if (dateString.indexOf(".") >= 0)
    dArray = dateString.split(".");
  else if (dateString.indexOf("-") >= 0)
    dArray = dateString.split("-");
  else if (dateString.indexOf("\\") >= 0)
    dArray = dateString.split("\\");
  else
    dArray = false;

  return dArray;
}

function updateDateField(dateFieldName, dateString)
{
  var targetDateField = document.getElementsByName (dateFieldName).item(0);
  if (dateString)
    targetDateField.value = dateString;

  var pickerDiv = document.getElementById(datePickerDivID);
  pickerDiv.style.visibility = "hidden";
  pickerDiv.style.display = "none";

  adjustiFrame();
  targetDateField.focus();

  // after the datepicker has closed, optionally run a user-defined function called
  // datePickerClosed, passing the field that was just updated as a parameter
  // (note that this will only run if the user actually selected a date from the datepicker)
  if ((dateString) && (typeof(datePickerClosed) == "function"))
    datePickerClosed(targetDateField);
}


function adjustiFrame(pickerDiv, iFrameDiv)
{
  // we know that Opera doesn't like something about this, so if we
  // think we're using Opera, don't even try
  var is_opera = (navigator.userAgent.toLowerCase().indexOf("opera") != -1);
  if (is_opera)
    return;

  // put a try/catch block around the whole thing, just in case
  try {
    if (!document.getElementById(iFrameDivID)) {
      // don't use innerHTML to update the body, because it can cause global variables
      // that are currently pointing to objects on the page to have bad references
      //document.body.innerHTML += "<iframe id='" + iFrameDivID + "' src='javascript:false;' scrolling='no' frameborder='0'>";
      var newNode = document.createElement("iFrame");
      newNode.setAttribute("id", iFrameDivID);
      newNode.setAttribute("src", "javascript:false;");
      newNode.setAttribute("scrolling", "no");
      newNode.setAttribute ("frameborder", "0");
      document.body.appendChild(newNode);
    }

    if (!pickerDiv)
      pickerDiv = document.getElementById(datePickerDivID);
    if (!iFrameDiv)
      iFrameDiv = document.getElementById(iFrameDivID);

    try {
      iFrameDiv.style.position = "absolute";
      iFrameDiv.style.width = pickerDiv.offsetWidth;
      iFrameDiv.style.height = pickerDiv.offsetHeight ;
      iFrameDiv.style.top = pickerDiv.style.top;
      iFrameDiv.style.left = pickerDiv.style.left;
      iFrameDiv.style.zIndex = pickerDiv.style.zIndex - 1;
      iFrameDiv.style.visibility = pickerDiv.style.visibility ;
      iFrameDiv.style.display = pickerDiv.style.display;
    } catch(e) {
    }

  } catch (ee) {
  }

}


</script>

<style>
body {
	font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
	font-size: .8em;
	}

/* the div that holds the date picker calendar */
.dpDiv {
	}


/* the table (within the div) that holds the date picker calendar */
.dpTable {
	font-family: Tahoma, Arial, Helvetica, sans-serif;
	font-size: 12px;
	text-align: center;
	color: #505050;
	background-color: #ece9d8;
	border: 1px solid #AAAAAA;
	}


/* a table row that holds date numbers (either blank or 1-31) */
.dpTR {
	}


/* the top table row that holds the month, year, and forward/backward buttons */
.dpTitleTR {
	}


/* the second table row, that holds the names of days of the week (Mo, Tu, We, etc.) */
.dpDayTR {
	}


/* the bottom table row, that has the "This Month" and "Close" buttons */
.dpTodayButtonTR {
	}


/* a table cell that holds a date number (either blank or 1-31) */
.dpTD {
	border: 1px solid #ece9d8;
	}


/* a table cell that holds a highlighted day (usually either today's date or the current date field value) */
.dpDayHighlightTD {
	background-color: #CCCCCC;
	border: 1px solid #AAAAAA;
	}


/* the date number table cell that the mouse pointer is currently over (you can use contrasting colors to make it apparent which cell is being hovered over) */
.dpTDHover {
	background-color: #aca998;
	border: 1px solid #888888;
	cursor: pointer;
	color: red;
	}


/* the table cell that holds the name of the month and the year */
.dpTitleTD {
	}


/* a table cell that holds one of the forward/backward buttons */
.dpButtonTD {
	}


/* the table cell that holds the "This Month" or "Close" button at the bottom */
.dpTodayButtonTD {
	}


/* a table cell that holds the names of days of the week (Mo, Tu, We, etc.) */
.dpDayTD {
	background-color: #CCCCCC;
	border: 1px solid #AAAAAA;
	color: white;
	}


/* additional style information for the text that indicates the month and year */
.dpTitleText {
	font-size: 12px;
	color: gray;
	font-weight: bold;
	}


/* additional style information for the cell that holds a highlighted day (usually either today's date or the current date field value) */
.dpDayHighlight {
	color: 4060ff;
	font-weight: bold;
	}


/* the forward/backward buttons at the top */
.dpButton {
	font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: gray;
	background: #d8e8ff;
	font-weight: bold;
	padding: 0px;
	}


/* the "This Month" and "Close" buttons at the bottom */
.dpTodayButton {
	font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: gray;
	background: #d8e8ff;
	font-weight: bold;
	}
</style>
        <script type="text/javascript">
function friendlyPrinter(titulo,encabezado)
{
    var currentTime = new Date();
    var month = currentTime.getMonth() + 1;
    var day = currentTime.getDate();
    var year = currentTime.getFullYear();
    var hours = currentTime.getHours();
    var minutes = currentTime.getMinutes();
    if (minutes < 10){
       minutes = "0" + minutes;
    }

    var Title = titulo;
    var Header = encabezado;
    var disp_settings="toolbar=no,location=no,directories=no,menubar=no,";
    disp_settings+="scrollbars=yes,width=650, height=600, left=100, top=25";
    var content_value = document.getElementById("print_content").innerHTML;
    var docprint=window.open("","",disp_settings);
    docprint.document.open();
    docprint.document.write('<html><head>');
    docprint.document.write('<title>');
    docprint.document.write(Title);
    docprint.document.write('</title>');
    docprint.document.write('<link rel=stylesheet type="text/css" href="./css/friendlyPrinter.css">');
    docprint.document.write('</head>');
    docprint.document.write('<body>');
    docprint.document.write('<div style="text-align:left"><a href="#" onclick="window.print();"><div class="noLink">IMPRIMIR </div></a></div>');
    docprint.document.write('<div style="text-align:left"><img src="./imagenes/Encabezado_de_pagina_MM.jpg" width="600" height="80"></div>');

    docprint.document.write('<table border="0" CELLPADDING=0 CELLSPACING=0 width="600px">');
    docprint.document.write('<TR>');
    docprint.document.write('<TD align="center">');
    docprint.document.write('<h3>'+ Header +'</h3>');
    docprint.document.write('</TD>');
    docprint.document.write('<TD align="right">');
    docprint.document.write(day + "/" +month  + "/" + year );
    docprint.document.write('</TD>');
    docprint.document.write('</TR>');
    docprint.document.write('<TR>');
    docprint.document.write('<TD></TD><TD align="right">'+ hours + ":" + minutes +"</TD");
    docprint.document.write('</TR>');
    docprint.document.write('</table>');

    docprint.document.write('<div class="contenidoTabla">');
    docprint.document.write(content_value);
    docprint.document.write('</div>');
    docprint.document.write('<table width="600px"><TR>');
    docprint.document.write('<div style="text-align:right"><img src="./imagenes/Pie_de_pagina_GNP.bmp" width="200" height="70"></div>');
    docprint.document.write('</TR></table>');
    docprint.document.write('</body></html>');
    docprint.document.close();
    docprint.focus();
}


</script>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  <script language=JavaScript>
var datePickerDivID = "datepicker";
var iFrameDivID = "datepickeriframe";

var dayArrayShort = new Array('Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa');
var dayArrayMed = new Array('Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab');
var dayArrayLong = new Array('Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado');
var monthArrayShort = new Array('En', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic');
var monthArrayMed = new Array('Ene', 'Feb', 'Mar', 'Abr', 'May', 'Junio', 'Julio', 'Ago', 'Sept', 'Oct', 'Nov', 'Dic');
var monthArrayLong = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre');

// these variables define the date formatting we're expecting and outputting.
// If you want to use a different format by default, change the defaultDateSeparator
// and defaultDateFormat variables either here or on your HTML page.
var defaultDateSeparator = "/";        // common values would be "/" or "."
var defaultDateFormat = "dmy"    // valid values are "mdy", "dmy", and "ymd"
var dateSeparator = defaultDateSeparator;
var dateFormat = defaultDateFormat;


function displayDatePickerStruts(targetDateField, displayBelowThisObject, dtFormat, dtSep)
{

  // if we weren't told what node to display the datepicker beneath, just display it
  // beneath the date field we're updating
  if (!displayBelowThisObject)
    displayBelowThisObject = targetDateField;

  // if a date separator character was given, update the dateSeparator variable
  if (dtSep)
    dateSeparator = dtSep;
  else
    dateSeparator = defaultDateSeparator;

  // if a date format was given, update the dateFormat variable
  if (dtFormat)
    dateFormat = dtFormat;
  else
    dateFormat = defaultDateFormat;

  var x = displayBelowThisObject.offsetLeft;
  var y = displayBelowThisObject.offsetTop + displayBelowThisObject.offsetHeight ;

  // deal with elements inside tables and such
  var parent = displayBelowThisObject;
  while (parent.offsetParent) {
    parent = parent.offsetParent;
    x += parent.offsetLeft;
    y += parent.offsetTop ;
  }

  drawDatePicker(targetDateField, x, y);
}


/**
Draw the datepicker object (which is just a table with calendar elements) at the
specified x and y coordinates, using the targetDateField object as the input tag
that will ultimately be populated with a date.

This function will normally be called by the displayDatePicker function.
*/
function drawDatePicker(targetDateField, x, y)
{
  var dt = getFieldDate(targetDateField.value );

  // the datepicker table will be drawn inside of a <div> with an ID defined by the
  // global datePickerDivID variable. If such a div doesn't yet exist on the HTML
  // document we're working with, add one.
  if (!document.getElementById(datePickerDivID)) {
    // don't use innerHTML to update the body, because it can cause global variables
    // that are currently pointing to objects on the page to have bad references
    //document.body.innerHTML += "<div id='" + datePickerDivID + "' class='dpDiv'></div>";
    var newNode = document.createElement("div");
    newNode.setAttribute("id", datePickerDivID);
    newNode.setAttribute("class", "dpDiv");
    newNode.setAttribute("style", "visibility: hidden;");
    document.body.appendChild(newNode);
  }

  // move the datepicker div to the proper x,y coordinate and toggle the visiblity
  var pickerDiv = document.getElementById(datePickerDivID);
  pickerDiv.style.position = "absolute";
  pickerDiv.style.left = x + "px";
  pickerDiv.style.top = y + "px";
  pickerDiv.style.visibility = (pickerDiv.style.visibility == "visible" ? "hidden" : "visible");
  pickerDiv.style.display = (pickerDiv.style.display == "block" ? "none" : "block");
  pickerDiv.style.zIndex = 10000;

  // draw the datepicker table
  refreshDatePicker(targetDateField.name, dt.getFullYear(), dt.getMonth(), dt.getDate());
}


/**
This is the function that actually draws the datepicker calendar.
*/
function refreshDatePicker(dateFieldName, year, month, day)
{
  // if no arguments are passed, use today's date; otherwise, month and year
  // are required (if a day is passed, it will be highlighted later)
  var thisDay = new Date();

  if ((month >= 0) && (year > 0)) {
    thisDay = new Date(year, month, 1);
  } else {
    day = thisDay.getDate();
    thisDay.setDate(1);
  }

  // the calendar will be drawn as a table
  // you can customize the table elements with a global CSS style sheet,
  // or by hardcoding style and formatting elements below
  var crlf = "\r\n";
  var TABLE = "<table cols=7 class='dpTable'>" + crlf;
  var xTABLE = "</table>" + crlf;
  var TR = "<tr class='dpTR'>";
  var TR_title = "<tr class='dpTitleTR'>";
  var TR_days = "<tr class='dpDayTR'>";
  var TR_todaybutton = "<tr class='dpTodayButtonTR'>";
  var xTR = "</tr>" + crlf;
  var TD = "<td class='dpTD' onMouseOut='this.className=\"dpTD\";' onMouseOver=' this.className=\"dpTDHover\";' ";    // leave this tag open, because we'll be adding an onClick event
  var TD_title = "<td colspan=5 class='dpTitleTD'>";
  var TD_buttons = "<td class='dpButtonTD'>";
  var TD_todaybutton = "<td colspan=7 class='dpTodayButtonTD'>";
  var TD_days = "<td class='dpDayTD'>";
  var TD_selected = "<td class='dpDayHighlightTD' onMouseOut='this.className=\"dpDayHighlightTD\";' onMouseOver='this.className=\"dpTDHover\";' ";    // leave this tag open, because we'll be adding an onClick event
  var xTD = "</td>" + crlf;
  var DIV_title = "<div class='dpTitleText'>";
  var DIV_selected = "<div class='dpDayHighlight'>";
  var xDIV = "</div>";

  // start generating the code for the calendar table
  var html = TABLE;

  // this is the title bar, which displays the month and the buttons to
  // go back to a previous month or forward to the next month
  html += TR_title;
  html += TD_buttons + getButtonCode(dateFieldName, thisDay, -1, "&lt;") + xTD;
  html += TD_title + DIV_title + monthArrayLong[ thisDay.getMonth()] + " " + thisDay.getFullYear() + xDIV + xTD;
  html += TD_buttons + getButtonCode(dateFieldName, thisDay, 1, "&gt;") + xTD;
  html += xTR;

  // this is the row that indicates which day of the week we're on
  html += TR_days;
  for(i = 0; i < dayArrayShort.length; i++)
    html += TD_days + dayArrayShort[i] + xTD;
  html += xTR;

  // now we'll start populating the table with days of the month
  html += TR;

  // first, the leading blanks
  for (i = 0; i < thisDay.getDay(); i++)
    html += TD + "&nbsp;" + xTD;

  // now, the days of the month
  do {
    dayNum = thisDay.getDate();
    TD_onclick = " onclick=\"updateDateField('" + dateFieldName + "', '" + getDateString(thisDay) + "');\">";

    if (dayNum == day)
      html += TD_selected + TD_onclick + DIV_selected + dayNum + xDIV + xTD;
    else
      html += TD + TD_onclick + dayNum + xTD;

    // if this is a Saturday, start a new row
    if (thisDay.getDay() == 6)
      html += xTR + TR;

    // increment the day
    thisDay.setDate(thisDay.getDate() + 1);
  } while (thisDay.getDate() > 1)

  // fill in any trailing blanks
  if (thisDay.getDay() > 0) {
    for (i = 6; i > thisDay.getDay(); i--)
      html += TD + "&nbsp;" + xTD;
  }
  html += xTR;

  // add a button to allow the user to easily return to today, or close the calendar
  var today = new Date();
  var todayString = "Today is " + dayArrayMed[today.getDay()] + ", " + monthArrayMed[ today.getMonth()] + " " + today.getDate();
  html += TR_todaybutton + TD_todaybutton;
  html += "<button class='dpTodayButton' onClick='refreshDatePicker(\"" + dateFieldName + "\");'>este mes</button> ";
  html += "<button class='dpTodayButton' onClick='updateDateField(\"" + dateFieldName + "\");'>cerrar</button>";
  html += xTD + xTR;

  // and finally, close the table
  html += xTABLE;

  document.getElementById(datePickerDivID).innerHTML = html;
  // add an "iFrame shim" to allow the datepicker to display above selection lists
  adjustiFrame();
}


/**
Convenience function for writing the code for the buttons that bring us back or forward
a month.
*/
function getButtonCode(dateFieldName, dateVal, adjust, label)
{
  var newMonth = (dateVal.getMonth () + adjust) % 12;
  var newYear = dateVal.getFullYear() + parseInt((dateVal.getMonth() + adjust) / 12);
  if (newMonth < 0) {
    newMonth += 12;
    newYear += -1;
  }

  return "<button class='dpButton' onClick='refreshDatePicker(\"" + dateFieldName + "\", " + newYear + ", " + newMonth + ");'>" + label + "</button>";
}


/**
Convert a JavaScript Date object to a string, based on the dateFormat and dateSeparator
variables at the beginning of this script library.
*/
function getDateString(dateVal)
{
  var dayString = "00" + dateVal.getDate();
  var monthString = "00" + (dateVal.getMonth()+1);
  dayString = dayString.substring(dayString.length - 2);
  monthString = monthString.substring(monthString.length - 2);

  switch (dateFormat) {
    case "dmy" :
      return dayString + dateSeparator + monthString + dateSeparator + dateVal.getFullYear();
    case "ymd" :
      return dateVal.getFullYear() + dateSeparator + monthString + dateSeparator + dayString;
    case "mdy" :
    default :
      return monthString + dateSeparator + dayString + dateSeparator + dateVal.getFullYear();
  }
}


/**
Convert a string to a JavaScript Date object.
*/
function getFieldDate(dateString)
{
  var dateVal;
  var dArray;
  var d, m, y;

  try {
    dArray = splitDateString(dateString);
    if (dArray) {
      switch (dateFormat) {
        case "dmy" :
          d = parseInt(dArray[0], 10);
          m = parseInt(dArray[1], 10) - 1;
          y = parseInt(dArray[2], 10);
          break;
        case "ymd" :
          d = parseInt(dArray[2], 10);
          m = parseInt(dArray[1], 10) - 1;
          y = parseInt(dArray[0], 10);
          break;
        case "mdy" :
        default :
          d = parseInt(dArray[1], 10);
          m = parseInt(dArray[0], 10) - 1;
          y = parseInt(dArray[2], 10);
          break;
      }
      dateVal = new Date(y, m, d);
    } else if (dateString) {
      dateVal = new Date(dateString);
    } else {
      dateVal = new Date();
    }
  } catch(e) {
    dateVal = new Date();
  }

  return dateVal;
}


/**
Try to split a date string into an array of elements, using common date separators.
If the date is split, an array is returned; otherwise, we just return false.
*/
function splitDateString(dateString)
{
  var dArray;
  if (dateString.indexOf("/") >= 0)
    dArray = dateString.split("/");
  else if (dateString.indexOf(".") >= 0)
    dArray = dateString.split(".");
  else if (dateString.indexOf("-") >= 0)
    dArray = dateString.split("-");
  else if (dateString.indexOf("\\") >= 0)
    dArray = dateString.split("\\");
  else
    dArray = false;

  return dArray;
}

function updateDateField(dateFieldName, dateString)
{
  var targetDateField = document.getElementsByName (dateFieldName).item(0);
  if (dateString)
    targetDateField.value = dateString;

  var pickerDiv = document.getElementById(datePickerDivID);
  pickerDiv.style.visibility = "hidden";
  pickerDiv.style.display = "none";

  adjustiFrame();
  targetDateField.focus();

  // after the datepicker has closed, optionally run a user-defined function called
  // datePickerClosed, passing the field that was just updated as a parameter
  // (note that this will only run if the user actually selected a date from the datepicker)
  if ((dateString) && (typeof(datePickerClosed) == "function"))
    datePickerClosed(targetDateField);
}


function adjustiFrame(pickerDiv, iFrameDiv)
{
  // we know that Opera doesn't like something about this, so if we
  // think we're using Opera, don't even try
  var is_opera = (navigator.userAgent.toLowerCase().indexOf("opera") != -1);
  if (is_opera)
    return;

  // put a try/catch block around the whole thing, just in case
  try {
    if (!document.getElementById(iFrameDivID)) {
      // don't use innerHTML to update the body, because it can cause global variables
      // that are currently pointing to objects on the page to have bad references
      //document.body.innerHTML += "<iframe id='" + iFrameDivID + "' src='javascript:false;' scrolling='no' frameborder='0'>";
      var newNode = document.createElement("iFrame");
      newNode.setAttribute("id", iFrameDivID);
      newNode.setAttribute("src", "javascript:false;");
      newNode.setAttribute("scrolling", "no");
      newNode.setAttribute ("frameborder", "0");
      document.body.appendChild(newNode);
    }

    if (!pickerDiv)
      pickerDiv = document.getElementById(datePickerDivID);
    if (!iFrameDiv)
      iFrameDiv = document.getElementById(iFrameDivID);

    try {
      iFrameDiv.style.position = "absolute";
      iFrameDiv.style.width = pickerDiv.offsetWidth;
      iFrameDiv.style.height = pickerDiv.offsetHeight ;
      iFrameDiv.style.top = pickerDiv.style.top;
      iFrameDiv.style.left = pickerDiv.style.left;
      iFrameDiv.style.zIndex = pickerDiv.style.zIndex - 1;
      iFrameDiv.style.visibility = pickerDiv.style.visibility ;
      iFrameDiv.style.display = pickerDiv.style.display;
    } catch(e) {
    }

  } catch (ee) {
  }

}


</script>

<style>
body {
	font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
	font-size: .8em;
	}

/* the div that holds the date picker calendar */
.dpDiv {
	}


/* the table (within the div) that holds the date picker calendar */
.dpTable {
	font-family: Tahoma, Arial, Helvetica, sans-serif;
	font-size: 12px;
	text-align: center;
	color: #505050;
	background-color: #ece9d8;
	border: 1px solid #AAAAAA;
	}


/* a table row that holds date numbers (either blank or 1-31) */
.dpTR {
	}


/* the top table row that holds the month, year, and forward/backward buttons */
.dpTitleTR {
	}


/* the second table row, that holds the names of days of the week (Mo, Tu, We, etc.) */
.dpDayTR {
	}


/* the bottom table row, that has the "This Month" and "Close" buttons */
.dpTodayButtonTR {
	}


/* a table cell that holds a date number (either blank or 1-31) */
.dpTD {
	border: 1px solid #ece9d8;
	}


/* a table cell that holds a highlighted day (usually either today's date or the current date field value) */
.dpDayHighlightTD {
	background-color: #CCCCCC;
	border: 1px solid #AAAAAA;
	}


/* the date number table cell that the mouse pointer is currently over (you can use contrasting colors to make it apparent which cell is being hovered over) */
.dpTDHover {
	background-color: #aca998;
	border: 1px solid #888888;
	cursor: pointer;
	color: red;
	}


/* the table cell that holds the name of the month and the year */
.dpTitleTD {
	}


/* a table cell that holds one of the forward/backward buttons */
.dpButtonTD {
	}


/* the table cell that holds the "This Month" or "Close" button at the bottom */
.dpTodayButtonTD {
	}


/* a table cell that holds the names of days of the week (Mo, Tu, We, etc.) */
.dpDayTD {
	background-color: #CCCCCC;
	border: 1px solid #AAAAAA;
	color: white;
	}


/* additional style information for the text that indicates the month and year */
.dpTitleText {
	font-size: 12px;
	color: gray;
	font-weight: bold;
	}


/* additional style information for the cell that holds a highlighted day (usually either today's date or the current date field value) */
.dpDayHighlight {
	color: 4060ff;
	font-weight: bold;
	}


/* the forward/backward buttons at the top */
.dpButton {
	font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: gray;
	background: #d8e8ff;
	font-weight: bold;
	padding: 0px;
	}


/* the "This Month" and "Close" buttons at the bottom */
.dpTodayButton {
	font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: gray;
	background: #d8e8ff;
	font-weight: bold;
	}
</style>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword">
    </head>
    <body>
        <div id="containerPrincipal"/>
        <!--
            <div id="principalbanner"></div>
        -->
        <div id="header">






<div id="principalbanner">
<div id="div_infoheader">
        <table width="100%">
            <tr>

                <td width="48%" align="left" >
                    Usuario: Chandra Nichdali&nbsp; Quintas&nbsp; De la Parra
                </td>
                <td width="55%" align="left" >
                    Suc. Pana:
                        México&nbsp;


                </td>
            </tr>
        </table>
    </div>

    <div id="div_infoheader2">
        <table width="100%">
            <tr>
                <td  align="left">
                    Banco/Serpa: CITIBANK&nbsp;
                </td>
            </tr>
        </table>
    </div>
</div>
        </div>

        <div id="menuPrincipal">
















<link rel="stylesheet" type="text/css" media="screen"
      href="/serpaweb/css/coolmenu.css" />

<script type="text/javascript" src="/serpaweb/scripts/coolmenus4.js"></script>
<script type="text/javascript" src="/serpaweb/scripts/cm_addins.js"></script>

<!-- Custom Configuration for this example, must come after body to work in IE -->
<script type="text/javascript" src="/serpaweb/scripts/coolmenu4-config.js"></script>

    <script type="text/javascript">



                                                                oCMenu.makeMenu('menuprincipal','','Módulos','','');
                                                                                        oCMenu.makeMenu('administracion','menuprincipal','Administración','','');
                                                                                        oCMenu.makeMenu('privilegios','administracion','Privilegios','','');
                                                                                 oCMenu.makeMenu('serpa000008','privilegios','Actualización','/serpaweb/IniciaPrivilegiosA.do?modulo=asignaprivilegios','');
                                                                                                                          oCMenu.makeMenu('usuario','administracion','Usuarios','','');
                                                                                 oCMenu.makeMenu('serpa000001','usuario','Alta','/serpaweb/IniciaUsuariosA.do?modulo=altausuario','');
                                                                                               oCMenu.makeMenu('serpa000003','usuario','Consulta','/serpaweb/IniciaUsuariosA.do?modulo=criteriosusuario','');
                                                                                                                          oCMenu.makeMenu('solicitudes','administracion','Solicitudes Usuarios','','');
                                                                                 oCMenu.makeMenu('serpa000012','solicitudes','Actualización','/serpaweb/IniciaSolicitudesA.do?modulo=consultarSolicitudes','');
                                                                                                                          oCMenu.makeMenu('maqbloq','administracion','Bloqueos','','');
                                                                                 oCMenu.makeMenu('serpa000024','maqbloq','Desbloquear Máquinas','/serpaweb/IniciaConsultaMaqsBloquedasA.do?modulo=maquinasBloqeadas','');
                                                                                                                          oCMenu.makeMenu('sucursales','administracion','Asociar Bancos','','');
                                                                                 oCMenu.makeMenu('serpa000028','sucursales','Actualizacion','/serpaweb/IniciaAdmonSucursalesPanamericanoA.do?modulo=adminSucPanamericano','');
                                                                                                                                              oCMenu.makeMenu('operacion','menuprincipal','Operacion','','');
                                                                                        oCMenu.makeMenu('concentracion','operacion','Concentraciones','','');
                                                                                 oCMenu.makeMenu('serpa000013','concentracion','Alta','/serpaweb/IniciaSolicitudConcentracionA.do?modulo=solicitarConcentracion','');
                                                                                               oCMenu.makeMenu('serpa000015','concentracion','Consulta','/serpaweb/IniciaSolicitudConcentracionA.do?modulo=consultarConcentraciones','');
                                                                                                                          oCMenu.makeMenu('dotacion','operacion','Dotaciones','','');
                                                                                        oCMenu.makeMenu('dotacion_alta','dotacion','Alta','','');
                                                                                 oCMenu.makeMenu('serpa000017','dotacion_alta','Por Detalle','/serpaweb/IniciaDotacionA.do?modulo=registrarDotacion','');
                                                                                               oCMenu.makeMenu('serpa000018','dotacion_alta','Por Importe','/serpaweb/IniciaDotacionA.do?modulo=registrarDotacionImporte','');
                                                                                                                   oCMenu.makeMenu('serpa000019','dotacion','Consulta','/serpaweb/IniciaCriterioDotacionA.do?modulo=criteriodotaciones','');
                                                                                                                          oCMenu.makeMenu('reportes','operacion','Reportes','','');
                                                                                        oCMenu.makeMenu('reportes_verificacion','reportes','Verificación','','');
                                                                                 oCMenu.makeMenu('serpa000029','reportes_verificacion','Consolidado Verif.','/serpaweb/IniciaReporteA.do?modulo=criteriosConsolidado','');
                                                                                               oCMenu.makeMenu('serpa000030','reportes_verificacion','Entradas Procesadas','/serpaweb/IniciaReporteA.do?modulo=criteriosEntradasProcesadas','');
                                                                                                                          oCMenu.makeMenu('reportes_caja','reportes','Caja','','');
                                                                                 oCMenu.makeMenu('serpa000031','reportes_caja','Flujo de efectivo','/serpaweb/IniciaReporteA.do?modulo=criteriosFlujoEfectivo','');
                                                                                                                          oCMenu.makeMenu('reportes_salidas','reportes','Salidas','','');
                                                                                 oCMenu.makeMenu('serpa000032','reportes_salidas','Salidas Procesadas','/serpaweb/IniciaReporteA.do?modulo=salidasProcesadas','');
                                                                                                                                              oCMenu.makeMenu('cargaarchivo','operacion','Carga archivos','','');
                                                                                 oCMenu.makeMenu('serpa000033','cargaarchivo','Cargar Archivos','/serpaweb/IniciaCargarArchivoA.do?modulo=cargarArchivos','');
                                                                                               oCMenu.makeMenu('serpa000034','cargaarchivo','Descarga de Archivos','/serpaweb/IniciaCargarArchivoA.do?modulo=descargarArchivos','');





                                                         oCMenu.makeMenu('cambiarcont','','Cambiar contraseña','/serpaweb/IniciaCambioContraseniaA.do?modulo=cambioContrasenia','');





                                                         oCMenu.makeMenu('paginicial','','Página inicial','/serpaweb/Home.jsp','');





                                                         oCMenu.makeMenu('salir','','Salir','/serpaweb/SalidaA.do','');



                    oCMenu.construct();
    </script>







        </div>
        <div id="body">









<script type="text/javascript">
    function enviaForma(nombreForma, valorBotonOprimido){
        var forma = document.getElementsByName(nombreForma);
        var boton = document.getElementById('botonOprimido');
        if(forma && boton){
            boton.value = valorBotonOprimido;
            forma[0].submit();
        }
    }
</script>

<form name="ListaUsuarioAF" method="post" action="/serpaweb/ListaUsuarioA.do" onsubmit="return confirmaEliminacion()">


    <center>
        <table width="80%">
            <tr>
                <td>

                        <br><br><br>
                        <table border="1" width="100%">
                            <tr>
                                <td class="cabeceraTabla" colspan="7" >
                                    <center>Lista Usuarios</center>
                                </td>
                            </tr>
                            <tr class="cabeceraTablaUsuarios">
                                <td colspan="1"></td>
                                <td>Nusuario</td>
                                <td>Nombre</td>
                                <td>Ap. Paterno</td>
                                <td>Banco/Serpa:</td>
                                <td>Suc Banco/Dep. Serpa:</td>
                                <td>Estado</td>
                            </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="1">
                                            </td>
                                            <td>
                                                1
                                            </td>
                                            <td>
                                                Ophir
                                            </td>
                                            <td>
                                                Mendez
                                            </td>
                                            <td>

                                                    BANCO DE MEXICO


                                            </td>
                                            <td>

                                                    B Azteca Tijuana Las Torres


                                            </td>
                                            <td>
                                                Fuera-línea
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="2">
                                            </td>
                                            <td>
                                                2
                                            </td>
                                            <td>
                                                Ophir
                                            </td>
                                            <td>
                                                Mendez
                                            </td>
                                            <td>

                                                    HSBC


                                            </td>
                                            <td>

                                                    Salamanca


                                            </td>
                                            <td>
                                                Solicitando Token
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="3">
                                            </td>
                                            <td>
                                                3
                                            </td>
                                            <td>
                                                Isaac
                                            </td>
                                            <td>
                                                Orihuela
                                            </td>
                                            <td>

                                                    SERPAPROSA


                                            </td>
                                            <td>

                                                    Sin dependencia


                                            </td>
                                            <td>
                                                Fuera-línea
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="4">
                                            </td>
                                            <td>
                                                4
                                            </td>
                                            <td>
                                                Chandra Nichdali
                                            </td>
                                            <td>
                                                Quintas
                                            </td>
                                            <td>

                                                    CITIBANK


                                            </td>
                                            <td>

                                                    León Obregón


                                            </td>
                                            <td>
                                                En línea
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="5">
                                            </td>
                                            <td>
                                                5
                                            </td>
                                            <td>
                                                Carlos Jacob
                                            </td>
                                            <td>
                                                Lobaco
                                            </td>
                                            <td>

                                                    SERPAPROSA


                                            </td>
                                            <td>

                                                    Sin dependencia


                                            </td>
                                            <td>
                                                Fuera-línea
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="6">
                                            </td>
                                            <td>
                                                6
                                            </td>
                                            <td>
                                                Juan
                                            </td>
                                            <td>
                                                Gomez
                                            </td>
                                            <td>

                                                    BANCO DE MEXICO


                                            </td>
                                            <td>

                                                    Cd. Altamira Tamaulipas


                                            </td>
                                            <td>
                                                Fuera-línea
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="7">
                                            </td>
                                            <td>
                                                7
                                            </td>
                                            <td>
                                                Ricardo
                                            </td>
                                            <td>
                                                Rodriguez
                                            </td>
                                            <td>

                                                    BANCO DE MEXICO


                                            </td>
                                            <td>

                                                    Cd. Altamira Tamaulipas


                                            </td>
                                            <td>
                                                Fuera-línea
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="8">
                                            </td>
                                            <td>
                                                8
                                            </td>
                                            <td>
                                                Jacob
                                            </td>
                                            <td>
                                                Lobaco
                                            </td>
                                            <td>

                                                    BANCO DE MEXICO


                                            </td>
                                            <td>

                                                    TM Cd. Juarez S


                                            </td>
                                            <td>
                                                registrado
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="9">
                                            </td>
                                            <td>
                                                9
                                            </td>
                                            <td>
                                                Alma
                                            </td>
                                            <td>
                                                Hernandez
                                            </td>
                                            <td>

                                                    BANCO DE MEXICO


                                            </td>
                                            <td>

                                                    B Azteca Tijuana Las Torres


                                            </td>
                                            <td>
                                                Fuera-línea
                                            </td>
                                        </tr>



                                        <tr>
                                            <td  align="center">
                                                <input type="radio" name="claveUsuarioSeleccionada" value="10">
                                            </td>
                                            <td>
                                                10
                                            </td>
                                            <td>
                                                Ernesto
                                            </td>
                                            <td>
                                                Hernández
                                            </td>
                                            <td>

                                                    BANCO DE MEXICO


                                            </td>
                                            <td>

                                                    Cd. Altamira Tamaulipas


                                            </td>
                                            <td>
                                                Fuera-línea
                                            </td>
                                        </tr>




















































                            </table>


                            <TABLE width="100%" border="0">

                                <TR align="left">

                                        <TD align="left" WIDTH="50">

                                        </TD>
                                        <TD align="center" >

                                                &nbsp;
                                                <font color="black" style="font-size:16px" > 1</font>


                                                &nbsp;
                                                <a href="/serpaweb/listaUsuarios.do?pager.offset=10"><font color="#15317E" style="font-size:16px" >
                                                        <u>2</u>
                                                    </font></a>


                                                &nbsp;
                                                <a href="/serpaweb/listaUsuarios.do?pager.offset=20"><font color="#15317E" style="font-size:16px" >
                                                        <u>3</u>
                                                    </font></a>


                                                &nbsp;
                                                <a href="/serpaweb/listaUsuarios.do?pager.offset=30"><font color="#15317E" style="font-size:16px" >
                                                        <u>4</u>
                                                    </font></a>


                                        </TD>
                                        <TD align="left" WIDTH="50">

                                                <a href="/serpaweb/listaUsuarios.do?pager.offset=10"><font color="#15317E">[Siguiente&gt;&gt;]</font></a>

                                        </TD>

                                </TR>
                            </TABLE>

                            <div class="bloque" style="text-align:center;">
                                <table width="100%">
                                    <tr align="center">

                                            <td>
                                                <input type="submit" name="buttonSubmit" value="Asoc. Suc Pana" onmouseover="this.bgColor='#0099CC'">
                                            </td>
                                            <td>
                                                <input type="submit" name="buttonSubmit" value="Desbloquear" onmouseover="this.bgColor='#0099CC'">
                                            </td>
                                            <td>
                                                <input type="submit" name="buttonSubmit" value="Cancelar Tokens" onmouseover="this.bgColor='#0099CC'">
                                            </td>
                                            <td>
                                                <input type="submit" name="buttonSubmit" value="Ver Detalles" onmouseover="this.bgColor='#0099CC'">
                                            </td>
                                            <td>

                                                    <input type="submit" name="buttonSubmit" value="Eliminar" onclick="javascript:document.ListaUsuarioAF.botonOprimido.value = 'Eliminar' ">

                                                <input type="hidden" name="botonOprimido"/>
                                            </td>
                                            <td>
                                                <input type="button" value="Fuera de línea" onclick="enviaForma('ListaUsuarioAF','fueraDeLinea');"/>
                                                <input type="hidden" name="buttonSubmit" value="" id="botonOprimido">
                                            </td>
                                            <td>

                                                    <input type="submit" name="buttonSubmit" value="Modificar">

                                            </td>

                                    </tr>
                                </table>
                            </div>
                            <!-- Botones de navegación -->
                            <table width="100%" border="0">
                                <tr>
                                    <td align="center"><input type="submit" name="buttonSubmit" value="Atras" class="navegacion"></td>

                                </tr>
                            </table>



                </td>
            </tr>
        </table>
    </center>


</form>


        </div>
        <!--tiles:insert attribute="footer"/-->

        <br>
    </body>
</html>
