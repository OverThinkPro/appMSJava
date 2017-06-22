<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>測試</title>
<link rel="stylesheet" href="style/reset.css">
<link rel="stylesheet" href="style/common.css">
<link rel="stylesheet" href="bootstrap-3.3.5/css/bootstrap.min.css">
<script type="text/javascript" src="jquery.min.js"></script>
<link rel="stylesheet" href="bootstrap-3.3.5/js/bootstrap.min.js">
<script type="text/javascript">
$(function() {
	$("#staffCall").click(function() {
		$.ajax({
			type: 'post',
			url: 'http://localhost:8080/appMSJava/api/v1/main//staff/alarm/4',
			data: null,
			success: function(result) {
				alert("员工呼叫成功")
			},
			error: function(result) {
			
			}
		});
	});
	
	$("#overtimeAlarm").click(function() {
		$.ajax({
			type: 'post',
			url: '',
			data: {
			
			},
			success: function(result) {
			
			},
			error: function(result) {
			
			}
		});
	});
});
</script>
</head>

<body>
	<main>
		<div class="title-box content-box text-center">
			<h3>实时报警mock数据测试</h3>
		</div>
		<div class="table-box">
			<div class="btn-box">
				<button type="button" class="btn btn-primary" id="staffCall">员工报警</button>
				<button type="button" class="btn btn-primary" id="overtimeAlarm">超时报警</button>
			</div>
		</div>
	</main>
</body>
</html>
