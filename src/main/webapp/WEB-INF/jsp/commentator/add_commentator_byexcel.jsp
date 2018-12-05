<%@page import="com.guide.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ pageContext.getAttribute("APP_PATH") + "/";
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
<!--dropzone css-->
<link href="${APP_PATH }/static/js/dropzone/css/dropzone.css"
	rel="stylesheet" />
<!--dashboard calendar-->
<link href="${APP_PATH }/static/css/clndr.css" rel="stylesheet">

<!--Morris Chart CSS -->
<link rel="stylesheet"
	href="${APP_PATH }/static/js/morris-chart/morris.css">

<!--common-->
<link href="${APP_PATH }/static/css/style.css" rel="stylesheet">
<link href="${APP_PATH }/static/css/style-responsive.css"
	rel="stylesheet">

<!--file upload-->
<link rel="stylesheet" type="text/css"
	href="${APP_PATH }/static/css/bootstrap-fileupload.min.css" />


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
				<li><a href="${APP_PATH }/turn_index"><i class="fa fa-home"></i><span>首页</span></a></li>
				<li class="menu-list"><a href=""><i
						class="fa fa-location-arrow"></i> <span>金牌讲解员</span></a>
					<ul class="sub-menu-list">
						<li><a href="${APP_PATH }/turn_guide_page"> 讲解员信息</a></li>
						<c:if test="${userpower  == 1}">
						<li><a href="${APP_PATH }/turn_add_guide"> 导入讲解员</a></li>
						</c:if>
					</ul></li>
					
				<li class="menu-list nav-active"><a href=""><i
						class="fa fa-microphone"></i> <span>金牌讲解员</span></a>
					<ul class="sub-menu-list">
						<li><a href="${APP_PATH }/turn_commentator_page"> 讲解员信息</a></li>
						<c:if test="${userpower  == 1}">
						<li class="active"><a href="${APP_PATH }/turn_add_commentator"> 导入讲解员</a></li>
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
	<div class="main-content" style="height: 100%">
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

		<!-- page heading start-->
		<div class="page-heading">批量导入金牌讲解员</div>
		<!-- page heading end-->

		<!--body wrapper start-->
		<div class="wrapper">
			<div class="panel" style="padding-bottom: 20px" style="height: 650px; overflow-y: scroll;">
				<header class="panel-heading"> 选择Excel文件(至少5条数据才能使用此功能)</header>
				<form method="POST" enctype="multipart/form-data" id="form1">
					<table style="margin-left: 10px; margin-top: 10px">
						<tr>
							<td><input id="upfile" type="file" name="upfile"></td>
							<td><input type="button" class="btn btn-primary btn-sm"
								value="导入" id="btn"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-success btn-sm"
								href="${APP_PATH }/commentator/download/?filename=金牌讲解员导入模板.xlsx" id="btn_download">模板下载</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<!--body wrapper end-->
		<!--footer section start-->
		<footer class="sticky-footer"> 2017 &copy; <a href="#"
			target="_blank">金牌讲解员和讲解员管理系统</a> </footer>
		<!--footer section end-->
	</div>
	</section>
	<!-- 用户设置和退出登录 -->
	<script src="${APP_PATH }/static/js/jquery-1.10.2.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery.form.js"></script>
	<script src="${APP_PATH }/static/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="${APP_PATH }/static/js/bootstrap.min.js"></script>
	<script src="${APP_PATH }/static/js/modernizr.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery.nicescroll.js"></script>
	<!--dropzone-->
	<script src="${APP_PATH }/static/js/dropzone/dropzone.js"></script>
	<!--侧边栏-->
	<script src="${APP_PATH }/static/js/scripts.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#btn').click(function() {
				if (checkData()) {
					$('#form1').ajaxSubmit({
						url : '${APP_PATH}/commentator/uploadexcels',
						dataType : 'text',
						success : function(result) {
							var results = JSON.parse(result);
							alert("成功导入" + results.extend.successcount + "条数据,失败" + results.extend.failcount + "条!");
							console.log(result);
						},
						error : function() {
							alert("导入excel出错！");
						}
					});
				}
			});
		});
		//JS校验form表单信息  
		function checkData() {
			var fileDir = $("#upfile").val();
			var suffix = fileDir.substr(fileDir.lastIndexOf("."));
			if ("" == fileDir) {
				alert("选择需要导入的Excel文件！");
				return false;
			}
			if (".xls" != suffix && ".xlsx" != suffix) {
				alert("选择Excel格式的文件导入！");
				return false;
			}
			return true;
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
