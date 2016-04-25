<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Twenty by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html lang="en">
	<head>
		<title>EaseMySleep</title>
		<!-- NV - start 04/18/2016 --> 
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico"  type="image/x-icon" />
		<!-- NV - end 04/18/2016 --> 
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		
		<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/home/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/ie9.css" /><![endif]-->
		<link rel="stylesheet" href="https://i.icomoon.io/public/temp/6271e1568c/UntitledProject/style.css">

<script>
if('${userId}'!='')
{
	location.replace("/smacrobs/dashboard");
	
}
</script>
	</head>
	<body class="index">
		<div id="page-wrapper">

			<!-- Header -->
				<header id="header" class="alt">
					<h1 id="logo"><a href="<%=request.getContextPath()%>">EaseMySleep <span>by SMACROBS</span></a></h1>
					<nav id="nav">
						<ul>
							<li class="current"><a href="<%=request.getContextPath()%>">Home</a></li>
							<li class="submenu">
								<a href="#">What's More?</a>
								<ul>
									<li><a href="/smacrobs/fitbit">Fitbit</a></li>
									<li><a href="/smacrobs/senso">Sense Fence</a></li>
									<li><a href="/smacrobs/data">Data Analytics</a></li>
									<li><a href="/smacrobs/contact">Contact Us</a></li>
								</ul>
							</li>				
						</ul>
					</nav>
				</header>

			<!-- Banner -->
				<section id="banner">

					<!--
						".inner" is set up as an inline-block so it automatically expands
						in both directions to fit whatever's inside it. This means it won't
						automatically wrap lines, so be sure to use line breaks where
						appropriate (<br />).
					-->
					<div class="inner">

						<header>
							<h2>EaseMySleep</h2>
						</header>
						<p style="font-size:15px" >Did you have a restless sleep last night?<br/>
						<strong> Wonder Why?</strong><br/>Click to know more.
						</p>
						<footer>
							<ul class="buttons vertical">
								<li><a href="/smacrobs/oauth" class="button fit scrolly">Connect With Fitbit</a></li>
							</ul>
						</footer>
					</div>
				</section>

			<!-- Main -->
				<article id="main">

					<header class="special container">
						<span class="icon fa-bar-chart-o"></span>
						<h2><strong>SLEEP TRIVIA</strong></h2> 
						<br />
						<ul class="lists">
							<li>Did you know that you may die after 96 hours without sleep?</li>
						 	<li>You will lose all your senses after 150 hours without sleep?</li>
							<li><strong>Sleep Deprivation</strong> is so debilitating that it is sometimes used as a component of military interrogation.</li>
						</ul>
					</header>

					<!-- One -->
						<section class="wrapper style2 container special-alt">
							<div class="row 50%">
								<div class="8u 12u(narrower)">

									<header>
										<h2>Your sleep decides the energy during the day and the energy defines you.</h2>
									</header>
									<p>Your food and water in-take, your activities during the day, the coffee you drink, the drink that makes you high, your smartphone, laptop and the big screens, the temperature in your bedroom, the mattress on your bed. All of these contribute to your sleep. Do you care? </p>
									<footer>
										<ul class="buttons">
											<li><a href="#" class="button">Find Out More</a></li>
										</ul>
									</footer>

								</div>
								<div class="4u 12u(narrower) important(narrower)">

									<ul class="featured-icons">
										<li><span class="icon fa-bed"></span></li>
										<li><span class="icon fa-heartbeat"></span></li>
										<li><span class="icon fa-bicycle"></span></li>
										<li><span class="icon fa-cutlery"></span></li>
										<li><span class="icon fa-tint"></span></li>
										<li><span class="icon fa-lightbulb-o"></span></li>
										<li><span class="icon fa-fire"></span></li>
										<li><span class="icon fa-volume-up"></span></li>
									</ul>

								</div>
							</div>
						</section>

					<!-- Two -->
						<section class="wrapper style1 container special">
							<div class="row">
								<div class="4u 12u(narrower)">

									<section>
										<span class="icon featured fa-ioxhost"></span>
										<header>
											<h3>Fast Fact #1</h3>
										</header>
										<p>People who don't get enough sleep are more likely to have bigger appetites due to the fact that their leptin levels (an appetite-regulating hormone) fall, promoting appetite increase.</p>
									</section>

								</div>
								<div class="4u 12u(narrower)">

									<section>
										<span class="icon featured fa-ioxhost"></span>
										<header>
											<h3>Fast Fact #2</h3>
										</header>
										<p>In general, most healthy adults need seven to nine hours of sleep a night. However, some individuals are able to function without sleepiness or drowsiness after as little as six hours of sleep. Others can't perform at their peak unless they've slept for ten hours.</p>
									</section>

								</div>
								<div class="4u 12u(narrower)">

									<section>
										<span class="icon featured fa-ioxhost"></span>
										<header>
											<h3>Fast Fact #3</h3>
										</header>
										<p>24 hours of wakefulness caused as much impairment as a blood alcohol content of 0.10%.Microsleeps are brief episodes of sleep that occur in the midst of ongoing wakeful activity. They can happen in people who are sleep deprived, often without their awareness.</p>
									</section>

								</div>
							</div>
						</section>

					<!-- Three -->
						<section class="wrapper style3 container special">

							<header class="major">
								<h2>Next look at these <strong>short videos</strong></h2>
							</header>

							<div class="row">
								<div class="6u 12u(narrower)">

									<section>
										<!-- <a href="#" class="image featured"><img src="images/pic01.jpg" alt="" /></a>-->
										<iframe width="500" height="300" src="https://www.youtube.com/embed/qPoZVQvsbW0" frameborder="0" allowfullscreen></iframe>
										<header>
											<h3>What is Sleep Deprivation?</h3>
										</header>
										<p>Watch this video to understand the risks of sleep deprivation.</p>
									</section>

								</div>
								<div class="6u 12u(narrower)">

									<section>
										<!-- <a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>-->
										<iframe width="500" height="300" src="//www.dailymotion.com/embed/video/x1ky31w" frameborder="0" allowfullscreen></iframe>
										<header>
											<h3>How to sleep better?</h3>
										</header>
										<p>Watch this video to understand sleep and sleep better.</p>
									</section>

								</div>
							</div>
						</section>

				</article>

			<!-- CTA -->
				<section id="cta">

					<header>
						<h2>Ready to <strong>KNOW MORE</strong>?</h2>
						<p>Login to our website with your Fitbit credentials. Sleep Better! Feel Better!</p>
					</header>
					<footer>
						<ul class="buttons">
							<li><a href="<%=request.getContextPath()%>/smacrobs/oauth" class="button special">Login with Fitbit</a></li>
						</ul>
					</footer>

				</section>

				<!-- Footer -->
				<footer id="footer">

					<ul class="copyright">
						<li>&copy; <strong>SMACROBS</strong> 2015-2016</li><li>Design: <a href="http://html5up.net">TWENTY By HTML5 UP</a></li>
					</ul>

				</footer>

		</div>

		<!-- Scripts -->
			<script src="<%=request.getContextPath()%>/home/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/jquery.dropotron.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/jquery.scrolly.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/jquery.scrollgress.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/skel.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/util.js"></script>
			<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/home/js/ie/respond.min.js"></script><![endif]-->
			<script src="<%=request.getContextPath()%>/home/js/main.js"></script>
			<script type="text/javascript">
							$(document).ready(function(){
								if(${isLoggedIn}!=null){
								console.log(${isLoggedIn} +".."+ (${isLoggedIn}==true));
								if(${isLoggedIn}==true){
									window.open("oauth"); 
								}
								}
							});
			</script>
	</body>
</html>