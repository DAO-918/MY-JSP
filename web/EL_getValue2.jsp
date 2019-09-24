<%@ page import="com.company.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象、List集合、Map集合的值</title>
</head>
<body>
<%
    User user = new User();
    user.setName("zhangsan");
    user.setDate(new Date());
    request.setAttribute("user",user);

    //定义一个集合
    List list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("elist",list);

    //定义一个Map
    Map map = new HashMap<>();
    map.put("name","zhangsan");
    map.put("date","2019");
    map.put("user",user);
    request.setAttribute("emap",map);
%>
<h3>访问自定义对象中的属性</h3>
<%--可以省略requestScope--%>
${requestScope.user}<br/>
${requestScope.user.name}<br/>
${requestScope.user.date}<br/>
<%--获取到的是Date--%>
${requestScope.user.dateStr}<br/>
<%--获取到的是String--%>
<%--error
${requestScope.user.datestr}<br/>
--%>

<h3>访问集合中的值</h3>

${elist}<br/>
${elist[0]}<br/>
${elist[1]}<br/>
${elist[10]}<br/><%--不报错--%>
${elist[2].name}<br/>
${elist[2].date}<br/>

<h3>访问Map的值</h3>

${emap}<br/>
${emap.name}<br/>
${emap.date}<br/>
${emap["date"]}<br/>
${emap.user.name}<br/>
${emap.user.date}<br/>
<%--error
${emap.user.datestr}<br/>
--%>

<%--
访问自定义对象中的属性
com.company.User@4644d847
zhangsan
Fri Sep 20 11:30:20 CST 2019
2019-09-20

访问集合中的值
[aaa, bbb, com.company.User@4644d847]
aaa
bbb

zhangsan
Fri Sep 20 11:30:20 CST 2019

访问Map的值
{date=2019, name=zhangsan, user=com.company.User@4644d847}
zhangsan
2019
2019
zhangsan
Fri Sep 20 11:30:20 CST 2019
--%>
</body>
</html>
