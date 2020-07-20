<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- JSTL 核心标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL 格式化标签 用来格式化并输出文本、日期、时间、数字 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- JSTL SQL标签库 提供了与关系型数据库进行交互的标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!-- JSTL XML标签库 提供了创建和操作XML文档的标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增学生</title>
    <!--视口/视觉窗口标签:meta, 宽度=设备宽度，初始化缩放比例1， 是否允许用户缩放页面:no -->
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
    <!-- 扩展对低版本IE支持,开启IE兼容模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap核心css -->
    <link rel="stylesheet" type="text/css" href="bootstrap3/css/bootstrap.css">
    <!-- 字体图标 -->
    <link rel="stylesheet" type="text/css" href="bootstrap3/font-awesome-4.7.0/css/font-awesome.css"/>
    <title>新增社团</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body><!-- body-start  -->

<%--<h2>新增门店</h2>--%>
<%--<hr/>--%>
<%--<form action="${pageContext.request.contextPath}/DoorAddServlet" method="POST">--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <td width="30%">门店名称</td>--%>
<%--            <td>--%>
<%--                <input type="text" name="name"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>联系电话</td>--%>
<%--            <td>--%>
<%--                <input type="text" name="tel"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>门店地址</td>--%>
<%--            <td>--%>
<%--                <input type="text" name="addr"/>--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td colspan="2">--%>
<%--                <input type="submit" value="提 	交"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    中北大学<small>新增学生</small>
                </h1>
            </div>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/hjStudentAdd" method="post">
                <div class="form-group">
                    <label for="hj_stu_no" class="col-sm-2 control-label">学生学号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_stu_no" name="hj_stu_no"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_stu_name" class="col-sm-2 control-label">学生姓名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_stu_name" name="hj_stu_name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_stu_age" class="col-sm-2 control-label">学生年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_stu_age" name="hj_stu_age" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_stu_sex" class="col-sm-2 control-label">学生性别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_stu_sex" name="hj_stu_sex"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_stu_phone" class="col-sm-2 control-label">电话号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_stu_phone" name="hj_stu_phone"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_stu_grp_id" class="col-sm-2 control-label">参加社团的编号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_stu_grp_id" name="hj_stu_grp_id"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_stu_department" class="col-sm-2 control-label">学院</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_stu_department" name="hj_stu_department"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
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