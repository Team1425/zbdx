package com.zb.servlet;

import com.zb.dao.HjlDoctorDao;
import com.zb.pojo.HjlDoctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: l
 * @date: 2020-7-14 12:01
 * @description:
 */
@WebServlet("/HjlDoctorUpdate")
public class HjlDoctorUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HjlDoctor doctor=new HjlDoctor();
        doctor.setDoctor_id(Integer.parseInt(req.getParameter("id")));
        doctor.setDepart_id(Integer.parseInt(req.getParameter("depId")));
        doctor.setDoctor_name(req.getParameter("doctorName"));
        doctor.setDoctor_tel(req.getParameter("doctorTel"));
        doctor.setDoctor_sex(req.getParameter("doctorSex"));
        doctor.setDoctor_addr(req.getParameter("doctorAddr"));
        HjlDoctorDao doctorDao=new HjlDoctorDao();
        int i=doctorDao.update_doc(doctor);
        resp.sendRedirect("/hjlDoctorList");
    }
}
