package com.zb.servlet;

import com.zb.dao.HjlDepartmentDao;
import com.zb.pojo.HjlDepartment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-14 18:11
 * @description:
 */
@WebServlet("/HjlDepatUpdateinfo")
public class HjlDeUpdateInofoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        HjlDepartmentDao departmentDao=new HjlDepartmentDao();
        HjlDepartment department=departmentDao.findById_dep(id);

        req.setAttribute("list",department);
        req.getRequestDispatcher("hjlDepartUpdate.jsp").forward(req,resp);
    }
}
