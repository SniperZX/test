<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Sniper</title>

<script src="resource/js/jquery-3.2.1.min.js"></script>
<script src="resource/js/bootstrap.min.js"></script>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script src="resource/js/bootstrap-paginator.js"></script>
<link href="resource/css/css.css" rel="stylesheet" />
<style>
.content {
	padding: 3px;
	border: solid 1px;
	margin: 2px;
}
</style>

<script>
	$(function() {
		$('#pageLimit').bootstrapPaginator({
			currentPage : 1,
			totalPages : 10,
			size : "normal",
			bootstrapMajorVersion : 3,
			alignment : "right",
			numberOfPages : 5,
			itemTexts : function(type, page, current) {
				switch (type) {
				case "first":
					return "首页";
				case "prev":
					return "上一页";
				case "next":
					return "下一页";
				case "last":
					return "末页";
				case "page":
					return page;
				}
			}
		});
		getList(1);
	});
</script>
</head>

<body class="container">
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="index.html">首页</a>
		</li>
		<li><a href="index.html">电影</a></li>
		<li><a href="index.html">电视剧</a></li>
		<li><a href="index.html">综艺</a></li>
	</ul>

	<div class="col-md-12">
		<div class="col-md-12">
			<div id="list" class="row">
				<div class="content">
					<a href="index.html">电影标题</a>
				</div>
				<div class="content">
					<a href="index.html">电影标题</a>
				</div>

			</div>
		</div>

	</div>
	<div align="center">
		<nav aria-label="Page navigation">
			<ul id="pageLimit" class="pagination">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>

	<script>
		function getList(page) {
			$.ajax({
				type : "get",
				url : "ajax/index/list?page=" + page,
				async : true,
				dataType : "json",
				success : function(data) {
					var length = data.data.length;
					$("#list").html("");
					for (var i = 0; i < length; i++) {
						
						$("#list").append("<div class='content'><a href='javascript:void(0)' onclick=getDetail('" + data.data[i].url + "')> " + data.data[i].title + "</a></div>");
					}
					display(page, data.totalPage);
	
				},
				error : function(xml) {
					alert('An error happend while loading XML document ');
				}
			});
	
		}
	
		function getDetail(url) {
			window.location.href = '<%=basePath%>' + "detail?url=" + url;
	
		}
		//显示新闻评论  
		function display(curtpage, tpage) {
			var options = {
				bootstrapMajorVersion : 3, //版本  
				currentPage : curtpage, //当前页数  
				numberOfPages : 5, //设置显示的页码数  
				totalPages : tpage, //总页数  
				itemTexts : function(type, page, current) {
					switch (type) {
					case "first":
						return "首页";
					case "prev":
						return "上一页";
					case "next":
						return "下一页";
					case "last":
						return "末页";
					case "page":
						return page;
					}
				},
				onPageClicked : function(event, originalEvent, type, page) {
	
					//show the corresponding page and retrieve the newly built item related to the page clicked before for the event return
	
					var currentTarget = $(event.currentTarget);
	
					switch (type) {
					case "first":
						currentTarget.bootstrapPaginator("showFirst");
						getList(page);
						break;
					case "prev":
						currentTarget.bootstrapPaginator("showPrevious");
						getList(page);
						break;
					case "next":
						currentTarget.bootstrapPaginator("showNext");
						getList(page);
						break;
					case "last":
						currentTarget.bootstrapPaginator("showLast");
						getList(page);
						break;
					case "page":
						currentTarget.bootstrapPaginator("show", page);
						getList(page);
						break;
					}
	
				}
			}
			$("#pageLimit").bootstrapPaginator(options);
		}
	</script>

</body>

</html>