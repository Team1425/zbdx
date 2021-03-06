package com.zb.servlet.hjservlet;

import com.zb.dao.hjdao.hjStudentDao;
import com.zb.pojo.hjpojo.hjStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hjStudentUpdate")
public class hjStudentUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("hj_stu_id"));
        String name=req.getParameter("hj_stu_name");
        Integer no=Integer.parseInt(req.getParameter("hj_stu_no"));
        Integer age=Integer.parseInt(req.getParameter("hj_stu_age"));
        String sex=req.getParameter("hj_stu_sex");
        Integer grp_id=Integer.parseInt(req.getParameter("hj_stu_grp_id"));
        String phone=req.getParameter("hj_stu_phone");
        String department=req.getParameter("hj_stu_department");
        hjStudent hjStudent=new hjStudent();
        hjStudent.setHj_stu_id(id);
        hjStudent.setHj_stu_no(no);
        hjStudent.setHj_stu_name(name);
        hjStudent.setHj_stu_age(age);
        hjStudent.setHj_stu_sex(sex);
        hjStudent.setHj_stu_phone(phone);
        hjStudent.setHj_stu_grp_id(grp_id);
        hjStudent.setHj_stu_department(department);
        hjStudentDao hjStudentDao=new hjStudentDao();
        hjStudentDao.update(hjStudent);
        req.getSession().setAttribute("id", id);
//        req.getRequestDispatcher("/hjStudentListNew").forward(req,resp);
//        req.getRequestDispatcher("/hj_group_stu_list.jsp").forward(req,resp);
        resp.sendRedirect("hjStudentListNew");
    }
}
