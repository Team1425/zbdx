package com.zb.servlet.hlzServlet;

import com.zb.dao.HlzStudentDao;
import com.zb.pojo.HlzStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/hlzStudentList")
public class HlzStudentListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HlzStudentDao studentDao=new HlzStudentDao();
        ArrayList<HlzStudent> list = new ArrayList<>();
        list = studentDao.selectAll();
        req.setAttribute("lists",list);
        req.getRequestDispatcher("hlzStudentList.jsp").forward(req,resp);
    }
}
