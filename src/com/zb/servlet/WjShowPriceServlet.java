package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.WjBooksDao;
import com.zb.pojo.WjBooks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showprice")
public class WjShowPriceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ShowPriceServlet");
        WjBooksDao wjBooksDao = new WjBooksDao();
        List<WjBooks>list = wjBooksDao.showPrice();
        System.out.println(list);


        //利用gson将对象转变成json格式的字符串
        Gson gson = new Gson();
        String json =  gson.toJson(list);
        System.out.println(json);
        response.getWriter().write(json);

    }
}
