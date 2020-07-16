<%@ page pageEncoding="utf-8" %>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bootstrap Template</title>
    <!--视口/视觉窗口标签:meta, 宽度=设备宽度，初始化缩放比例1， 是否允许用户缩放页面:no -->
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
    <!-- 扩展对低版本IE支持,开启IE兼容模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap核心css -->
    <link rel="stylesheet" type="text/css" href="bootstrap3/css/bootstrap.css">
    <!-- 字体图标 -->
    <link rel="stylesheet" type="text/css" href="bootstrap3/font-awesome-4.7.0/css/font-awesome.css"/>

    <title>学生表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
    </script>
    <style>
        .delete a:hover {
            background-color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    中北大学 <small>社团管理系统学生信息</small>
                </h1>
            </div>
            <ul class="breadcrumb">
                <li>
                    <a href="hj_group_list.jsp">查看社团</a>
                </li>
                <li>
                    <a href="hj_group_stu_add.jsp">增加学生</a>
                </li>
                <li>
                    <a href="#">查看学生人数</a>
                </li>
                <li class="active">
                    选择要进行的操作
                </li>
            </ul>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>
                        编号
                    </th>
                    <th>
                        学号
                    </th>
                    <th>
                        姓名
                    </th>
                    <th>
                        年龄
                    </th>
                    <th>
                        性别
                    </th>
                    <th>
                        电话号
                    </th>
                    <th>
                        参加社团编号
                    </th>
                    <td>
                        所属学院
                    </td>
                    <th colspan="2" style="text-align: center">
                        选择要进行的操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="hjs">
                    <tr class="success">
                        <td>
                                ${hjs.hj_stu_id}
                        </td>
                        <td>
                                ${hjs.hj_stu_no}
                        </td>
                        <td>
                                ${hjs.hj_stu_name}
                        </td>
                        <td>
                                ${hjs.hj_stu_age}
                        </td>
                        <td>
                                ${hjs.hj_stu_sex}
                        </td>
                        <td>
                                ${hjs.hj_stu_phone}
                        </td>
                        <td>
                                ${hjs.hj_stu_grp_id}
                        </td>
                        <td>
                                ${hjs.hj_stu_department}
                        </td>
                        <td class="delete">
                            <a href="${pageContext.request.contextPath}/hjStudentDelete?id=${hjs.hj_stu_id}">删除</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/hjStudentInfo?id=${hjs.hj_stu_id}">修改</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="bootstrap3/jquery.min.js"></script>
<!-- Bootstrap核心js -->
<script type="text/javascript" src="bootstrap3/js/bootstrap.js"></script>
<!-- 图片占位，解决低版本IE不支持圆角的问题-->
<script type="text/javascript" src="bootstrap3/js/holder.js"></script>
<!-- 引入T5和C3的js函数库，支持旧版浏览器-->
<script type="text/javascript" src="bootstrap3/js/html5shiv.min.js"></script>
<script type="text/javascript" src="bootstrap3/js/css3-mediaqueries.js"></script>
<script type="text/javascript" src="bootstrap3/js/respond.min.js"></script>

</body><!-- body-end  -->
</html>
