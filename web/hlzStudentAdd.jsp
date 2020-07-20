<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入样式文件和动态控制 -->
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <title>学生</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10">
            <ol class="breadcrumb">
                <li class="active">首页</li>
                <li class="active">添加学生</li>
            </ol>

            <form action="hlzStudentAdd" method="post" style="width: 500px">
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
                </div>
                <div class="form-group">
                    <label for="sex">性别</label>
                    <input type="text" class="form-control" id="sex" name="sex" placeholder="请输入性别">
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="number" class="form-control" id="age" name="age" placeholder="请输入年龄">
                </div>
                <div class="form-group">
                    <label for="number">学号</label>
                    <input type="text" class="form-control" id="number" name="number" placeholder="请输入学号" maxlength="10">
                </div>
                <button type="submit" class="btn btn-primary">添加</button>
            </form>

        </div>
    </div>
</div>
</body>
</html>