<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--step:步长，i一次循环增加多少--%>
<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
    ${i}====>${s.count}<br/>
</c:forEach>
<%
    List list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("elist",list);
%>
<%--
items:容器对象
var:容器中元素的临时变量
varStatus:循环状态对象
index:容器中元素的索引，从0开始
count:循环次数，从1开始
--%>
<c:forEach items="${elist}" var="i" varStatus="s">
    ${s.index}===>${i}===>${s.count}<br/>
</c:forEach>
${elist}
<%--[aaa, bbb, ccc]--%>
${elist[0]}
<%--aaa--%>
<%--
1====>1
3====>2
5====>3
7====>4
9====>5
0===>aaa===>1
1===>bbb===>2
2===>ccc===>3
--%>
</body>
</html>
