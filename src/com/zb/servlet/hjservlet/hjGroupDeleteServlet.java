package com.zb.servlet.hjservlet;

import com.zb.dao.hjdao.hjGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/hjGroupDelete")
public class hjGroupDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Integer id=Integer.parseInt(req.getParameter("id"));
            hjGroupDao hjgroupDao=new hjGroupDao();
            hjgroupDao.deleteGroup(id);
        } catch (SQLException e) {
           e.printStackTrace();
        }
        resp.sendRedirect("hjGroupList");
    }
}
