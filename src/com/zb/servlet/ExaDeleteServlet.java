package com.zb.servlet;

import com.zb.dao.SzbExaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exaDelete")
public class ExaDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        SzbExaDao szbExaDao = new SzbExaDao();
        szbExaDao.deleteById(id);
        response.sendRedirect("" + request.getContextPath() + "/szb_exaHandle");
    }
}
