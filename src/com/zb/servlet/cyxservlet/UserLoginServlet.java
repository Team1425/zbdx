package com.zb.servlet.cyxservlet;
/*我日*/
import com.zb.pojo.CyxUsers;
import com.zb.service.cyxusers.UserLoginService;
import com.zb.utils.CyxUserNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login.do")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        String code = req.getParameter("code");
        try{
            HttpSession session = req.getSession();
            String codeTemp = (String)session.getAttribute("code");
            if(codeTemp.equals(code)){
                UserLoginService userLoginService = new UserLoginService();
                CyxUsers users = userLoginService.userLogin(username,userpwd);
                //建立客户端与服务端的会话状态
               /* session.setAttribute("users",users);
                ServletContext servletContext = this.getServletContext();
                HttpSession temp = (HttpSession) servletContext.getAttribute(users.getUserid()+"");
                if(temp != null){
                    servletContext.removeAttribute(users.getUserid()+"");
                    temp.invalidate();
                }
                servletContext.setAttribute(users.getUserid()+"",session);*/
                //使用重定向方式跳转首页
                resp.sendRedirect("cyxmain.jsp");
            }
            else{
                req.setAttribute("msg","验证码有误，请重新输入");
                req.getRequestDispatcher("cyxlogin.html").forward(req,resp);
            }
        }catch (CyxUserNotFoundException e){
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("cyxlogin.html").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("cyxerror.jsp");
        }
    }
}
