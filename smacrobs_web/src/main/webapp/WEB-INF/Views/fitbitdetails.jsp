<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>SMACROBS</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/font-awesome.css" />

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
				<a href="#" class="navbar-brand"> <small> <i class="fa fa-bed"></i>
				Smacrobs
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
					<li class="grey"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="ace-icon fa fa-tasks"></i> <span class="badge badge-grey">4</span>
					</a>

						<ul
							class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="ace-icon fa fa-check"></i>
								4 Tasks to complete</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar">
									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left">Software Update</span> <span
													class="pull-right">65%</span>
											</div>

											<div class="progress progress-mini">
												<div style="width: 65%" class="progress-bar"></div>
											</div>
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left">Hardware Upgrade</span> <span
													class="pull-right">35%</span>
											</div>

											<div class="progress progress-mini">
												<div style="width: 35%"
													class="progress-bar progress-bar-danger"></div>
											</div>
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left">Unit Testing</span> <span
													class="pull-right">15%</span>
											</div>

											<div class="progress progress-mini">
												<div style="width: 15%"
													class="progress-bar progress-bar-warning"></div>
											</div>
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left">Bug Fixes</span> <span
													class="pull-right">90%</span>
											</div>

											<div class="progress progress-mini progress-striped active">
												<div style="width: 90%"
													class="progress-bar progress-bar-success"></div>
											</div>
									</a></li>
								</ul>
							</li>

							<li class="dropdown-footer"><a href="#"> See tasks with
									details <i class="ace-icon fa fa-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="purple"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="ace-icon fa fa-bell icon-animated-bell"></i> <span
							class="badge badge-important">8</span>
					</a>

						<ul
							class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i
								class="ace-icon fa fa-exclamation-triangle"></i> 8 Notifications
							</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar navbar-pink">
									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left"> <i
													class="btn btn-xs no-hover btn-pink fa fa-comment"></i> New
													Comments
												</span> <span class="pull-right badge badge-info">+12</span>
											</div>
									</a></li>

									<li><a href="#"> <i
											class="btn btn-xs btn-primary fa fa-user"></i> Bob just
											signed up as an editor ...
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left"> <i
													class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
													New Orders
												</span> <span class="pull-right badge badge-success">+8</span>
											</div>
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left"> <i
													class="btn btn-xs no-hover btn-info fa fa-twitter"></i>
													Followers
												</span> <span class="pull-right badge badge-info">+11</span>
											</div>
									</a></li>
								</ul>
							</li>

							<li class="dropdown-footer"><a href="#"> See all
									notifications <i class="ace-icon fa fa-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="green"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="ace-icon fa fa-envelope icon-animated-vertical"></i> <span
							class="badge badge-success">5</span>
					</a>

						<ul
							class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i
								class="ace-icon fa fa-envelope-o"></i> 5 Messages</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar">
									<li><a href="#" class="clearfix"> <img
											src="<%=request.getContextPath()%>/assets/avatars/avatar.png"
											class="msg-photo" alt="Alex's Avatar" /> <span
											class="msg-body"> <span class="msg-title"> <span
													class="blue">Alex:</span> Ciao sociis natoque penatibus et
													auctor ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>a moment
														ago</span>
											</span>
										</span>
									</a></li>

									<li><a href="#" class="clearfix"> <img
											src="<%=request.getContextPath()%>/assets/avatars/avatar3.png"
											class="msg-photo" alt="Susan's Avatar" /> <span
											class="msg-body"> <span class="msg-title"> <span
													class="blue">Susan:</span> Vestibulum id ligula porta felis
													euismod ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>20 minutes
														ago</span>
											</span>
										</span>
									</a></li>

									<li><a href="#" class="clearfix"> <img
											src="<%=request.getContextPath()%>/assets/avatars/avatar4.png"
											class="msg-photo" alt="Bob's Avatar" /> <span
											class="msg-body"> <span class="msg-title"> <span
													class="blue">Bob:</span> Nullam quis risus eget urna mollis
													ornare ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>3:15 pm</span>
											</span>
										</span>
									</a></li>

									<li><a href="#" class="clearfix"> <img
											src="<%=request.getContextPath()%>/assets/avatars/avatar2.png"
											class="msg-photo" alt="Kate's Avatar" /> <span
											class="msg-body"> <span class="msg-title"> <span
													class="blue">Kate:</span> Ciao sociis natoque eget urna
													mollis ornare ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>1:33 pm</span>
											</span>
										</span>
									</a></li>

									<li><a href="#" class="clearfix"> <img
											src="<%=request.getContextPath()%>/assets/avatars/avatar5.png"
											class="msg-photo" alt="Fred's Avatar" /> <span
											class="msg-body"> <span class="msg-title"> <span
													class="blue">Fred:</span> Vestibulum id penatibus et auctor
													...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>10:09 am</span>
											</span>
										</span>
									</a></li>
								</ul>
							</li>

							<li class="dropdown-footer"><a href="inbox.html"> See
									all messages <i class="ace-icon fa fa-arrow-right"></i>
							</a></li>
						</ul></li>

					<!-- #section:basics/navbar.user_menu -->
					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="${userProfile.avatar}" alt="User's Photo" /> <span
							class="user-info"> <small>Welcome,</small>
								${userProfile.fullName}
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="ace-icon fa fa-cog"></i>
									Settings
							</a></li>

							<li><a href="profile.html"> <i
									class="ace-icon fa fa-user"></i> Profile
							</a></li>

							<li class="divider"></li>

							<li><a href="#"> <i class="ace-icon fa fa-power-off"></i>
									Logout
							</a></li>
						</ul></li>

					<!-- /section:basics/navbar.user_menu -->
				</ul>
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
		<div id="sidebar" class="sidebar                  responsive">
			<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<!-- #section:basics/sidebar.layout.shortcuts -->
					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>

					<!-- /section:basics/sidebar.layout.shortcuts -->
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- /.sidebar-shortcuts -->

			<!--SSR put the profile details here-->
			<div id="profile">





				<!-- #section:pages/profile.info -->
				<!-- <center>
					<span class="profile-picture"> <img id="avatar"
						class="editable img-responsive" alt="User's Avatar"
						src=${userProfile.avatar } />
					</span>
				</center>



				<div class="profile-user-info profile-user-info-striped pull-left">


					<div class="profile-info-row">
						<div class="profile-info-name">Username</div>

						<div class="profile-info-value">
							<span class="editable" id="username">${userProfile.fullName}</span>
						</div>
					</div>

					<div class="profile-info-row">
						<div class="profile-info-name">Gender</div>

						<div class="profile-info-value">
							<i class="fa fa-user light-orange bigger-110"></i> <span
								class="editable" id="country">${userProfile.gender}</span>
						</div>
					</div>

					<div class="profile-info-row">
						<div class="profile-info-name">Age</div>

						<div class="profile-info-value">
							<span class="editable" id="age">${userProfile.age}</span>
						</div>
					</div>

					<div class="profile-info-row col-md-12">
						<div class="profile-info-name col-md-12">${userProfile.dateOfBirth}</div>					
					</div>
				</div> -->
				
				
					<ul class="nav nav-list">
					<li class="">
						<a href="index.html">
							<i class="menu-icon fa fa-user"></i>
							<span class="menu-text"> ${userProfile.fullName} </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="index.html">
							<i class="menu-icon fa fa-intersex"></i>
							<span class="menu-text">Gender: ${userProfile.gender} </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="index.html">
							<i class="menu-icon fa fa-calendar"></i>
							<span class="menu-text">Age: ${userProfile.age} </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="index.html">
							<i class="menu-icon fa fa-birthday-cake"></i>
							<span class="menu-text">DOB: ${userProfile.dateOfBirth}</span>
						</a>

						<b class="arrow"></b>
					</li>
					
					</ul>

			</div>

			<!-- #section:basics/sidebar.layout.minimize -->
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right" ></i>
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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>

						<li><a href="#">Other Pages</a></li>
						<li class="active">Blank Page</li>
					</ul>
					<!-- /.breadcrumb -->

					<!-- #section:basics/content.searchbox -->
					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->

					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<!-- #section:settings.box -->
					<div class="ace-settings-container" id="ace-settings-container">
						<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
							id="ace-settings-btn">
							<i class="ace-icon fa fa-cog bigger-130"></i>
						</div>

						<div class="ace-settings-box clearfix" id="ace-settings-box">
							<div class="pull-left width-50">
								<!-- #section:settings.skins -->
								<div class="ace-settings-item">
									<div class="pull-left">
										<select id="skin-colorpicker" class="hide">
											<option data-skin="no-skin" value="#438EB9">#438EB9</option>
											<option data-skin="skin-1" value="#222A2D">#222A2D</option>
											<option data-skin="skin-2" value="#C6487E">#C6487E</option>
											<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
										</select>
									</div>
									<span>&nbsp; Choose Skin</span>
								</div>

								<!-- /section:settings.skins -->

								<!-- #section:settings.navbar -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-navbar" /> <label class="lbl"
										for="ace-settings-navbar"> Fixed Navbar</label>
								</div>

								<!-- /section:settings.navbar -->

								<!-- #section:settings.sidebar -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-sidebar" /> <label class="lbl"
										for="ace-settings-sidebar"> Fixed Sidebar</label>
								</div>

								<!-- /section:settings.sidebar -->

								<!-- #section:settings.breadcrumbs -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-breadcrumbs" /> <label class="lbl"
										for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
								</div>

								<!-- /section:settings.breadcrumbs -->

								<!-- #section:settings.rtl -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-rtl" /> <label class="lbl"
										for="ace-settings-rtl"> Right To Left (rtl)</label>
								</div>

								<!-- /section:settings.rtl -->

								<!-- #section:settings.container -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-add-container" /> <label class="lbl"
										for="ace-settings-add-container"> Inside <b>.container</b>
									</label>
								</div>

								<!-- /section:settings.container -->
							</div>
							<!-- /.pull-left -->

							<div class="pull-left width-50">
								<!-- #section:basics/sidebar.options -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-hover" /> <label class="lbl"
										for="ace-settings-hover"> Submenu on Hover</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-compact" /> <label class="lbl"
										for="ace-settings-compact"> Compact Sidebar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-highlight" /> <label class="lbl"
										for="ace-settings-highlight"> Alt. Active Item</label>
								</div>

								<!-- /section:basics/sidebar.options -->
							</div>
							<!-- /.pull-left -->
						</div>
						<!-- /.ace-settings-box -->
					</div>
					<!-- /.ace-settings-container -->

					<!-- /section:settings.box -->
					<div class="row">
						<div class="col-xs-12"><!-- SSR page contents -->
							<!-- PAGE CONTENT BEGINS -->
							<div class="col-md-2">
								<div id="sleepData">
									<span class="btn btn-app btn-sm btn-yellow no-hover"> <span
										class="line-height-1 bigger-170 blue"> <i
											class="fa fa-moon-o "></i>
									</span> <br /> <span class="line-height-1 smaller-90">
											Sleep </span>
									</span>
								</div>
							</div>
							
							<div class="col-md-2">
								<div id="heartData">
							<span class="btn btn-app btn-sm btn-pink no-hover">
													<span class="line-height-1 bigger-170"> <i
											class="fa fa-heartbeat "></i> </span>

													<br />
													<span class="line-height-1 smaller-90"> ${heartRateDetails.heartRate}/minute </span>
												</span></div></div>							
							
							<script type="text/javascript">
							$(document).ready(function(){
							    $("#sleepData").click(function(){
							        $("#sleepDataModal").modal();
							    });
							});
							</script>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->
		
		  <!-- Modal -->
 				<div id="sleepDataModal" class="modal fade" tabindex="-1">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header no-padding">
												<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													Sleep details from fitbit
												</div>
											</div>

											<div class="modal-body no-padding">
												<table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
													<thead>
														<tr>
															<th class="text-center">Sleep Efficiency</th>
															<th class="text-center">Sleep Duration</th>
															<th class="text-center">Awake Count</th>

															<th class="text-center">
																Restless Count
															</th>
														</tr>
													</thead>

													<tbody>
														<tr>
															<td class="text-center">
																${sleepDetails.efficiency}
															</td>
															<td class="text-center">${sleepDetails.duration}</td>
															<td class="text-center">${sleepDetails.awakeCount}</td>
															<td class="text-center">${sleepDetails.restlessCount}</td>
														</tr>					
													</tbody>
												</table>
											</div>

											<div class="modal-footer no-margin-top">
												<button class="btn btn-sm btn-danger pull-left" data-dismiss="modal">
													<i class="ace-icon fa fa-times"></i>
													Close
												</button>

						
											</div>
										</div><!-- /.modal-content -->
									</div><!-- /.modal-dialog -->
								</div>

		<div class="footer">
			<div class="footer-inner">
				<!-- #section:basics/footer -->
				<div class="footer-content">
					<span class="bigger-120"> <span class="blue bolder">Ace</span>
						Application &copy; 2013-2014
					</span> &nbsp; &nbsp; <span class="action-buttons"> <a href="#">
							<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-rss-square orange bigger-150"></i>
					</a>
					</span>
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
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/assets/css/ace.onpage-help.css" />
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/assets/js/themes/sunburst.css" />

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
</body>
</html>
