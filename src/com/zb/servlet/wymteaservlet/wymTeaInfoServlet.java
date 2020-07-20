package com.zb.servlet.wymteaservlet;

import com.zb.dao.wymteadao.wymTeaDao;
import com.zb.pojo.wymteacher.wymTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/wymTeaInfo")
public class wymTeaInfoServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        wymTeaDao wymTeaDao= new wymTeaDao();
        wymTeacher wymTeacher = wymTeaDao.findById(id);
        req.setAttribute("wymTeacher",wymTeacher);
        req.getRequestDispatcher("/wymteacher/wymTea_update.jsp").forward(req,resp);
    }
}
