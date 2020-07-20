package com.zb.servlet.wymteaservlet;

import com.zb.dao.wymteadao.wymTeaDao;
import com.zb.pojo.wymteacher.wymTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/wymTeaUpdate")
public class wymTeaUpdateServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String wymTeaJobnum= req.getParameter("wymTeaJobnum");
        String wymTeaName= req.getParameter("wymTeaName");
        String wymTeaSex= req.getParameter("wymTeaSex");
        String wymTeaIdcard= req.getParameter("wymTeaIdcard");
        String wymTeaCollege= req.getParameter("wymTeaCollege");
        String wymTeaProfession= req.getParameter("wymTeaProfession");
        String wymTeaZhicheng= req.getParameter("wymTeaZhicheng");
        String wymTeaZhengzhimm= req.getParameter("wymTeaZhengzhimm");
        String wymTeaPhonenum= req.getParameter("wymTeaPhonenum");
        String wymTeaEmail= req.getParameter("wymTeaEmail");
        String wymTeaState= req.getParameter("wymTeaState");

        Date wymTeaBirthday=null;
        Date wymTeaStartdate=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datetime =null;
        datetime = req.getParameter("wymTeaBirthday");
        try {
            wymTeaBirthday = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        datetime = req.getParameter("wymTeaStartdate");
        try {
            wymTeaStartdate = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        wymTeacher wymTeacher= new wymTeacher();
        wymTeacher.setWymTeaId(id);
        wymTeacher.setWymTeaJobnum(wymTeaJobnum);
        wymTeacher.setWymTeaName(wymTeaName);
        wymTeacher.setWymTeaSex(wymTeaSex);
        wymTeacher.setWymTeaBirthday(wymTeaBirthday);
        wymTeacher.setWymTeaIdcard(wymTeaIdcard);
        wymTeacher.setWymTeaStartdate(wymTeaStartdate);
        wymTeacher.setWymTeaCollege(wymTeaCollege);
        wymTeacher.setWymTeaProfession(wymTeaProfession);
        wymTeacher.setWymTeaZhicheng(wymTeaZhicheng);
        wymTeacher.setWymTeaZhengzhimm(wymTeaZhengzhimm);
        wymTeacher.setWymTeaPhonenum(wymTeaPhonenum);
        wymTeacher.setWymTeaEmail(wymTeaEmail);
        wymTeacher.setWymTeaState(wymTeaState);
        wymTeacher.setWymTeaState("1");

        wymTeaDao wymTeaDao= new wymTeaDao();
        wymTeaDao.updateById(wymTeacher);
        resp.sendRedirect(""+req.getContextPath()+"/wymTeaList");
    }
}
