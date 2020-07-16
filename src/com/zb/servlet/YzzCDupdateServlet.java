package com.zb.servlet;

import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzcd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YzzCDupdateServlet")
public class YzzCDupdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String ctname=request.getParameter("ctname");
        String cdname= request.getParameter("cdname");
        String cdprice=request.getParameter("cdprice");
        String cdtype=request.getParameter("cdtype");
        Yzzcd yzzcd=new Yzzcd();
        yzzcd.setId(id);
        yzzcd.setCT_name(ctname);
        yzzcd.setCD_name(cdname);
        yzzcd.setCD_price(cdprice);
        yzzcd.setCD_type(cdtype);
        YzzuserDao yzzuserDao=new YzzuserDao();
        yzzuserDao.cdupdate(yzzcd);
        response.sendRedirect(""+request.getContextPath()+"/YzzCDlistServlet");

    }
}
