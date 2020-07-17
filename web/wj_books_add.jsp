<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/14
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增图书</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;font-size:26px; }
        table{ margin: 30px auto; text-align: center; border-collapse:collapse; width:50%; }
        td, th{ padding: 7px;font-size:18px;}
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        input,select,textarea{ width:284px; height:30px; background:#EDEDED; border:1px solid #999; text-indent:5px; font-size:18px; }
        input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
        select{text-indent:0px;}
        textarea{height:100px;font-size:22px;}
    </style>
</head>
<body>
<form action="booksAdd" method="POST">
    <table border="1">

        <tr>
            <td width="30%">图书名称</td>
            <td>
                <input type="text" name="booksname"/>
            </td>
        </tr>
        <tr>
            <td>作者</td>
            <td>
                <input type="text" name="author"/>
            </td>
        </tr>
        <tr>
            <td>ISBN</td>
            <td>
                <input type="text" name="ISBN"/>
            </td>
        </tr>


        <tr>
            <td>出版社</td>
            <td>
                <input type="text" name="ph"/>
            </td>
        </tr>

        <tr>
            <td>价格</td>
            <td>
                <input type="text" name="price"/>
            </td>
        </tr>

        <tr>
            <td>出版日期</td>
            <td>
                <input type="text" name="pd"/>
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
