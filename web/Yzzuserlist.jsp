<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>用户管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
    </script>
    <script type="text/javascript" src="js/layui.all.js"></script>
    <link rel="stylesheet" href="js/layui.css">
</head>
<body>
<table id="demo" lay-filter="test"></table>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '${pageContext.request.contextPath}/dopage' //数据接口
            ,request:{
                page:1,
                limit:2
            }
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'username', title: '同户名', width:80}
                ,{field: 'password', title: '订单号', width:80}
                ,{field: 'type', title: '类型', width:80}
            ]]
            ,page:{
                layout:['limit','count','prev','page','next','skip'],
                cuur:1,
                groups:7,
                first:true,
                last:true
            }
            ,limit:2
            ,limits:[1,2,3]

        });

    });
</script>
</body><!-- body-end  -->
</html>




