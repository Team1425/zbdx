<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>离职教师</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="/js/layui.all.js"></script>
    <link rel="stylesheet" href="/js/layui.css">
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
                ,url: '${pageContext.request.contextPath}/wymTeadopage' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'wymTeaId', title: 'ID', width:20, sort: true, fixed: 'left'}
                    ,{field: 'wymTeaJobnum', title: '职工号', width:100}
                    ,{field: 'wymTeaName', title: '姓名', width:100, sort: true}
                    ,{field: 'wymTeaSex', title: '性别', width:80}
                    ,{field: 'wymTeaBirthday', title: '出生日期', width: 200}
                    ,{field: 'wymTeaIdcard', title: '身份证号', width: 200, sort: true}
                    ,{field: 'wymTeaStartdate', title: '工作起始日期', width: 200, sort: true}
                    ,{field: 'wymTeaCollege', title: '所属学院', width: 100}
                    ,{field: 'wymTeaProfession', title: '专业', width: 135, sort: true}
                    ,{field: 'wymTeaZhicheng', title: '职称', width: 135, sort: true}
                    ,{field: 'wymTeaZhengzhimm', title: '政治面貌', width: 100, sort: true}
                    ,{field: 'wymTeaPhonenum', title: '手机号', width: 150, sort: true}
                    ,{field: 'wymTeaEmail', title: 'email', width: 150}
                    ,{field: 'wymTeaSalary', title: '薪资', width: 135, sort: true}
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
</body>
</html>
