<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传页面</title>
</head>
<body>
<%--
一定要用post
enctype="multipart/form-data"
--%>
<form action="${pageContext.request.contextPath}/upload_Servlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="name" placeholder="请输入用户名"/><br/>
    文件：<input type="file" name="file"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
