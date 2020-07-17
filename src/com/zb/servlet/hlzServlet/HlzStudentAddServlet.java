package com.zb.servlet.hlzServlet;

import com.zb.dao.HlzStudentDao;
import com.zb.pojo.HlzStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hlzStudentAdd")
public class HlzStudentAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HlzStudent student = new HlzStudent();
        student.setName(req.getParameter("name"));
        student.setSex(req.getParameter("sex"));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        student.setNumber(req.getParameter("number"));
        HlzStudentDao dao = new HlzStudentDao();
        int i=dao.insert(student);
        resp.sendRedirect("/hlzStudentList");
    }
}
