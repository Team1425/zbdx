package com.zb.servlet.hjservlet;

import com.zb.dao.hjdao.hjStudentDao;
import com.zb.pojo.hjpojo.hjStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hjStudentListNew")
public class hjStudentListNewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("学生列表查询");
        Integer id=(Integer) req.getSession().getAttribute("id");
        hjStudentDao hjStudentDao=new hjStudentDao();
        try {
            List<hjStudent> list= hjStudentDao.findByIdNew(id);
            req.setAttribute("list",list);
            req.getRequestDispatcher("/hj_group_stu_list.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
