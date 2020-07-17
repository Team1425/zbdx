package com.zb.servlet.wymteaservlet;

import com.zb.dao.wymteadao.wymTeaDao;
import com.zb.pojo.wymteacher.wymTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/wymTeaList")
public class wymTeaListServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        wymTeaDao wymTeaDao= new wymTeaDao();
        List<wymTeacher> list = wymTeaDao.findAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/wymteacher/wymTea_list.jsp").forward(req,resp);
    }
}
