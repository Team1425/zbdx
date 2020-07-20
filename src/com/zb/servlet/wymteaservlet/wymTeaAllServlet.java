package com.zb.servlet.wymteaservlet;

import com.google.gson.Gson;
import com.zb.dao.wymteadao.wymTeaDao;
import com.zb.pojo.wymteacher.wymTeaJsonResult;
import com.zb.pojo.wymteacher.wymTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/wymTeadopage")
public class wymTeaAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageOn = Integer.parseInt(req.getParameter("page"));
        Integer pageSize = Integer.parseInt(req.getParameter("limit"));
        wymTeaDao wymTeaDao = new wymTeaDao();
        List<wymTeacher> list =  wymTeaDao.dopage(pageOn,pageSize);
        Integer count = wymTeaDao.pagecount();
        wymTeaJsonResult jr = new wymTeaJsonResult(0,"成功",count,list);
        Gson gson = new Gson();
        String json = gson.toJson(jr);
        System.out.println(json);
        resp.getWriter().write(json);
    }
}
