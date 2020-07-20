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

    <title>社团管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
    </script>
    <style>
        .delete a:hover {
            background-color: red;
        }
        body{
            background-color: rgba(255,254,196,0.97)
        }
    </style>
</head>
<body class="body">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    中北大学 <small>社团管理系统</small>
                </h1>
            </div>
            <ul class="breadcrumb">
                <li>
                    <a href="hjGroupList">查看社团</a>
                </li>
                <li>
                    <a href="hj_group_add.jsp">增加社团</a>
                </li>
                <li>
                    <a href="#">查看社团人数</a>
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
                        社团名称
                    </th>
                    <th>
                        社团总人数
                    </th>
                    <th>
                        社团种类
                    </th>
                    <th>
                        社团经费
                    </th>
                    <th>
                        社团正在进行的活动
                    </th>
                    <th colspan="3" style="text-align: center">
                        选择要进行的操作
                    </th>
                </tr>
                </thead>
                <tbody>
                 <c:forEach items="${list}" var="hjg">
                     <tr class="success">
                         <td>
                             ${hjg.hj_grp_id}
                         </td>
                         <td>
                             ${hjg.hj_grp_name}
                         </td>
                         <td>
                             ${hjg.hj_grp_total}
                         </td>
                         <td>
                             ${hjg.hj_grp_type}
                         </td>
                         <td>
                             ${hjg.hj_grp_money}
                         </td>
                         <td>
                             ${hjg.hj_grp_activity}
                         </td>
                         <td class="delete">
                             <a href="${pageContext.request.contextPath}/hjGroupDelete?id=${hjg.hj_grp_id}">删除</a>
                         </td>
                         <td>
                             <a href="${pageContext.request.contextPath}/hjGroupInfo?id=${hjg.hj_grp_id}">修改</a>
                         </td>
                         <td>
                             <a href="${pageContext.request.contextPath}/hjStudentList?id=${hjg.hj_grp_id}">社团学生信息</a>
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
