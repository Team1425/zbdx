<%--
  Created by IntelliJ IDEA.
  User: sung
  Date: 2020/7/17
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ExaAdd</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;font-size:26px; }
        table{ margin: 30px auto; text-align: center; border-collapse:collapse; width:50%; }
        td, th{ padding: 5px;font-size:18px;}
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        input,select,textarea{ width:284px; height:30px; background:#EDEDED; border:1px solid #999; text-indent:5px; font-size:18px; }
        input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
        select{text-indent:0px;}
        textarea{height:100px;font-size:22px;}
    </style>
</head>
<body>

<h2>新增考试安排</h2>
<hr/>
<form action="${pageContext.request.contextPath}/szb_exaAdd" method="POST">
    <table border="1">
        <tr>
            <td width="30%">考试序号</td>
            <td>
                <input type="text" name="ExaId"/>
            </td>
        </tr>
        <tr>
            <td>考试名称</td>
            <td>
                <input type="text" name="ExaName"/>
            </td>
        </tr>
        <tr>
            <td>考场</td>
            <td>
                <input type="text" name="ExaRoom"/>
            </td>
        </tr>
        <tr>
            <td>考试时间</td>
            <td>
                <input type="text" name="ExaTime"/>
            </td>
        </tr>
        <tr>
            <td>监考教师</td>
            <td>
                <input type="text" name="ExaTeacher"/>
            </td>
        </tr>
        <tr>
            <td>教师工号</td>
            <td>
                <input type="text" name="ExaTeacherId"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提 	交"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
