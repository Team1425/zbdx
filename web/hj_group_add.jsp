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
                    中北大学<small>新增社团</small>
                </h1>
            </div>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/hjGroupAdd" method="post">
                <div class="form-group">
                    <label for="hj_grp_name" class="col-sm-2 control-label">社团名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_grp_name" name="hj_grp_name"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_grp_total" class="col-sm-2 control-label">社团总人数</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_grp_total" name="hj_grp_total"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_grp_type" class="col-sm-2 control-label">社团种类</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_grp_type" name="hj_grp_type" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_grp_money" class="col-sm-2 control-label">社团经费</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_grp_money" name="hj_grp_money" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="hj_grp_activity" class="col-sm-2 control-label">社团正在进行的活动</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="hj_grp_activity" name="hj_grp_activity"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">提交</button>
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