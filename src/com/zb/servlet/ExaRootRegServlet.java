package com.zb.servlet;

import com.zb.dao.SzbExaRootDao;
import com.zb.pojo.Szb_ExaRoot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/szb_rootReg")
public class ExaRootRegServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mos = request.getParameter("mos");
        String root = request.getParameter("root");
        String pwd = request.getParameter("pwd");

//        if (mos == "7777777") {

            Szb_ExaRoot szb_exaRoot = new Szb_ExaRoot();
            szb_exaRoot.setExaAdRoot(root);
            szb_exaRoot.setPwd(pwd);

            SzbExaRootDao szbExaRootDao = new SzbExaRootDao();
            szbExaRootDao.addRoot(szb_exaRoot);
        System.out.println("11111111111111");
            response.sendRedirect("" + request.getContextPath() + "/szb_Login.jsp");

//        } else {
//            response.sendRedirect("" + request.getContextPath() + "/szb_Fail.jsp");
//        }
    }
}
