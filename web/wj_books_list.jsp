<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/14
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>图书管理系统</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <style type="text/css">
            body{ font-family: "微软雅黑"; background-color: #EDEDED; }
            h2{ text-align: center;}
            table{ width:96%; margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px;}
            td, th{ padding: 5px;}
            th{ background-color: #DCDCDC; width:120px; }
            hr{ margin-bottom:20px; border:1px solid #aaa; }
            #add-books{text-align:center;font-size:20px;}
        </style>
        <script type="text/javascript" src="js/echarts.js"></script>
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    </head>
</head>
<body>
<h2>图书管理系统</h2>
<div id="add-books">
    <a href="wj_books_add.jsp" target="rightFrame">新增图书</a>
    <a>&nbsp;&nbsp;|&nbsp;&nbsp;</a>
    <a href="#" onclick="showprice()" target="rightFrame">图书单价一览</a>

</div>
<div style="float:left">
    <a href=${pageContext.request.contextPath}"wjdayeditor.jsp">
        <button>日总结</button>
    </a>
</div>

<div style="float: right">
    <form action="${pageContext.request.contextPath}/wjdownexcel">
        <input type="submit" value="报表导出"/>
    </form>
</div>

<hr/>
<table border="1">
    <tr>
        <th>序号</th>
        <th>书名</th>
        <th>作者</th>
        <th>ISBN</th>
        <th>出版社</th>
        <th>价格</th>
        <th>出版日期</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${list}" var="wjbooks" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${wjbooks.booksname}</td>
            <td>${wjbooks.author}</td>
            <td>${wjbooks.ISBN}</td>
            <td>${wjbooks.ph}</td>
            <td>${wjbooks.price}</td>
            <td>${wjbooks.pd}</td>
            <td>
                <a href="${pageContext.request.contextPath}/booksDelete?id=${wjbooks.id}">删除</a>
                &nbsp;|&nbsp;
                <a href="${pageContext.request.contextPath}/booksInfo?id=${wjbooks.id}">修改</a>
            </td>
        </tr>

    </c:forEach>
</table>

<div style="width: 100%;float: none;display: block">
    <div id="main" style="width: 1100px;height: 350px;margin: 0px auto;display: none">

        <script type="text/javascript">
            function showprice() {
                $("#main").css("display","block")
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '图书单价一览表'
                    },
                    tooltip: {},
                    legend: {
                        data:['单价']
                    },
                    xAxis: {
                        data: []
                    },
                    yAxis: {},
                    series: [{
                        name: '单价',
                        type: 'bar',
                        data: []
                    }]
                };
                //设置加载动画
                myChart.showLoading();
                var booksname=[];
                var price=[];

                $.ajax({
                    url:"showprice",
                    type:"post",
                    data:{},
                    dataType:"json",
                    success:function (result) {
                        console.log(result)
                        for (var i=0;i<result.length;i++){
                            booksname.push(result[i].booksname)
                        }
                        for (var i=0;i<result.length;i++){
                            price.push(result[i].price)
                        }
                        //隐藏加载动画
                        myChart.hideLoading();
                        //覆盖数据
                        myChart.setOption({
                            xAxis: {
                                data: booksname
                            },
                            series: [{
                                data: price
                            }]
                            }
                        )

                    }
                })
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        </script>
    </div>
</div>


</body>
</html>
