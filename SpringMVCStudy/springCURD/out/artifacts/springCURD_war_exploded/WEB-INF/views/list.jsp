<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2020/1/16
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<!-- 导入JSTL的标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息表</title>
</head>
<body>
<h1 align="center">员工信息列表</h1>
<table border="1px" align="center" width="70%" cellspacing="0px">
    <tr>
        <th>Id</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Gender</th>
        <th>DeptName</th>
        <th>Operation</th>
    </tr>
    <!-- 通过迭代模型数据，生成表格 -->
    <c:forEach items="${emps}" var ="emp">
        <tr align="center">
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.department.departmentName}</td>
            <td>
                <a href="#">Edit</a>
                &nbsp;&nbsp;
                <a href="#">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2 align="center"><a href="emp">Add New Emp</a></h2>
</body>
</html>
