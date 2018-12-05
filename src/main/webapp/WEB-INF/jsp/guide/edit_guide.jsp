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
	pageContext.setAttribute("GUIDE_ID", request.getAttribute("guideId"));
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
<div class="modal fade" id="guideAwardUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">获奖信息修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" id="guide_award_form">
        <input type="hidden" name="guideAwardId" id="guide_award_id">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">获奖年份</label>
		    
		    <div class="col-sm-10">
		      	<input type="text" name="guideAwardYear" class="form-control" id="guide_award_year" placeholder="输入获奖年份">
		      	<span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">获奖名称</label>
		    <div class="col-sm-10">
		      <input type="text" name="guideAwardName" class="form-control" id="guide_award_name" placeholder="输入获奖名称">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="guide_award_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="guideAwardAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">获奖信息添加</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" id="guide_award_add_form">
        <input type="hidden" name="guideId" id="guide_add_id">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">获奖年份</label>
		    <div class="col-sm-10">
		      	<input type="text" name="guideAwardYear" class="form-control" id="guide_add_award_year" placeholder="输入获奖年份">
		      	<span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">获奖名称</label>
		    <div class="col-sm-10">
		      <input type="text" name="guideAwardName" class="form-control" id="guide_add_award_name" placeholder="输入获奖名称">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="guide_award_add_btn">添加</button>
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
				<li class="menu-list nav-active"><a href=""><i
						class="fa fa-location-arrow"></i> <span>金牌导游</span></a>
					<ul class="sub-menu-list">
						<li class="active"><a href="${APP_PATH }/turn_guide_page"> 导游信息</a></li>
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

		<!-- page heading start-->
		<div class="page-heading" id="head"></div>
		<!-- page heading end-->
		<!--body wrapper start-->
		<div class="wrapper">
			<div class="row">
				<div class="col-lg-6">
					<section class="panel"> <header class="panel-heading">
					修改金牌导游信息(放空或不动表示不修改)
					<button style="float: right;margin-right: 50px" class="btn btn-default" type="button" id="turn_back">返回</button>
					 <button style="float: right;margin-right: 10px" class="btn btn-primary" type="submit" id="guide-edit">保存</button>
									</header>
					<div class="panel-body">
						<div class="form">
							<form class="cmxform form-horizontal adminex-form"
								id="guideupdateform" method="get" action="">
								<input name="guideId" type="hidden" id="guideId">
								<div class="form-group ">
									<label class="control-label col-lg-2">姓名</label>
									<div class="col-lg-10">
										<input type="text" name="guideName" class="form-control"
											id="add_guide_name" placeholder="请输入金牌导游姓名">
									</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">性别</label>
									<div class="col-lg-10">
										<label class="radio-inline"> <input type="radio"
											name="guideGender" id="add_guide_man" value="M"
											checked="checked"> 男
										</label> <label class="radio-inline"> <input type="radio"
											name="guideGender" id="add_guide_woman" value="F"> 女
										</label>
									</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">年龄</label>
									<div class="col-lg-10">
										<input type="text" name="guideAge" class="form-control"
											id="add_guide_age" placeholder="请输入金牌导游年龄">
									</div>
								</div>

								<div class="form-group ">
									<label class="control-label col-lg-2">所在地</label>
									<div class="col-lg-10">
										<select id="s_city" name="guideCity">
											<option value="南平市" >南平市</option>
											<option value="宁德市" >宁德市</option>
											<option value="三明市" >三明市</option>
											<option value="福州市" >福州市</option>
											<option value="莆田市" >莆田市</option>
											<option value="泉州市" >泉州市</option>
											<option value="龙岩市" >龙岩市</option>
											<option value="厦门市" >厦门市</option>
											<option value="漳州市" >漳州市</option>
										</select>&nbsp;&nbsp;
									</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">身份证</label>
									<div class="col-lg-10">
										<input type="text" name="guideIdcard" class="form-control"
											id="add_guide_idcard" placeholder="请输入金牌导游身份证">
									</div>
								</div>


								<div class="form-group ">
									<label class="control-label col-lg-2">专业职称</label>
									<div class="col-lg-10">
										<input type="text" name="guideRecord" class="form-control"
											id="add_guide_record" placeholder="请输入金牌导游专业职称">
									</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">学历</label>
									<div class="col-lg-10">
									<select id="add_guide_education" name="guideEducation">
										<option value="小学学历" >小学学历</option>
										<option value="初中学历" >初中学历</option>
										<option value="高中学历" >高中学历</option>
										<option value="大专学历" >大专学历</option>
										<option value="本科学历" >本科学历</option>
										<option value="硕士研究生学历" >硕士研究生学历</option>
										<option value="博士研究生学历" >博士研究生学历市</option>
									</select>&nbsp;&nbsp;
									<span class="help-block"></span>
									</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">工作地点</label>
									<div class="col-lg-10">
										<input type="text" name="guideWorkPlace" class="form-control"
											id="add_guide_workplace" placeholder="请输入金牌导游现工作地点">
									</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">职位</label>
									<div class="col-lg-10">
										<input type="text" name="guideWorkPosition"
											class="form-control" id="add_guide_workposition"
											placeholder="请输入金牌导游现职位">
									</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">工作年龄</label>
									<div class="col-lg-10">
										<input type="text" name="guideWorkYear" class="form-control"
											id="add_guide_workage" placeholder="请输入金牌导游现工作年龄">
									</div>
								</div>

							</form>
							<form style="margin-top: 15px; margin-bottom: 15px"
								class="cmxform form-horizontal adminex-form" method="POST"
								enctype="multipart/form-data" id="form1">
								<div class="form-group ">
									<label class="control-label col-lg-2">图片</label>
									<div class="col-lg-10">

										<table style="margin-left: 5px">
											<tr>
												<td><input id="upfile" type="file" name="file"></td>
												<td><input type="button" class="btn btn-primary btn-sm"
													value="导入" id="btn"></td>
											</tr>
										</table>
									</div>
								</div>
							</form>
						</div>
					</div>
					</section>
				</div>
				
				
				
				<div class="col-lg-6">
					<section class="panel"> <header class="panel-heading">
					修改金牌导游获奖信息 
					<button style="float: right;margin-right: 50px" class="btn btn-danger" type="button" id="btn_del_all_guide_award">删除</button>
					<button style="float: right;margin-right: 10px" class="btn btn-primary" type="submit" id="btn_add_guide_award">新增</button>
					</header>
					<div class="panel-body">
						<!-- <form class="cmxform form-horizontal adminex-form"
								id="guideawardupdateform">
								<input name="guideAwardId" type="hidden" id="guideAwardId"> 
								<div class="form-group">
								<label class="col-lg-8"><h4>获奖信息</h4></label>
								<div class="control-label col-lg-4">
									<button class="btn btn-primary" type="submit" id="update_guide_award">修改</button>
									<button class="btn btn-danger" type="button" id="del_guide_award">删除</button>
								</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">获奖年份</label>
									<div class="col-lg-10">
										<input type="text" name="guideName" class="form-control"
											id="update_guide_award_year" placeholder="请输入金牌导游获奖年份">
									</div>
								</div>
								<div class="form-group ">
									<label class="control-label col-lg-2">获奖名称</label>
									<div class="col-lg-10">
										<input type="text" name="guideName" class="form-control"
											id="update_guide_award_name" placeholder="请输入金牌导游获奖名称">
									</div>
								</div>
							</form> -->
						<div class="col-lg-12">
							<table class="table table-hover" id="guide_award_table">
								<thead>
									<tr>
										<th><input type="checkbox" id="check_all" /></th>
										<th>#</th>
										<th>获奖年份</th>
										<th>获奖名称</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
						</div>
					</div>
					</section>
				</div>
			</div>
		</div>
		<!--body wrapper end-->
		<!--footer section start-->
		<footer class="sticky-footer"> 2017 &copy; <a href="#"
			target="_blank">金牌导游和讲解员管理系统</a> </footer>
		<!--footer section end-->
	</div>

	<!-- main content end--> </section>

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
		$.ajax({
			url : "${APP_PATH}/guide/getguideid/${GUIDE_ID}",
			type : "GET",
			success : function(result) {
				//console.log(result);
				formatGuide(result);
			}
		});
		function formatGuide(result) {
			var guide = result.extend.guide;
			var guideId = guide.guideId;
			var guideName = guide.guideName;
			var guideGender = guide.guideGender == 'M' ? '男' : '女';
			var guideAge = guide.guideAge;
			var guideRecord = guide.guideRecord;
			var guideEducation = guide.guideEducation;
			var guideIdcard = guide.guideIdcard;
			var guideCity = guide.guideCity;
			var guideWorkPlace = guide.guideWorkPlace;
			var guideWorkPosition = guide.guideWorkPosition;
			var guideWorkYear = guide.guideWorkYear;
			//var guideImageUrl = guide.guideImageUrl == null ? 'default.jpg' : guide.guideImageUrl;
			var guideIdcard = guide.guideIdcard;
			$("#head").append("修改" +guideName+"金牌导游信息");
			$("#guideId").val(guideId);
			$("#add_guide_name").val(guideName);

			$("#signupForm input[name=guideGender]").val([ guide.guideGender ]);

			$("#add_guide_age").val(guideAge);

			$("#s_city").val([ guideCity ]);

			$("#add_guide_idcard").val(guideIdcard);
			$("#add_guide_record").val(guideRecord);
			$("#add_guide_education").val([ guideEducation ]);
			$("#add_guide_workplace").val(guideWorkPlace);
			$("#add_guide_workposition").val(guideWorkPosition);
			$("#add_guide_workage").val(guideWorkYear);
			//$("#guidedetail_img").attr("src","${APP_PATH}/img/"+ guideImageUrl);
		}
		$("#guide-edit").click(function() {
			$.ajax({
				url : "${APP_PATH}/guide/updateguide",
				data : $("#guideupdateform").serialize(),
				type : "PUT",
				success : function(result) {
					alert("更新成功");
					window.location.href = "${APP_PATH}/turn_guide_page";
				}
			})
		});
		$("#turn_back").click(function() {
			window.location.href = "${APP_PATH}/turn_guide_page";
		});
		//获取金牌导游获奖信息
		$.ajax({
			url : "${APP_PATH}/guide/getguideAwardbyid/${GUIDE_ID}",
			type : "GET",
			success : function(result) {
				console.log(result);
				formatGuideAward(result);
			}
		});
		function formatGuideAward(result) {
			$("#guide_award_table tbody").empty();
			var guideAwards = result.extend.guideAwards;
			$.each(guideAwards, function(index, item) {
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				checkBoxTd.attr("guide_award_id",item.guideAwardId);
				var guideIdTd = $("<td></td>").append(index+1);
				var guideAwardYearTd = $("<td></td>").append(item.guideAwardYear);
				var guideAwardNameTd = $("<td></td>").append(item.guideAwardName);
				
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
				.append($("<span></span>").addClass("fa fa-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性，来表示当前员工id
				editBtn.attr("edit-id",item.guideAwardId);
				var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
								.append($("<span></span>").addClass("fa fa-trash-o")).append("删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的员工id
				delBtn.attr("del-id",item.guideAwardId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				$("<tr></tr>").append(checkBoxTd)
				.append(guideIdTd)
				.append(guideAwardYearTd)
				.append(guideAwardNameTd)
				.append(btnTd)
				.appendTo("#guide_award_table tbody");
			});
		}
		//完成全选/全不选功能
		$("#check_all").click(function(){
			//attr获取checked是undefined;
			//我们这些dom原生的属性；attr获取自定义属性的值；
			//prop修改和读取dom原生属性的值
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		//check_item
		$(document).on("click",".check_item",function(){
			//判断当前选择中的元素是否5个
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
		//更新获奖信息
		$(document).on("click",".edit_btn",function(){
			//alert("edit");
			//2、查出员工信息，显示员工信息
			getGuideAward($(this).attr("edit-id"));
			
			//3、把员工的id传递给模态框的更新按钮
			$("#guide_award_update_btn").attr("edit-id",$(this).attr("edit-id"));
			$("#guideAwardUpdateModal").modal({
				backdrop:"static"
			});
		});
		function getGuideAward(id){
			$.ajax({
				url:"${APP_PATH}/guide/getguideAwardbyguideId/" + id,
				type:"get",
				success:function(result){
					guideaward = result.extend.guideAward;
					$("#guide_award_id").val(guideaward.guideAwardId);
					$("#guide_award_year").val(guideaward.guideAwardYear);
					$("#guide_award_name").val(guideaward.guideAwardName);
				}
			});
		}
		$("#guide_award_update_btn").click(function(){
			$.ajax({
				url:"${APP_PATH}/guide/updateguideAwardByguideId",
				type:"put",
				data:$("#guide_award_form").serialize(),
				success:function(result){
					$("#guideAwardUpdateModal").modal('hide');
					 window.location.reload();
				}
			});
		});
		//添加获奖信息
		$("#btn_add_guide_award").click(function(){
			reset_form("#guideAwardAddModal form");
			$("#guideAwardAddModal").modal({
				backdrop:"static"
			});
		});
		$("#guide_award_add_btn").click(function(){
			if (!validate_add_form()) {
				return false;
			}
			//1、判断之前的ajax用户名校验是否成功。如果成功。
			if ($(this).attr("ajax-va") == "error") {
				return false;
			}
			$("#guide_add_id").val("${GUIDE_ID}");
			$.ajax({
				url:"${APP_PATH}/guide/insertGuideAward",
				type:"post",
				data:$("#guide_award_add_form").serialize(),
				success:function(result){
					//alert("success");
					$("#guideAwardAddModal").modal('hide');
					 window.location.reload();
				}
			});
		});
		//单个删除获奖信息
		$(document).on("click",".delete_btn",function(){
			if(confirm("确认删除这条信息吗？")){
				//确认，发送ajax请求删除即可
				var guideawardid = $(this).attr("del-id");
				$.ajax({
					url:"${APP_PATH}/guide/delGuideAward/"+guideawardid,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到本页
						window.location.reload();
					}
				});
			}
		});
		$("#btn_del_all_guide_award").click(function(){
			var del_idstr = "";
			var count = 0;
			$.each($(".check_item:checked"),function(){
				del_idstr += $(this).parents("tr").find("td:eq(0)").attr("guide_award_id")+"-";
				count++;
			})
			//alert(del_idstr);
			del_idstr = del_idstr.substring(0, del_idstr.length-1);
			if(confirm("确认删除这"+count+"条信息吗？")){
				$.ajax({
					url:"${APP_PATH}/guide/delGuideAward/"+del_idstr,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到当前页面
						//to_page(currentPage);
						window.location.reload();
					}
				})
			}
		});
		
		//清空表单样式及内容
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		//校验表单数据
		function validate_add_form() {
			var guideAwardYear = $("#guide_add_award_year").val();
			if (guideAwardYear.length == 0) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#guide_add_award_year", "error", "请输入获奖年份");
				return false;
			} else {
				show_validate_msg("#guide_add_award_year", "success", "");
			}
			;

			var guideAwardName = $("#guide_add_award_name").val();
			if (guideAwardName.length == 0) {
				show_validate_msg("#guide_add_award_name", "error", "请输入获奖名称");
				return false;
			} else {
				show_validate_msg("#guide_add_award_name", "success", "");
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
		$("#guide_add_award_year").change(function() {
			var age = this.value;
			var pattern = /^[0-9]{4}$/;
			if (!pattern.test(age)) {
				show_validate_msg("#guide_add_award_year", "error", "获奖年份格式不正确");
				$("#guide_add_award_year").attr("ajax-va", "error");
			} else {
				show_validate_msg("#guide_add_award_year", "success", "");
				$("#guide_add_award_year").attr("ajax-va", "success");
			}
		});
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
