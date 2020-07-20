package com.zb.servlet.wghservlet;

import com.zb.dao.wghCollegeDao.wghCollegeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wghcollegeDelete")
public class wghCollegeDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        wghCollegeDao wghCollegeDao = new wghCollegeDao();
        wghCollegeDao.deleteById(id);
        response.sendRedirect(""+request.getContextPath()+"/wghcollegeList");

    }
}
