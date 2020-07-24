<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>失物管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style>

    </style>
    <link rel="stylesheet" type="text/css" href="js/layui.css">
    <script type="text/javascript">

    </script>
</head>
<body>

<table id="demo" lay-filter="test"></table>

<script src="js/layui.all.js"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '${pageContext.request.contextPath}/by_dopage' //数据接口
            ,request:{
                page:1,
                limit:2,
            }
            // ,response:{
            //     statusName: 'code' //规定数据状态的字段名称，默认：code
            //     ,statusCode: 200 //规定成功的状态码，默认：0
            //     ,msgName: 'hint' //规定状态信息的字段名称，默认：msg
            //     ,countName: 'count' //规定数据总数的字段名称，默认：count
            //     ,dataName: 'data' //规定数据列表的字段名称，默认：data
            // }
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'type', title: '物品类型', width:80}
                ,{field: 'trait', title: '物品特征', width:80, sort: true}
                ,{field: 'time', title: '录入时间', width:80}
                ,{field: 'lost_loc', title: '丢失地点', width: 177}
                ,{field: 'get_loc', title: '领取地点', width: 80, sort: true}
            ]]
            ,page:{
                layout:['limit','count','prev','page','next','skip'],
                curr:1,
                groups:7,
                first:true,
                last:true,
            }
            ,limit:2
            ,limits:[1,2,3]
        });
    });
</script>

</body><!-- body-end  -->
</html>