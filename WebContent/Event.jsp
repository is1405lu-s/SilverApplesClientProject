<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="SilverApplesCSS.css">
<script type="text/javascript" src="SilverApplesJS.js"></script>
<title>Event</title>

<header>
<img src="Image/logga1.png" id="eventlogo">
<br>
</header>

</head>

<body>

<div class="topnav">
  <a href="Startpage.jsp">Startsida</a>
  <a class="active" href="Event.jsp">Event</a>
  <a href="Customer.jsp">Kund</a>
  <a href="Support.jsp">Support</a>
  <a href="Test.jsp">Test</a>
</div>

<section id="main">

<div class="eventPageContent">

<div class="formContainer">

<p>Event</p>

<form id="formEvent">
<input type= "text" name= "txtId" id= "txtId" maxlength= "10" placeholder= "Event ID">
<input type="button" name= "btnSearch" id= "btnSearch" value= "Sök event">
<br>
<input type= "text" name= "txtName" id= "txtName" maxlength= "30" placeholder= "Namn">
<input type= "text" name= "txtPrice" id= "txtPrice" maxlength= "5" placeholder= "Pris">
<br>
<input type="date" min="2018-01-01" max="2020-12-31" value="2018-01-01"/>
<input type="time" min="00" max="24" value="00:00"/>
<br>
<input type="button" name= "btnCreate" id= "btnCreate" value= "Skapa">
<input type="button" name= "btnDelete" id= "btnDelete" value= "Ta bort">
<br>

</form>

</div>

<hr id="verticalLine">

<div class="tableContainer">

<div class="tableTabs">
  <button class="tablinks" onclick="openTable(event, 'TableFuture')">Registrerade kunder</button>
  <button class="tablinks" onclick="openTable(event, 'TablePast')">Tidigare kunder</button>
</div>

<div id="TableFuture" class="tabcontent">
<table id= "TableFutureCustomers" class="table">
<thead>
<tr bgcolor="white">
<th>Kundnamn</th>
<th>Datum</th>
<th>Pris</th>
</tr>
</thead>
<tbody>
<tr>
<td>rad1, kol1</td>
<td>rad1, kol2</td>
<td>rad1, kol3</td>
</tr>
<tr>
<td>rad2, kol1</td>
<td>rad2, kol2</td>
<td>rad2, kol3</td>
</tr>
</tbody>
</table>
</div>


<div id="TablePast" class="tabcontent">
<table id= "TablePastCustomers" class="table">
<thead>
<tr bgcolor="white">
<th>Kundnamn</th>
<th>Datum</th>
<th>Pris</th>
</tr>
</thead>
<tbody>
<tr>
<td>ahysfdaj</td>
<td>rad1, kol2</td>
<td>rad1, kol3</td>
</tr>
<tr>
<td>anything</td>
<td>rad2, kol2</td>
<td>rad2, kol3</td>
</tr>
<tr>
<td>something</td>
<td>rad2, kol2</td>
<td>rad2, kol3</td>
</tr>
</tbody>
</table>
</div>

<input type="button" name="btnAddCertificate" id="btnAddCertificate" value="Lägg till certifikat">

</div>
</div>
</section>

<footer>
<hr id="hrFooter">
<div class="footerContent">
<div class="containerFooter">
  <p>Kontakt<br>admin@info.se<br>+4640 0101 444</p>
</div>
<div class="containerFooter">
  <p>Organisationsnummer: <br>0101010101001010</p>
</div>
</div>
</footer>
<p id="copyright">Copyright 2018 admin</p>
</body>
</html>