package com.zb.servlet;

import com.zb.dao.WjBooksDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/booksDelete")
public class WjBooksDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        WjBooksDao wjBooksDao = new WjBooksDao();
        wjBooksDao.deleteById(id);
        response.sendRedirect("/booksList");
    }
}
