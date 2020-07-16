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

@WebServlet("/wghcollegeAdd")
public class wghCollegeAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String leader = request.getParameter("leader");
        Integer teacherNum = Integer.parseInt(request.getParameter("teacherNum"));
        Integer studentNum = Integer.parseInt(request.getParameter("studentNum"));
        String promotionRate = request.getParameter("promotionRate");


        wghCollege wghcollege = new wghCollege();
        wghcollege.setWgh_name(name);
        wghcollege.setWgh_leader(leader);
        wghcollege.setWgh_teacherNum(teacherNum);
        wghcollege.setWgh_studentNum(studentNum);
        wghcollege.setWgh_promotionRate(promotionRate);
        wghCollegeDao wghCollegeDao = new wghCollegeDao();
        try {
            wghCollegeDao.addCollege(wghcollege);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(""+request.getContextPath()+"/wghcollegeList");
    }
}
