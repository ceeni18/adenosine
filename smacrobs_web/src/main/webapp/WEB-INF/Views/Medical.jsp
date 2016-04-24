<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Medical Details | EaseMySleep</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/favicon.ico"
	type="image/x-icon" />
<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />


<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/font-awesome.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/ace.onpage-help.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/js/themes/sunburst.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-ie.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="<%=request.getContextPath()%>/assets/js/ace-extra.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="<%=request.getContextPath()%>/assets/js/html5shiv.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/respond.js"></script>
		<![endif]-->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- High charts -->


<script>
console.log('${userId}'=='');
console.log('${userId}');
if('${userId}'=='')
{
	location.replace("/smacrobs/");
	
}
</script>

</head>

<body class="no-skin">
	<!-- #section:basics/navbar.layout -->
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

		<div class="navbar-container" id="navbar-container">
			<!-- #section:basics/sidebar.mobile.toggle -->
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<!-- /section:basics/sidebar.mobile.toggle -->
			<div class="navbar-header pull-left">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-bed"></i> EaseMySleep
				</small>
				</a>

				<!-- /section:basics/navbar.layout.brand -->

				<!-- #section:basics/navbar.toggle -->

				<!-- /section:basics/navbar.toggle -->
			</div>

			<!-- #section:basics/navbar.dropdown -->
			<div class="navbar-buttons navbar-header pull-right"
				role="navigation">
				<ul class="nav ace-nav">



					<!-- #section:basics/navbar.user_menu -->
					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="${user.getAvatar()}" alt="User's Photo" /> <span class="user-info">
								<small>Welcome,</small> ${user.getDisplayName()}
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a> <!-- NV - start 04/18/2016 -->
						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="/smacrobs/tisensor"> <i
                                    class="ace-icon fa fa-key"></i> Ti Sensor
                            </a></li>
							<li><a href="/smacrobs/medical"> <i
                                    class="ace-icon fa fa-medkit"></i> Medical Details
                            </a></li>
							<li><a href="/smacrobs/redirectToSite"> <i
                                    class="ace-icon fa fa-power-off"></i> Logout
                            </a></li>
						</ul></li>

					<!-- /section:basics/navbar.user_menu -->
				</ul>
			
				<!-- NV - end 04/18/2016 -->
			</div>

			<!-- /section:basics/navbar.dropdown -->
		</div>
		<!-- /.navbar-container -->
	</div>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

		<!-- #section:basics/sidebar -->
		<div id="sidebar" class="sidebar responsive">
			<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>


			<!-- /.sidebar-shortcuts -->
			<div id="profile">


				<ul class="nav nav-list">
					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-user"></i> <span class="menu-text">
								${user.getFullName()} </span>
					</a> <b class="arrow"></b></li>

					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-intersex"></i> <span class="menu-text">
								${user.getGender()} </span>
					</a> <b class="arrow"></b></li>

					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-calendar"></i> <span class="menu-text">
								${user.getAge()} years</span>
					</a> <b class="arrow"></b></li>

					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-birthday-cake"></i> <span
							class="menu-text">${user.getDateOfBirth()} </span>
					</a> <b class="arrow"></b></li>

					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-arrows-v"></i> <span class="menu-text">
								${user.getHeight()} inches</span>
					</a> <b class="arrow"></b></li>

					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-balance-scale"></i> <span
							class="menu-text">${user.getWeight()} pounds</span>
					</a> <b class="arrow"></b></li>

				</ul>

			</div>

			<!--SSR put the profile details here-->
		
			<!-- #section:basics/sidebar.layout.minimize -->
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>

			<!-- /section:basics/sidebar.layout.minimize -->
			<script type="text/javascript">
				
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>



		</div>

		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-tachometer"></i> <a
							href="/smacrobs/dashboard">Dashboard</a></li>

							<li><i class="ace-icon fa fa-random active"></i> <a
							href="#">Medical Details</a></li>
					</ul>
					<!-- /.breadcrumb -->



					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<!-- /section:settings.box -->
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

							<div id="details">
					<form id="medicalForm" action="/smacrobs/medical" method="POST">
					<div class="row">
						
						<h3 class="col-md-offset-3">Check conditions if applicable</h3>
						<div class="input-group col-md-offset-3 col-md-6">
							<div class="checkbox ">
								<label> <input name="form-field-checkbox"
									type="checkbox" class="ace" /> <span class="lbl"> Is
										Condition</span>
								</label>
							</div>
						</div>
						<br />
						<div class="input-group col-md-offset-3 col-md-6">
							<label for="form-field-select-2">Multiple</label> <select
								class="form-control" id="form-field-select-2"
								multiple="multiple">
								<option value="AL">Condition 1</option>
								<option value="AK">Condition 1</option>
								<option value="AZ">Condition 1</option>
								<option value="AR">Condition 1</option>
								<option value="CA">Condition 1</option>

							</select>
						</div>
					</div>

					<br />
					<!-- /.span -->
					<div class="col-md-offset-5">
						<button id="submitTiBtn" type="submit" class=" btn btn-sm btn-danger pull-left"
							data-dismiss="modal">
							<i class="glyphicon glyphicon-ok"></i> Submit
						</button>
					</div>
					</form>
					<!-- /.modal-dialog -->
				</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					

					<!-- /.ace-settings-box -->
				</div>
				<!-- /.ace-settings-container -->




			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->

	<div class="footer">
		<div class="footer-inner">
			<!-- #section:basics/footer -->
			<div class="footer-content">
				<div class="infobox-chart">
					<span class="sparkline" data-values="3,4,2,3,4,4,2,2"></span>
				</div>
				<span class="bigger-120"> <span class="blue bolder">SMACROBS</span>
					&copy; 2015-2016
				</span> &nbsp; &nbsp;
			</div>

			<!-- /section:basics/footer -->
		</div>
	</div>

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery.js'>"+"<"+"/script>");
		</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.js"></script>

	<!-- page specific plugin scripts -->

	<!-- ace scripts -->
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.scroller.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.colorpicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.fileinput.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.typeahead.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.wysiwyg.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.spinner.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.treeview.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.wizard.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.aside.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/ace/ace.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.ajax-content.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.touch-drag.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.sidebar.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.sidebar-scroll-1.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.submenu-hover.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.widget-box.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.settings.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.settings-rtl.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.settings-skin.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.widget-on-reload.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.searchbox-autocomplete.js"></script>

	<!-- inline scripts related to this page -->

	<!-- the following scripts are used in demo only for onpage help and you don't need them -->


	<script type="text/javascript"> ace.vars['base'] = '..'; </script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.onpage-help.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.onpage-help.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/rainbow.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/language/generic.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/language/html.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/language/css.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/language/javascript.js"></script>

	<script type="text/javascript">
		
							
</body>
</html>
