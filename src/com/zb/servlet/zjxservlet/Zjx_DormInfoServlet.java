package com.zb.servlet.zjxservlet;

import com.zb.dao.zjxdao.Zjx_DormDao;
import com.zb.pojo.zjxpojo.Zjx_Dorm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dormInfo")
public class Zjx_DormInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Zjx_DormDao dormDao = new Zjx_DormDao();
        Zjx_Dorm dorm = dormDao.findById(id);
        System.out.println(dorm);
        request.setAttribute("dorm",dorm);
        request.getRequestDispatcher("/zjx_dorm_update.jsp").forward(request,response);
    }
}
