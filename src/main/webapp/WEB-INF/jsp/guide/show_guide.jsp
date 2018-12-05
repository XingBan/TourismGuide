<%@page import="com.guide.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>

<body class="sticky-header">
	<div class="modal fade" id="editPwdModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="commentator_award_form">
						<div class="form-group">
							<label class="col-sm-3 control-label">旧密码</label>

							<div class="col-sm-9">
								<input type="password" name="oldPwd" class="form-control"
									id="old_pwd" placeholder="输入旧密码"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">新密码</label>
							<div class="col-sm-9">
								<input type="password" name="userPwd" class="form-control"
									id="new_pwd" placeholder="输入新密码"> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">再次输入新密码</label>
							<div class="col-sm-9">
								<input type="password" name="newPwdAgain" class="form-control"
									id="new_pwd_again" placeholder="再次输入新密码"> <span
									class="help-block"></span>
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
	<!-- 添加导游模态框 -->
	<!-- Modal -->
	<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
		tabindex="-1" id="addGuideModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close"
						type="button">×</button>
					<h4 class="modal-title">添加金牌导游</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" name="guideName" class="form-control"
									id="add_guide_name" placeholder="请输入金牌导游姓名"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="guideGender" id="add_guide_man" value="M"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="guideGender" id="add_guide_woman" value="F"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">年龄</label>
							<div class="col-sm-10">
								<input type="text" name="guideAge" class="form-control"
									id="add_guide_age" placeholder="请输入金牌导游年龄"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">所在地</label>
							<div class="col-sm-10">
								<!-- <select id="s_province" name="guideProvince"></select>&nbsp;&nbsp; -->
								<select id="s_city" name="guideCity">
									<option value="南平市">南平市</option>
									<option value="宁德市">宁德市</option>
									<option value="三明市">三明市</option>
									<option value="福州市">福州市</option>
									<option value="莆田市">莆田市</option>
									<option value="泉州市">泉州市</option>
									<option value="龙岩市">龙岩市</option>
									<option value="厦门市">厦门市</option>
									<option value="漳州市">漳州市</option>
								</select>&nbsp;&nbsp;
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">身份证</label>
							<div class="col-sm-10">
								<input type="text" name="guideIdcard" class="form-control"
									id="add_guide_idcard" placeholder="请输入金牌导游身份证"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">专业职称</label>
							<div class="col-sm-10">
								<input type="text" name="guideRecord" class="form-control"
									id="add_guide_record" placeholder="请输入金牌导游专业职称"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">学历</label>
							<div class="col-sm-10">
								<select id="add_guide_education" name="guideEducation">
									<option value="小学学历">小学学历</option>
									<option value="初中学历">初中学历</option>
									<option value="高中学历">高中学历</option>
									<option value="大专学历">大专学历</option>
									<option value="本科学历">本科学历</option>
									<option value="硕士研究生学历">硕士研究生学历</option>
									<option value="博士研究生学历">博士研究生学历市</option>
								</select>&nbsp;&nbsp; <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">工作地点</label>
							<div class="col-sm-10">
								<input type="text" name="guideWorkPlace" class="form-control"
									id="add_guide_workplace" placeholder="请输入金牌导游现工作地点"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">职位</label>
							<div class="col-sm-10">
								<input type="text" name="guideWorkPosition" class="form-control"
									id="add_guide_workposition" placeholder="请输入金牌导游现职位"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">工作年龄</label>
							<div class="col-sm-10">
								<input type="text" name="guideWorkYear" class="form-control"
									id="add_guide_workage" placeholder="请输入金牌导游现工作年龄"> <span
									class="help-block"></span>
							</div>
						</div>

					</form>
					<div class="form-group">
						<label class="col-sm-2 control-label">图片</label>
						<div class="col-sm-10">
							<form method="POST" enctype="multipart/form-data" id="form1">
								<table style="margin-left: 5px">
									<tr>
										<td><input id="upfile" type="file" name="file"></td>
										<td><input type="button" class="btn btn-primary btn-sm"
											value="导入" id="btn"></td>
									</tr>
								</table>
							</form>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-success" id="btn_add_guide">添加</button>
				</div>
			</div>
		</div>
	</div>
	<!-- modal -->
	<!-- 导游详情模态框 -->
	<!-- Modal -->
	<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
		tabindex="-1" id="guideDetailModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close"
						type="button">×</button>
					<h4 class="modal-title">金牌导游详情</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">


						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-6">
								<p class="form-control-static" id="guidedetail_name"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">性别</label>
							<div class="col-sm-6">
								<p class="form-control-static" id="guidedetail_sex"></p>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">年龄</label>
							<div class="col-sm-6">
								<p class="form-control-static" id="guidedetail_age"></p>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">所在地</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="guidedetail_from"></p>
							</div>
						</div>
						<div class="col-md-offset-7">
							<img style='height: 150px; width: 200px; margin-top: -150px'
								id='guidedetail_img'></img>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">身份证</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="guidedetail_idcard">保密</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">专业职称</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="guidedetail_record"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">学历</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="guidedetail_education"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">工作地点</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="guidedetail_workplace"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">职位</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="guidedetail_workposition"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">工作年龄</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="guidedetail_workage"></p>
							</div>
						</div>
						<div class="form-group" id="guide_award"></div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- modal -->
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
				<li class="menu-list nav-active"><a href=""><i
						class="fa fa-location-arrow"></i> <span>金牌导游</span></a>
					<ul class="sub-menu-list">
						<li class="active"><a href="${APP_PATH }/turn_guide_page">
								导游信息</a></li>
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
	<!-- left side end-->
	<!-- main content start-->
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
							<li><a href="#" id="edit_pwd"><i class="fa fa-cog"></i>
									修改密码</a></li>
							<li><a href="#" id="login_out"><i class="fa fa-sign-out"></i>
									退出登录</a></li>
						</ul></li>
				</ul>
			</div>
			<!--notification menu end -->

		</div>
		<!-- header section end-->

		<!-- page heading start-->
		<!-- page heading end-->
		<!--body wrapper start-->
		<div class="content">
			<section class="wrapper">
			<div class="row">
				<div class="page-heading">金牌导游列表</div>
				<div class="col-md-8" style="margin-left: 20px">
					<form id="search_form">
						<div class="col-md-3">
							<input style="width: 200px; float: left" type="text"
								class="form-control " id="seach_guide_name" name="guideName"
								placeholder="输入姓名进行查询">
						</div>
						<div class="col-md-3">
							<select class="form-control" size="1" name="guideGender"
								aria-controls="dynamic-table" id="seach_guide_gender">
								<option value="" selected="selected">按性别搜索</option>
								<option value="M">男</option>
								<option value="F">女</option>
							</select>
						</div>
						<div class="col-md-2">
							<select class="form-control" size="1" name="guideCity"
								aria-controls="dynamic-table" id="seach_guide_city">
								<option value="" selected="selected">按城市搜索</option>
								<option value="南平市">南平市</option>
								<option value="宁德市">宁德市</option>
								<option value="三明市">三明市</option>
								<option value="福州市">福州市</option>
								<option value="莆田市">莆田市</option>
								<option value="泉州市">泉州市</option>
								<option value="龙岩市">龙岩市</option>
								<option value="厦门市">厦门市</option>
								<option value="漳州市">漳州市</option>
							</select>
						</div>
						<div class="col-md-2">
							<select class="form-control" size="1" name="guideEducation"
								aria-controls="dynamic-table" id="seach_guide_education">
								<option value="" selected="selected">按学历搜索</option>
								<option value="小学学历">小学学历</option>
								<option value="初中学历">初中学历</option>
								<option value="高中学历">高中学历</option>
								<option value="大专学历">大专学历</option>
								<option value="本科学历">本科学历</option>
								<option value="硕士研究生学历">硕士研究生学历</option>
								<option value="博士研究生学历">博士研究生学历市</option>
							</select>
						</div>
					</form>
					<div class="col-md-1">
						<button style="margin-left: 10px" id="btn_search"
							class="btn btn-primary">
							<span class="fa fa-search"></span> 搜索
						</button>
						</div>
						<div class="col-md-1">	
						<button style="margin-left: 10px" id="btn_reset"
							class="btn btn-default">
							<span class="fa fa-coffee"></span> 重置
						</button>
					</div>

				</div>
				<c:if test="${userpower  == 1}">
					<div class="col-md-3" style="text-align: right">

						<button class="btn btn-primary" id="guide_add_modal"><span class="fa fa-plus"></span> 新增金牌导游</button>
						<button class="btn btn-danger" id="emp_add_guide_by_excel"><span class="fa   fa-external-link"></span> 导入金牌导游</button>
					</div>
				</c:if>
			</div>
			<div class="row" id="row_guide"
				style="height: 650px; overflow-y: scroll;">

				<%-- <div class="panel panel-body " align="center"
				style="width: 270px; height: 340px; margin: 20px; float: left">
				<img style="height: 150px; width: 200px"
					src="${APP_PATH }/static/images/default.jpg" alt="" />
				<h4>
					姓名：<small>Secondary text</small>
				</h4>
				<h4>
					性别：<small>Secondary text</small>
				</h4>
				<h4>
					工作地点：<small>Secondary text</small>
				</h4>
				<h4>
					职位：<small>Secondary text</small>
				</h4>
				<button style="width: 150px; height: 35px" class="btn btn-primary">详情信息</button>

				<div class="btn-group">
					<button data-toggle="dropdown"
						class="btn btn-default dropdown-toggle" type="button">
						&nbsp;···&nbsp;</button>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">编辑信息</a></li>
						<li class="divider"></li>
						<li><a href="#">删除讲解员</a></li>
					</ul>
				</div>
			</div> --%>
			</div>

			</section>
		</div>
		<!--body wrapper end-->
		<!--footer section start-->
		<footer class="sticky-footer">
		<div class="row">
			<div align="center" class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">
				<!-- <ul class="pagination pagination-lg">
                 <li><a href="#">«</a></li>
                 <li><a href="#">1</a></li>
                 <li class="active"><a href="#">2</a></li>
                 <li><a href="#">3</a></li>
                 <li><a href="#">4</a></li>
                 <li><a href="#">5</a></li>
                 <li><a href="#">»</a></li>
             </ul> -->
			</div>
		</div>

		2017 &copy; <a href="#" target="_blank">金牌导游和讲解员管理系统</a> </footer>
		<!--footer section end-->

	</div>


	<!-- main content end-->
	<!-- 用户设置和退出登录 -->
	<script src="${APP_PATH }/static/js/jquery-1.10.2.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery.form.js"></script>
	<script src="${APP_PATH }/static/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="${APP_PATH }/static/js/bootstrap.min.js"></script>
	<script src="${APP_PATH }/static/js/modernizr.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery.nicescroll.js"></script>
	<!--侧边栏-->
	<script src="${APP_PATH }/static/js/scripts.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#btn').click(function() {
				$('#form1').ajaxSubmit({
					url : '${APP_PATH}/guide/uploadimg',
					dataType : 'text',
					success : function(result) {
						alert("上传成功");
						console.log(result);
					},
					error : function() {
						alert("导入图片出错！");
					}
				});
			});
		});
	</script>
	<script type="text/javascript">
		var totalRecord;
		var currentPage;

		$(function() {
			to_page(1);
		});
		$("#btn_reset").click(function(){
			$("#seach_guide_name").val('');
			$("#seach_guide_gender").val('');
			$("#seach_guide_city").val('');
			$("#seach_guide_education").val('');
		});
		function to_page(pn) {
			$.ajax({
				url : "${APP_PATH}/guide/getguide",
				data : "pn=" + pn,
				type : "GET",
				success : function(result) {
					//console.log(result);
					build_guide_message(result);
					build_page_info(result);
					build_page_nav(result);
				}
			});
		}
		function build_guide_message(result) {
			$("#row_guide").empty();
			var guides = result.extend.guide.list;
			$
					.each(
							guides,
							function(index, item) {
								var sex = item.guideGender == 'M' ? '男' : '女';
								var guideImageUrl = item.guideImageUrl == null ? 'default.jpg'
										: item.guideImageUrl;
								var divAll = $("<div class='panel panel-body' align='center' style='width: 270px; height: 340px; margin: 20px; float: left'></div>");
								var guideAvatarItem = $("<img style='height: 150px; width: 200px' id='avatar'></img>");
								guideAvatarItem.attr("src", "${path}/"
										+ guideImageUrl);
								/* 
								<h4>
									姓名：<small>Secondary text</small>
								</h4>
								<img style='height: 150px; width: 200px' src='${APP_PATH}/img/default.jpg' id='avatar'></img>
								 */
								var guideNameItem = $("<h4></h4>")
										.append("姓名：").append(
												$("<small></small>").append(
														item.guideName));
								var guideGenderItem = $("<h4></h4>").append(
										"性别：").append(
										$("<small></small>").append(sex));
								var guideRecordItem = $("<h4></h4>").append(
										"职称：").append(
										$("<small></small>").append(
												item.guideRecord));
								var guideWorkPlaceItem = $("<h4></h4>").append(
										"工作地点：").append(
										$("<small></small>").append(
												item.guideWorkPlace));
								var guideDetailItem = $(
										"<button style='width: 150px; height: 35px' id='btn-detail'></button>")
										.addClass("btn btn-primary").addClass(
												"btn_detail").append("详情信息");
								guideDetailItem.attr("detail-id", item.guideId);
								/* 
								<div class="btn-group">
								<button data-toggle="dropdown" class="btn btn-default dropdown-toggle"
		type="button">
								&nbsp;···&nbsp;
								</button>
								<ul role="menu" class="dropdown-menu">
								<li><a href="#">编辑信息</a></li>
								<li class="divider"></li>
								<li><a href="#">删除讲解员</a></li>
								</ul>
								</div>
								 */
								var isPowerItem = $("<c:if test='${userpower  == 1}'></c:if>");
								var divItem = $("<div class='btn-group'></div>");
								var buttonItem = $("<button data-toggle='dropdown' class='btn btn-default dropdown-toggle' type='button'> &nbsp;···&nbsp; </button>");
								var ulItem = $("<ul role='menu' class='dropdown-menu'></ul>");
								var liEditItem = $("<li></li>");
								var liDelItem = $("<li></li>");
								var aEditItem = $("<a id='a-edit' href='#'>编辑信息</a>");
								var liLineItem = $("<li class='divider'></li>");
								var aDelItem = $("<a id='a-del' href='#'>删除讲解员</a>");
								aEditItem.attr("edit-id", item.guideId);
								aDelItem.attr("del-id", item.guideId);
								liEditItem.append(aEditItem);
								liDelItem.append(aDelItem);
								ulItem.append(liEditItem).append(liLineItem)
										.append(liDelItem);
								divItem.append(buttonItem).append(ulItem);
								isPowerItem.append(divItem);
								divAll.append(guideAvatarItem).append(
										guideNameItem).append(guideGenderItem)
										.append(guideRecordItem).append(
												guideWorkPlaceItem).append(
												guideDetailItem);
								if ('${userpower}' == 1) {
									//console.log('${userpower}');
									divAll.append(divItem);
								}
								divAll.appendTo("#row_guide");
								aDelItem.attr("del-name", item.guideName);
							});
		}
		function build_page_info(result) {
			$("#page_info_area").empty();
			/* <h3>h3. Bootstrap heading <small>Secondary text</small></h3> */
			/* $("#page_info_area").append("<h3><h3>"). */
			$("#page_info_area").append(
					"<h3>第<kbd>" + result.extend.guide.pageNum
							+ "</kbd>页,总<kbd>" + result.extend.guide.pages
							+ "</kbd>页,总<kbd>" + result.extend.guide.total
							+ "</kbd>条记录</h3>");
			totalRecord = result.extend.guide.total;
			currentPage = result.extend.guide.pageNum;
		}

		//解析显示分页条，点击分页要能去下一页....
		function build_page_nav(result) {
			//page_nav_area
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination pagination-lg");
			//构建元素
			var firstPageLi = $("<li style=''></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (result.extend.guide.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加点击翻页的事件
				firstPageLi.click(function() {
					to_page(1);
				});
				prePageLi.click(function() {
					to_page(result.extend.guide.pageNum - 1);
				});
			}

			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			if (result.extend.guide.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_page(result.extend.guide.pageNum + 1);
				});
				lastPageLi.click(function() {
					to_page(result.extend.guide.pages);
				});
			}
			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(result.extend.guide.navigatepageNums, function(index, item) {

				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.guide.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);
			//把ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		$("#btn_search").click(function() {
			//alert($("#input_guide_name").val());
			//var guideName = $("#input_guide_name").val();
			//alert($("#search_form").serialize());

			get_guide_by_name($("#search_form").serialize());
			
		});
		function get_guide_by_name(guideName) {

			console.log(guideName);
			$.ajax({
				url : "${APP_PATH}/guide/searchByNSCE",
				type : "GET",
				data : guideName,
				success : function(result) {
					console.log(result);
					if (result.code == 100) {
						build_guide_message(result);
						build_page_info(result);
						build_page_nav(result);
					} else {
						$("#row_guide").empty();
						$("#page_info_area").empty();
						$("#page_nav_area").empty();
						var errorH = $("<h1 align='center'></h1>").append(
								"查无此人");
						errorH.appendTo("#row_guide");
					}
				}
			});
		}
		//清空表单样式及内容
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		$("#guide_add_modal").click(function() {
			reset_form("#addGuideModal form");
			$("#addGuideModal").modal({
				backdrop : "static"
			});
		});

		//校验表单数据
		function validate_add_form() {
			//用户名
			var userName = $("#add_guide_name").val();
			if (userName.length == 0) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#add_guide_name", "error", "请输入金牌导游姓名");
				return false;
			} else {
				show_validate_msg("#add_guide_name", "success", "");
			}
			;
			//年龄
			var userAge = $("#add_guide_age").val();
			if (userAge.length == 0) {
				show_validate_msg("#add_guide_age", "error", "请输入年龄");
				return false;
			} else {
				show_validate_msg("#add_guide_age", "success", "");
			}
			;
			//身份证
			var userIdCrad = $("#add_guide_idcard").val();
			if (userIdCrad.length == 0) {
				show_validate_msg("#add_guide_idcard", "error", "请输入身份证");
				return false;
			} else {
				show_validate_msg("#add_guide_idcard", "success", "");
			}
			;
			//专业职称
			var userCecord = $("#add_guide_record").val();
			if (userCecord.length == 0) {
				show_validate_msg("#add_guide_record", "error", "请输入专业职称");
				return false;
			} else {
				show_validate_msg("#add_guide_record", "success", "");
			}
			;
			//学历
			var userEducation = $("#add_guide_education").val();
			if (userEducation.length == 0) {
				show_validate_msg("#add_guide_education", "error", "请输入学历");
				return false;
			} else {
				show_validate_msg("#add_guide_education", "success", "");
			}
			;
			//工作地点
			var userWrokPlace = $("#add_guide_workplace").val();
			if (userWrokPlace.length == 0) {
				show_validate_msg("#add_guide_workplace", "error", "请输入工作地点");
				return false;
			} else {
				show_validate_msg("#add_guide_workplace", "success", "");
			}
			;
			//职位
			var userWorkPosition = $("#add_guide_workposition").val();
			if (userWorkPosition.length == 0) {
				show_validate_msg("#add_guide_workposition", "error", "请输入职位");
				return false;
			} else {
				show_validate_msg("#add_guide_workposition", "success", "");
			}
			;
			//工作年龄
			var userWrokAge = $("#add_guide_workage").val();
			if (userWrokAge.length == 0) {
				show_validate_msg("#add_guide_workage", "error", "请输入工作年龄");
				return false;
			} else {
				show_validate_msg("#add_guide_workage", "success", "");
			}
			;
			return true;
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

		$("#btn_add_guide")
				.click(
						function() {
							if (!validate_add_form()) {
								return false;
							}
							//console.log($("#addGuideModal form").serialize());
							//1、判断之前的ajax用户名校验是否成功。如果成功。
							if ($(this).attr("ajax-va") == "error"
									|| $("#add_guide_name").attr("ajax-va") == "error"
									|| $("#add_guide_age").attr("ajax-va") == "error"
									|| $("#add_guide_idcard").attr("ajax-va") == "error"
									|| $("#add_guide_record").attr("ajax-va") == "error"
									|| $("#add_guide_education")
											.attr("ajax-va") == "error"
									|| $("#add_guide_workplace")
											.attr("ajax-va") == "error"
									|| $("#add_guide_workposition").attr(
											"ajax-va") == "error"
									|| $("#add_guide_workage").attr("ajax-va") == "error") {
								return false;
							}
							;
							$.ajax({
								url : "${APP_PATH}/guide/insertguide",
								type : "post",
								data : $("#addGuideModal form").serialize(),
								success : function(result) {
									$("#addGuideModal").modal('hide');
									//console.log(result);
									to_page(totalRecord);
								}
							});
						});

		//姓名
		$("#add_guide_name").change(function() {
			var name = this.value;
			var pattern = /(^[a-zA-Z_-]{1,16}$)|(^[\u2E80-\u9FFF]{1,20})/;
			if (!pattern.test(name)) {
				show_validate_msg("#add_guide_name", "error", "姓名格式不正确");
				$("#add_guide_name").attr("ajax-va", "error");
			} else {
				show_validate_msg("#add_guide_name", "success", "");
				$("#add_guide_name").attr("ajax-va", "success");

			}
		});
		//专业职称
		$("#add_guide_record").change(function() {
			var age = this.value;
			var pattern = /(^[a-zA-Z_-]{1,16}$)|(^[\u2E80-\u9FFF]{1,20})/;
			if (!pattern.test(age)) {
				show_validate_msg("#add_guide_record", "error", "专业职称格式不正确");
				$("#add_guide_record").attr("ajax-va", "error");
			} else {
				show_validate_msg("#add_guide_record", "success", "");
				$("#add_guide_record").attr("ajax-va", "success");
			}
		});
		//学历
		$("#add_guide_education").change(function() {
			var age = this.value;
			var pattern = /(^[a-zA-Z_-]{1,16}$)|(^[\u2E80-\u9FFF]{1,20})/;
			if (!pattern.test(age)) {
				show_validate_msg("#add_guide_education", "error", "学历格式不正确");
				$("#add_guide_education").attr("ajax-va", "error");
			} else {
				show_validate_msg("#add_guide_education", "success", "");
				$("#add_guide_education").attr("ajax-va", "success");
			}
		});
		//工作地点
		$("#add_guide_workplace")
				.change(
						function() {
							var age = this.value;
							var pattern = /(^[a-zA-Z_-]{1,16}$)|(^[\u2E80-\u9FFF]{1,20})/;
							if (!pattern.test(age)) {
								show_validate_msg("#add_guide_workplace",
										"error", "工作地点格式不正确");
								$("#add_guide_workplace").attr("ajax-va",
										"error");
							} else {
								show_validate_msg("#add_guide_workplace",
										"success", "");
								$("#add_guide_workplace").attr("ajax-va",
										"success");
							}
						});
		//职位
		$("#add_guide_workposition")
				.change(
						function() {
							var age = this.value;
							var pattern = /(^[a-zA-Z_-]{1,16}$)|(^[\u2E80-\u9FFF]{1,20})/;
							if (!pattern.test(age)) {
								show_validate_msg("#add_guide_workposition",
										"error", "职位格式不正确");
								$("#add_guide_workposition").attr("ajax-va",
										"error");
							} else {
								show_validate_msg("#add_guide_workposition",
										"success", "");
								$("#add_guide_workposition").attr("ajax-va",
										"success");
							}
						});
		//年龄
		$("#add_guide_age").change(function() {
			var age = this.value;
			var pattern = /^[0-9]{2}$/;
			if (!pattern.test(age)) {
				show_validate_msg("#add_guide_age", "error", "年龄格式不正确");
				$("#add_guide_age").attr("ajax-va", "error");
			} else {
				show_validate_msg("#add_guide_age", "success", "");
				$("#add_guide_age").attr("ajax-va", "success");
			}
		});
		//身份证
		$("#add_guide_idcard").change(function() {
			var age = this.value;
			var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			if (!pattern.test(age)) {
				show_validate_msg("#add_guide_idcard", "error", "身份证格式不正确");
				$("#add_guide_idcard").attr("ajax-va", "error");
			} else {
				show_validate_msg("#add_guide_idcard", "success", "");
				$("#add_guide_idcard").attr("ajax-va", "success");
			}
		});
		//工作年龄
		$("#add_guide_workage").change(function() {
			var age = this.value;
			var pattern = /^[0-9]{2}$/;
			if (!pattern.test(age)) {
				show_validate_msg("#add_guide_workage", "error", "工作年龄格式不正确");
				$("#add_guide_workage").attr("ajax-va", "error");
			} else {
				show_validate_msg("#add_guide_workage", "success", "");
				$("#add_guide_workage").attr("ajax-va", "success");
			}
		});
		$("#emp_add_guide_by_excel").click(function() {
			window.location.href = "${APP_PATH}/turn_add_guide";
		});
		$(document).on("click", "#btn-detail", function() {
			//alert($(this).attr("detail-id"));
			get_guide_by_id($(this).attr("detail-id"));
			getGuideAward($(this).attr("detail-id"));
			$("#guideDetailModal").modal({
				backdrop : "static"
			});
		});

		function get_guide_by_id(guideId) {
			$
					.ajax({
						url : "${APP_PATH}/guide/getguideid/" + guideId,
						type : "GET",
						success : function(result) {
							console.log(result);
							var guide = result.extend.guide;

							var guideName = guide.guideName;
							var guideGender = guide.guideGender == 'M' ? '男'
									: '女';
							var guideAge = guide.guideAge;
							var guideRecord = guide.guideRecord;
							var guideEducation = guide.guideEducation;
							var guideIdcard = guide.guideIdcard;
							var guideCity = guide.guideCity;
							var guideWorkPlace = guide.guideWorkPlace;
							var guideWorkPosition = guide.guideWorkPosition;
							var guideWorkYear = guide.guideWorkYear;
							var guideImageUrl = guide.guideImageUrl == null ? 'default.jpg'
									: guide.guideImageUrl;
							var guideIdcard = guide.guideIdcard;

							$("#guidedetail_name").text(guideName);
							$("#guidedetail_sex").text(guideGender);
							$("#guidedetail_age").text(guideAge);
							$("#guidedetail_record").text(guideRecord);
							$("#guidedetail_education").text(guideEducation);
							$("#guidedetail_workplace").text(guideWorkPlace);
							$("#guidedetail_workposition").text(
									guideWorkPosition);
							$("#guidedetail_workage").text(guideWorkYear);
							$("#guidedetail_from").text(guideCity);
							$("#guidedetail_img").attr("src",
									"${path}/" + guideImageUrl);
						}
					});
		}

		function getGuideAward(id) {
			$.ajax({
				url : "${APP_PATH}/guide/getguideAwardbyid/" + id,
				type : "get",
				success : function(result) {
					console.log(result);
					formatGuideAward(result);
				}
			});
		}
		/* 
		<div class="form-group">
			<label class="col-sm-2 control-label">工作年龄</label>
			<div class="col-sm-5">
				<p class="form-control-static" id="guidedetail_workage"></p>
			</div>
		</div>
		<id = guide_award>
		 */
		function formatGuideAward(result) {
			$("#guide_award").empty();
			var labelItem = $("<p class='col-sm-12'>&nbsp;&nbsp;&nbsp;获奖情况</p>");
			labelItem.appendTo("#guide_award");
			var guideAwards = result.extend.guideAwards;
			$
					.each(
							guideAwards,
							function(index, item) {
								var divAllItem = $("<div class='form-group'></div>");
								/* var labelItem = $("<div class='col-sm-12'></div>");
								var labelDetailItem = $("<p class='form-control-static'></p>").append("获奖情况").append(index+1);
								labelItem.append(labelDetailItem); */

								var divYearItem = $("<div class='col-sm-2'></div>");
								var yearItem = $(
										"<p class='form-control-static' id='guidedetail_workage'></p>")
										.append("获奖时间");
								divYearItem.append(yearItem);

								var divYearDetailItem = $("<div class='col-sm-2'></div>");
								var yearDetailItem = $(
										"<p class='form-control-static' id='guidedetail_workage'></p>")
										.append(item.guideAwardYear);
								divYearDetailItem.append(yearDetailItem);

								var divNameItem = $("<div class='col-sm-2'></div>");
								var nameItem = $(
										"<p class='form-control-static' id='guidedetail_workage'></p>")
										.append("获奖名称");
								divNameItem.append(nameItem);

								var divNameDetailItem = $("<div class='col-sm-6'></div>");
								var nameDetailItem = $(
										"<p class='form-control-static' id='guidedetail_workage'></p>")
										.append(item.guideAwardName);
								divNameDetailItem.append(nameDetailItem);

								divAllItem.append(divYearItem).append(
										divYearDetailItem).append(divNameItem)
										.append(divNameDetailItem).appendTo(
												"#guide_award");

							});
		}
		$(document).on(
				"click",
				"#a-edit",
				function() {
					window.location.href = "${APP_PATH}/editguide/"
							+ $(this).attr("edit-id");
				});

		//通过id删除导游
		$(document).on(
				"click",
				"#a-del",
				function() {
					if (confirm("确认删除【" + $(this).attr("del-name") + "】吗？")) {
						$.ajax({
							url : "${APP_PATH}/guide/delguide/"
									+ $(this).attr("del-id"),
							type : "delete",
							success : function(result) {
								alert("删除成功");
								to_page(currentPage);
							}

						});
					}
				});
		$("#login_out").click(function() {
			loginOut();
		})
		function loginOut() {
			$.ajax({
				url : "${APP_PATH }/login_out",
				type : "get",
				success : function(result) {
					window.location.href = "${APP_PATH}/";
				}
			})
		}
		console.log('${userpwd}');
		$("#edit_pwd").click(function() {
			reset_form("#editPwdModal form");
			$("#editPwdModal").modal({
				backdrop : "static"
			});
		});
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
			}
			;
			//新密码
			var newPwd = $("#new_pwd").val();
			if (newPwd.length == 0) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#new_pwd", "error", "请输入新密码");
				return false;
			} else {
				show_validate_msg("#new_pwd", "success", "");
			}
			;
			//再次新密码
			var newPwdAgain = $("#new_pwd_again").val();
			if (newPwdAgain.length == 0 | newPwdAgain != newPwd) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#new_pwd_again", "error", "再次输入的密码不合法");
				return false;
			} else {
				show_validate_msg("#new_pwd_again", "success", "");
			}
			;
			console.log($("#editPwdModal form").serialize());
			$.ajax({
				url : "${APP_PATH}/updateuser/" + '${userid}',
				type : "PUT",
				data : $("#editPwdModal form").serialize(),
				success : function(result) {
					$("#editPwdModal").modal('hide');
					alert("密码修改成功，请重新登陆");
					loginOut();
				}
			});
		}
		$("#btn_pwd_save").click(
				function() {
					if (!validate_add_forms()) {
						return false;
					}
					if ($(this).attr("ajax-va") == "error"
							|| $("#old_pwd").attr("ajax-va") == "error"
							|| $("#new_pwd").attr("ajax-va") == "error"
							|| $("#new_pwd_again").attr("ajax-va") == "error") {
						return false;
					}
				});
		//验证密码合法性
		$("#new_pwd_again").change(function() {
			var name = this.value;
			var pattern = $("#new_pwd").val();
			if (pattern != name) {
				show_validate_msg("#new_pwd_again", "error", "两次输入密码不一致");
				$("#new_pwd_again").attr("ajax-va", "error");
			} else {
				show_validate_msg("#new_pwd_again", "success", "");
				$("#new_pwd_again").attr("ajax-va", "success");
			}
		});
	</script>
</body>
</html>
