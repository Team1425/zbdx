<%@ page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>新增宿舍</title>
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

<h2>新增宿舍</h2>
<hr/>
<form action="doorAdd" method="POST">
	<table border="1">
		<tr>
			<td width="30%">宿舍楼</td>
			<td>
				<input type="text" name="addr" />
			</td>
		</tr>
		<tr>
			<td>宿舍号</td>
			<td>
				<input type="text" name="id" />
			</td>
		</tr>
		<tr>
			<td>舍长姓名</td>
			<td>
				<input type="text" name="name1" />
			</td>
		</tr>
		<tr>
			<td>舍长学号</td>
			<td>
				<input type="text" name="stu_id" />
			</td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td>
				<input type="text" name="stu_tel" />
			</td>
		</tr>
		<tr>
			<td>宿舍成员1</td>
			<td>
				<input type="text" name="name2"/>
			</td>
		</tr>
		<tr>
			<td>宿舍成员2</td>
			<td>
				<input type="text" name="name3"/>
			</td>
		</tr>
		<tr>
			<td>宿舍成员3</td>
			<td>
				<input type="text" name="name4"/>
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



