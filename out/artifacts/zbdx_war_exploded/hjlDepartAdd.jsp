<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2020-7-14
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<<%@ page pageEncoding="utf-8"%>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>新增科室</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;font-size:26px; }
        table{ margin: 30px auto; text-align: center; border-collapse:collapse; width:50%; }
        td, th{ padding: 5px;font-size:18px;}
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        input,select,textarea{ width:284px; height:30px; background:#EDEDED; border:1px solid #999; text-indent:5px; font-size:18px; }
        input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
        select{text-indent:0px;}
        textarea{height:100px;font-size:22px;}
    </style>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/echarts.js"></script>
</head>
<body><!-- body-start  -->

<h2>新增科室</h2>
<form action="/hjlDepartAdd" method="POST">
    <table border="1">
        <tr>
        <tr>
            <td>科室主任</td>
            <td>
                <input type="text" name="dirName"/>
            </td>
        </tr>
        <tr>
            <td>科室名字</td>
            <td>
                <input type="text" name="depName"/>
            </td>
        </tr>
        <tr>
            <td>病房数量</td>
            <td>
                <input type="text" name="room"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提 	交"/>
                &nbsp;  &nbsp;  &nbsp;
              <a href="/hjlDoctorList " type="button"> 返 回</a>
                &nbsp;  &nbsp;  &nbsp;
                <a href="/HjlDeSelect " type="button"> 查询</a>
                <a>&nbsp;&nbsp;|&nbsp;&nbsp;</a>
                <a href="#" onclick="show()" target="rightFrame">查看科室人数</a>
            </td>
        </tr>
    </table>
</form>
<h2>已有科室</h2>
<table border="1">
    <tr>
        <th class="width-40">序号</th>
        <th class="width-80">系主任姓名</th>
        <th class="width-40">科室</th>
        <th class="width-80">病房数量</th>
        <th class="width-80">操 作</th>
    </tr>

    <!-- 模版数据 -->
    <c:forEach items="${deList}" var="de">
        <tr>
            <td>${de.depart_id}</td>
            <td>${de.depart_dir}</td>
                    <td>${de.depart_name}</td>
            <td>${de.room_num}</td>
            <td>
                <a href="/HjlDepartDelete?id=${de.depart_id}">删除</a>
                &nbsp;|&nbsp;
                <a href="/HjlDepatUpdateinfo?id=${de.depart_id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div style="width: 100%;float: none;display: block;">
    <div id="main" style="width: 1100px;height: 350px;margin: 0px auto;display: none">

    </div>
</div>
<script type="text/javascript">
    function show() {
        $("#main").css("display","block");
        var  myChart=echarts.init(document.getElementById("main"));
        var option = {
            title: {
                text: '科室病房统计'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: []
            }]
        };
        myChart.showLoading();
        var name=[];
        var num=[];
        $.ajax({
            url:"/ShowNum",
            type:"post",
            data:{},
            dataType:'json',
            success:function (result) {
                console.log(result);
                for (var i=0;i<result.length;i++){
                    name.push(result[i].depart_name);
                }
                for (var i=0;i<result.length;i++){
                    num.push(result[i].room_num);
                }
                myChart.hideLoading();
                myChart.setOption({
                    xAxis: {
                        data: name
                    },
                    series: [{
                        data: num
                    }]
                });
            }
        })
        myChart.setOption(option);
    }
</script>
</body><!-- body-end  -->
</html>



