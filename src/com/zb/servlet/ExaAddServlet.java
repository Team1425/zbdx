package com.zb.servlet;

import com.zb.dao.SzbExaDao;
import com.zb.pojo.Szb_Exa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/szb_exaAdd")
public class ExaAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Szb_Exa exa = new Szb_Exa();
        exa.setExa_id(request.getParameter("ExaId"));
        exa.setExa_name(request.getParameter("ExaName"));
        exa.setExa_room(request.getParameter("ExaRoom"));
        exa.setExa_time(request.getParameter("ExaTime"));
        exa.setExa_teacher(request.getParameter("ExaTeacher"));
        exa.setExa_teacherId(request.getParameter("ExaTeacherId"));
        SzbExaDao szbExaDao = new SzbExaDao();
        try {
            szbExaDao.addExa(exa);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("" + request.getContextPath() + "/szb_exaHandle");
    }
}
