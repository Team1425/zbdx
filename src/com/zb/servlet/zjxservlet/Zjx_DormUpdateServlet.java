package com.zb.servlet.zjxservlet;

import com.zb.dao.zjxdao.Zjx_DormDao;
import com.zb.pojo.zjxpojo.Zjx_Dorm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doorUpdate")
public class Zjx_DormUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addr = request.getParameter("addr");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String stu_tel = request.getParameter("stu_tel");
        Integer stu_id = Integer.parseInt(request.getParameter("stu_id"));
        String name2 = request.getParameter("name2");
        String name3 = request.getParameter("name3");
        String name4 = request.getParameter("name4");
        String name1 = request.getParameter("name1");
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
        dormDao.updateById(dorm);
        response.sendRedirect("/dormList");
    }
}
