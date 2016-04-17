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
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
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
						class="fa fa-bed"></i> Smacrobs
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
							src="${userProfile.avatar}" alt="User's Photo" /> <span
							class="user-info"> <small>Welcome,</small>
								${userProfile.fullName}
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
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

		
			<!-- /.sidebar-shortcuts -->

			<!--SSR put the profile details here-->
			<div id="profile">


				<ul class="nav nav-list">
					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-user"></i> <span class="menu-text">
								${userProfile.fullName} </span>
					</a> <b class="arrow"></b></li>

					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-intersex"></i> <span class="menu-text">Gender:
								${userProfile.gender} </span>
					</a> <b class="arrow"></b></li>

					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-calendar"></i> <span class="menu-text">Age:
								${userProfile.age} </span>
					</a> <b class="arrow"></b></li>

					<li class=""><a href="index.html"> <i
							class="menu-icon fa fa-birthday-cake"></i> <span
							class="menu-text">DOB: ${userProfile.dateOfBirth}</span>
					</a> <b class="arrow"></b></li>

				</ul>

			</div>

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
						<li><i class="ace-icon fa fa-home home-icon active"></i> <a href="#">Home</a>
						</li>
					</ul>
					<!-- /.breadcrumb -->

				

					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<!--SSR #section:settings.box -->
					<div class="ace-settings-container" id="ace-settings-container">
						<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
							id="ace-settings-btn">
							<i class="ace-icon fa fa-cog bigger-130"></i>
						</div>
						<!-- Modal -->

						<script type="text/javascript">
							$(document).ready(function(){
							    $("#ace-settings-btn").click(function(){
							        $("#tisensorModal").modal();
							    });
							});
							</script>

					</div>
					<!-- /.ace-settings-box -->
				</div>
				<!-- /.ace-settings-container -->

				<div id="tisensorModal" class="modal fade" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header no-padding">
								<div class="table-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">
										<span class="white">&times;</span>
									</button>
									Input Ti Sensor Key
								</div>
							</div>

							<div class="modal-body no-padding">
								<hr />
								<div class="row">

									<div class="input-group col-md-offset-3 col-md-6">
										<input class="form-control input-mask-product"
											placeholder="TI Sensor Key" type="text"
											id="form-field-mask-3" /> <span class="input-group-addon">
											<i class="ace-icon fa fa-key"></i>
										</span>
									</div>
								</div>
								<hr />
								<!-- /.span -->
							</div>

							<div class="modal-footer no-margin-top">
								<button class="btn btn-sm btn-danger pull-left"
									data-dismiss="modal">
									<i class="glyphicon glyphicon-ok"></i> Submit
								</button>


							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>

				<!-- /section:settings.box -->
				<div class="row">
					<div class="col-xs-12">
						<!-- SSR page contents -->
						<!-- PAGE CONTENT BEGINS -->


						<div class="col-md-1 col-sm-4 col-xs-12">
							<div id="heartData">
								<span class="btn btn-app btn-sm btn-pink no-hover"> <span
									class="line-height-1 bigger-170"> <i
										class="fa fa-heartbeat"></i>
								</span> <br /> <span class="line-height-1 smaller-90">
										${heartRateDetails.heartRate}/minute </span>
								</span>
							</div>
							
							<div id="heartData">
								<span class="btn btn-app btn-sm btn-success no-hover"> <span
									class="line-height-1 bigger-170"> <i
										class="fa fa-cutlery"></i>
								</span> <br /> <span class="line-height-1 smaller-90">
										${heartRateDetails.heartRate}/minute </span>
								</span>
							</div>
						</div>
						
						<div class="col-md-1 col-sm-4 col-xs-12">
							<div id="heartData">
								<span class="btn btn-app btn-sm btn-purple no-hover"> <span
									class="line-height-1 bigger-170"> <i
										class="fa fa-beer"></i>
								</span> <br /> <span class="line-height-1 smaller-90">
										${heartRateDetails.heartRate}/minute </span>
								</span>
							</div>
							
							
							<div id="heartData">
								<span class="btn btn-app btn-sm btn-yellow no-hover"> <span
									class="line-height-1 bigger-170"> <i
										class="fa fa-moon-o"></i>
								</span> <br /> <span class="line-height-1 smaller-90">
										${heartRateDetails.heartRate}/minute </span>
								</span>
							</div>
						</div>

						
						<div id="steps" class="col-md-3 col-sm-6 col-xs-12" style="height: 200px"></div>
						<div id="floors" class="col-md-3 col-sm-6 col-xs-12" style="height: 200px"></div>
						<div id="distance" class="col-md-3 col-sm-6 col-xs-12" style="height: 200px"></div>
						<br><br>
						<div id="food" class="col-md-6 col-sm-6 col-xs-12" style="height: 250px"></div>
			


						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->


