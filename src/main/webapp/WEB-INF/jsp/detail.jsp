
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>detail</title>
<script src="resource/js/jquery-3.2.1.min.js">
</script>
<script src="resource/js/bootstrap.min.js"></script>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script src="resource/js/bootstrap-paginator.js"></script>
<link href="resource/css/css.css" rel="stylesheet" />
</head>
<body class="container">
	<div id="detail"></div>
	<div id="download">
		<div>下载地址：</div>
	</div>
	<script type="text/javascript">
		$(function() {
			getDetail('${url}');
	
		});
		function getDetail(url) {
			$.ajax({
				type : "get",
				url : "ajax/index/detail?url=" + url,
				async : true,
				dataType : "json",
				success : function(data) {
					$("#detail").append("" + data[0].detail);
					$("title").html(data[0].title);
					$("#download").append("" + data[0].download);
				},
				error : function(xml) {
					alert('An error happend while loading XML document ');
				}
			});
		}
	</script>
</body>
</html>
