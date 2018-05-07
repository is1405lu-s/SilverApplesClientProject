$(document).ready(
		function() {
			$("#btnSearch").click(function() {
				var fnElement = $("#txtPnr"); // get textfield
				var cPnr = fnElement.val(); // get value from textfield
				if (cPnr == null || cPnr == "") { // value blank?
					fnElement.attr("placeholder", "Fyll i personnummer.");
					return;
				}

				var fnElement = $("#txtName");
				fnElement.val("");
				var fnElement1 = $("#txtAddress");
				fnElement1.val("");
				var fnElement2 = $("#txtPhoneNo");
				fnElement2.val("");
				var fnElement3 = $("#txtEmail");
				fnElement3.val("");
				var fnElement4 = $("#TableFutureEvents");
				$('#TableFutureEvents tbody > tr').remove(); //rensa tabellen, förutom headern
				var fnElement5 = $("#TablePastEvents");
				$('#TablePastEvents tbody > tr').remove(); //rensa tabellen, förutom headern
				
				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_findcustomer",
						cPnr : cPnr
					},
					error : ajax_findReturnError,
					success : ajax_findReturn_Success
				})
			});

			function ajax_findReturn_Success(c, status, xhr) {

				var fnElement = $("#txtName");
				var fnElement1 = $("#txtAddress");
				var fnElement2 = $("#txtPhoneNo");
				var fnElement3 = $("#txtEmail");
				var fnElement4 = $("#TableFutureEvents");
				var fnElement5 = $("#TablePastEvents");
				var feedback = $("#customerFeedback");

				console.log(c);
				var obj = JSON.parse(c);
				console.log(obj);

				fnElement.val(obj[0]);
				fnElement1.val(obj[1]);
				fnElement2.val(obj[2]);
				fnElement3.val(obj[3]);

				for (var i = 0; i < obj[4].length; i++) {
					fnElement4.find('tbody').append(
							$('<tr>').append($('<td>').append(obj[4][i++]))
									.append($('<td>').append(obj[4][i++]))
									.append($('<td>').append(obj[4][i])));
				}

				for (var i = 0; i < obj[5].length; i++) {
					fnElement5.find('tbody').append(
							$('<tr>').append($('<td>').append(obj[5][i++]))
									.append($('<td>').append(obj[5][i++]))
									.append($('<td>').append(obj[5][i])));
				}

				feedback.attr("value", "Kund hittades.");

			}
			function ajax_findReturnError(result, status, xhr) {
				var feedback = $("#customerFeedback");
				feedback.attr("value", "Kunden hittades inte.");
			}

			$("#btnCreate").click(function() {

				var fnElement1 = $("#txtPnr"); // get textfield
				var cPnr = fnElement1.val(); // get value from textfield
				var fnElement2 = $("#txtName"); // get textfield
				var cName = fnElement2.val(); // get value from textfield
				var fnElement3 = $("#txtAddress"); // get textfield
				var cAddress = fnElement3.val(); // get value from textfield
				var fnElement4 = $("#txtPhoneNo"); // get textfield
				var cPhoneNo = fnElement4.val(); // get value from textfield
				var fnElement5 = $("#txtEmail"); // get textfield
				var cEmail = fnElement4.val(); // get value from textfield
				var feedback = $("#customerFeedback");

				if (cPnr == null || cPnr == "") { // value blank?
					fnElement1.attr("placeholder", "Fyll i personnummer.");
					return;
				}
				if (cName == null || cName == "") { // value blank?
					fnElement2.attr("placeholder", "Fyll i namn.");
					return;
				}
				if (cPhoneNo == null || cPhoneNo == "") { // value blank?
					fnElement3.attr("placeholder", "Fyll i telefonnummer.");
					return;
				}
				if (cEmail == null || cEmail == "") { // value blank?
					fnElement4.attr("placeholder", "Fyll i email.");
					return;
				}
				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_createcustomer",
						"cPnr" : cPnr,
						"cName" : cName,
						"cAddress" : cAddress,
						"cPhoneNo" : cPhoneNo,
						"cEmail" : cEmail
					},
					error : ajax_createReturnError,
					success : ajax_createReturn_Success
				})
			});
			function ajax_createReturn_Success(c, status, xhr) {
				var feedback = $("#customerFeedback");
				feedback.attr("value", "Kunden skapades.");
			}
			function ajax_createReturnError(result, status, xhr) {
				var feedback = $("#customerFeedback");
				feedback.attr("value", "Kunden kunde inte skapas.");
			}

			$("#btnDelete").click(function() {
				var answer = confirm("Är du säker?");
				if (answer == true) {
					var fnElement = $("#txtPnr"); // get textfield
					var cPnr = fnElement.val(); // get value from textfield
					var feedback = $("#customerFeedback");

					if (cPnr == null || cPnr == "") { // value blank?
						fnElement.attr("placeholder", "Fyll i personnummer.");
						return;
					}

					$.ajax({
						method : "POST",
						url : "/SilverApplesClientProject/SilverApplesServlet",
						data : {
							operation : "ajax_deletecustomer",
							cPnr : cPnr
						},
						error : ajax_deleteReturnError,
						success : ajax_deleteReturn_Success
					})
				} else {
					feedback.attr("value", "Handlingen ångrades. Inget skedde.");
				}

			});

			function ajax_deleteReturn_Success(c, status, xhr) {
				var fnElement = $("#txtPnr")
				fnElement.val("");
				var fnElement1 = $("#txtName");
				fnElemen1.val("");
				var fnElement2 = $("#txtAddress");
				fnElement2.val("");
				var fnElement3 = $("#txtPhoneNo");
				fnElement3.val("");
				var fnElement4 = $("#txtEmail");
				fnElement4.val("");
				
				var feedback = $("#customerFeedback");
				feedback.attr("value", "Kunden togs bort.");

			}
			function ajax_deleteReturnError(result, status, xhr) {
				var feedback = $("#customerFeedback");
				feedback.attr("value", "Kunden kunde inte tas bort.");
			}

			$(function() {
				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_eventcombobox",
					},
					error : ajax_comboboxReturn_Error,
					success : ajax_comboboxReturn_Success
				})
			});

			function ajax_comboboxReturn_Success(c, status, xhr) {
				var fnElement = $("#comboboxEvent");

				var obj = JSON.parse(c);

				for (var i = 0; i < obj.length; i++) {
					fnElement.append($('<option>').append(obj[i]));
				}

			}

			function ajax_comboboxReturn_Error(c, status, xhr) {
				var feedback = $("#customerFeedback");
				feedback.attr("value", "Comboboxen kunde inte laddas.");
			}

			$("#btnAddEvent").click(function() {
				var fnElement1 = $("#txtPnr"); // get textfield
				var cPnr = fnElement1.val(); // get value from textfield
				if (cPnr == null || cPnr == "") { // value blank?
					fnElement1.attr("placeholder", "Fyll i personnummer.");
					return;
				}

				var fnElement2 = $("#comboboxEvent");
				var event = fnElement2.val(); // get value from textfield

				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_addtoevent",
						cPnr : cPnr,
						event : event
					},
					error : ajax_addToEventReturn_Error,
					success : ajax_addToEventReturn_Success
				})
			});

			function ajax_addToEventReturn_Success(c, status, xhr) {
				var feedback = $("#customerFeedback");
				feedback.attr("value", "Kunden lades till på event. Sök på kund för att uppdatera tabellerna.");

			}

			function ajax_addToEventReturn_Error(c, status, xhr) {
				var feedback = $("#customerFeedback");
				feedback.attr("value", "Kunden kunde inte läggas till på event.");
			}

		});