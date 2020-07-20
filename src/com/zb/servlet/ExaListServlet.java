package com.zb.servlet;

import com.zb.dao.SzbExaDao;
import com.zb.pojo.Szb_Exa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/szb_exaList")
public class ExaListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SzbExaDao szbExaDao = new SzbExaDao();
        List<Szb_Exa> list = szbExaDao.findAll();
        request.setAttribute("listExa", list);
        System.out.println(list);
        request.getRequestDispatcher("/szb_exaList.jsp").forward(request,response);
    }
}
