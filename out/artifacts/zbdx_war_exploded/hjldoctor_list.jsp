<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2020-7-14
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>医院管理</title>
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
    </style>
</head>
<body><!-- body-start  -->

<h2>医院管理</h2>
<div id="add-door">
    <a href="/hjlDoctorAddInfo" target="rightFrame">新增医生</a>
    <a>&nbsp;&nbsp;|&nbsp;&nbsp;</a>
    <a href="/hjlDepartAdd.jsp" target="rightFrame">新增科室</a>
</div>
<hr/>
<table border="1">
    <tr>
        <th class="width-40">序号</th>
        <th class="width-40">姓名</th>
        <th class="width-40">性别</th>
        <th class="width-40">所属科室</th>
        <th class="width-80">联系电话</th>
        <th class="width-120">家庭地址</th>
        <th class="width-80">操 作</th>
    </tr>

    <!-- 模版数据 -->
    <c:forEach items="${doList}" var="doctor">
        <tr>
            <td>${doctor.doctor_id}</td>
            <td>${doctor.doctor_name}</td>
            <td>${doctor.doctor_sex}</td>
            <c:forEach var="depart" items="${deList}">
                <c:if test="${doctor.depart_id==depart.depart_id}">
                    <td>${depart.depart_name}</td>
                </c:if>
            </c:forEach>
            <td>${doctor.doctor_tel}</td>
            <td>${doctor.doctor_addr}</td>
            <td>
                <a href="/HjlDoctorDelete?id=${doctor.doctor_id}">删除</a>
                &nbsp;|&nbsp;
                <a href="/HjlDoctorUpdateinfo?id=${doctor.doctor_id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body><!-- body-end  -->
</html>



