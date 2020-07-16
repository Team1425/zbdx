package com.zb.servlet.wghservlet;

import com.zb.dao.wghCollegeDao;
import com.zb.pojo.wghCollege;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wghcollegeUpdate")
public class wghCollegeUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer teacherNum = Integer.parseInt(request.getParameter("teacherNum"));
        Integer studentNum = Integer.parseInt(request.getParameter("studentNum"));
        String leader = request.getParameter("leader");
        String promotionRate = request.getParameter("promotionRate");
        wghCollege wghcollege = new wghCollege();
        wghcollege.setWgh_id(id);
        wghcollege.setWgh_name(name);
        wghcollege.setWgh_leader(leader);
        wghcollege.setWgh_teacherNum(teacherNum);
        wghcollege.setWgh_studentNum(studentNum);
        wghcollege.setWgh_promotionRate(promotionRate);
        wghCollegeDao wghCollegeDao = new wghCollegeDao();
        wghCollegeDao.updateById(wghcollege);
        response.sendRedirect(""+request.getContextPath()+"/wghcollegeList");
    }
}
