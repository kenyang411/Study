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
    <!--
    Springmvc处理静态资源的问题：
        静态资源：
        因为DispatcherServlet的<url-pattern>配置的是 /;会匹配到所有的请求（排除jsp的请求）；
        加载的jquery文件，也会交给DispatcherServlet处理。所以会出现no mapping found问题。
        解决问题：
            1.修改<url-pattern>为后缀匹配。但是不建议这么做。对REST的支持不好，因为一个优秀的REST不希望请求URL带有任何后缀。
<%--            2.在springmvc.xml中加上一个配置：<mvc:default-servlet-handler />--%>
    -->
    <script type="text/javascript" src="../../scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        //给删除<a>动态绑定事件
        $(function () {
            $(".del").click(function () {
                //是否要删除
               var flag= window.confirm("是否要删除?");
               if(!flag){
                   return  false;   //如果取消删除，返回false
               }

                //this：当前的dom对象
                //获取点击的超链接的href的值
                var href = $(this).attr("href");
                //将href的值设置到表单的action上
                $("form").attr("action", href).submit();
                //取消<a>的默认行为
                return false;
            });
        })
    </script>
</head>
<body>
<form action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>

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
    <c:forEach items="${emps}" var="emp">
        <tr align="center">
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.department.departmentName}</td>
            <td>
                <a href="#">Edit</a>
                &nbsp;&nbsp;
                <!--
                解决思路：
                    给删除的超链接绑定事件，当触发了点击事件，可以在事件处理函数中获取到要发送的请求URL;
                    再将获取到的请求URL设置到某个表单的action属性上，再将表单提交。
                    最终将<a>的默认行为取消。
                -->
                <a class="del" href="emp/${emp.id}">Delete</a>

            </td>
        </tr>
    </c:forEach>
</table>

<h2 align="center"><a href="emp">Add New Emp</a></h2>
</body>
</html>
