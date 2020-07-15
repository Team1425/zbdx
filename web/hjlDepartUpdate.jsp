<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2020-7-14
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<<%@ page pageEncoding="utf-8"%>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>新增科室</title>
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
<body><!-- body-start  -->

<h2>更新科室</h2>
<form action="/HjlDeUpdate" method="POST">
    <input type="hidden" name="id" value="${list.depart_id}" />
    <table border="1">
        <tr>
        <tr>
            <td>科室主任</td>
            <td>
                <input type="text" name="dirName" value="${list.depart_dir}"/>
            </td>
        </tr>
        <tr>
            <td>科室名字</td>
            <td>
                <input type="text" name="depName" value="${list.depart_name}"/>
            </td>
        </tr>
        <tr>
            <td>病房数量</td>
            <td>
                <input type="text" name="room" value="${list.room_num}"/>
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
