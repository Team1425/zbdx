<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

    <title>考试管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;}
        table{ width:96%; margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px;}
        td, th{ padding: 5px;}
        th{ background-color: #DCDCDC; width:120px; }
        th.width-40{ width: 40px; }
        th.width-70{ width: 70px; }
        th.width-80{ width: 80px; }
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        #add-door{text-align:center;font-size:20px;}
        #add-door1{text-align:center;font-size:20px;}
    </style>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/echarts.js"></script>
</head>
<body><!-- body-start  -->
<script src=""></script>
<hr/>
<script src=""></script>
<h2>考试管理</h2>
<div id="add-door1">
    <a href="${pageContext.request.contextPath}/szb_Login.jsp" target="rightFrame">
        <input type="submit" value="考试管理员登陆"/></a>
    <a href="${pageContext.request.contextPath}/szb_Register.jsp" target="rightFrame">
        <input type="submit" value="管理员身份注册"/></a>
</div>
<table border="1">
    <hr/>
    <tr>
        <th class="width-40">序号</th>
        <th>考试名称</th>
        <th>考场名称</th>
        <th>考试时间</th>
        <th>监考老师</th>
        <th>老师工号</th>
    </tr>

    <c:forEach items="${listExa}" var="szbexa" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${szbexa.getExa_name()}</td>
            <td>${szbexa.getExa_room()}</td>
            <td>${szbexa.getExa_time()}</td>
            <td>${szbexa.getExa_teacher()}</td>
            <td>${szbexa.getExa_teacherId()}</td>
        </tr>
    </c:forEach>
</table>


</body><!-- body-end  -->
</html>
