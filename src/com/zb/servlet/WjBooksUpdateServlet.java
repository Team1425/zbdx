package com.zb.servlet;

import com.zb.dao.WjBooksDao;
import com.zb.pojo.WjBooks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/booksUpdate")
public class WjBooksUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String booksname = request.getParameter("booksname");
        String author  = request.getParameter("author");
        String ISBN = request.getParameter("ISBN");
        String ph = request.getParameter("ph");
        String price = request.getParameter("price");
        String pd = request.getParameter("pd");

        WjBooks wjBooks = new WjBooks();
        wjBooks.setId(id);
        wjBooks.setBooksname(booksname);
        wjBooks.setAuthor(author);
        wjBooks.setISBN(ISBN);
        wjBooks.setPh(ph);
        wjBooks.setPrice(price);
        wjBooks.setPd(pd);

        WjBooksDao wjBooksDao = new WjBooksDao();
        wjBooksDao.updateById(wjBooks);
        response.sendRedirect("/booksList");


    }
}
