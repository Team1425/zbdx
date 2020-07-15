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
 * @date: 2020-7-14 10:09
 * @description:
 */
@WebServlet("/hjlDoctorAdd")
public class HjlDoctorAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HjlDoctor doc=new HjlDoctor();
        doc.setDoctor_name(req.getParameter("doctorName"));
        doc.setDoctor_sex(req.getParameter("doctorSex"));
        doc.setDoctor_addr(req.getParameter("doctorAddr"));
        doc.setDepart_id(Integer.parseInt(req.getParameter("departId")));
        doc.setDoctor_tel(req.getParameter("doctorTel"));
        HjlDoctorDao doctorDao=new HjlDoctorDao();
        int i=doctorDao.insert_doc(doc);
        resp.sendRedirect("/hjlDoctorList");
    }
}
