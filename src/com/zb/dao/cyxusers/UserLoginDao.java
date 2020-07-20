package com.zb.dao.cyxusers;

import com.zb.pojo.CyxUsers;
import com.zb.utils.DBUtils;
import com.zb.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDao {
    public CyxUsers selectUsersByUserNameAndUserPwd(String username, String userpwd){
        Connection conn=null;
        CyxUsers users=null;
        try{
            //conn= JdbcUtils.getConnection();
            conn = DBUtils.getConnectionByDatasource();
            String sql="select * from cyxusers where username=? and userpwd=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,userpwd);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                users=new CyxUsers();
                users.setUserid(rs.getInt("userid"));
                users.setUsername(rs.getString("username"));
                users.setUserpwd(rs.getString("userpwd"));
                users.setUsersex(rs.getString("usersex"));
                users.setPhonenumber(rs.getString("phonenumber"));
                users.setQqnumber(rs.getString("qqnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //JdbcUtils.closeConnection(conn);
            DBUtils.close(conn);
        }

    return  users;
    }
}
