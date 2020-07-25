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
import java.util.List;

@WebServlet("/WjBooksShow")
public class WjBooksShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WjBooksDao wjBooksDao = new WjBooksDao();
        try {
            List<WjBooks> list = wjBooksDao.findAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/wj_booksShow.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
