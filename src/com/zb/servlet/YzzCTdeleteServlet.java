package com.zb.servlet;

import com.zb.dao.YzzuserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YzzCTdeleteServlet")
public class YzzCTdeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        YzzuserDao yzzuserDao=new YzzuserDao();
        yzzuserDao.ctdelete(id);
        response.sendRedirect(""+request.getContextPath()+"/CTlistServlet");
    }
}
