package com.zb.servlet;

import com.zb.dao.by_LostDao;
import com.zb.pojo.by_Lost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/by_lostInfo")
public class by_LostInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        by_LostDao lostDao = new by_LostDao();
        by_Lost lost = lostDao.findById(id);
        request.setAttribute("lost",lost);
        request.getRequestDispatcher("/by_lostUpdate.jsp").forward(request,response);


    }
}