<!-- SSR Recommendations -->
<h3 class="header smaller lighter blue">Recommendations</h3>
				<div class="col-xs-12 col-sm-6 col-md-4 widget-container-col">
					<div class="widget-box widget-color-orange  light-border">
						<div class="widget-header">
							<h5 class="widget-title smaller">Light</h5>


						</div>

						<div class="widget-body scrollable">
							<div class="widget-main padding-6">
								<div class="alert alert-info">Hello World!</div>
								<div class="alert alert-success">Hello World!</div>
								<div class="alert alert-danger">Hello World!</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-4 widget-container-col">
					<div class="widget-box widget-color-blue light-border">
						<div class="widget-header">
							<h5 class="widget-title smaller">Food</h5>

						</div>

						<div class="widget-body scrollable">
							<div class="widget-main padding-6">
								<div class="alert alert-info">Hello World!</div>
								<div class="alert alert-success">Hello World!</div>
								<div class="alert alert-danger">Hello World!</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-4 widget-container-col">
					<div class="widget-box widget-color-pink light-border">
						<div class="widget-header">
							<h5 class="widget-title smaller">Temperature</h5>


						</div>

						<div class="widget-body scrollable">
							<div class="widget-main padding-6">
								<div class="alert alert-info">Hello World!</div>
								<div class="alert alert-success">Hello World!</div>
								<div class="alert alert-danger">Hello World!</div>
							</div>
						</div>
					</div>
				</div>




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
		
		//floors
		$(function () {
		    $('#floors').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'Floors'
		        },
		        
		        xAxis: {
		            categories: [
		                'Floors',
		            ],
		            crosshair: true
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: 'Floors'
		            }
		        },
		        tooltip: {
		            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
		            footerFormat: '</table>',
		            useHTML: true
		        },
		        plotOptions: {
		            column: {
		                pointPadding: 0.2,
		                borderWidth: 0,
		                series: {
		                    colorByPoint: true
		                }
		            }
		        },
		        series: [{
		            name: 'Current',
		            colorByPoint: false,
		            data: [9],
		            color:'#FFFF00'
		        }, {
		            name: 'Goal',
		            colorByPoint: false,
		            data: [10],
		            color:'#00FFFF'

		        }]
		    });
		});
		

		//steps
		$(function () {
		    $('#steps').highcharts({
		        chart: {
		            type: 'bar'
		        },
		        title: {
		            text: 'Steps'
		        },
		            
		        xAxis: {
		            categories: ['4/7/16'],
		            title: {
		                text: null
		            }
		        },
		        yAxis: {
		            min: 0,
		            max:10000,
		            title: {
		                text: 'Steps (thousands)',
		                align: 'high'
		            },
		            labels: {
		                overflow: 'justify'
		            }
		        },
		            tooltip: {
		            headerFormat: '<b>{point.key}</b><br>',
		            pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y} steps '
		        },
		        plotOptions: {
		            bar: {
		                dataLabels: {
		                    enabled: true
		                }
		            },
		            series: {
	                    colorByPoint: true
	                }
		        
		        },
		        
		        credits: {
		            enabled: false
		        },
		        series: [{
		            name: 'Currents',
		            colorByPoint: false,
		            data: [5000],
		        	color:'orange'
		        }, {
		            name: 'Goal',
		            colorByPoint: false,
		            data: [10000],
		            color:'#7FFF00'
		        }]
		    });
		});
		
		//distance
		$(function () {
    $('#distance').highcharts({
        chart: {
            type: 'column',
            options3d: {
                enabled: true,
                alpha: 5,
                beta: 15,
                viewDistance: 25,
                depth: 40
            }
        },

        title: {
            text: 'Distance'
        },

        xAxis: {
            categories: ['4/7/16']
        },

        yAxis: {
            allowDecimals: false,
            min: 0,
            title: {
                text: 'Distance'
            }
        },

        tooltip: {
            headerFormat: '<b>{point.key}</b><br>',
            pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
        },

        plotOptions: {
            column: {
                depth: 40
            },
            series: {
                colorByPoint: true
            }
        },

        series: [{
            name: 'Current',
            colorByPoint: false,
            data: [3.4],
            color:'#FFB6C1',
            stack: 'male'
        }, {
            name: 'Goal',
            colorByPoint: false,
            data: [5],
            color:'#00FF7F',
            stack: 'male'
        }]
    });
});
		//food
		$(function () {

		    $(document).ready(function () {

		        // Build the chart
		        $('#food').highcharts({
		            chart: {
		                plotBackgroundColor: null,
		                plotBorderWidth: null,
		                plotShadow: false,
		                type: 'pie'
		            },
		            title: {
		                text: 'Nutrition Values in gms'
		            },
		            tooltip: {
		                pointFormat: '{series.name}: <b>{point.percentage:.1f}gms</b>'
		            },
		            plotOptions: {
		                pie: {
		                    allowPointSelect: true,
		                    cursor: 'pointer',
		                    dataLabels: {
		                        enabled: false
		                    },
		                    showInLegend: true
		                }
		            },
		            series: [{
		                colorByPoint: true,
		                data: [{
		                    name: 'Carbs',
		                    y: 56.33,
		                    color:'#00FFFF'
		                }, {
		                    name: 'Fat',
		                    y: 24.03,
		                    color:'#7FFF00'
		                }, {
		                    name: 'Fibre',
		                    y: 10.38,
		                    color:'#FF00FF'
		                }, {
		                    name: 'Protein',
		                    y: 4.77,
		                    color:'#7B68EE'
		                }, {
		                    name: 'Sodium',
		                    y: 0.91,
		                    color:'	#FF0000'
		                }]
		            }]
		        });
		    });
		});
		
		</script>
</body>
</html>
