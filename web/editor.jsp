<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/17
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日总结编写</title>
<%--    引入插件--%>
    <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="ueditor/ueditor.all.js"></script>
    <link rel="stylesheet" href="ueditor/themes/default/css/ueditor.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/douEditor" method="post" style="width: 800px">
    <textarea name="content" id="myEditor">
        这里是默认初始化内容
    </textarea>
    <script>
        UE.getEditor("myEditor");//初始化编辑器id保持一致
    </script>
    <input type="submit" value="提交">
</form>
</body>
</html>
