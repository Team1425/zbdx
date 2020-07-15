package com.zb.servlet;

import com.zb.dao.HjlDepartmentDao;
import com.zb.dao.HjlDoctorDao;
import com.zb.pojo.HjlDepartment;
import com.zb.pojo.HjlDoctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-14 8:36
 * @description:
 */
@WebServlet("/hjlDoctorList")
public class HjlDoctorListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HjlDoctorDao doctorDao=new HjlDoctorDao();
        ArrayList<HjlDoctor> doList=doctorDao.selectAll_doc();
        HjlDepartmentDao departmentDao=new HjlDepartmentDao();
        ArrayList<HjlDepartment> deList=departmentDao.selectAll_dep();
        req.setAttribute("doList",doList);
        req.setAttribute("deList",deList);
        req.getRequestDispatcher("hjldoctor_list.jsp").forward(req,resp);
    }
}
