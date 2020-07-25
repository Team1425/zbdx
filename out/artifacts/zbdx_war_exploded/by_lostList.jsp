<%--
  Created by IntelliJ IDEA.
  User: 白宇
  Date: 2020/7/13
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>失物管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script src="js/jquery-3.4.1.min.js"></script>
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
        #by_add-lost{text-align:center;font-size:20px;}
    </style>
    <script type="text/javascript" src="js/echarts.js"></script>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
    <h2>失物招领</h2>
    <div id="by_add-lost">
        <a href="by_lostAdd.jsp" style="text-align: center" target="rightFrame">新增失物</a>
        <div style="float: right">
            <form action="${pageContext.request.contextPath}/by_downexcel">
                <input type="submit" value="报表导出">
            </form>
        </div>
    </div>
    <hr/>
    <table id="by_table" class="sort-table" border="1">
        <tr>
            <th class="width-40">序 号</th>
            <th class="width-80">物品种类</th>
            <th>物品特征</th>
            <th>录入时间</th>
            <th>丢失地点</th>
            <th>领取地点</th>
            <th class="width-80">操 作</th>
        </tr>
        <c:forEach items="${list}" var="lost" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${lost.type}</td>
                    <td>${lost.trait}</td>
                    <td>${lost.time}</td>
                    <td>${lost.lost_loc}</td>
                    <td>${lost.get_loc}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/by_lostDelete?id=${lost.id}">删除</a>
                        &nbsp;|&nbsp;
                        <a href="${pageContext.request.contextPath}/by_lostInfo?id=${lost.id}">修改</a>
                    </td>
                </tr>
        </c:forEach>
    </table>
</body>
</html>
