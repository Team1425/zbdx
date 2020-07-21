package com.zb.servlet.hjservlet;

import com.google.gson.Gson;
import com.zb.dao.hjdao.hjGroupDao;
import com.zb.pojo.hjpojo.hjGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showMan")
public class hjShowManServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showMan");
        hjGroupDao hjGroupDao = new hjGroupDao();
        List<hjGroup> list = null;
        try {
            list = hjGroupDao.showMan();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);
//利用gson将对象转变成json格式的字符串
        Gson gson = new Gson();
        String json = gson.toJson(list);System.out.println(json);
        resp.getWriter().write(json);
    }
}
