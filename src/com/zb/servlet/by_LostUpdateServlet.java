package com.zb.servlet;

import com.zb.dao.by_LostDao;
import com.zb.pojo.by_Lost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/by_lostUpdate")
public class by_LostUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        String trait = request.getParameter("trait");
        Timestamp time = Timestamp.valueOf(request.getParameter("time"));
        String lost_loc = request.getParameter("lost_loc");
        String get_loc = request.getParameter("get_loc");

        by_Lost lost = new by_Lost();
        lost.setId(id);
        lost.setType(type);
        lost.setTrait(trait);
        lost.setTime(time);
        lost.setLost_loc(lost_loc);
        lost.setGet_loc(get_loc);
        by_LostDao lostDao = new by_LostDao();
        lostDao.updateLost(lost);
        response.sendRedirect("" + request.getContextPath() + "/by_lostList");

    }
}
