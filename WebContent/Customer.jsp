<!DOCTYPE html>

<%@ page import="silverApples.ejb.ics.Customer"%>

<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="SilverApplesCSS.css">
<script type="text/javascript" src="SilverApplesJS.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
		$(document).ready(function() {
			$("#btnSearch").click(function() {
			<!-- alert("OBS!") -->
				var fnElement = $("#txtPnr"); //get textfield
				var cPnr = fnElement.val(); //get value from textfield
				if (cPnr == null || cPnr == "") { //value blank?
					fnElement.attr("placeholder", "Customer id, please.");
					return;
				}
				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_findcustomer",
						cPnr : cPnr, 
						cAddress: "cAddress"
					},
					error : ajaxReturnError,
					success : ajaxReturn_Success
				})
			});
			function ajaxReturn_Success(c, status, xhr) {								
				var fnElement = $("#txtName");
				var fnElement1 = $("#txtAddress");
				
				console.log(c);
				var obj = JSON.parse(c);
				console.log(obj);
				
				fnElement.val(obj[0]);
				fnElement1.val(obj[1]);
				//fnElement1.val(list.get(1));
				
			}
			function ajaxReturnError(result, status, xhr) {
				console.log("Ajax-find customer: " + status);
			}
		});
	</script>

<!--
<script>
$(document).ready(function(){
    $("#btnSearch").click(function(){
        $("p").slideToggle();
    });
});
</script> -->

<title>Customer</title>

<header>
	<img src="Image/logga1.png" id="eventlogo">

	<div class="topnav">
		<a href="Startpage.jsp">Startsida</a> 
		<a href="Event.jsp">Event</a> 
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
					<input type="text" name="txtPnr" id="txtPnr" maxlength="10"
						placeholder="Personnummer"> <input type="button"
						name="btnSearch" id="btnSearch" value="Sök kund"> <br>

					<input type="text" name="txtName" id="txtName" maxlength="30"
						placeholder="Namn"> <input type="text" name="txtAddress"
						id="txtAddress" maxlength="30" placeholder="Address"> <br>
					<input type="text" name="txtPhoneNo" id="txtPhoneNo" maxlength="10"
						placeholder="Telefonnummer"> <input type="text"
						name="txtEmail" id="txtEmail" maxlength="50" placeholder="Email">
					<br> <input type="button" name="btnCreate" id="btnCreate"
						value="Skapa"> <input type="button" name="btnDelete"
						id="btnDelete" value="Ta bort"> <br> <label
						id="lblAddCust">Lägg kund till Event:</label> <br> <select
						name="comboboxEvent" id="comboboxEvent">
						<option>Programmering</option>
						<option>Film</option>
					</select> <input type="button" name="btnAddEvent" id="btnAddEvent"
						value="Lägg till">
					<!-- <input name="operation" value="showcustomer" type="hidden"> -->


				</form>

			</div>

			<hr id="verticalLine">

			<div class="tableContainer">
				<div class="tableTabs">
					<button class="tablinks" onclick="openTable(event, 'TableFuture')">Framtida
						Event</button>
					<button class="tablinks" onclick="openTable(event, 'TablePast')">Tidigare
						Event</button>
				</div>

				<div id="TableFuture" class="tabcontent">

					<table id="TableFutureEvents" class="table">
						<thead>
							<tr bgcolor="white">
								<th>Eventnamn</th>
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
							<tr>
								<td>rad2, kol1</td>
								<td>rad2, kol2</td>
								<td>rad2, kol3</td>
							</tr>
						</tbody>
					</table>
				</div>


				<div id="TablePast" class="tabcontent">
					<table id="TablePastEvents" class="table">
						<thead>
							<tr bgcolor="white">
								<th>Eventnamn</th>
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
								<td>rad2, kol1</td>
								<td>rad2, kol2</td>
								<td>rad2, kol3</td>
							</tr>
							<tr>
								<td>rad2, kol1</td>
								<td>rad2, kol2</td>
								<td>rad2, kol3</td>
							</tr>
							<tr>
								<td>rad2, kol1</td>
								<td>rad2, kol2</td>
								<td>rad2, kol3</td>
							</tr>
							<tr>
								<td>rad2, kol1</td>
								<td>rad2, kol2</td>
								<td>rad2, kol3</td>
							</tr>
							<tr>
								<td>rad2, kol1</td>
								<td>rad2, kol2</td>
								<td>rad2, kol3</td>
							</tr>
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