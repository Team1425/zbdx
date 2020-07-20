package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.by_LostDao;
import com.zb.pojo.by_JsonResult;
import com.zb.pojo.by_Lost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/by_dopage")
public class by_DoPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前页
        Integer pageOn = Integer.parseInt(request.getParameter("page"));
        //每页显示几条
        Integer pageSize = Integer.parseInt(request.getParameter("limit"));
        by_LostDao lostDao = new by_LostDao();
        List<by_Lost> list = lostDao.dopage(pageOn,pageSize);
        Integer count = lostDao.pagecount();
        by_JsonResult jr = new by_JsonResult(0,"成功",count,list);
        Gson gson = new Gson();
        String json = gson.toJson(jr);
        System.out.println(json);
        response.getWriter().write(json);

    }
}
