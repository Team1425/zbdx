package com.zb.servlet;

import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzcd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/YzzstudentlistServlet")
public class YzzstudentlistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        YzzuserDao yzzuserDao=new YzzuserDao();
        List<Yzzcd> list=yzzuserDao.findallcd();
        request.setAttribute("listcd",list);
        System.out.println(list);
        request.getRequestDispatcher("/Yzzstudent.jsp").forward(request,response);
    }
}
