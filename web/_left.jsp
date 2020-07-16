<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8"/>
<style>
	body{ background:#222D32;margin:0px; }
	.menu-bar a{ color:#fff;text-decoration:none; }
	.menu-bar{ font-size:22px;border-bottom:1px solid #fff;height:40px;line-height:40px;text-indent:18px;letter-spacing:5px; }
	.menu-bar:first-child{border-top:1px solid #fff;}
	.menu-bar:hover{background:#797979;}
</style>
</head>
<body>
	<div class="menu-bar">
		<a href="orderList" target="rightFrame">› 餐厅管理</a>
	</div>
	<div class="menu-bar">
		<a href="orderList" target="rightFrame">› 宿舍管理</a>
	</div>
	<div class="menu-bar">
		<a href="/wghcollegeList" target="rightFrame">› 学院管理</a>
	</div>
	<div class="menu-bar">
		<a href="orderList" target="rightFrame">› 教师管理</a>
	</div>
	<div class="menu-bar">
		<a href="/hlzStudentList" target="rightFrame">› 学生管理</a>
	</div>
	<div class="menu-bar">
		<a href="/hjlDoctorList" target="rightFrame">› 医院管理</a>
	</div>
	<div class="menu-bar">
		<a href="orderList" target="rightFrame">› 社团管理</a>
	</div>
	<div class="menu-bar">
		<a href="orderList" target="rightFrame">› 图书管理</a>
	</div>
	<div class="menu-bar">
		<a href="${pageContext.request.contextPath}/by_lostList" target="rightFrame">› 失物管理</a>
	</div>
	<div class="menu-bar">
		<a href="orderList" target="rightFrame">› 用户管理</a>
	</div>
	<div class="menu-bar">
		<a href="orderList" target="rightFrame">› 考试管理</a>
	</div>


</body>
</html>