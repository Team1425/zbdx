<%@ page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>新增学院</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; }
	h2{ text-align: center;font-size:26px; }
	table{ margin: 30px auto; text-align: center; border-collapse:collapse; width:50%; }
	td, th{ padding: 7px;font-size:18px;}
	hr{ margin-bottom:20px; border:1px solid #aaa; }
	input,select,textarea{ width:284px; height:30px; background:#EDEDED; border:1px solid #999; text-indent:5px; font-size:18px; }
	input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
	select{text-indent:0px;}
	textarea{height:100px;font-size:22px;}
</style>
</head>
<body><!-- body-start  -->

<h2>新增学院</h2>
<hr/>
<form action="${pageContext.request.contextPath}/wghcollegeAdd" method="POST">
	<table border="1">
		<tr>
			<td width="30%">学院名称</td>
			<td>
				<input type="text" name="name" value="${wghcollege.wgh_name}"/>
			</td>
		</tr>
		<tr>
			<td>学院院长</td>
			<td>
				<input type="text" name="leader" value="${wghcollege.wgh_leader}"/>
			</td>
		</tr>
		<tr>
			<td>老师人数</td>
			<td>
				<input type="text" name="teacherNum" value="${wghcollege.wgh_teacherNum}"/>
			</td>
		</tr>
		<tr>
			<td>学生人数</td>
			<td>
				<input type="text" name="studentNum" value="${wghcollege.wgh_studentNum}"/>
			</td>
		</tr>
		<tr>
			<td>就业率(单位:%)</td>
			<td>
				<input type="text" name="promotionRate" value="${wghcollege.wgh_promotionRate}"/>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="提 	交"/>
			</td>
		</tr>
	</table>
</form>

</body><!-- body-end  -->
</html>



