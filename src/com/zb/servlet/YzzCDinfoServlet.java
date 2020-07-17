package com.zb.servlet;

import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzcd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YzzCDinfoServlet")
public class YzzCDinfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        YzzuserDao yzzuserDao = new YzzuserDao();
        Yzzcd yzzcd= yzzuserDao.cdfingbyid(id);
        System.out.println(yzzcd);
        request.setAttribute("yzzcd",yzzcd);
        request.getRequestDispatcher("/Yzzcdupdate.jsp").forward(request,response);
    }
}
