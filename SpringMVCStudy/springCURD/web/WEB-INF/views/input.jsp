<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/17 0017
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<!-- 导入SpringMVC表单标签库 -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- 导入JSTL标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<!-- SpringMVC的表单标签：
    1.可以快速的开发表单；
    2.可以更加方便的回显(modelAttribute)数据；
 -->

<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">

    <!--
        判断是添加操作还是修改操作：
            根据回显的Employee对象的id值来判断。如果有id就是修改，如果没有id就是添加操作
    -->
<c:if test="${!empty employee.id}" var="flag">
    <!-- 修改操作 -->
    <form:hidden path="id" />
    <!-- 隐藏PUT -->
    <input type="hidden" name="_method" value="PUT" />
</c:if>

    lastName:<form:input path="lastName"/> <!-- path就相当于HTML中input标签中的name属性 -->
    <%--        <input type="text" name="lastName" />--%>
    <br/>
    Email:<form:input path="email"/>
    <br/>
    Gender:<form:radiobuttons path="gender" items="${genders}"/>
    <br/>
    deptName:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"></form:select>
    <br />
    <c:if test="${flag}">
        <input type="submit" value="Edit" />
    </c:if>
    <c:if test="${!flag}">
        <input type="submit" value="Add" />
    </c:if>
</form:form>
</body>
</html>
