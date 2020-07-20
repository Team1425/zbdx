<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sung
  Date: 2020/7/20
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RootList</title>
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
<body>
<script src=""></script>
<hr/>
<script src=""></script>
<h2>考试管理</h2>
<div id="add-door1">
    <a href="${pageContext.request.contextPath}/szb_exaHandle" target="rightFrame">
        <input type="submit" value="管理考试"/></a>
</div>
<table border="1">
    <hr/>
    <tr>
        <th class="width-40">序号</th>
        <th>管理员令牌</th>
        <th>负责考试ID</th>
    </tr>
    <%--@elvariable id="listExaRoot" type="java.util.List"--%>
    <c:forEach items="${listExaRoot}" var="szbroot" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${szbroot.getExaAdRoot()}</td>
            <td>${szbroot.getId()}</td>
        </tr>
    </c:forEach>
</table>



</body>
</html>
