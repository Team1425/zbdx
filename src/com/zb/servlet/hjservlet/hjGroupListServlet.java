package com.zb.servlet.hjservlet;

import com.zb.dao.hjdao.hjGroupDao;
import com.zb.pojo.hjpojo.hjGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hjGroupList")
public class hjGroupListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("社团列表查询");
        hjGroupDao hjGroupDao = new hjGroupDao();
        try {
            List<hjGroup> list = hjGroupDao.findAll();
            req.setAttribute("list",list);
            req.getRequestDispatcher("/hj_group_list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
