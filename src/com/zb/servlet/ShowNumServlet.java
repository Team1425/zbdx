package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.HjlDepartmentDao;
import com.zb.pojo.HjlDepartment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-14 22:29
 * @description:
 */
@WebServlet("/ShowNum")
public class ShowNumServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HjlDepartmentDao departmentDao=new HjlDepartmentDao();
        ArrayList<HjlDepartment> list=departmentDao.selectAll_dep();
        Gson gson=new Gson();
        String json=gson.toJson(list);
        System.out.println(json);
        resp.getWriter().write(json);
    }
}
