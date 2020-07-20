<%--
  Created by IntelliJ IDEA.
  User: sung
  Date: 2020/7/20
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ExaInfo</title>
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
<h2>考试信息更改</h2>
<hr/>
<form action="${pageContext.request.contextPath}/exaInfo" method="POST">

    <table border="1">
        <tr>
            <td width="30%">考试序号</td>
            <td>
                <input type="text" name="ExaId" value="${exa.getExa_id()}"/>
            </td>
        </tr>
        <tr>
            <td>考试名称</td>
            <td>
                <input type="text" name="ExaName" value="${exa.getExa_name()}"/>
            </td>
        </tr>
        <tr>
            <td>考场</td>
            <td>
                <input type="text" name="RoomName" value="${exa.getExa_room()}"/>
            </td>
        </tr>
        <tr>
            <td>考试时间</td>
            <td>
                <input type="text" name="ExaTime" value="${exa.getExa_time()}"/>
            </td>
        </tr>
        <tr>
            <td>监考教师</td>
            <td>
                <input type="text" name="ExaTeacher" value="${exa.getExa_teacher()}"/>
            </td>
        </tr>
        <tr>
            <td>教师工号</td>
            <td>
                <input type="text" name="ExaTeacherId" value="${exa.getExa_teacherId()}"/>
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
