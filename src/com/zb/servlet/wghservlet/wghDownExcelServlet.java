package com.zb.servlet.wghservlet;

import com.zb.utils.wghExcelPOI;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wghdownexcel")
public class wghDownExcelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.创建一个流，将我们生成的Excel对象返回给浏览器
        ServletOutputStream out = response.getOutputStream();
        //2.设置头文件，让浏览器去下载
        response.setHeader("Content-Disposition","attachment;fileName=doorlist.xls");
        //3.预先设置表头
        String[] wgh_titles = {"编号","学院名称","学院院长","教师人数","学生人数","就业率(单位:%)"};
        //调用ExcelPOI（自己创建的类）,调用里面的方法帮我们生成Excel
        wghExcelPOI wghExcelPOI = new wghExcelPOI();
        wghExcelPOI.excelport(wgh_titles,out);
    }
}
