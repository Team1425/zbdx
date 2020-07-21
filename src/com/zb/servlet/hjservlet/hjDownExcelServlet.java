package com.zb.servlet.hjservlet;

import com.zb.dao.hjdao.ExcelPOI;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/downExcel")
public class hjDownExcelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("downExcel");
        ServletOutputStream out = resp.getOutputStream();
//2.设置头文件，让浏览器去下载
        resp.setHeader("ContentDisposition","attachment;fileName=grouplist.xls");
//3.预先设置表头
        String [] titles = {"编号","社团名称","总人数","类型","社团经费","社团近期活动"};
//调用ExcelPOI（我们自己创建的类）里面的方法，帮助我们生成excel
        ExcelPOI excelPOI = new ExcelPOI();excelPOI.export(titles,out);
    }
}
