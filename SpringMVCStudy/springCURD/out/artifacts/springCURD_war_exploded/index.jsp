<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/15 0015
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC CURD</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    上传文件:<input type="file" name="uploadFile"/>
    <br/>
    文件描述:<input type="text" name="desc"/>
    <br/>
    <input type="submit" value="上传"/>
</form>
<br/>
<a href="download">下载</a>
<br/>
<a href="testJson">Test Json </a>
<br/>
<a href="emps">List All Emps</a>
</body>
</html>
