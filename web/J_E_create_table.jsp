<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.company.People" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>使用JSTL+EL 将List集合数据展示到 jsp 页面的表格 table 中</title>
</head>
<body>
<%
    List<People> list = new ArrayList<>();
    People people1 = new People("zhangsan",22,new Date());
    People people2 = new People("lisi",33,new Date());
    People people3 = new People("wangwu",44,new Date());
    list.add(people1);
    list.add(people2);
    list.add(people3);
    request.setAttribute("peo_list",list);
    //没有该句下面的JSP语句无法读取到list集合
%>
<table border="1px solid black" cellpadding="5px" cellspacing="0" align="center">
    <tr align="center">
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>日期</td>
    </tr>

    <c:forEach items="${peo_list}" var="peo" varStatus="s">
        <c:if test="${s.count%2 != 0}">
        <tr bgcolor="#88d47e">
            <td>${s.count}</td>
            <td>${peo.name}</td>
            <td>${peo.age}</td>
            <td>${peo.brithStr}</td>
        </tr>
        </c:if>
        <c:if test="${s.count%2 == 0}">
            <tr bgcolor="#82d4a3">
                <td>${s.count}</td>
                <td>${peo.name}</td>
                <td>${peo.age}</td>
                <td>${peo.brithStr}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
