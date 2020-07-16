<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

    <title>门店管理</title>
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
        #add-door{text-align:center;font-size:20px;}
        #add-door1{text-align:center;font-size:20px;}
    </style>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/echarts.js"></script>
</head>
<body><!-- body-start  -->
<script src=""></script>
<h2>餐厅管理</h2>
<div id="add-door">
    <a href="Yzzctadd.jsp" target="rightFrame"><input type="submit" value="新增餐厅"/></a>
    <a>&nbsp;&nbsp;&nbsp;</a>
    <a href="Yzzreg.jsp"  target="rightFrame"><input type="submit" value="注册用户"/></a>
    <a href="YzzCDlistServlet"  target="rightFrame"><input type="submit" value="菜单管理"/></a>
    <div style="float: right">
        <%--<form action="${pageContext.request.contextPath}/downexcel">
            <input type="submit" value="报表导出"/>
        </form>--%>
            <a href="#" onclick="showSale()" target="rightFrame"><input type="submit" value="查看销售额"/></a>
    </div>
</div>
<hr/>
<table border="1">
    <tr>
        <th class="width-40">序号</th>
        <th>餐厅名称</th>
        <th class="width-80">联系电话</th>
        <th>餐厅地址</th>
        <th class="width-80">操 作</th>
    </tr>

    <c:forEach items="${list}" var="yzzct" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${yzzct.CT_name}</td>
            <td>${yzzct.CT_tel}</td>
            <td>${yzzct.CT_addr}</td>
            <td>
                <a href="YzzCTdeleteServlet?id=${yzzct.id}">删除</a>
                &nbsp;|&nbsp;
                <a href="YzzCTinfoServlet?id=${yzzct.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr/>

<div style="width: 100%;float: none;display: block;">
    <div id="main" style="width: 1100px;height: 350px;margin: 0px auto;display: none">
    </div>
</div>
<script type="text/javascript">
    function showSale() {
        $("#main").css("display","block");
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '门店销售额'
            },
            tooltip: {},
            legend: {
                data:['销售额']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销售额',
                type: 'bar',
                data: []
            }]
        };
        //设置加载动画
        myChart.showLoading();
        var name=[];//店铺
        var sales=[];//销量

        $.ajax({
            url:"/YzzShowsaleServlet",
            type:"post",
            data:{},
            dataType:"json",
            success:function (result) {
                console.log(result)
                for(var i=0;i<result.length;i++){
                    name.push(result[i].CT_name)
                }
                for(var j=0;j<result.length;j++){
                    sales.push(result[j].CT_sale)
                }
                //隐藏加载动画
                myChart.hideLoading();
                //覆盖数据根据数据加载图表
                myChart.setOption({
                    xAxis: {
                        data: name
                    },
                    series: [{
                        data: sales
                    }]

                })

            }
        })
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
</script>

</body><!-- body-end  -->
</html>
