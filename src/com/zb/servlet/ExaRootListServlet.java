package com.zb.servlet;

import com.zb.dao.SzbExaRootDao;
import com.zb.pojo.Szb_ExaRoot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/szb_rootList")
public class ExaRootListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SzbExaRootDao szbExaRootDao = new SzbExaRootDao();
        List<Szb_ExaRoot> listRoot = szbExaRootDao.findAllRoot();
        request.setAttribute("listExaRoot", listRoot);
        System.out.println(listRoot.toString());
        request.getRequestDispatcher("/szb_rootList.jsp").forward(request,response);

    }
}
