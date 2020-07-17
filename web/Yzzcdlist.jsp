<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

    <title>门店管理</title>
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
<h2>菜单管理</h2>
<div id="add-door1">
    <a href="Yzzcdadd.jsp" target="rightFrame"><input type="submit" value="新增菜品"/></a>
    <a>&nbsp;&nbsp;&nbsp;</a>
</div>
<table border="1">
    <hr/>
    <tr>
        <th class="width-40">序号</th>
        <th>餐厅名称</th>
        <th>菜品名字</th>
        <th>菜品价格</th>
        <th>是否售罄</th>
        <th class="width-80">操 作</th>
    </tr>

    <c:forEach items="${listcd}" var="yzzcd" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${yzzcd.CT_name}</td>
            <td>${yzzcd.CD_name}</td>
            <td>${yzzcd.CD_price}</td>
            <td>${yzzcd.CD_type}</td>
            <td>
                <a href="YzzCDdeleteServlet?id=${yzzcd.id}">删除</a>
                &nbsp;|&nbsp;
                <a href="YzzCDinfoServlet?id=${yzzcd.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>


</body><!-- body-end  -->
</html>
