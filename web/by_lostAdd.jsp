
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增失物</title>
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
<body><!-- body-start  -->

<h2>新增失物</h2>
<hr/>
<form action="by_lostAdd" method="POST">
    <table border="1">
        <tr>
            <td width="30%">物品种类</td>
            <td>
                <input type="text" name="type"/>
            </td>
        </tr>

        <tr>
            <td>物品特征</td>
            <td>
                <input type="text" name="trait"/>
            </td>
        </tr>

        <tr>
            <td>丢失地点</td>
            <td>
                <input type="text" name="lost_loc"/>
            </td>
        </tr>
        <tr>
            <td>领取地点</td>
            <td>
                <input type="text" name="get_loc"/>
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