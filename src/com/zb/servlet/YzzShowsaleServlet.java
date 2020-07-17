package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/YzzShowsaleServlet")
public class YzzShowsaleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        YzzuserDao yzzuserDao=new YzzuserDao();
        List<Yzzct> list=yzzuserDao.findall();
        Gson gson=new Gson();
        String json=gson.toJson(list);
        /*System.out.println(json);*/
        response.getWriter().write(json);
    }
}
