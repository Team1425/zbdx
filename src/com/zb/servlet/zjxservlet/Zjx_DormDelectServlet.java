package com.zb.servlet.zjxservlet;

import com.zb.dao.zjxdao.Zjx_DormDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dormDelete")
public class Zjx_DormDelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Zjx_DormDao dormDao = new Zjx_DormDao();
        dormDao.deleteById(id);
        response.sendRedirect("/dormList");
    }
}
