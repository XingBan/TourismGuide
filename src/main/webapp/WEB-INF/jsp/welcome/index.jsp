<%@page import="com.guide.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="keywords"
	content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon" href="#" type="image/png">

<title>主页</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	String user = (String) request.getSession().getAttribute("username");
%>
<!--icheck-->
<link href="${APP_PATH }/static/js/iCheck/skins/minimal/minimal.css"
	rel="stylesheet">
<link href="${APP_PATH }/static/js/iCheck/skins/square/square.css"
	rel="stylesheet">
<link href="${APP_PATH }/static/js/iCheck/skins/square/red.css"
	rel="stylesheet">
<link href="${APP_PATH }/static/js/iCheck/skins/square/blue.css"
	rel="stylesheet">

<!--dashboard calendar-->
<link href="${APP_PATH }/static/css/clndr.css" rel="stylesheet">

<!--Morris Chart CSS -->
<link rel="stylesheet"
	href="${APP_PATH }/static/js/morris-chart/morris.css">

<!--common-->
<link href="${APP_PATH }/static/css/style.css" rel="stylesheet">
<link href="${APP_PATH }/static/css/style-responsive.css"
	rel="stylesheet">




<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header">
<div class="modal fade" id="editPwdModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">修改密码</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" id="commentator_award_form">
			  <div class="form-group">
			    <label class="col-sm-3 control-label">旧密码</label>
			    
			    <div class="col-sm-9">
			      	<input type="password" name="oldPwd" class="form-control" id="old_pwd" placeholder="输入旧密码">
			      	<span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-3 control-label">新密码</label>
			    <div class="col-sm-9">
			      <input type="password" name="userPwd" class="form-control" id="new_pwd" placeholder="输入新密码">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label class="col-sm-3 control-label">再次输入新密码</label>
			    <div class="col-sm-9">
			      <input type="password" name="newPwdAgain" class="form-control" id="new_pwd_again" placeholder="再次输入新密码">
			      <span class="help-block"></span>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="btn_pwd_save">修改</button>
	      </div>
	    </div>
	  </div>
	</div>
	<section> <!-- left side start-->
	<div class="left-side sticky-left-side">

		<!--logo and iconic logo start-->
		<div class="logo">
			<a href="${APP_PATH }/turn_index"><img
				src="${APP_PATH }/static/images/logo.png" alt=""></a>
		</div>

		<div class="logo-icon text-center">
			<a href="index.html"><img
				src="${APP_PATH }/static/images/logo_icon.png" alt=""></a>
		</div>
		<!--logo and iconic logo end-->

		<div class="left-side-inner">
			<!--sidebar nav start-->
			<ul class="nav nav-pills nav-stacked custom-nav">
				<li class="active"><a href="${APP_PATH }/turn_index"><i
						class="fa fa-home"></i><span>首页</span></a></li>
				<li class="menu-list"><a href=""><i
						class="fa fa-location-arrow"></i> <span>金牌导游</span></a>
					<ul class="sub-menu-list">
						<li><a href="${APP_PATH }/turn_guide_page"> 导游信息</a></li>
						<c:if test="${userpower  == 1}">
							<li><a href="${APP_PATH }/turn_add_guide"> 导入导游</a></li>
						</c:if>
					</ul></li>

				<li class="menu-list"><a href=""><i
						class="fa fa-microphone"></i> <span>金牌讲解员</span></a>
					<ul class="sub-menu-list">
						<li><a href="${APP_PATH }/turn_commentator_page"> 讲解员信息</a></li>
						<c:if test="${userpower  == 1}">
							<li><a href="${APP_PATH }/turn_add_commentator"> 导入讲解员</a></li>
						</c:if>
					</ul></li>
				<c:if test="${userpower  == 1}">
					<li class="menu-list"><a href=""><i class="fa fa-cog"></i>
							<span>权限管理</span></a>
						<ul class="sub-menu-list">
							<li><a href="${APP_PATH }/turn_power_page"> 权限管理</a></li>
						</ul></li>
				</c:if>
			</ul>
			<!--sidebar nav end-->
		</div>
	</div>
	<!-- left side end--> <!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<div class="header-section">
			<!--toggle button start-->
			<a class="toggle-btn"><i class="fa fa-bars"></i></a>
			<!--toggle button end-->
			<!--notification menu start -->
			<div class="menu-right">
				<ul class="notification-menu">
					<li><a href="#" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">${username }<span class="caret"></span>
					</a>
						<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
							<li><a href="#" id="edit_pwd"><i class="fa fa-cog" ></i> 修改密码</a></li>
							<li><a href="#" id="login_out"><i class="fa fa-sign-out"></i>
									退出登录</a></li>
						</ul></li>
				</ul>
			</div>
			<!--notification menu end -->
		</div>
		<!-- header section end-->
		<div class="wrapper">

			<div class="row">
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							金牌导游按年龄分布 <span class="tools pull-right"> <a
								href="javascript:;" class="fa fa-chevron-down"></a>
							</span>
						</div>
						<div class="panel-body">
							<div style="margin: auto; width: 80%; height: 400px;"
								id="guide_age"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							金牌讲解员按年龄分布 <span class="tools pull-right"> <a
								href="javascript:;" class="fa fa-chevron-down"></a>
							</span>
						</div>
						<div class="panel-body">
							<div style="margin: auto; width: 80%; height: 400px;"
								id="commentator_age"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							金牌导游性别比例 <span class="tools pull-right"> <a
								href="javascript:;" class="fa fa-chevron-down"></a>
							</span>
						</div>
						<div class="panel-body">
							<div style="margin: auto; width: 80%; height: 400px;"
								id="guide_sex"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							金牌讲解员性别比例 <span class="tools pull-right"> <a
								href="javascript:;" class="fa fa-chevron-down"></a>
							</span>
						</div>
						<div class="panel-body">
							<div style="margin: auto; width: 80%; height: 400px;"
								id="commentator_sex"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							金牌导游所在地分布 <span class="tools pull-right"> <a
								href="javascript:;" class="fa fa-chevron-down"></a>
							</span>
						</div>
						<div class="panel-body">
							<div style="margin: auto; width: 80%; height: 500px;"
								id="guide_region"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							金牌讲解员所在地分布 <span class="tools pull-right"> <a
								href="javascript:;" class="fa fa-chevron-down"></a>
							</span>
						</div>
						<div class="panel-body">
							<div style="margin: auto; width: 80%; height: 500px;"
								id="commentator_region"></div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--footer section start-->
		<footer class="sticky-footer"> 2017 &copy; <a href="#"
			target="_blank">金牌导游和讲解员管理系统</a> </footer>
		<!--footer section end-->


	</div>
	<!-- main content end--> </section>

	<!-- 用户设置和退出登录 -->
	<script src="${APP_PATH }/static/js/jquery-1.10.2.min.js"></script>
	<script src="${APP_PATH }/static/js/echarts.js"></script>
	<script src="${APP_PATH }/static/js/china.js"></script>
	<script src="${APP_PATH }/static/js/fujian.js"></script>

	<script src="${APP_PATH }/static/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="${APP_PATH }/static/js/bootstrap.min.js"></script>
	<script src="${APP_PATH }/static/js/modernizr.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery.nicescroll.js"></script>
	<!--侧边栏-->
	<script src="${APP_PATH }/static/js/scripts.js"></script>
	<script type="text/javascript">
		var guideAge = echarts.init(document.getElementById('guide_age'));
		var guideSex = echarts.init(document.getElementById('guide_sex'));
		var guideRegion = echarts.init(document.getElementById('guide_region'));

		var commentatorAge = echarts.init(document
				.getElementById('commentator_age'));
		var commentatorSex = echarts.init(document
				.getElementById('commentator_sex'));
		var commentatorRegion = echarts.init(document
				.getElementById('commentator_region'));

		var age_atr = new Array();
		$.ajax({
			url : "${APP_PATH}/guide/selectcount",
			type : "get",
			success : function(result) {
				//console.log(result);
				var d = new Dictionary();
				var year_arr = new Array();
				$.each(result.extend.count, function(index, item) {
					//console.log(item);
					d.put(item.groups, item.counts);
				});
				year_arr[0] = d.get("20age") == null ? 0 : d.get("20age");
				year_arr[1] = d.get("30age") == null ? 0 : d.get("30age");
				year_arr[2] = d.get("40age") == null ? 0 : d.get("40age");
				year_arr[3] = d.get("50age") == null ? 0 : d.get("50age");
				year_arr[4] = d.get("60age") == null ? 0 : d.get("60age");
				year_arr[5] = d.get("70age") == null ? 0 : d.get("70age");
				year_arr[6] = d.get("80age") == null ? 0 : d.get("80age");

				guideAge.setOption({
					title : {
						text : '金牌导游按年龄分布',
						x : 'center'
					},
					color : [ '#3398DB' ],
					tooltip : {
						trigger : 'axis',
						axisPointer : { // 坐标轴指示器，坐标轴触发有效
							type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					xAxis : [ {
						type : 'category',
						data : [ '11-20', '21-30', '31-40', '41-50', '51-60',
								'61-70', '71-80' ],
						axisTick : {
							alignWithLabel : true
						}
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [ {
						name : '人数',
						type : 'bar',
						barWidth : '60%',
						data : year_arr

					} ]
				});
			}

		});
		$.ajax({
			url : "${APP_PATH}/guide/selectsex",
			type : "get",
			success : function(result) {
				console.log(result);
				var d = new Dictionary();
				$.each(result.extend.count, function(index, item) {
					//console.log(item);
					d.put(item.groups, item.counts);
				});
				guideSex.setOption({
					title : {
						text : '金牌导游性别比例',
						x : 'center'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {c} ({d}%)"
					},
					legend : {
						orient : 'vertical',
						left : 'left',
						data : [ '男', '女' ]
					},
					series : [ {
						name : '访问来源',
						type : 'pie',
						radius : '55%',
						center : [ '50%', '60%' ],
						data : [ {
							value : d.get("男") == null ? 0 : d.get("男"),
							name : '男'
						}, {
							value : d.get("女") == null ? 0 : d.get("女"),
							name : '女'
						} ],
						itemStyle : {
							emphasis : {
								shadowBlur : 10,
								shadowOffsetX : 0,
								shadowColor : 'rgba(0, 0, 0, 0.5)'
							}
						}
					} ]
				});

			}
		});

		$.ajax({
			url : "${APP_PATH}/guide/selectcity",
			type : "get",
			success : function(result) {
				console.log(result);
				var d = new Dictionary();
				$.each(result.extend.count, function(index, item) {
					//console.log(item);
					d.put(item.groups, item.counts);
				});
				console.log(d.get("厦门市"));
				guideRegion.setOption({
					title : {
						text : '金牌导游所在地分布',
						left : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					legend : {
						orient : 'vertical',
						left : 'left',
						data : [ '金牌导游分布' ],
						selected : {
							'金牌导游分布' : true,
						},
						selectedMode : 'single'
					},
					visualMap : {
						min : 0,
						max : 20,
						left : 'left',
						top : 'bottom',
						text : [ '高', '低' ], // 文本，默认为数值文本
						calculable : true
					},
					series : [ {
						name : '金牌导游',
						type : 'map',
						mapType : '福建',
						roam : false,
						label : {
							normal : {
								show : true
							}
						},
						data : [ {
							name : '南平市',
							value : d.get("南平市") == null ? 0 : d.get("南平市")
						}, {
							name : '宁德市',
							value : d.get("宁德市") == null ? 0 : d.get("宁德市")
						}, {
							name : '三明市',
							value : d.get("三明市") == null ? 0 : d.get("三明市")
						}, {
							name : '福州市',
							value : d.get("福州市") == null ? 0 : d.get("福州市")
						}, {
							name : '莆田市',
							value : d.get("莆田市") == null ? 0 : d.get("莆田市")
						}, {
							name : '龙岩市',
							value : d.get("龙岩市") == null ? 0 : d.get("龙岩市")
						}, {
							name : '厦门市',
							value : d.get("厦门市") == null ? 0 : d.get("厦门市")
						}, {
							name : '漳州市',
							value : d.get("漳州市") == null ? 0 : d.get("漳州市")
						}, {
							name : '泉州市',
							value : d.get("泉州市") == null ? 0 : d.get("泉州市")
						} ]
					} ]
				});
			}

		});

		var commentator_age_atr = new Array();
		$.ajax({
			url : "${APP_PATH}/commentator/selectcount",
			type : "get",
			success : function(result) {
				//console.log(result);
				var d = new Dictionary();
				var year_arr = new Array();
				$.each(result.extend.count, function(index, item) {
					//console.log(item);
					d.put(item.groups, item.counts);
				});
				year_arr[0] = d.get("20age") == null ? 0 : d.get("20age");
				year_arr[1] = d.get("30age") == null ? 0 : d.get("30age");
				year_arr[2] = d.get("40age") == null ? 0 : d.get("40age");
				year_arr[3] = d.get("50age") == null ? 0 : d.get("50age");
				year_arr[4] = d.get("60age") == null ? 0 : d.get("60age");
				year_arr[5] = d.get("70age") == null ? 0 : d.get("70age");
				year_arr[6] = d.get("80age") == null ? 0 : d.get("80age");

				commentatorAge.setOption({
					title : {
						text : '金牌讲解员按年龄分布',
						x : 'center'
					},
					color : [ '#3398DB' ],
					tooltip : {
						trigger : 'axis',
						axisPointer : { // 坐标轴指示器，坐标轴触发有效
							type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					xAxis : [ {
						type : 'category',
						data : [ '11-20', '21-30', '31-40', '41-50', '51-60',
								'61-70', '71-80' ],
						axisTick : {
							alignWithLabel : true
						}
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [ {
						name : '人数',
						type : 'bar',
						barWidth : '60%',
						data : year_arr

					} ]
				});
			}

		});
		$.ajax({
			url : "${APP_PATH}/commentator/selectsex",
			type : "get",
			success : function(result) {
				var d = new Dictionary();
				$.each(result.extend.count, function(index, item) {
					//console.log(item);
					d.put(item.groups, item.counts);
				});
				commentatorSex.setOption({
					title : {
						text : '金牌讲解员性别比例',
						x : 'center'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {c} ({d}%)"
					},
					legend : {
						orient : 'vertical',
						left : 'left',
						data : [ '男', '女' ]
					},
					series : [ {
						name : '访问来源',
						type : 'pie',
						radius : '55%',
						center : [ '50%', '60%' ],
						data : [ {
							value : d.get("男") == null ? 0 : d.get("男"),
							name : '男'
						}, {
							value : d.get("女") == null ? 0 : d.get(" "),
							name : '女'
						} ],
						itemStyle : {
							emphasis : {
								shadowBlur : 10,
								shadowOffsetX : 0,
								shadowColor : 'rgba(0, 0, 0, 0.5)'
							}
						}
					} ]
				});

			}
		});

		$.ajax({
			url : "${APP_PATH}/commentator/selectcity",
			type : "get",
			success : function(result) {
				console.log(result);
				var d = new Dictionary();
				$.each(result.extend.count, function(index, item) {
					//console.log(item);
					d.put(item.groups, item.counts);
				});
				console.log(d.get("厦门市"));
				commentatorRegion.setOption({
					title : {
						text : '金牌讲解员所在地分布',
						left : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					legend : {
						orient : 'vertical',
						left : 'left',
						data : [ '金牌导游分布' ],
						selected : {
							'金牌导游分布' : true,
						},
						selectedMode : 'single'
					},
					visualMap : {
						min : 0,
						max : 20,
						left : 'left',
						top : 'bottom',
						text : [ '高', '低' ], // 文本，默认为数值文本
						calculable : true
					},
					series : [ {
						name : '金牌讲解员',
						type : 'map',
						mapType : '福建',
						roam : false,
						label : {
							normal : {
								show : true
							}
						},
						data : [ {
							name : '南平市',
							value : d.get("南平市") == null ? 0 : d.get("南平市")
						}, {
							name : '宁德市',
							value : d.get("宁德市") == null ? 0 : d.get("宁德市")
						}, {
							name : '三明市',
							value : d.get("三明市") == null ? 0 : d.get("三明市")
						}, {
							name : '福州市',
							value : d.get("福州市") == null ? 0 : d.get("福州市")
						}, {
							name : '莆田市',
							value : d.get("莆田市") == null ? 0 : d.get("莆田市")
						}, {
							name : '龙岩市',
							value : d.get("龙岩市") == null ? 0 : d.get("龙岩市")
						}, {
							name : '厦门市',
							value : d.get("厦门市") == null ? 0 : d.get("厦门市")
						}, {
							name : '漳州市',
							value : d.get("漳州市") == null ? 0 : d.get("漳州市")
						}, {
							name : '泉州市',
							value : d.get("泉州市") == null ? 0 : d.get("泉州市")
						} ]
					} ]
				});
			}

		});

		//自定义键值对
		function Dictionary() {
			this.data = new Array();

			this.put = function(key, value) {
				this.data[key] = value;
			};

			this.get = function(key) {
				return this.data[key];
			};

			this.remove = function(key) {
				this.data[key] = null;
			};

			this.isEmpty = function() {
				return this.data.length == 0;
			};

			this.size = function() {
				return this.data.length;
			};
		}
		$("#login_out").click(function() {
			loginOut();
		})
		function loginOut(){
			$.ajax({
				url : "${APP_PATH }/login_out",
				type : "get",
				success : function(result) {
					window.location.href = "${APP_PATH}/";
				}
			})
		}
		console.log('${userpwd}');
		$("#edit_pwd").click(function(){
			reset_form("#editPwdModal form");
			$("#editPwdModal").modal({
				backdrop : "static"
			});
		});
		//清空表单样式及内容
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		//显示校验结果的提示信息
		function show_validate_msg(ele, status, msg) {
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		//校验表单数据
		function validate_add_forms() {
			//旧密码
			var oldPwd = $("#old_pwd").val();
			if (oldPwd.length == 0 | oldPwd != '${userpwd}') {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#old_pwd", "error", "输入的旧密码不正确");
				return false;
			} else {
				show_validate_msg("#old_pwd", "success", "");
			};
			//新密码
			var newPwd = $("#new_pwd").val();
			if (newPwd.length == 0) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#new_pwd", "error", "请输入新密码");
				return false;
			} else {
				show_validate_msg("#new_pwd", "success", "");
			};
			//再次新密码
			var newPwdAgain = $("#new_pwd_again").val();
			if (newPwdAgain.length == 0 | newPwdAgain!=newPwd) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#new_pwd_again", "error", "再次输入的密码不合法");
				return false;
			}else {
				show_validate_msg("#new_pwd_again", "success", "");
			};
			console.log($("#editPwdModal form").serialize());
			 $.ajax({
				url:"${APP_PATH}/updateuser/" + '${userid}',
				type:"PUT",
				data:$("#editPwdModal form").serialize(),
				success:function(result){
					$("#editPwdModal").modal('hide');
					alert("密码修改成功，请重新登陆");
					loginOut();
				}
			}); 
		}
		$("#btn_pwd_save").click(function(){
			if (!validate_add_forms()) {
				return false;
			}
			if ($(this).attr("ajax-va") == "error"
				|| $("#old_pwd").attr(
				"ajax-va") == "error"
				|| $("#new_pwd").attr(
				"ajax-va") == "error"
				|| $("#new_pwd_again").attr(
				"ajax-va") == "error") {
					return false;
			}
		});
		//验证密码合法性
		$("#new_pwd_again").change(function() {
			var name = this.value;
			var pattern = $("#new_pwd").val();
			if (pattern != name) {
				show_validate_msg("#new_pwd_again",
						"error", "两次输入密码不一致");
				$("#new_pwd_again").attr("ajax-va",
						"error");
			} else {
				show_validate_msg("#new_pwd_again",
						"success", "");
				$("#new_pwd_again").attr("ajax-va",
						"success");
			}
		});
	</script>
</body>
</html>
