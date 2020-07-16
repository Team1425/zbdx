package com.zb.servlet;

import com.zb.dao.YzzuserDao;
import com.zb.pojo.Yzzuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YzzloginServlet")
public class YzzuserloginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Integer id=request.getParameter("id");*/
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Yzzuser yzzuser=new Yzzuser();
        yzzuser.setUsername(username);
        yzzuser.setPassword(password);
        YzzuserDao yzzuserDao=new YzzuserDao();
        Yzzuser yzzuser1 = new Yzzuser();
        yzzuser1=yzzuserDao.denglu(yzzuser);

        if(yzzuser1.getUsername().equals(yzzuser.getUsername())&&yzzuser1.getPassword().equals(yzzuser.getUsername())){
                if(yzzuser1.getType().equals("管理员"))
                {
                    response.sendRedirect(""+request.getContextPath()+"/CTlistServlet");
                }
                if(yzzuser1.getType().equals("学生")){
                    response.sendRedirect(""+request.getContextPath()+"/YzzstudentlistServlet");
                }
            }else{
            response.sendRedirect(""+request.getContextPath()+"/Yzzfaild.jsp");

            }
    }
}
