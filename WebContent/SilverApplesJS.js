		function() {

			function openTable(evt, tableName) {
				var i, tabcontent, tablinks;
				tabcontent = document.getElementsByClassName("tabcontent");
				for (i = 0; i < tabcontent.length; i++) {
					tabcontent[i].style.display = "none";
				}
				tablinks = document.getElementsByClassName("tablinks");
				for (i = 0; i < tablinks.length; i++) {
					tablinks[i].className = tablinks[i].className.replace(
							" active", "");
				}
				document.getElementById(tableName).style.display = "block";
				evt.currentTarget.className += " active";
			}

			var slideIndex = [ 1, 1 ];
			var slideId = [ "mySlides1", "mySlides2" ]
			showSlides(1, 0);
			showSlides(1, 1);

			function plusSlides(n, no) {
				showSlides(slideIndex[no] += n, no);
			}

			function showSlides(n, no) {
				var i;
				var x = document.getElementsByClassName(slideId[no]);
				if (n > x.length) {
					slideIndex[no] = 1
				}
				if (n < 1) {
					slideIndex[no] = x.length
				}
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				x[slideIndex[no] - 1].style.display = "block";
			}