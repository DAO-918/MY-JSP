
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>从指定域中获取指定键的值</title>
</head>
<body>
<%
    request.setAttribute("name","zhangsan");
    request.setAttribute("msg","xxxxxxx");
    session.setAttribute("msg","hello world");
%>

<h3>获取域对象的值</h3>
<%--zhangsan--%>
requestScope.name--->${requestScope.name}<br/>
<%--hello world--%>
sessionScope.msg--->${sessionScope.msg}<br/>
<%--xxxxxxx--%>
重复了，会获取哪个域的值-msg--->${msg}<br/>
<%--zhangsan--%>
不指定域的范围可以访问吗-name--->${name}<br/>
<%----%>
倘若没有值显示什么-word--->${word}<br/>

<%--
requestScope.name--->zhangsan
sessionScope.msg--->hello world
重复了，会获取哪个域的值-msg--->xxxxxxx
不指定域的范围可以访问吗-name--->zhangsan
倘若没有值显示什么-word--->
--%>
</body>
</html>
