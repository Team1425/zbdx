package com.zb.servlet;

import com.zb.dao.WjBooksDao;
import com.zb.pojo.WjBooks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/booksAdd")
public class WjBooksAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String booksname = request.getParameter("booksname");
        String author = request.getParameter("author");
        String ISBN = request.getParameter("ISBN");
        String ph = request.getParameter("ph");
        String price = request.getParameter("price");
        String pd = request.getParameter("pd");
        WjBooks wjBooks = new WjBooks();
        wjBooks.setBooksname(booksname);
        wjBooks.setAuthor(author);
        wjBooks.setISBN(ISBN);
        wjBooks.setPh(ph);
        wjBooks.setPrice(price);
        wjBooks.setPd(pd);
        WjBooksDao wjBooksDao = new WjBooksDao();
        try {
            wjBooksDao.addBooks(wjBooks);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(""+request.getContextPath()+"/booksList");
    }
}
