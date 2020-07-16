package com.zb.servlet;

import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YzzCTinfoServlet")
public class YzzCTinfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        YzzuserDao yzzuserDao = new YzzuserDao();
        Yzzct yzzct= yzzuserDao.ctfindbyid(id);
        request.setAttribute("yzzct",yzzct);
        request.getRequestDispatcher("/Yzzctupdate.jsp").forward(request,response);
    }
}
