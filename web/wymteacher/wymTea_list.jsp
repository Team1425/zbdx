<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>教师管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;}
        table{ width:96%; margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px;}
        td, th{ padding: 5px;}
        th{ background-color: #DCDCDC; width:120px; }
        th.width-40{ width: 40px; }
        th.width-50{ width: 50px; }
        th.width-64{ width: 64px; }
        th.width-80{ width: 80px; }
        th.width-120{ width: 100px; }
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        #add-order{text-align:center;font-size:20px;}
    </style>

    <script type="text/javascript" src="/js/echarts.js"></script>
    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
</head>
<body>

<h2>教师管理</h2>
<div id="add-order">
    <a href="/wymteacher/wymTea_add.jsp" target="rightFrame">新增教师</a>
    <a>&nbsp;&nbsp;|&nbsp;&nbsp;</a>
    <a href="#" onclick="showsale()" target="rightFrame">查看教师薪资</a>
    <a>&nbsp;&nbsp;|&nbsp;&nbsp;</a>
    <a href="/wymteacher/wymTea_all.jsp" target="rightFrame">离职教师</a>
    <div style="float: right">
        <form action="${pageContext.request.contextPath}/downexcel">
            <input type="submit" value="报表导出">
        </form>
    </div>
</div>
<hr/>
<table border="1">
    <tr>
        <th class="width-40">序号</th>
        <th class="width-50">工号</th>
        <th class="width-50">姓名</th>
        <th class="width-40">性别</th>
        <th class="width-120">出生日期</th>
        <th class="width-150">身份证号</th>
        <th class="width-120">上岗日期</th>
        <th class="width-120">学院</th>
        <th class="width-120">专业</th>
        <th class="width-50">职称</th>
        <th class="width-80">政治面貌</th>
        <th class="width-50">手机号</th>
        <th class="width-50">邮箱地址</th>
        <th class="width-100">操 作</th>
    </tr>


    <c:forEach items="${list}" var="wymteacher" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${wymteacher.wymTeaJobnum}</td>
            <td>${wymteacher.wymTeaName}</td>
            <td>${wymteacher.wymTeaSex}</td>
            <td>
                <fmt:formatDate value="${wymteacher.wymTeaBirthday}"
                                pattern="yyyy-MM-dd" />
            </td>
            <td>${wymteacher.wymTeaIdcard}</td>
            <td>
                <fmt:formatDate value="${wymteacher.wymTeaStartdate}"
                                pattern="yyyy-MM-dd" />
            </td>
            <td>${wymteacher.wymTeaCollege}</td>
            <td>${wymteacher.wymTeaProfession}</td>

            <td>${wymteacher.wymTeaZhicheng}</td>
            <td>${wymteacher.wymTeaZhengzhimm}</td>
            <td>${wymteacher.wymTeaPhonenum}</td>

            <td>${wymteacher.wymTeaEmail}</td>
            <td>
                <a href="${pageContext.request.contextPath}/wymTeaDelete?id=${wymteacher.wymTeaId}">删除</a>
                &nbsp;|&nbsp;
                <a href="${pageContext.request.contextPath}/wymTeaInfo?id=${wymteacher.wymTeaId}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div style="width:100%;float:none;display:block">
    <div id="main" style="width:1100px;height:350px;margin: 0px auto;display:none"></div>
</div>
<script type="text/javascript">
    function showsale() {
        $("#main").css("display","block")
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '教师薪资'
            },
            tooltip: {},
            legend: {
                data:['薪资']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '薪资',
                type: 'bar',
                data: []
            }]
        };

        myChart.showLoading()
        var names = []; //用来接收教师名称
        var sales = []; //用来接收销量
        $.ajax({
            url:"/showsale",
            type:"post",
            data:{},
            dataType:"json",
            success: function (result){
                console.log(result)
                for (var i=0;i<result.length;i++){
                    names.push(result[i].wymTeaName)//往最后一个元素追加
                }
                for (var i=0;i<result.length;i++){
                    sales.push(result[i].wymTeaSalary)//往最后一个元素追加
                }
                //隐藏加载动画
                myChart.hideLoading();
                //覆盖数据根据数据在家数据图表
                myChart.setOption({
                    xAxis: {
                        data: names
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



