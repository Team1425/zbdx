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
 * @date: 2020-7-14 18:26
 * @description:
 */
@WebServlet("/HjlDeUpdate")
public class HjlDeUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HjlDepartment department=new HjlDepartment();
        department.setDepart_id(Integer.parseInt(req.getParameter("id")));
        department.setDepart_dir(req.getParameter("dirName"));
        department.setDepart_name(req.getParameter("depName"));
        department.setRoom_num(Integer.parseInt(req.getParameter("room")));
        HjlDepartmentDao departmentDao=new HjlDepartmentDao();
        departmentDao.update_dep(department);
        ArrayList<HjlDepartment> list=departmentDao.selectAll_dep();
        req.setAttribute("deList",list);
        req.getRequestDispatcher("hjlDepartAdd.jsp").forward(req,resp);
    }
}
