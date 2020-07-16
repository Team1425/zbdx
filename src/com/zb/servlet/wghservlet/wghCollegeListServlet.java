package com.zb.servlet.wghservlet;

import com.zb.dao.wghCollegeDao;
import com.zb.pojo.wghCollege;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/wghcollegeList")
public class wghCollegeListServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("学院系统查询");
        wghCollegeDao wghCollegeDao = new wghCollegeDao();
        try {
            List<wghCollege> list = wghCollegeDao.findAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/wghcollege_list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
