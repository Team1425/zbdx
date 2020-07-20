<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/20
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日总结</title>
    <script type="text/javascript" src="Wjueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="Wjueditor/ueditor.all.js"></script>
    <link rel="stylesheet" href="Wjueditor/themes/default/css/ueditor.css">
</head>
<body>


    <form action="${pageContext.request.contextPath}/wjdoueditor" method="post" style="width:100%">
        <textarea name="content" id="myEditor">
            这是默认初始化内容
        </textarea>
        <script>
            UE.getEditor("myEditor");//初始化编辑器 id保持一致
        </script>
        <input type="submit" value="提交">
    </form>




</body>
</html>
