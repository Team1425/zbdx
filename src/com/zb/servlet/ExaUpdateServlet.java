package com.zb.servlet;

import com.zb.dao.SzbExaDao;
import com.zb.pojo.Szb_Exa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exaUpdate")
public class ExaUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        SzbExaDao szbExaDao = new SzbExaDao();
        Szb_Exa exa = szbExaDao.findById(id);
        request.setAttribute("exa",exa);
        request.getRequestDispatcher("/szb_exaInfo.jsp").forward(request,response);
    }
}
