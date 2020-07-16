package com.zb.servlet;

import com.zb.dao.by_LostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/by_lostDelete")
public class by_LostDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        by_LostDao lostDao = new by_LostDao();
        lostDao.deleteById(id);
        response.sendRedirect(""+request.getContextPath()+"/by_lostList");
    }
}
