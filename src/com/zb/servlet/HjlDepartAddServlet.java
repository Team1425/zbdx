package com.zb.servlet;

import com.zb.dao.HjlDepartmentDao;
import com.zb.pojo.HjlDepartment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-14 10:40
 * @description:
 */
@WebServlet("/hjlDepartAdd")
public class HjlDepartAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HjlDepartment department=new HjlDepartment();
        department.setDepart_name(req.getParameter("depName"));
        department.setDepart_dir(req.getParameter("dirName"));
        department.setRoom_num(Integer.parseInt(req.getParameter("room")));
        HjlDepartmentDao departmentDao=new HjlDepartmentDao();
        int i=departmentDao.insert_dep(department);
        ArrayList<HjlDepartment> list=departmentDao.selectAll_dep();
        req.setAttribute("deList",list);
        if(i>0){
            JOptionPane.showMessageDialog(null, "添加成功");
            resp.sendRedirect("/hjlDoctorList");
        }else{
            JOptionPane.showMessageDialog(null, "添加失败,科室名字已重复!!!");
            req.getRequestDispatcher("hjlDepartAdd.jsp").forward(req,resp);
        }

    }
}
