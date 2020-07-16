package com.zb.servlet;

import com.zb.dao.by_LostDao;
import com.zb.pojo.by_Lost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/by_lostList")
public class by_LostListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        by_LostDao lostDao = new by_LostDao();
        List<by_Lost> list = lostDao.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/by_lostList.jsp").forward(request,response);
    }
}
