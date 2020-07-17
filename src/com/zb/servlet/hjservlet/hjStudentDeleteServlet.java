package com.zb.servlet.hjservlet;

import com.zb.dao.hjdao.hjStudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/hjStudentDelete")
public class hjStudentDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer id=Integer.parseInt(req.getParameter("id"));
            hjStudentDao hjStudentDao=new hjStudentDao();
            hjStudentDao.deleteStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("hjStudentListNew1");
    }
}
