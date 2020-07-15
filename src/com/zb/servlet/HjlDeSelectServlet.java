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
 * @date: 2020-7-14 18:44
 * @description:
 */
@WebServlet("/HjlDeSelect")
public class HjlDeSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HjlDepartmentDao departmentDao=new HjlDepartmentDao();
        ArrayList<HjlDepartment> list=departmentDao.selectAll_dep();
        req.setAttribute("deList",list);
        req.getRequestDispatcher("hjlDepartAdd.jsp").forward(req,resp);
    }
}
