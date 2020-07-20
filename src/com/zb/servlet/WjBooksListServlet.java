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

@WebServlet("/booksList")
public class WjBooksListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("图书列表查询");
        WjBooksDao wjBooksDao = new WjBooksDao();
        try {
          List<WjBooks> list = wjBooksDao.findAll();
          request.setAttribute("list",list);
          request.getRequestDispatcher("/wj_books_list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
