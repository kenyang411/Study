<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/17 0017
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<!-- 导入SpringMVC表单标签库 -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<!-- SpringMVC的表单标签：
    1.可以快速的开发表单；
    2.可以更加方便的回显数据；
 -->

<form:form action="emp" method="post">
    lastName:<form:input path="lastName"/> <!-- path就相当于HTML中input标签中的name属性 -->
    <%--        <input type="text" name="lastName" />--%>
    <br/>
    Email:<form:input path="email"/>
    <br/>
    Gender:<form:radiobuttons path="gender" items="${genders}"/>
    <br/>
    deptName:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"></form:select>
    <br />
    <input type="submit" value="Add" />

</form:form>
</body>
</html>
