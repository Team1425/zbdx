<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>宿舍管理</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; }
	h2{ text-align: center;}
	table{ width:96%; margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px;}
	td, th{ padding: 5px;}
	th{ background-color: #DCDCDC; width:100px; }
	th.width-40{ width: 90px; }
	th.width-80{ width: 150px; }
	hr{ margin-bottom:20px; border:1px solid #aaa; }
	#add-door{text-align:center;font-size:20px;}
</style>
</head>
<body><!-- body-start  -->

<h2>宿舍管理</h2>
<div id="add-door">
	<a href="zjx_dorm_add.jsp" target="rightFrame">添加宿舍</a>
</div>
<hr/>
<table border="1">
	<tr>
		<th class="width-40">宿舍楼</th>
		<th class="width-40">宿舍号</th>
		<th class="width-80">舍长姓名</th>
		<th class="width-80">舍长学号</th>
		<th class="width-80">联系电话</th>
		<th colspan="3">宿舍成员</th>
		<th class="width-80">操 作</th>
	</tr>

	<c:forEach items="${list}" var="dorm">
		<tr>
			<td>${dorm.addr}</td>
			<td>${dorm.id}</td>
			<td>${dorm.name1}</td>
			<td>${dorm.stu_id}</td>
			<td>${dorm.stu_tel}</td>
			<td class="">${dorm.name2}</td>
			<td>${dorm.name3}</td>
			<td>${dorm.name4}</td>
			<td>
				<a href="${pageContext.request.contextPath}/dormDelete?id=${dorm.id}">删除</a>
				&nbsp;|&nbsp;
				<a href="${pageContext.request.contextPath}/dormInfo?id=${dorm.id}">修改</a>
			</td>
		</tr>
	</c:forEach>


	
</table>
</body><!-- body-end  -->
</html>



