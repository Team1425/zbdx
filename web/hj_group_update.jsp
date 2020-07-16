<%@ page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>修改社团</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;font-size:26px; }
        table{ margin: 30px auto; text-align: center; border-collapse:collapse; width:50%; }
        td, th{ padding: 7px;font-size:18px;}
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        input,select,textarea{ width:284px; height:30px; background: #ededed; border:1px solid #999; text-indent:5px; font-size:18px; }
        input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
        select{text-indent:0px;}
        textarea{height:100px;font-size:22px;}
    </style>
</head>
<body><!-- body-start  -->

<h2>修改社团信息</h2>
<hr/>
<form action="${pageContext.request.contextPath}/hjGroupUpdate" method="POST">
    <!-- hidden隐藏域,在提交表单时连door.id一起提交 -->
    <input type="hidden" name="hj_grp_id" value="${hjGroup.hj_grp_id}"/>
    <table border="1">
        <tr>
            <td width="30%">社团名称</td>
            <td>
                <input type="text" name="hj_grp_name" value="${hjGroup.hj_grp_name}"/>
            </td>
        </tr>
        <tr>
            <td>社团总人数</td>
            <td>
                <input type="text" name="hj_grp_total" value="${hjGroup.hj_grp_total}"/>
            </td>
        </tr>
        <tr>
            <td>社团类型</td>
            <td>
                <input type="text" name="hj_grp_type" value="${hjGroup.hj_grp_type}"/>
            </td>
        </tr>
        <tr>
            <td>社团经费</td>
            <td>
                <input type="text" name="hj_grp_money" value="${hjGroup.hj_grp_money}"/>
            </td>
        </tr>
        <tr>
            <td>社团正在进行的活动</td>
            <td>
                <input type="text" name="hj_grp_activity" value="${hjGroup.hj_grp_activity}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提	交" />
            </td>
        </tr>
    </table>
</form>
</body><!-- body-end  -->
</html>