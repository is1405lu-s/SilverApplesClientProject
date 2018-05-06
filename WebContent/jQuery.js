		$(document).ready(function() {
			$("#btnSearch").click(function() {
			<!-- alert("OBS!") -->
				var fnElement = $("#txtPnr"); // get textfield
				var cPnr = fnElement.val(); // get value from textfield
				if (cPnr == null || cPnr == "") { // value blank?
					fnElement.attr("placeholder", "Fyll i personnummer.");
					return;
				}
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
				
				console.log(c);
				var obj = JSON.parse(c);
				console.log(obj);
										
				fnElement.val(obj[0]);
				fnElement1.val(obj[1]);
				fnElement2.val(obj[2]);
				fnElement3.val(obj[3]);
								
					for (var i = 0; i < obj[4].length; i++) {
					fnElement4.find('tbody')
					    .append($('<tr>')
					        .append($('<td>')
					            .append(obj[4][i++])
				           ) 
				           .append($('<td>')
					            .append(obj[4][i++])
				           ) 
				           .append($('<td>')
					            .append(obj[4][i])
				           ) 
				        ); 
				}
				
				for (var i = 0; i < obj[5].length; i++) {
					fnElement5.find('tbody')
					    .append($('<tr>')
					        .append($('<td>')
					            .append(obj[5][i++])
				           ) 
				           .append($('<td>')
					            .append(obj[5][i++])
				           ) 
				           .append($('<td>')
					            .append(obj[5][i])
				           ) 
				        ); 
				}
				
				console.log(obj)
				// fnElement1.val(list.get(1));
				
			}
			function ajax_findReturnError(result, status, xhr) {
				console.log("Ajax-find customer: " + status);
			}

			$("#btnCreate").click(function() {
			<!-- alert("OBS!") -->
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
					fnElement4.attr("placeholder", "Customer id, please.");
					return;
				}
				$.ajax({
					method : "POST",
					url : "/SilverApplesClientProject/SilverApplesServlet",
					data : {
						operation : "ajax_createcustomer",
						"cPnr" : cPnr, 
						"cName" : cName,
						"cAddress": cAddress,
						"cPhoneNo": cPhoneNo,
						"cEmail": cEmail
					},
					error : ajax_createReturnError,
					success : ajax_createReturn_Success
				})
			});
			function ajax_createReturn_Success(c, status, xhr) {								
				alert("Skapad!");
				
			}
			function ajax_createReturnError(result, status, xhr) {
				console.log("Ajax-find customer: " + status);
			}
			
				$("#btnDelete").click(function() {
				var fnElement = $("#txtPnr"); // get textfield
				var cPnr = fnElement.val(); // get value from textfield
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
			});
			
			function ajax_deleteReturn_Success(c, status, xhr) {								
				alert("Borttagen!");
				
			}
			function ajax_deleteReturnError(result, status, xhr) {
				alert("Misslyckades");
			}
			
			$(function() {
			<!-- alert("OBS!") -->
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
				
				console.log(obj);
				
				for (var i = 0; i < obj.length; i++) {
					fnElement.append($('<option>').append(obj[i])); 
				}
				
			}
			
			function ajax_comboboxReturn_Error(c, status, xhr) {								
				alert("Kunde inte ladda combobox.");
			}
			
		});