package com.zb.servlet;

import com.zb.dao.SzbExaDao;
import com.zb.pojo.Szb_Exa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exaInfo")
public class ExaInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("ExaId");
        String name = request.getParameter("ExaName");
        String room = request.getParameter("RoomName");
        String time = request.getParameter("ExaTime");
        String teacher = request.getParameter("ExaTeacher");
        String teacherId = request.getParameter("ExaTeacherId");

        Szb_Exa szb_exa = new Szb_Exa();
        szb_exa.setExa_id(id);
        szb_exa.setExa_name(name);
        szb_exa.setExa_room(room);
        szb_exa.setExa_time(time);
        szb_exa.setExa_teacher(teacher);
        szb_exa.setExa_teacherId(teacherId);
        SzbExaDao szbExaDao = new SzbExaDao();
        szb_exa = szbExaDao.updateById(szb_exa);
        request.setAttribute("szb_exa",szb_exa);
        request.getRequestDispatcher("/szb_exaHandle").forward(request,response);

    }
}
