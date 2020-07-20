<%--
  Created by IntelliJ IDEA.
  User: sung
  Date: 2020/7/18
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ExaUpdate</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;font-size:26px; }
        table{ margin: 30px auto; text-align: center; border-collapse:collapse; width:50%; }
        td, th{ padding: 5px;font-size:18px;}
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        input,select,textarea{ width:284px; height:30px; background:#EDEDED;
            border:1px solid #999; text-indent:5px; font-size:18px; }
        input[type='submit']{ width:130px; height:36px; cursor:pointer;
            border-radius:5px 5px 5px 5px; background:#ddd; }
        select{text-indent:0px;}
        textarea{height:100px;font-size:22px;}
    </style>
</head>
</head>
<body>

<h2>修改考试信息</h2>
<div id="add-exa">
    <a href="${pageContext.request.contextPath}/szb_exaAdd.jsp" target="rightFrame">新增考试</a>
</div>
<hr/>
<table border="1">
    <hr/>
    <tr>
        <th class="width-40">序号</th>
        <th>考试名称</th>
        <th>考场名称</th>
        <th>考试时间</th>
        <th>监考老师</th>
        <th>老师工号</th>
        <th>操&nbsp;&nbsp;&nbsp;&nbsp;作</th>
    </tr>

    <c:forEach items="${listExa}" var="szbexa" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${szbexa.getExa_name()}</td>
            <td>${szbexa.getExa_room()}</td>
            <td>${szbexa.getExa_time()}</td>
            <td>${szbexa.getExa_teacher()}</td>
            <td>${szbexa.getExa_teacherId()}</td>
            <td>
                <a href="${pageContext.request.contextPath}/exaDelete?id=${
                szbexa.getExa_id()}">
                    删除</a>
                &nbsp;|&nbsp;
                <a href="${pageContext.request.contextPath}/exaUpdate?id=${
                szbexa.getExa_id()}">
                    修改</a>
            </td>

        </tr>
    </c:forEach>
</table>

</body>
</html>