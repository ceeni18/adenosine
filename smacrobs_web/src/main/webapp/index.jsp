<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--Bootstrap Jquery   -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!--Bootstrap Javascript  -->
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/bootstrap.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>S.M.A.C.R.O.B.S</title>

<script type="text/javascript">
function DisplaySigninModal()
{
	$('#signInModal').modal('show'); 
}
function DisplayCreateAccountModal()
{
	$('#createAccountModal').modal('show'); 
}
</script>

</head>

<body>
	<!-- Navbar -->
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SMACROBS</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">Contact Us</a></li>
				<li><a href="/smacrobs/template">Template</a></li>
				<li><a href="/smacrobs/oauth">Login with Fitbit</a></li>
			</ul>


			<ul class="nav navbar-nav navbar-right">
				<li><a href="javascript:DisplayCreateAccountModal();"><i class="glyphicon glyphicon-user"></i>
						Create Account</a></li>
				<li><a href="javascript:DisplaySigninModal();"><span
						class="glyphicon glyphicon-lock"></span> Sign In</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<!-- / Navbar -->

	<!-- Corousel -->
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="http://placehold.it/1200x315" alt="...">
				<div class="carousel-caption">
					<h3>Track Your sleep</h3>
				</div>
			</div>
			<div class="item">
				<img src="http://placehold.it/1200x315" alt="...">
				<div class="carousel-caption">
					<h3>Track Your Sleep Environment</h3>
				</div>
			</div>
			<div class="item">
				<img src="http://placehold.it/1200x315" alt="...">
				<div class="carousel-caption">
					<h3>Understand the factors that affect sleep</h3>
				</div>
			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left"></span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
	<!-- / Carousel -->


	<!-- Sign in Modal -->
	<div class="container">
	
		<div class="modal fade" id="signInModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Sign In</h4>
					</div>
					
					<!-- Form inside modal -->
					<form>
					<div class="modal-body">
					
						
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									placeholder="Email">
							</div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password">
							</div>
							
							
						
						
					</div>
					
					<div class="modal-footer">
						<button type="submit" class="btn btn-default">Sign In</button>
					</div>
					</form>
				</div>

			</div>
		</div>

	</div>
	<!-- /Sign in Modal -->
	
	
	<!-- Create Account Modal -->
	<div class="container">
	
		<div class="modal fade" id="createAccountModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
				
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Create Account</h4>
					</div>
					
					<!-- Form inside modal -->
					<form>
					<div class="modal-body">
					
						<div class="form-group">
								<label for="exampleInputEmail1">Full Name*</label> <input
									type="text" class="form-control" id="FullName">
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Email address*</label> <input
									type="email" class="form-control" id="InputEmail1">
							</div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Password*</label> <input
									type="password" class="form-control" id="InputPassword1"
									placeholder="Password">
							</div>
							
							
						
						
					</div>
					
					<div class="modal-footer">
						<button type="submit" class="btn btn-default">Create</button>
					</div>
					</form>
				</div>

			</div>
		</div>

	</div>
	<!-- /Create Modal -->


	<div class="footer navbar-fixed-bottom">
		<p class="text-muted">
			SMACROBS V 1.0 <span class="glyphicon glyphicon-copyright-mark"></span>
		</p>
	</div>



</body>
</html>