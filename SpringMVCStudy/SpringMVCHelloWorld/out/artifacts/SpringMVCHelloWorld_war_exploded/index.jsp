<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/9 0009
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<!-- 修改一个订单 -->
<form action="test/order" method="post">
  <input type="hidden" name="_method" value="PUT" />
  <input type="submit" value="REST PUT" />
</form>

<!-- 添加一个新的订单 -->
<form action="test/order" method="post">
  <input type="submit" value="REST POST" />
</form>

<!-- 删除id为1001的订单 -->
<form action="test/order/1001" method="post">
  <input type="hidden" name="_method" value="DELETE" />
  <input type="submit" value="REST DELETE">
</form>
<br />

<!-- 查询id=1001的订单 -->
<a href="test/order/1001">REST GET</a>
<br />

<a href="/test/testPathVariable/张三丰/123">test PathVariable</a>
<br />
<a href="/test/testParmsAndHeaders?username=刘德华&age=22">test Params and headers</a>
<br />

<form method="post" action="/test/testRequestMapping">
  <input type="submit" name="姓名" placeholder="请输入名字" />
</form>
<a href="test/testRequestMapping">Test RequestMapping</a>
<br/>
<!--
相对路径： /不以 / 开头的路径，相对于当前路径来发送请求。
绝对路径：以/开头的路径。直接在http://localhost:8888后面拼接请求。
-->
<a href="hello">Hello SpringMVC</a>
</body>
</html>
