<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>修改订单</title>
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

<h2>修改订单</h2>
<hr/>
<form action="${pageContext.request.contextPath}/wymTeaUpdate" method="POST">
    <!-- hidden隐藏域,在提交表单时连order.id一起提交 -->
    <input type="hidden" name="id" value="${wymTeacher.wymTeaId}"/>
    <table border="1">
        <tr>
            <td>工号</td>
            <td>
                <input type="text" name="wymTeaJobnum"
                       value="${wymTeacher.wymTeaJobnum}"/>
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="wymTeaName"
                       value="${wymTeacher.wymTeaName}"/>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="text" name="wymTeaSex"
                       value="${wymTeacher.wymTeaSex}"/>
            </td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td>
                <input type="text" name="wymTeaBirthday"
                       value="${wymTeacher.wymTeaBirthday}"/>
            </td>
        </tr>
        <tr>
            <td>身份证号</td>
            <td>
                <input type="text" name="wymTeaIdcard"
                       value="${wymTeacher.wymTeaIdcard}"/>
            </td>
        </tr>
        <tr>
            <td>上岗日期</td>
            <td>
                <input type="text" name="wymTeaStartdate"
                       value="${wymTeacher.wymTeaStartdate}"/>
            </td>
        </tr>
        <tr>
            <td>学院</td>
            <td>
                <input type="text" name="wymTeaCollege"
                       value="${wymTeacher.wymTeaCollege}"/>
            </td>
        </tr>
        <tr>
            <td>专业</td>
            <td>
                <input type="text" name="wymTeaProfession"
                       value="${wymTeacher.wymTeaProfession}"/>
            </td>
        </tr>
        <tr>
            <td>职称</td>
            <td>
                <input type="text" name="wymTeaZhicheng"
                       value="${wymTeacher.wymTeaZhicheng}"/>
            </td>
        </tr>
        <tr>
            <td>政治面貌</td>
            <td>
                <input type="text" name="wymTeaZhengzhimm"
                       value="${wymTeacher.wymTeaZhengzhimm}"/>
            </td>
        </tr>
        <tr>
            <td>手机号</td>
            <td>
                <input type="text" name="wymTeaPhonenum"
                       value="${wymTeacher.wymTeaPhonenum}"/>
            </td>
        </tr>
        <tr>
            <td>邮箱地址</td>
            <td>
                <input type="text" name="wymTeaEmail"
                       value="${wymTeacher.wymTeaEmail}"/>
            </td>
        </tr>
        <tr>
            <td>薪资</td>
            <td>
                <input type="text" name="wymTeaSalary"
                       value="${wymTeacher.wymTeaSalary}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提 	交"/>
            </td>
        </tr>
    </table>
</form>

</body><!-- body-end  -->
</html>



