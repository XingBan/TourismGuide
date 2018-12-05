<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("PATH", request.getContextPath());
%>

<title>Insert title here</title>
</head>
<body>
	<%-- <form method="POST" action="${PATH }/guide/uploadimg"
		enctype="multipart/form-data">
		File to upload: <input type="file" name="file"> <input
			type="submit" value="Upload"> Press here to upload the file!
	</form> --%>

	<form method="POST" enctype="multipart/form-data" id="form1">
		<table style="margin-left: 10px; margin-top: 10px">
			<tr>
				<td><input id="upfile" type="file" name="file"></td>
				<td><input type="button" class="btn btn-primary btn-sm"
					value="导入" id="btn"></td>
			</tr>
		</table>
	</form>


	<script src="${PATH }/static/js/jquery-1.10.2.min.js"></script>

	<script src="${PATH }/static/js/jquery.form.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#btn').click(function() {
				$('#form1').ajaxSubmit({
					url : '${PATH}/guide/uploadimg',
					dataType : 'text',
					success : function(result) {
						alert("上传成功");
						console.log(result);
					},
					error : function() {
						alert("导入excel出错！");
					}
				});
			});
		});
	</script>
	<!-- <script type="text/javascript">
		$("#button").click(function() {
			//alert("button");
			$.ajax({
				url : "${PATH}/getuser",
				type : "GET",
				success : function(result) {
					console.log(result);
				}
			});
		});
	</script> -->
</body>

</html>