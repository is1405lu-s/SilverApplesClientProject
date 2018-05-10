<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="SilverApplesCSS.css">
<script type="text/javascript" src="SilverApplesJS.js"></script>
<title>Start Page</title>

<header>
<img src="Image/logga1.png" id="eventlogo">
<br>
</header>
</head>
<body>

<div class="topnav">
  <a class="active" href="Startpage.jsp">Startsida</a>
  <a href="Customer.jsp">Kund</a>
  <a href="Support.jsp">Support</a>
  <a href="Test.jsp">Test</a>
</div>

<section id="main">

<div class="startPageContent">

  <h2 id="titleStartPage">Kommande evenemang</h2>

  <div class="slideshowContainer" id="leftContainer">
  
   <div class="mySlides1" id="firstImage">
     <img src="Image/dans1.png" style="width:100%">
      <h2>Dans</h2>
      <p class="text">Datum: 2018-10-23 Tid: 16:30<br>Plats: Pildamsparken<br>Adress: Svangatan 3A 214 54 Malmö</p>
      <p><a href="Customer.jsp" class="registerButton">Registrera</button></a></p>
    </div>

  <div class="mySlides1">
    <img src="Image/dans.png" style="width:100%">
    <h2>Zumba</h2>
    <p class="text">Datum: 2018-10-01 Tid: 11:00<br>Plats: Pildamsparken<br>Adress: Svangatan 3A 214 54 Malmö</p>
    <p><a href="Customer.jsp" class="registerButton">Registrera</button></a></p>
  </div>

  <div class="mySlides1">
    <img src="Image/moderndans.jpg" style="width:100%">
    <h2>Modern Dans</h2>
    <p class="text">Datum: 2018-06-20 Tid: 17:00<br>Plats: Pildamsparken<br>Adress: Svangatan 3A 214 54 Malmö</p>
    <p><a href="Customer.jsp" class="registerButton">Registrera</button></a></p>
  </div>
  
  <a class="prev" onclick="plusSlides(-1, 0)">&#10094;</a>
  <a class="next" onclick="plusSlides(1, 0)">&#10095;</a>

</div>

<div class="slideshowContainer"  id="rightContainer">

  <div class="mySlides2" id="firstImage">
    <img src="Image/aerobic.jpg" style="width:100%">
    <h2>Aerobic</h2>
    <p class="text">Datum: 2018-09-24  Tid: 20:30<br>Plats: Slottsparken<br>Adress: Södragatan 5B 215 63 Lund</p>
    <p><a href="Customer.jsp" class="registerButton">Registrera</button></a></p>
  </div>

  <div class="mySlides2">
    <img src="Image/yoga.jpg" style="width:100%">
    <h2>Yoga</h2>
    <p class="text">Datum: 2018-06-02  Tid: 11:30<br>Plats: Gerdahallen<br>Adress: Södergatan 5B 215 63 Lund</p>
    <p><a href="Customer.jsp" class="registerButton">Registrera</button></a></p>
  </div>

  <div class="mySlides2">
    <img src="Image/swim.png" style="width:100%">
    <h2>Simning</h2>
    <p class="text">Datum: 2018-07-24  Tid: 14:00<br>Plats: Aq-va-kul<br>Adress: Regementsg 6 215 63 Malmö</p>
    <p><a href="Customer.jsp" class="registerButton">Registrera</button></a></p>
  </div>

  <a class="prev" onclick="plusSlides(-1, 1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1, 1)">&#10095;</a>

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