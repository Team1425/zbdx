<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>教师管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;}
        table{ width:96%; margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px;}
        td, th{ padding: 5px;}
        th{ background-color: #DCDCDC; width:120px; }
        th.width-40{ width: 40px; }
        th.width-50{ width: 50px; }
        th.width-64{ width: 64px; }
        th.width-80{ width: 80px; }
        th.width-120{ width: 100px; }
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        #add-order{text-align:center;font-size:20px;}
    </style>

    <script type="text/javascript" src="/js/echarts.js"></script>
    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
</head>
<body>

<h2>教师信息</h2>
<hr/>
<table border="1">
    <tr>
        <th class="width-40">序号</th>
        <th class="width-50">工号</th>
        <th class="width-50">姓名</th>
        <th class="width-40">性别</th>
        <th class="width-120">学院</th>
        <th class="width-120">专业</th>
        <th class="width-50">职称</th>
        <th class="width-50">手机号</th>
        <th class="width-50">邮箱地址</th>
    </tr>
    <c:forEach items="${list}" var="wymteacher" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${wymteacher.wymTeaJobnum}</td>
            <td>${wymteacher.wymTeaName}</td>
            <td>${wymteacher.wymTeaSex}</td>
            <td>${wymteacher.wymTeaCollege}</td>
            <td>${wymteacher.wymTeaProfession}</td>
            <td>${wymteacher.wymTeaZhicheng}</td>
            <td>${wymteacher.wymTeaPhonenum}</td>
            <td>${wymteacher.wymTeaEmail}</td>
        </tr>
    </c:forEach>
</table>
</body><!-- body-end  -->
</html>



