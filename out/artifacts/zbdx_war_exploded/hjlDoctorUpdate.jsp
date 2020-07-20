<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2020-7-14
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>修改订单</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style type="text/css">
        body{ font-family: "微软雅黑"; background-color: #EDEDED; }
        h2{ text-align: center;font-size:26px; }
        table{ margin: 30px auto; text-align: center; border-collapse:collapse; width:50%; }
        td, th{ padding: 5px;font-size:18px;}
        hr{ margin-bottom:20px; border:1px solid #aaa; }
        input,select,textarea{ width:284px; height:30px; background:#EDEDED; border:1px solid #999; text-indent:5px; font-size:18px; }
        input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
        select{text-indent:0px;}
        textarea{height:100px;font-size:22px;}
    </style>
</head>
<body><!-- body-start  -->

<h2>修改订单</h2>
<hr/>
<form action="/HjlDoctorUpdate" method="POST">
    <!-- hidden隐藏域,在提交表单时连order.id一起提交 -->
    <input type="hidden" name="id" value="${doctor.doctor_id}" />
    <table border="1">
        <tr>
            <td width="30%">所属科室</td>
            <td>
                <select id="depId" name="depId" >
                    <c:forEach items="${deList}" var="depa">
                        <c:if test="${doctor.depart_id==depa.depart_id}">
                            <option selected="selected" value="${ depa.depart_id}">
                                    ${depa.depart_name}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="doctorName"
                       value="${doctor.doctor_name}"/>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="text" name="doctorSex"
                       value="${doctor.doctor_sex}"/>
            </td>
        </tr>
        <tr>
            <td>联系方式</td>
            <td>
                <input type="text" name="doctorTel"
                       value="${doctor.doctor_tel}"/>
            </td>
        </tr>
        <tr>
            <td>家庭地址</td>
            <td>
                <input type="text" name="doctorAddr"
                       value="${doctor.doctor_addr}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提 	交"/>
            </td>
        </tr>
    </table>
</form>

</body><!-- body-end  -->
</html>



