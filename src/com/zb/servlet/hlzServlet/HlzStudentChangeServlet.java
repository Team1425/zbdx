package com.zb.servlet.hlzServlet;

import com.zb.dao.HlzStudentDao;
import com.zb.pojo.HlzStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/hlzStudentChange")
public class HlzStudentChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HlzStudentDao studentDao=new HlzStudentDao();
        ArrayList<HlzStudent> list = new ArrayList<>();
        HlzStudent student = studentDao.findById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("student", student);
        req.getRequestDispatcher("hlzStudentChange.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HlzStudent student = new HlzStudent();
        student.setId(Integer.parseInt(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        student.setSex(req.getParameter("sex"));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        student.setNumber(req.getParameter("number"));
        HlzStudentDao dao = new HlzStudentDao();
        int i=dao.update(student);
        resp.sendRedirect("/hlzStudentList");
    }
}
