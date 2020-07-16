package com.zb.servlet;

import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YzzctaddServlet")
public class YzzctaddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ctname=request.getParameter("ctname");
        String cttel=request.getParameter("cttel");
        String ctaddr=request.getParameter("ctaddr");
        String ctsale=request.getParameter("ctsale");
        Yzzct yzzct= new Yzzct();
        yzzct.setCT_name(ctname);
        yzzct.setCT_tel(cttel);
        yzzct.setCT_addr(ctaddr);
        yzzct.setCT_sale(ctsale);
        YzzuserDao yzzuserDao = new YzzuserDao();
        yzzuserDao.ctadd(yzzct);
        response.sendRedirect(""+request.getContextPath()+"/CTlistServlet");

    }
}
