$(document).ready(
		function() {
			$("#btnSearch").click(function() {
				var txtPnr = $("#txtPnr"); // get textfield
				var cPnr = txtPnr.val(); // get value from textfield
				if (cPnr == null || cPnr == "") { // value blank?
					fnElement.attr("placeholder", "Fyll i personnummer.");
					return;
				}

				var txtName = $("#txtName");
				txtName.val("");
				var txtAddress = $("#txtAddress");
				txtAddress.val("");
				var txtPhone = $("#txtPhone");
				txtPhone.val("");
				var txtMail = $("#txtMail");
				txtMail.val("");
				var TableFutureEvents = $("#TableFutureEvents");
				$('#TableFutureEvents tbody > tr').remove(); //rensa tabellen, förutom headern
				var TablePastEvents = $("#TablePastEvents");
				$('#TablePastEvents tbody > tr').remove(); //rensa tabellen, förutom headern
				
				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_findCustomer",
						cPnr : cPnr
					},
					error : ajax_findCustomerError,
					success : ajax_findCustomerSuccess
				})
			});

			function ajax_findCustomerSuccess(result, status, xhr) {

				var txtName = $("#txtName");
				var txtAddress = $("#txtAddress");
				var txtPhone = $("#txtPhone");
				var txtMail = $("#txtMail");
				var TableFutureEvents = $("#TableFutureEvents");
				var TablePastEvents = $("#TablePastEvents");
				var txtFeedback = $("#txtFeedback");

				var list = JSON.parse(result);

				txtName.val(list[0]);
				txtAddress.val(list[1]);
				txtPhone.val(list[2]);
				txtMail.val(list[3]);

				for (var i = 0; i < list[4].length; i++) {
					TableFutureEvents.find('tbody').append(
							$('<tr>').append($('<td>').append(list[4][i++]))
									.append($('<td>').append(list[4][i++]))
									.append($('<td>').append(list[4][i])));
				}

				for (var i = 0; i < list[5].length; i++) {
					TablePastEvents.find('tbody').append(
							$('<tr>').append($('<td>').append(list[5][i++]))
									.append($('<td>').append(list[5][i++]))
									.append($('<td>').append(list[5][i])));
				}
				
				txtFeedback.css("color", "green");
				txtFeedback.attr("value", "Kund hittades.");

			}
			function ajax_findCustomerError(result, status, xhr) {
				var txtFeedback = $("#txtFeedback");
				txtFeedback.css("color", "red");
				txtFeedback.attr("value", "Kunden hittades inte.");
			}

			$("#btnCreate").click(function() {
				var txtPnr = $("#txtPnr"); // get textfield
				var cPnr = txtPnr.val(); // get value from textfield
				var txtName = $("#txtName");
				var cName = txtName.val();
				var txtAddress = $("#txtAddress");
				var cAddress = txtAddress.val();
				var txtPhone = $("#txtPhone");
				var cPhone = txtPhone.val();
				var txtMail = $("#txtMail");
				var cMail = txtMail.val();
				var txtFeedback = $("#txtFeedback");

				if (cPnr == null || cPnr == "") { // value blank?
					txtFeedback.css("color", "red");
					txtFeedback.attr("value", "Fyll i personnummer.");
					return;
				}
				if (cName == null || cName == "") { 
					txtFeedback.css("color", "red");
					txtFeedback.attr("value", "Fyll i namn.");
					return;
				}
				if (cAddress == null || cAddress == "") { 
					txtFeedback.css("color", "red");
					txtFeedback.attr("value", "Fyll i adress.");
					return;
				}
				if (cPhone == null || cPhone == "") { 
					txtFeedback.css("color", "red");
					txtFeedback.attr("value", "Fyll i telefonnummer.");
					return;
				}
				if (cMail == null || cMail == "") { 
					txtFeedback.css("color", "red");
					txtFeedback.attr("value", "Fyll i mail.");
					return;
				}
				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_createCustomer",
						"cPnr" : cPnr,
						"cName" : cName,
						"cAddress" : cAddress,
						"cPhone" : cPhone,
						"cMail" : cMail
					},
					error : ajax_createCustomerError,
					success : ajax_createCustomerSuccess
				})
			});
			function ajax_createCustomerSuccess(result, status, xhr) {
				var txtFeedback = $("#txtFeedback");
				txtFeedback.css("color", "green");
				txtFeedback.attr("value", "Kunden skapades.");
			}
			function ajax_createCustomerError(result, status, xhr) {
				var txtFeedback = $("#txtFeedback");
				txtFeedback.css("color", "red");
				txtFeedback.attr("value", "Kunden kunde inte skapas.");
			}

			$("#btnDelete").click(function() {
				var answer = confirm("Är du säker?");
				if (answer == true) {
					var txtPnr = $("#txtPnr"); // get textfield
					var cPnr = txtPnr.val(); // get value from textfield
					var txtFeedback = $("#txtFeedback");

					if (cPnr == null || cPnr == "") { // value blank?
						txtFeedback.css("color", "red");
						txtFeedback.attr("value", "Fyll i personnummer.");
						return;
					}

					$.ajax({
						method : "POST",
						url : "/SilverApplesClientProject/SilverApplesServlet",
						data : {
							operation : "ajax_deleteCustomer",
							cPnr : cPnr
						},
						error : ajax_deleteCustomerError,
						success : ajax_deleteCustomerSuccess
					})
				} 
			});

			function ajax_deleteCustomerSuccess(result, status, xhr) {
				var txtPnr = $("#txtPnr")
				txtPnr.val("");
				var txtName = $("#txtName");
				txtName.val("");
				var txtAddress = $("#txtAddress");
				txtAddress.val("");
				var txtPhone = $("#txtPhone");
				txtPhone.val("");
				var txtMail = $("#txtMail");
				txtMail.val("");
				$('#TableFutureEvents tbody > tr').remove(); //rensa tabellen, förutom headern
				$('#TablePastEvents tbody > tr').remove(); //rensa tabellen, förutom headern
				
				var txtFeedback = $("#txtFeedback");
				txtFeedback.css("color", "green");
				txtFeedback.attr("value", "Kunden togs bort.");

			}
			function ajax_deleteCustomerError(result, status, xhr) {
				var txtFeedback = $("#txtFeedback");
				txtFeedback.css("color", "red");
				txtFeedback.attr("value", "Kunden kunde inte tas bort.");
			}

			$(function() {
				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_eventCombobox",
					},
					error : ajax_eventComboboxError,
					success : ajax_eventComboboxSuccess
				})
			});

			function ajax_eventComboboxSuccess(result, status, xhr) {
				var combobox = $("#comboboxEvent");

				var list = JSON.parse(result);

				for (var i = 0; i < list.length; i++) {
					combobox.append($('<option>').append(list[i]).append('</option>'));
				}
			}

			function ajax_eventComboboxError(result, status, xhr) {
				var txtFeedback = $("#txtFeedback");
				txtFeedback.css("color", "red");
				txtFeedback.attr("value", "Comboboxen kunde inte laddas.");
			}

			$("#btnAddEvent").click(function() {
				var txtPnr = $("#txtPnr"); // get textfield
				var cPnr = txtPnr.val(); // get value from textfield
				if (cPnr == null || cPnr == "") { // value blank?
					txtFeedback.css("color", "red");
					txtFeedback.attr("value", "Fyll i personnummer.");
					return;
				}

				var combobox = $("#comboboxEvent");
				var event = combobox.val(); // get value from textfield

				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_addToEvent",
						cPnr : cPnr,
						event : event
					},
					error : ajax_addToEventError,
					success : ajax_addToEventSuccess
				})
			});

			function ajax_addToEventSuccess(result, status, xhr) {
				var txtFeedback = $("#txtFeedback");
				txtFeedback.css("color", "green");
				txtFeedback.attr("value", "Kunden lades till på event. Sök på kund för att uppdatera tabellerna.");

			}

			function ajax_addToEventError(result, status, xhr) {
				var txtFeedback = $("#txtFeedback");
				txtFeedback.css("color", "red");
				txtFeedback.attr("value", "Kunden kunde inte läggas till på event.");
			}

		});