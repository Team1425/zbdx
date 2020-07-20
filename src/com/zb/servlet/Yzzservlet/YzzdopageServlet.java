package com.zb.servlet.Yzzservlet;

import com.google.gson.Gson;
import com.zb.dao.Yzzuserdao.YzzuserDao;
import com.zb.pojo.Yzzpojo.YzzJsonResult;
import com.zb.pojo.Yzzpojo.Yzzuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dopage")
public class YzzdopageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前页
        Integer page=Integer.parseInt(request.getParameter("page"));
        //每页显示几条
        Integer limit=Integer.parseInt(request.getParameter("limit"));
        YzzuserDao yzzuserDao=new YzzuserDao();
        List<Yzzuser> list=yzzuserDao.dopage(page,limit);
        Integer count=yzzuserDao.pagecount();
        YzzJsonResult jr=new YzzJsonResult(0,"成功",count,list);
        Gson gson=new Gson();
        String json=gson.toJson(jr);
        System.out.println(json);
        response.getWriter().write(json);
    }

    }

