package com.zb.servlet;

import com.zb.dao.WjBooksDao;
import com.zb.pojo.WjBooks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/booksInfo")
public class WjBooksInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        WjBooksDao wjBooksDao = new WjBooksDao();
        WjBooks wjBooks = wjBooksDao.findById(id);
        System.out.println(wjBooks);
        request.setAttribute("wjbooks",wjBooks);
        request.getRequestDispatcher("/wj_books_update.jsp").forward(request,response);


    }
}
