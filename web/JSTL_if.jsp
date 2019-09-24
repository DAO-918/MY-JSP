<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>常用的JSTL标签</title>
</head>
<body>
<c:if test="true">
    test里面的boolean表达式为真,true,那么输出。。。
</c:if>

<%
    List list = new ArrayList<>();
    list.add("aaa");
    request.setAttribute("list",list);
    request.setAttribute("number",3);
%>
<c:if test="${empty list}">
    list集合为空
</c:if>
<c:if test="${not empty list}">
    list集合不为空
</c:if>

<c:if test="${number %2!=0}">
    ${number}是奇数
</c:if>
<c:if test="${number %2==0}">
    ${number}是偶数
</c:if>
</body>
</html>
