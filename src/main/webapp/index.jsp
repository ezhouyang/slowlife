<%@ page language="java" import="java.util.*,java.net.URL" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
		<meta name="author" content="www.frebsite.nl" />
		<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
		<meta name="robots" content="noindex, nofollow" />

		<title>慢生活</title>

		<link type="text/css" rel="stylesheet" href="http://slowlife.qiniudn.com/assets/mmenu-docs.css" />
		<link type="text/css" rel="stylesheet" href="http://slowlife.qiniudn.com/assets/mmenu.css" />
		<link type="text/css" rel="stylesheet" href="http://slowlife.qiniudn.com/assets/mmenu-positioning.css" />

		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script type="text/javascript" src="http://slowlife.qiniudn.com/assets/jquery.mmenu.min.js"></script>
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/hammer.js/1.0.5/jquery.hammer.min.js"></script>
		<script type="text/javascript">
          
          $(function() {
				$('nav#menu-left').mmenu({
					dragOpen: true
				});
			});
          
         

			//	The menu on the left
			$(function() {
				$('nav#menu-left').mmenu();
			});


			//	The menu on the right
			$(function() {

				$('nav#menu-right').mmenu({
					position	: 'right',
					counters	: true,
					searchfield	: true
				});

				//	Click a menu-item
				var $confirm = $('#confirmation');
				$('#menu-right a').not( '.mm-subopen' ).not( '.mm-subclose' ).bind(
					'click.example',
					function( e )
					{
						e.preventDefault();
						$confirm.show().text( 'You clicked "' + $(this).text() + '"' );
						$('#menu-right').trigger( 'close' );
					}
				);
			});
		</script>
	</head>
	<body>
		<div id="page">
			<div id="header">
				<a href="#menu-left"></a>
				向左是朋友，向右是生活
				<a href="#menu-right" class="friends right"></a>
			</div>
			<div id="content">
				<p id="confirmation"></p>
				<h4>Sliding menus for your website</h4>
				<p>Create an unlimited amount of app look-alike sliding menus, all with an unlimited amount of submenus.</p>
				<h4>Try it!</h4>
				<p>Click the menu-button in the header to open the menu on the left. Or click the contacts-button in the header to open a second menu on the right.</p>
				<h4>Search</h4>
				<p>The right menu has a search field prepended to it, so go ahead and try typing something in the search fields.</p>
			</div>
			<nav id="menu-left">
				<ul>
					<li><a href="index.html">Basic example</a></li>
					<li><a href="horizontal-submenus.html">Horizontal sliding submenus example</a></li>
					<li><a href="vertical-submenus.html">Vertical submenus example</a></li>
					<li><a href="positions.html">Positioning the menu</a></li>
					<li class="Selected"><a href="advanced.html">Advanced example</a></li>
					<li><a href="onepage.html">One page scrolling example</a></li>
					<li><a href="iconbar.html">Iconbar</a></li>
					<li><a href="dragopen.html">Drag/swipe the menu open</a></li>
				</ul>
			</nav>
			<nav id="menu-right">
				<ul>
					<li>
						<span>Friends</span>
						<ul>
							<li class="Label">A</li>
							<li><a href="#ALES">Alexa</a></li>
							<li><a href="#">Alexander</a></li>

							<li class="Label">F</li>
							<li><a href="#">Fred</a></li>

							<li class="Label">J</li>
							<li><a href="#">James</a></li>
							<li><a href="#">Jefferson</a></li>
							<li><a href="#">Jordan</a></li>

							<li class="Label">K</li>
							<li><a href="#">Kim</a></li>

							<li class="Label">M</li>
							<li><a href="#">Meagan</a></li>
							<li><a href="#">Melissa</a></li>
							
							<li class="Label">N</li>
							<li><a href="#">Nicole</a></li>

							<li class="Label">S</li>
							<li><a href="#">Samantha</a></li>
							<li><a href="#">Scott</a></li>
						</ul>
					</li>
					
					<li>
						<span>Family</span>
						<ul>
							<li class="Label">A</li>
							<li><a href="#">Adam</a></li>

							<li class="Label">B</li>
							<li><a href="#">Ben</a></li>
							<li><a href="#">Bruce</a></li>

							<li class="Label">E</li>
							<li><a href="#">Eddie</a></li>

							<li class="Label">J</li>
							<li><a href="#">Jack</a></li>
							<li><a href="#">John</a></li>

							<li class="Label">M</li>
							<li><a href="#">Martina</a></li>
							<li><a href="#">Matthew</a></li>

							<li class="Label">O</li>
							<li><a href="#">Olivia</a></li>
							<li><a href="#">Owen</a></li>
						</ul>
					</li>

					<li>
						<span>Work colleagues</span>
						<ul>
							<li class="Label">D</li>
							<li><a href="#">David</a></li>
							<li><a href="#">Dennis</a></li>
							
							<li class="Label">E</li>
							<li><a href="#">Eliza</a></li>
							
							<li class="Label">L</li>
							<li><a href="#">Larry</a></li>
							<li><a href="#">Lisa</a></li>
							
							<li class="Label">M</li>
							<li><a href="#">Michael</a></li>
							
							<li class="Label">R</li>
							<li><a href="#">Rachelle</a></li>
							<li><a href="#">Rick</a></li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
	</body>
</html>