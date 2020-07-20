package com.zb.servlet.wymteaservlet;

import com.google.gson.Gson;
import com.zb.dao.wymteadao.wymTeaDao;
import com.zb.pojo.wymteacher.wymTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showsale")
public class wymTeaSalaryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        wymTeaDao wymTeaDao = new wymTeaDao();
        List<wymTeacher> list = wymTeaDao.showSale();
        System.out.println(list);

        Gson gson = new Gson();
        String josn = gson.toJson(list);
        System.out.println(josn);
        resp.getWriter().write(josn);
    }
}
