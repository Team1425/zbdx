package com.zb.servlet;

import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CTlistServlet")
public class YzzCTlistServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        YzzuserDao yzzuserDao = new YzzuserDao();
        List<Yzzct> list=yzzuserDao.findall();
        request.setAttribute("list",list);
        System.out.println(list);
        request.getRequestDispatcher("/Yzzsecss.jsp").forward(request,response);
        /*response.sendRedirect(""+request.getContextPath()+"/CTlistServlet");*/
    }
}
