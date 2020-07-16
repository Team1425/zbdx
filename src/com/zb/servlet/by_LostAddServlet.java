package com.zb.servlet;

import com.zb.dao.by_LostDao;
import com.zb.pojo.by_Lost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/by_lostAdd")
public class by_LostAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String trait = request.getParameter("trait");
        String lost_loc = request.getParameter("lost_loc");
        String get_loc = request.getParameter("get_loc");
        by_Lost lost = new by_Lost();
        lost.setType(type);
        lost.setTrait(trait);
        lost.setLost_loc(lost_loc);
        lost.setGet_loc(get_loc);
        by_LostDao lostDao = new by_LostDao();
        lostDao.addLost(lost);
        response.sendRedirect("" + request.getContextPath() + "/by_lostList");
    }
}
