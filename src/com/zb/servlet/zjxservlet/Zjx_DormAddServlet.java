package com.zb.servlet.zjxservlet;

import com.zb.dao.zjxdao.Zjx_DormDao;
import com.zb.pojo.zjxpojo.Zjx_Dorm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/doorAdd")
public class Zjx_DormAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addr = req.getParameter("addr");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String stu_tel = req.getParameter("stu_tel");
        Integer stu_id = Integer.parseInt(req.getParameter("stu_id"));
        String name2 = req.getParameter("name2");
        String name3 = req.getParameter("name3");
        String name4 = req.getParameter("name4");
        String name1 = req.getParameter("name1");
        Zjx_Dorm dorm = new Zjx_Dorm();
        dorm.setName1(name1);
        dorm.setName2(name2);
        dorm.setName3(name3);
        dorm.setName4(name4);
        dorm.setAddr(addr);
        dorm.setStu_tel(stu_tel);
        dorm.setStu_id(stu_id);
        dorm.setId(id);
        Zjx_DormDao dormDao = new Zjx_DormDao();
        try {
            dormDao.addDorm(dorm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/dormList");

    }
}
