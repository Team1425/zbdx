package com.zb.servlet.hjservlet;

import com.zb.dao.hjdao.hjStudentDao;
import com.zb.pojo.hjpojo.hjStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/hjStudentInfo")
public class hjStudentInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        hjStudentDao hjStudentDao=new hjStudentDao();
        try {
            hjStudent hjStudent=hjStudentDao.findById(id);
            req.setAttribute("hjStudent",hjStudent);
            req.getRequestDispatcher("/hj_group_stu_update.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
