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
 * @date: 2020-7-14 11:39
 * @description:
 */
@WebServlet("/HjlDoctorDelete")
public class HjlDoctorDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        HjlDoctorDao doctorDao=new HjlDoctorDao();
        int i= doctorDao.delete_doc(id);
        resp.sendRedirect("/hjlDoctorList");
    }
}
