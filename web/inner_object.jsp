<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%--contentType等同于response.setContentType()--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    out.print("内置对象");
    pageContext.setAttribute("a","123");
    session.setAttribute("b","123");
    //int i=10/0;
  %>

  <%=pageContext.getAttribute("a")%>
  </body>
</html>
