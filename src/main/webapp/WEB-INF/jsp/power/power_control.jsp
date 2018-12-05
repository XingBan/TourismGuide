<%@page import="com.guide.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!-- 更新用户模态框 -->
	<div class="modal fade" id="userUpdateModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">更新用户</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" name="userName" class="form-control"
									id="userName_update_input" placeholder="请输入用户名"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="text" name="userPwd" class="form-control"
									id="userPwd_update_input" placeholder="请输入密码"> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">用户等级</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" name="userPower">
									<option value="1">管理员</option>
									<option value="0">普通用户</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="user_update_btn">更新</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加用户的模态框 -->
	<div class="modal fade" id="userAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加新用户</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" name="userName" class="form-control"
									id="userName_add_input" placeholder="请输入用户名"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="text" name="userPwd" class="form-control"
									id="userPwd_add_input" placeholder="请输入密码"> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">用户等级</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" name="userPower">
									<option value="1">管理员</option>
									<option value="0">普通用户</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="user_save_btn">保存</button>
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
				<li class="menu-list nav-active"><a href=""><i
						class="fa fa-cog"></i> <span>权限管理</span></a>
					<ul class="sub-menu-list">
						<li class="active"><a href="${APP_PATH }/turn_power_page">
								权限管理</a></li>
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
		<div class="page-heading">权限管理</div>
		<!-- header section end-->
		<div class="wrapper">

			<div class="row">
				<div class="col-md-4 col-md-offset-3">
					<h3>用户管理</h3>
				</div>
				<div class="col-md-2 col-md-offset-1">
					<button class="btn btn-primary" id="user_add_modal_btn">新增</button>
					<button class="btn btn-danger" id="user_delete_all_btn">删除</button>
				</div>
			</div>
			<div class="row" align="center">
				<div class="col-md-8 col-md-offset-2">
					<div class="panel">
						<table class="table table-hover" id="user_table">
							<thead>
								<tr>
									<th class="text-center"><input type="checkbox"
										id="check_all" /></th>
									<th class="text-center">#</th>
									<th class="text-center">用户名</th>
									<th class="text-center">密码</th>
									<th class="text-center">用户等级</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody class="text-center">

							</tbody>
						</table>
					</div>
					<div class="panel">
						<!-- 显示分页信息 -->
						<!--分页文字信息  -->
						<div class="col-md-6" id="page_info_area"></div>
						<!-- 分页条信息 -->
						<div class="col-md-6" id="page_nav_area"></div>
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
	<script src="${APP_PATH }/static/js/echarts.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="${APP_PATH }/static/js/bootstrap.min.js"></script>
	<script src="${APP_PATH }/static/js/modernizr.min.js"></script>
	<script src="${APP_PATH }/static/js/jquery.nicescroll.js"></script>
	<!--侧边栏-->
	<script src="${APP_PATH }/static/js/scripts.js"></script>
	<script type="text/javascript">
		var totalRecord, currentPage;
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
		$(function() {
			//去首页
			to_page(1);
		});

		function to_page(pn) {
			$.ajax({
				url : "${APP_PATH}/getuser",
				data : "pn=" + pn,
				type : "GET",
				success : function(result) {
					//console.log(result);
					//1、解析并显示员工数据
					build_user_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result);
				}
			});
		}

		function build_user_table(result) {
			//清空table表格
			$("#user_table tbody").empty();
			var user = result.extend.users.list;
			$
					.each(
							user,
							function(index, item) {
								var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
								var userIdTd = $("<td></td>").append(
										item.userId);
								var userNameTd = $("<td></td>").append(
										item.userName);
								var userPwdTd = $("<td></td>").append(
										item.userPwd);
								var userPowerTd = $("<td></td>").append(
										item.userPower == '1' ? "管理员" : "普通用户");

								/**
								<button class="">
													<span class="" aria-hidden="true"></span>
													编辑
												</button>
								 */
								var editBtn = $("<button></button>").addClass(
										"btn btn-primary btn-sm edit_btn")
										.append(
												$("<span></span>").addClass(
														"fa fa-pencil"))
										.append("编辑");
								//为编辑按钮添加一个自定义的属性，来表示当前员工id
								editBtn.attr("edit-id", item.userId);

								var delBtn = $("<button></button>").addClass(
										"btn btn-danger btn-sm delete_btn")
										.append(
												$("<span></span>").addClass(
														"fa fa-trash-o"))
										.append("删除");
								//为删除按钮添加一个自定义的属性来表示当前删除的员工id
								delBtn.attr("del-id", item.userId);
								var btnTd = $("<td></td>").append(editBtn)
										.append(" ").append(delBtn);
								//var delBtn = 
								//append方法执行完成以后还是返回原来的元素
								$("<tr></tr>").append(checkBoxTd).append(
										userIdTd).append(userNameTd).append(
										userPwdTd).append(userPowerTd).append(
										btnTd).appendTo("#user_table tbody");
							});
		}
		//解析显示分页信息
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前" + result.extend.users.pageNum + "页,总"
							+ result.extend.users.pages + "页,总"
							+ result.extend.users.total + "条记录");
			totalRecord = result.extend.users.total;
			currentPage = result.extend.users.pageNum;
		}
		//解析显示分页条，点击分页要能去下一页....
		function build_page_nav(result) {
			//page_nav_area
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");

			//构建元素
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (result.extend.users.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加点击翻页的事件
				firstPageLi.click(function() {
					to_page(1);
				});
				prePageLi.click(function() {
					to_page(result.extend.users.pageNum - 1);
				});
			}

			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			if (result.extend.users.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_page(result.extend.users.pageNum + 1);
				});
				lastPageLi.click(function() {
					to_page(result.extend.users.pages);
				});
			}

			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(result.extend.users.navigatepageNums, function(index, item) {

				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.users.pageNum == item) {
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
		//清空表单样式及内容
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		//点击新增按钮弹出模态框。
		$("#user_add_modal_btn").click(function() {
			//清除表单数据（表单完整重置（表单的数据，表单的样式））
			reset_form("#userAddModal form");
			//s$("")[0].reset();
			//发送ajax请求，查出部门信息，显示在下拉列表中
			//弹出模态框
			$("#userAddModal").modal({
				backdrop : "static"
			});
		});
		//校验表单数据
		function validate_add_form() {
			var userName = $("#userName_add_input").val();
			if (userName.length == 0) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#userName_add_input", "error", "请输入用户名");
				return false;
			} else {
				show_validate_msg("#userName_add_input", "success", "");
			}
			;

			var userPwd = $("#userPwd_add_input").val();
			if (userPwd.length == 0) {
				show_validate_msg("#userPwd_add_input", "error", "请输入密码");
				return false;
			} else {
				show_validate_msg("#userPwd_add_input", "success", "");
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
		//校验用户名是否可用
		$("#userName_add_input").change(
				function() {
					//发送ajax请求校验用户名是否可用
					var userName = this.value;
					$.ajax({
						url : "${APP_PATH}/checkuser",
						data : "userName=" + userName,
						type : "POST",
						success : function(result) {
							console.log(result);
							if (result.code == 100) {
								show_validate_msg("#userName_add_input",
										"success", "用户名可用");
								$("#user_save_btn").attr("ajax-va", "success");
							} else {
								show_validate_msg("#userName_add_input",
										"error", result.extend.va_msg);
								$("#user_save_btn").attr("ajax-va", "error");
							}
						}
					});
				});
		$("#user_save_btn").click(function() {
			if (!validate_add_form()) {
				return false;
			}
			;
			//1、判断之前的ajax用户名校验是否成功。如果成功。
			if ($(this).attr("ajax-va") == "error") {
				return false;
			}
			$.ajax({
				url : "${APP_PATH}/insertuser",
				type : "post",
				data : $("#userAddModal form").serialize(),
				success : function(result) {
					$("#userAddModal").modal('hide');
					//console.log(result);
					to_page(totalRecord);
				}
			});
		});
		$(document).on("click", ".edit_btn", function() {

			getUser($(this).attr("edit-id"));

			$("#user_update_btn").attr("edit-id", $(this).attr("edit-id"));
			$("#userUpdateModal").modal({
				backdrop : "static"
			});
		});
		function getUser(id) {
			$.ajax({
				url : "${APP_PATH}/getuserbyid/" + id,
				type : "get",
				success : function(result) {
					console.log(result);
					var user = result.extend.user;
					$("#userName_update_input").val(user.userName);
					$("#userPwd_update_input").val(user.userPwd);
					$("#userUpdateModal select").val([ user.userPower ]);
				}
			});
		}
		//点击更新，更新员工信息
		$("#user_update_btn").click(function() {

			//2、发送ajax请求保存更新的员工数据
			$.ajax({
				url : "${APP_PATH}/updateuser/" + $(this).attr("edit-id"),
				type : "PUT",
				data : $("#userUpdateModal form").serialize(),
				success : function(result) {
					//alert(result.msg);
					//1、关闭对话框
					$("#userUpdateModal").modal("hide");
					//2、回到本页面
					to_page(currentPage);
				}
			});
		});
		//单个删除
		$(document).on("click", ".delete_btn", function() {
			//1、弹出是否确认删除对话框
			var userName = $(this).parents("tr").find("td:eq(2)").text();
			var userId = $(this).attr("del-id");
			//alert($(this).parents("tr").find("td:eq(1)").text());
			if (confirm("确认删除【" + userName + "】吗？")) {
				//确认，发送ajax请求删除即可
				$.ajax({
					url : "${APP_PATH}/deluser/" + userId,
					type : "DELETE",
					success : function(result) {
						alert(result.msg);
						//回到本页
						to_page(currentPage);
					}
				});
			}
		});

		//完成全选/全不选功能
		$("#check_all").click(function() {
			//attr获取checked是undefined;
			//我们这些dom原生的属性；attr获取自定义属性的值；
			//prop修改和读取dom原生属性的值
			$(".check_item").prop("checked", $(this).prop("checked"));
		});

		//check_item
		$(document)
				.on(
						"click",
						".check_item",
						function() {
							//判断当前选择中的元素是否5个
							var flag = $(".check_item:checked").length == $(".check_item").length;
							$("#check_all").prop("checked", flag);
						});

		//点击全部删除，就批量删除
		$("#user_delete_all_btn").click(
				function() {
					//
					var userNames = "";
					var del_idstr = "";
					$.each($(".check_item:checked"), function() {
						//this
						userNames += $(this).parents("tr").find("td:eq(2)")
								.text()
								+ ",";
						//组装员工id字符串
						del_idstr += $(this).parents("tr").find("td:eq(1)")
								.text()
								+ "-";
					});
					//去除userNames多余的,
					userNames = userNames.substring(0, userNames.length - 1);
					//去除删除的id多余的-
					del_idstr = del_idstr.substring(0, del_idstr.length - 1);
					if (confirm("确认删除【" + userNames + "】吗？")) {
						//发送ajax请求删除
						$.ajax({
							url : "${APP_PATH}/deluser/" + del_idstr,
							type : "DELETE",
							success : function(result) {
								alert(result.msg);
								//回到当前页面
								to_page(currentPage);
							}
						});
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
