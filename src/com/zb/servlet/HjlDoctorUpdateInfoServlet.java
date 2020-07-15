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
 * @date: 2020-7-14 11:48
 * @description:
 */
@WebServlet("/HjlDoctorUpdateinfo")
public class HjlDoctorUpdateInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HjlDoctor doctor=new HjlDoctor();
        HjlDoctorDao doctorDao=new HjlDoctorDao();
        int id=Integer.parseInt(req.getParameter("id"));
        doctor=doctorDao.findById_doc(id);
        req.setAttribute("doctor",doctor);
        HjlDepartmentDao departmentDao=new HjlDepartmentDao();
        ArrayList<HjlDepartment> departments=departmentDao.selectAll_dep();
        req.setAttribute("deList",departments);
        req.getRequestDispatcher("hjlDoctorUpdate.jsp").forward(req,resp);
    }
}
