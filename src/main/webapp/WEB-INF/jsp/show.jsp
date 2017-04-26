<%@page import="com.test.ssm.domain.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>测试</title>
  </head>
  
  <body>
  我拍了来了
     
   <script type="text/javascript">
   		(function(){
   			alert(1111);
   			alert("${user.name}");
   			window.location.href ="${user.name}";
   		})();
   </script>
  </body>
</html>