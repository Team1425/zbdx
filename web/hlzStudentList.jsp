<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
                <li class="active">学生管理</li>
            </ol>
            <form action="">

                <a href="hlzStudentAdd.jsp" class="btn btn-primary">添加</a>
            </form>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">学生管理</h3>
                </div>
                <!--列表展示-->
                <div class="table-responsive">
                    <table class="table table-striped ">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>学号</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${lists}" var="students">
                            <tr>
                                <td>${students.name}</td>
                                <td>${students.sex}</td>
                                <td>${students.age}</td>
                                <td>${students.number}</td>

                                <td>
                                    <div class="btn-group">
                                        <a href="hlzStudentDelete?id=${students.id}" class="btn btn-danger">删除</a>
                                        <a href="hlzStudentChange?id=${students.id}" class="btn btn-default">修改</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>