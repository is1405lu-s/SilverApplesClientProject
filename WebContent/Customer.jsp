<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="silverApples.ejb.ics.Customer"%>

<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="SilverApplesCSS.cs">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript" src="SilverApplesJS.js"></script>

<title>Customer</title>

<header>
	<img src="Image/logga1.png" id="eventlogo">

	<div class="topnav">
		<a href="Startpage.jsp">Startsida</a> 
		<a class="active" href="Customer.jsp">Kund</a> 
		<a href="Support.jsp">Support</a>
		<a href="Test.jsp">Test</a>
	</div>

	<br>
</header>
</head>

<body>

	<section id="main">

		<div class="custPageContent">

			<div class="formContainer">

				<p>Kund</p>

				<form id="formCust" method="post">
					<input type="text" name="txtPnr" id="txtPnr" maxlength="10" placeholder="Personnummer*">
					<input type="button" name="btnSearch" id="btnSearch" value="Sök kund"> 
						<br>
					<input type="text" name="txtName" id="txtName" maxlength="30" placeholder="Namn*"> 
					<input type="text" name="txtAddress" id="txtAddress" maxlength="30" placeholder="Adress*"> <br>
					<input type="text" name="txtPhone" id="txtPhone" maxlength="10" placeholder="Telefonnummer*"> 
					<input type="text" name="txtMail" id="txtMail" maxlength="50" placeholder="Email*">
						<br> 
					<input type="button" name="btnCreate" id="btnCreate" value="Skapa"> 
					<input type="button" name="btnDelete" id="btnDelete" value="Ta bort"> 
						<br> 
					<label id="lblAddCust">Lägg kund till Event:</label> 
						<br>
					<select name="comboboxEvent" id="comboboxEvent"> </select>
					 <input type="button" name="btnAddEvent" id="btnAddEvent" value="Lägg till">
					<!-- <input name="operation" value="showcustomer" type="hidden"> -->
					<br>
					<input type="text" name="txtFeedback" id="txtFeedback" readonly="readonly">
				</form>

			</div>

			<hr id="verticalLine">

			<div class="tableContainer">
			<br> <br>
				<div class="tableTabs">
					<button class="tablinks" onclick="openTable(event, 'TableFuture')">Framtida Event</button>
					<button class="tablinks" onclick="openTable(event, 'TablePast')">Tidigare Event</button>
				</div>

				<div id="TableFuture" class="tabcontent">

					<table id="TableFutureEvents" class="table">
						<thead>
							<tr>
								<th>Eventnamn</th>
								<th>Tidpunkt</th>
								<th>Pris</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>

				<div id="TablePast" class="tabcontent">
					<table id="TablePastEvents" class="table">
						<thead>
							<tr>
								<th>Eventnamn</th>
								<th>Tidpunkt</th>
								<th>Pris</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>

		</div>

	</section>

	<footer>
		<hr id="hrFooter">
		<div class="footerContent">
			<div class="containerFooter">
				<p> 
				  Kontakt<br>admin@info.se<br>+4640 0101 444 
				</p>
			</div>
			<div class="containerFooter">
				<p>
					Organisationsnummer: <br>0101010101001010
				</p>
			</div>
		</div>
	</footer>
	<p id="copyright">Copyright 2018 admin</p>
</body>
</html>