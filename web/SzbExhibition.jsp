<%--
  Created by IntelliJ IDEA.
  User: sung
  Date: 2020/7/24
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>考试管理</title>
    <link rel="stylesheet" href="./css/clockstyle.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/echarts.js"></script>
</head>
<body>
    <div id="time">
        <div class="clock">
            <div class="hour">
                <div class="hr" id="hr"></div>
            </div>
            <div class="min">
                <div class="mn" id="mn"></div>
            </div>
            <div class="sec">
                <div class="sc" id="sc"></div>
            </div>
        </div>
        <script type="text/javascript">
            var deg= 6;
            var hr= document.getElementById("hr");
            var mn=document.getElementById("mn");
            var sc=document.getElementById("sc");
            setInterval(()=>{
                var day=new Date();
                var hh=day.getHours()*30;
                var mm=day.getMinutes()*deg;
                var ss=day.getSeconds()*deg;
                hr.style.transform='rotateZ('+(hh+(mm/12))+'deg)';
                mn.style.transform='rotateZ('+mm+'deg)';
                sc.style.transform='rotateZ('+ss+'deg)';
            })
        </script>
    </div>
    <div id="table">
        <table>
            <tr>
                <td id="Exh" colspan="2"><a id="szbFob">---|考试通知|---</a></td>
            </tr>
            <c:forEach items="${listExh}" var="szbexa" varStatus="status">
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                </tr>
                <tr>
                    <td>考试名称:</td>
                    <td>${szbexa.getExa_name()}</td>
                </tr>
                <tr>
                    <td>考试时间:</td>
                    <td>${szbexa.getExa_time()}</td>
                </tr>
                <tr>
                    <td>考场地址:</td>
                    <td>${szbexa.getExa_room()}</td>
                </tr>
                <tr>
                    <td>监考教师:</td>
                    <td>${szbexa.getExa_teacher()}</td>
                </tr>

            </c:forEach>
        </table>
    </div>
</body>
</html>
