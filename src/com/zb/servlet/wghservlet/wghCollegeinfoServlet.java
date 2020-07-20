package com.zb.servlet.wghservlet;

import com.zb.dao.wghCollegeDao.wghCollegeDao;
import com.zb.pojo.wghpojo.wghCollege;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wghcollegeInfo")
public class wghCollegeinfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Integer id = Integer.parseInt(request.getParameter("id"));

        wghCollegeDao wghCollegeDao = new wghCollegeDao();
        wghCollege wghcollege = wghCollegeDao.findById(id);
        System.out.println(wghcollege);
        request.setAttribute("wghcollege",wghcollege);
        request.getRequestDispatcher("/wghCollege/wghcollege_update.jsp").forward(request,response);

    }
}
