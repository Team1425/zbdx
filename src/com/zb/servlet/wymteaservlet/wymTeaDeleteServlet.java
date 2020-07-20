package com.zb.servlet.wymteaservlet;

import com.zb.dao.wymteadao.wymTeaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wymTeaDelete")
public class wymTeaDeleteServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        wymTeaDao wymTeaDao= new wymTeaDao();
        wymTeaDao.deleteById(id);
        resp.sendRedirect(""+req.getContextPath()+"/wymTeaList");
    }
}
