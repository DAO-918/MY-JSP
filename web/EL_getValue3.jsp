<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>隐式对象：</title>
</head>
<body>
<h3>在jsp页面动态获取虚拟目录</h3>
虚拟目录：
<%--类似request.getContextPath()--%>
${pageContext.request.contextPath}<br/>
<%--虚拟目录： /MY_JSP--%>
</body>
</html>
