<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="SilverApplesCSS.css">
<script type="text/javascript" src="SilverApplesJS.js"></script>
<title>Support</title>

<header>
<img src="Image/logga1.png" id="eventlogo">
<br>
</header>
</head>

<body>

<div class="topnav">
  <a href="Startpage.jsp">Startsida</a>
  <a href="Customer.jsp">Kund</a>
  <a class="active" href="Support.jsp">Support</a>
  <a href="Test.jsp">Test</a>
</div>

<section id="main">
<div class="supportPageContent">

<div class="containerSupport">
	<img src="Image/roger.png" alt="Personbild" class="pictures">
<p>Roger Grundare<br>admin@gmail.com<br>070-999 0101</p>
</div>

<div class="containerSupport">
	<img src="Image/astrid.png" alt="Personbild" class="pictures">
<p>Astrid Åberg<br>support@gmail.com<br>070-333 5050</p>
</div>

<div class="containerAccordion">
	<h3>FAQ</h3>
	<button class="accordion">Vilka är Supports öppettider?</button>
		<div class="panel">
  			<p>Mån-fre: 08:00 - 16:00<br>Lör: 10:00 - 14:00<br>Sön: Stängt</p>
		</div>

	<button class="accordion">Hur registrerar jag en Kund?</button>
		<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div>

	<button class="accordion">Hur registrerar jag en kund till ett Event?</button>
		<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div>

</div>

</div>
</section>

<script> 
var acc = document.getElementsByClassName("accordion");
for (var i = 0; i < acc.length; i++) {
	acc[i].addEventListener("click", function() {
		this.classList.toggle("active");
		var panel = this.nextElementSibling;
		if (panel.style.display === "block") {
			panel.style.display = "none";
		} else {
			panel.style.display = "block";
		}
	});
}
</script>

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