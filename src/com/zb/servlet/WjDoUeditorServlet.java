package com.zb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wjdoueditor")
public class WjDoUeditorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("content");
        System.out.println(data);
        request.setAttribute("data",data);
        request.getRequestDispatcher("/wj_daily.jsp").forward(request,response);
    }
}
