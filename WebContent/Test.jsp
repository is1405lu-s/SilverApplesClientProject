<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="silverApples.ejb.ics.Customer"%>

<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="SilverApplesCSS.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript" src="SilverApplesJS.js"></script>

<title>Test</title>

<header>
	<img src="Image/logga1.png" id="eventlogo">

	<div class="topnav">
		<a href="Startpage.jsp">Startsida</a> 
		<a href="Customer.jsp">Kund</a> 
		<a href="Support.jsp">Support</a>
		<a class="active" href="Test.jsp">Test</a>
	</div>

	<br>
</header>
</head>

<body>

	<section id="main">
		<p>
		Här kan du välja en eller flera av följande test:<br>
	</p>
	<form action="TestServlet" method="get" name="youPickItForm">
		<select id ="comboboxTest" name="suite" size="2" multiple>
			<option value="silverApples.junit.ics.TestCustomer">
				TestCustomer</option>
			<option value="silverApples.junit.ics.TestEvent">
				TestEvent</option>
			<option value="silverApples.junit.ics.TestAttending">
				TestAttending</option>
			<option value="silverApples.junit.ics.AllTests">
				AllTests</option>
		</select> <input type="submit" name="btnTest" id="btnTest" value="Run" />
	</form>
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