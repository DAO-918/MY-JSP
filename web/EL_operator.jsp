<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>elPage</title>
</head>
<body>

<%--jsp默认支持EL表达式--%>
${3 > 4}<br/>
<%--忽略EL表达式--%>
\${3 > 4}

<h3>算术运算符</h3>
${3+4}<br/>
${3/4}<br/>
${3 div 4}<br/>
${3%4}<br/>
${3 mod 4}<br/>

<h3>比较运算符</h3>
${3>4}<br/>
${4==3}<br/>

<h3>逻辑运算符</h3>
${3>4 && 4>3}<br/>
${3>4 and 4>3}<br/>

<h3>empty空运算符</h3>
<%
    String str = "abc";
    request.setAttribute("str",str);

    List list = new ArrayList<>();
    request.setAttribute("list",list);
%>
<%--str不为空，结果为false--%>
${empty str}<br/>
<%--str不为空，结果为true--%>
${not empty str}<br/>
<%--list为空，结果为true--%>
${empty list}<br/>
</body>
</html>