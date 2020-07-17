package com.zb.servlet.hjservlet;
import com.zb.dao.hjdao.hjGroupDao;
import com.zb.pojo.hjpojo.hjGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/hjGroupAdd")
public class hjGroupAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hj_grp_name = req.getParameter("hj_grp_name");
        Integer hj_grp_total = Integer.parseInt(req.getParameter("hj_grp_total"));
        String hj_grp_type= req.getParameter("hj_grp_type");
        String hj_grp_money = req.getParameter("hj_grp_money");
        String hj_grp_activity = req.getParameter("hj_grp_activity");
        hjGroup hjgroup = new hjGroup();
        hjgroup.setHj_grp_name(hj_grp_name);
        hjgroup.setHj_grp_total(hj_grp_total);
        hjgroup.setHj_grp_money(hj_grp_money);
        hjgroup.setHj_grp_type(hj_grp_type);
        hjgroup.setHj_grp_activity(hj_grp_activity);
        hjGroupDao hjGroupDao=new hjGroupDao();
        try {
            hjGroupDao.addGroup(hjgroup);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("hjGroupList");
    }
}
