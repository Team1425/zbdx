package com.zb.servlet.hlzServlet;

import com.zb.dao.HlzStudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hlzStudentDelete")
public class HlzStudentDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HlzStudentDao dao = new HlzStudentDao();
        int i=dao.delete(id);
        resp.sendRedirect("/hlzStudentList");
    }
}
