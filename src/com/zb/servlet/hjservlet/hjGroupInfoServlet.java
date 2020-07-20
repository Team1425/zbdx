package com.zb.servlet.hjservlet;

import com.zb.dao.hjdao.hjGroupDao;
import com.zb.pojo.hjpojo.hjGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hjGroupInfo")
public class hjGroupInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        hjGroupDao hjGroupDao=new hjGroupDao();
        hjGroup hjGroup=hjGroupDao.findById(id);
        req.setAttribute("hjGroup",hjGroup);
        req.getRequestDispatcher("/hj_group_update.jsp").forward(req,resp);
    }
}
