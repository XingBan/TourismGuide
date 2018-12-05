<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon" href="#" type="image/png">

<title>Login</title>
<%
	pageContext.setAttribute("PATH", request.getContextPath());
%>
<link href="${PATH}/static/css/style.css" rel="stylesheet">
<link href="${PATH}/static/css/style-responsive.css" rel="stylesheet">
<script src="${PATH}/static/js/jquery-1.10.2.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

	<div class="container">
		<div class="form-signin">
			<form id="form-login">
				<div class="form-signin-heading text-center">
					<h1 class="sign-title">如故管理系统</h1>
					<img src="${PATH}/static/images/login-logo.png" alt="" />
				</div>
				<div class="login-wrap">
					<input type="text" id="userName" name="userName"
						class="form-control" placeholder="请输入用户名" autofocus> <input
						type="password" id="userPwd" name="userPwd" class="form-control"
						placeholder="请输入密码"><span style="color: red" class="help-block"></span>

				</div>
			</form>
			<div class="login-wrap">
				<button class="btn btn-lg btn-login btn-block" id="btn_login"
					type="submit">
					<i class="fa fa-check"></i>
				</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#btn_login").click(function() {
			$.ajax({
				url : "${PATH}/login_to",
				type : "POST",
				data : $("#form-login").serialize(),
				success : function(result) {
					if (result.extend.message == "登录成功!") {
						show_validate_msg("#userPwd", "success", "");
						window.location.href = "${PATH}/login_success";
					}else{
						show_validate_msg("#userPwd", "error", "用户名或密码错误");
					}
				}
			});
			//alert($("#form-login").serialize());
		});
		//显示校验结果的提示信息
		function show_validate_msg(ele, status, msg) {
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).next("span").text(msg);
			}
		}
	</script>
</body>
</html>
