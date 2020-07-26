<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/26
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学院管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;}
        table{ width:96%; margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px;}
        td, th{ padding: 5px;}
        th{ background-color: #DCDCDC; width:120px; }
        th.width-40{ width: 40px; }
        th.width-70{ width: 70px; }
        th.width-80{ width: 80px; }
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        #add-college{text-align:center;font-size:20px;}
    </style>
    <script type="text/javascript" src="../js/echarts.js"></script>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
</head>
<body>
<
<h2>学院管理</h2>
<div id="add-college">
    <a href="#" target="rightFrame"  onclick="wghpromotrate()"><button>查看学院就业率</button></a>
    <div style="float: right">
        <form action="${pageContext.request.contextPath}/wghdownexcel">
            <input type="submit" value="报表导出"/>
        </form>
    </div>
</div>
<hr/>
<table border="1">
    <tr>
        <!--<th>状态</th>-->
        <th class="width-40">序号</th>
        <th>学院名称</th>
        <th>学院院长</th>
        <th>教师人数</th>
        <th>学生人数</th>
        <th>就业率(单位:%)</th>
    </tr>
    <c:forEach items="${list}" var="wghcollege"  varStatus="status" >
        <tr>
            <td>${status.count}</td>
            <td>${wghcollege.wgh_name}</td>
            <td>${wghcollege.wgh_leader}</td>
            <td>${wghcollege.wgh_teacherNum}</td>
            <td>${wghcollege.wgh_studentNum}</td>
            <td>${wghcollege.wgh_promotionRate}</td>
        </tr>

    </c:forEach>
</table>
<div  style="width: 100%;float: none; display: block">
    <div id="main" style="width: 1100px;height: 350px; margin: 0px auto;display: none"></div>
</div>
<script type="text/javascript">


    function wghpromotrate() {
        $("#main").css("display","block")
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '学院就业率(单位:%)'
            },
            tooltip: {},
            legend: {
                data:['就业率(单位:%)']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '就业率(单位:%)',
                type: 'bar',
                data: []
            }]
        };
        //设置加载动画
        myChart.showLoading();
        //定义数据来接收后台返回的数据
        var names = [];//用来接收学院名称
        var promotionRates = [];//用来接收升学率

        //利用ajax请求发起数据请求
        $.ajax({
            url:"wghshowrate",
            type:"post",
            data:{},
            dataType:"json",
            success:function (result) {
                console.log(result)
                for (var i=0;i<result.length;i++){
                    names.push(result[i].wgh_name)//往最后一个元素追加
                }
                for (var i=0;i<result.length;i++){
                    promotionRates.push(result[i].wgh_promotionRate)//往最后一个元素追加
                }
                //隐藏加载动画
                myChart.hideLoading();
                myChart.setOption({
                    xAxis: {
                        data: names
                    },
                    series: [{
                        data: promotionRates
                    }]
                });
            }
        })

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

    }


</script>
</body>
</html>
