package com.zb.servlet;

import com.zb.dao.SzbExaRootDao;
import com.zb.pojo.Szb_ExaRoot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/szb_rootLogin")
public class ExaRootLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String root = request.getParameter("root");
        String pwd = request.getParameter("pwd");

        Szb_ExaRoot szb_exaRoot = new Szb_ExaRoot();
        szb_exaRoot.setExaAdRoot(root);
        szb_exaRoot.setPwd(pwd);
        System.out.println(szb_exaRoot.toString());
        SzbExaRootDao szbExaRootDao = new SzbExaRootDao();
        Szb_ExaRoot szb_exaRoot1 = new Szb_ExaRoot();
        szb_exaRoot1 = szbExaRootDao.login(szb_exaRoot);

        if (szb_exaRoot1.getPwd().equals(szb_exaRoot.getPwd())) {
            response.sendRedirect("" + request.getContextPath() + "/szb_rootList");
        } else {
            response.sendRedirect("" + request.getContextPath() + "/szb_Fail.jsp");
        }
    }
}
