package com.zb.servlet.cyxservlet;

import com.zb.pojo.CyxUsers;
import com.zb.service.cyxusers.UserLoginService;
import com.zb.service.cyxusers.UserManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/userManager.do")
public class UserManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag=req.getParameter("flag");
        if("addUser".equals(flag)){
            this.addUser(req,resp);
        }else if ("findUser".equals(flag)){
            this.findUser(req, resp);
        }else if("preUpdate".equals(flag)){
            this.preUpdate(req, resp);
        }else if("modifyUser".equals(flag)){
            this.modifyUser(req,resp);
        }else{
            this.dropUser(req,resp);
        }



    }
    private  void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        CyxUsers users=this.createUsers(req);
        try{
            UserManagerService userManagerService=new UserManagerService();
            userManagerService.addUser(users);
            resp.sendRedirect("cyxok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("cyxerror.jsp");
        }

    }

    private CyxUsers createUsers(HttpServletRequest req){
        CyxUsers users=new CyxUsers();
        users.setUsername(req.getParameter("username"));
        users.setUserpwd(req.getParameter("userpwd"));
        users.setUsersex(req.getParameter("usersex"));
        users.setPhonenumber(req.getParameter("phonenumber"));
        users.setQqnumber(req.getParameter("qqnumber"));
        return users;
    }

    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        CyxUsers user=this .createUsers(req);
        try {
            UserManagerService userManagerService=new UserManagerService();
            List<CyxUsers> list= userManagerService.findUser(user);
            req.setAttribute("list",list);
            System.out.println(list.size());
            req.getRequestDispatcher("usermanager/viewUser.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("cyxerror.jsp");
        }
    }

    private void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userid=req.getParameter("userid");
        try{
            UserManagerService userManagerService=new UserManagerService();
            CyxUsers user= userManagerService.findUserByUserId(Integer.parseInt(userid));
            req.setAttribute("user",user);
            req.getRequestDispatcher("usermanager/updateUser.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("cyxerror.jsp");
        }
    }

    private void modifyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userid = req.getParameter("userid");
        CyxUsers users = this.createUsers(req);
        users.setUserid(Integer.parseInt(userid));
        try{
            UserManagerService userManagerService = new UserManagerService();
            userManagerService.modifyUser(users);
            resp.sendRedirect("cyxok.jsp");
        }catch(Exception e){
            e.printStackTrace();
            resp.sendRedirect("cyxerror.jsp");
        }
    }

    private void dropUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userid = req.getParameter("userid");
        try{
            UserManagerService userManagerService = new UserManagerService();
            userManagerService.dropUser(Integer.parseInt(userid));
            resp.sendRedirect("cyxok.jsp");
        }catch(Exception e){
            e.printStackTrace();
            resp.sendRedirect("cyxerror.jsp");
        }
    }
}
