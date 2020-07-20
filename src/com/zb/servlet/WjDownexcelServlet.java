package com.zb.servlet;

import com.zb.utils.WjExcelPOI;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wjdownexcel")
public class WjDownexcelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建一个流，将生成的excel对象返回给浏览器让浏览器下载
        ServletOutputStream out = response.getOutputStream();
        //2.设置头文件
        response.setHeader("Content-Disposition","attachment;fileName=booklist.xls");
        //3.设置表头
        String [] titles = {"编号","书名","作者","ISBN","出版社","价格","出版日期"};
        //调用EXCELPOI里面的方法
        WjExcelPOI wjExcelPOI = new WjExcelPOI();
        wjExcelPOI.export(titles,out);




    }
}
