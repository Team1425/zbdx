package com.zb.servlet.zjxservlet;

import com.zb.dao.zjxdao.Zjx_DormDao;
import com.zb.pojo.zjxpojo.Zjx_Dorm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dormList")
public class Zjx_DormListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Zjx_DormDao dormDao = new Zjx_DormDao();
        try {
            List<Zjx_Dorm> list = dormDao.findAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/zjx_dorm_list.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
