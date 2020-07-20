package com.zb.servlet.wymteaservlet;

import com.zb.utils.wymteautils.wymTeaExcelPOI;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/downexcel")
public class wymTeaDownExcelServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();

        resp.setHeader("Content-Disposition","attachment;fileName=Tealist.xls");

        String [] titles={"序号","工号","姓名","性别","出生日期","身份证号","上岗日期","学院","专业","职称","政治面貌","手机号","邮箱地址","薪资"};

        wymTeaExcelPOI excelPOI = new wymTeaExcelPOI();

        excelPOI.export(titles,out);
    }
}
