package com.zb.servlet;

import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YzzRegServlet")
public class YzzRegServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("usertype");
        String username=request.getParameter("username");
        String passwpord=request.getParameter("password");
        Yzzuser yzzuser = new Yzzuser();
        yzzuser.setType(type);
        yzzuser.setUsername(username);
        yzzuser.setPassword(passwpord);
        YzzuserDao yzzuserDao=new YzzuserDao();
        yzzuserDao.adduser(yzzuser);
        response.sendRedirect(""+request.getContextPath()+"/Yzzsecss.jsp");

    }
}
