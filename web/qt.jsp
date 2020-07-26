<%--
  Created by IntelliJ IDEA.
  User: 杨忠泽
  Date: 2020/7/24
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .menu-bar{
            float: left;
        }
    </style>
</head>
<body>

<div class="menu-bar">

    <a href="${pageContext.request.contextPath}/YzzstudentlistServlet" target="rightFrame"><input type="submit" value="餐厅管理"/></a>
</div>
<div class="menu-bar">
    <a href="" target="rightFrame"><input type="submit" value="宿舍管理"/></a>
</div>
<div class="menu-bar">
    <a href="${pageContext.request.contextPath}/wghCollegeView" target="rightFrame"><input type="submit" value="学院管理"/></a>
</div>
<div class="menu-bar">
    <a href="${pageContext.request.contextPath}/wymTeaView" target="rightFrame"><input type="submit" value="教师信息"/></a>
</div>
<div class="menu-bar">
    <a href="" target="rightFrame"><input type="submit" value="学生管理"/></a>
</div>
<div class="menu-bar">
    <a href="" target="rightFrame"><input type="submit" value="医院管理"/></a>
</div>
<div class="menu-bar">
    <a href="" target="rightFrame"><input type="submit" value="社团管理"/></a>
</div>
<div class="menu-bar">
    <a href="${pageContext.request.contextPath}/WjBooksShow" target="rightFrame"><input type="submit" value="图书管理"/></a>
</div>
<div class="menu-bar">
    <a href="${pageContext.request.contextPath}/by_lostShow.jsp" target="rightFrame"><input type="submit" value="失物管理"/></a>
</div>
<div class="menu-bar">
    <a href=""  target="rightFrame"><input type="submit" value="用户管理"/></a>
</div>
<div class="menu-bar">
    <a href="${pageContext.request.contextPath}/szb_Exh" target="rightFrame"><input type="submit" value="考试管理"/></a>
</div>
<div class="menu-bar">
    <a href="index.jsp" target="rightFrame"><input type="submit" value="登录"/></a>
</div>



</body>
</html>
