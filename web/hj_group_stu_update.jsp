<%@ page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>修改学生信息</title>
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

<h2>修改学生信息</h2>
<hr/>
<form action="${pageContext.request.contextPath}/hjStudentUpdate" method="POST">
    <!-- hidden隐藏域,在提交表单时连door.id一起提交 -->
    <input type="hidden" name="hj_stu_id" value="${hjStudent.hj_stu_id}"/>
    <table border="1">
        <tr>
            <td width="30%">学号</td>
            <td>
                <input type="text" name="hj_stu_no" value="${hjStudent.hj_stu_no}"/>
            </td>
        </tr>
        <tr>
            <td width="30%">姓名</td>
            <td>
                <input type="text" name="hj_stu_name" value="${hjStudent.hj_stu_name}"/>
            </td>
        </tr>
        <tr>
            <td width="30%">年龄</td>
            <td>
                <input type="text" name="hj_stu_age" value="${hjStudent.hj_stu_age}"/>
            </td>
        </tr>

        <tr>
            <td width="30%">性别</td>
            <td>
                <input type="text" name="hj_stu_sex" value="${hjStudent.hj_stu_sex}"/>
            </td>
        </tr>
        <tr>
            <td width="30%">电话号</td>
            <td>
                <input type="text" name="hj_stu_phone" value="${hjStudent.hj_stu_phone}"/>
            </td>
        </tr><tr>
        <td width="30%">所选社团编号</td>
        <td>
            <input type="text" name="hj_stu_grp_id" value="${hjStudent.hj_stu_grp_id}"/>
        </td>
    </tr>
        <tr>
            <td width="30%">学院</td>
            <td>
                <input type="text" name="hj_stu_department" value="${hjStudent.hj_stu_department}"/>
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
