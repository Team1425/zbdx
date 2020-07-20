<%@ page pageEncoding="utf-8"%>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>新增订单</title>
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

<h2>注册用户</h2>
<hr/>
<form action="YzzRegServlet" method="POST">
    <table border="1">
        <tr>
            <td width="30%">用户类型</td>
            <td>
                <select name="usertype">
                    <option value="管理员">管理员</option>
                    <option value="学生">学生</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="text" name="password"/>
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