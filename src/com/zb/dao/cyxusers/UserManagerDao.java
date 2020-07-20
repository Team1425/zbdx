package com.zb.dao.cyxusers;

import com.zb.pojo.CyxUsers;
import com.zb.utils.DBUtils;
import com.zb.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserManagerDao  {
    public void insertUser(CyxUsers users){
        Connection conn=null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql="insert into cyxusers values(default ,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,users.getUsername());
            ps.setString(2,users.getUserpwd());
            ps.setString(3,users.getUsersex());
            ps.setString(4,users.getPhonenumber());
            ps.setString(5,users.getQqnumber());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public List<CyxUsers> selectUserByProperty(CyxUsers users) {
        Connection conn = null;
        List<CyxUsers> list = new ArrayList<>();
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql = this.createSQL(users);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                CyxUsers user = new CyxUsers();
                user.setUserid(resultSet.getInt("userid"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setQqnumber(resultSet.getString("qqnumber"));
                user.setUserpwd(resultSet.getString("userpwd"));
                user.setUsername(resultSet.getString("username"));
                user.setUsersex(resultSet.getString("usersex"));
                list.add(user);
            }
        }catch(Exception e){
             e.printStackTrace();
        }finally{
            DBUtils.close(conn);
        }
        return list;
    }

    private String createSQL(CyxUsers users){
        StringBuffer stringBuffer = new StringBuffer("select * from cyxusers where 1=1 ");
        if(users.getUsersex() != null && users.getUsersex().length() > 0){
            stringBuffer.append(" and usersex = "+users.getUsersex());
        }if(users.getQqnumber() != null && users.getQqnumber().length() > 0){
            stringBuffer.append(" and qqnumber = "+users.getQqnumber());
        }if(users.getUsername() != null && users.getUsername().length() > 0){
            stringBuffer.append(" and username = "+users.getUsername());
        }if(users.getPhonenumber() != null &&users.getPhonenumber().length() > 0){
            stringBuffer.append(" and phonenumber = "+users.getPhonenumber());
        }
        return stringBuffer.toString();
    }

    public CyxUsers selectUserByUserId(int userid){
        Connection conn=null;
        CyxUsers user=null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            PreparedStatement ps=conn.prepareStatement("select * from cyxusers where userid=?");
            ps.setInt(1,userid);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                user = new CyxUsers();
                user.setUserid(rs.getInt("userid"));
                user.setPhonenumber(rs.getString("phonenumber"));
                user.setQqnumber(rs.getString("qqnumber"));
                user.setUserpwd(rs.getString("userpwd"));
                user.setUsername(rs.getString("username"));
                user.setUsersex(rs.getString("usersex"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return user;
    }

    public void updateUserByUserId(CyxUsers users){
        Connection conn=null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql="update cyxusers set username=?,usersex=?,phonenumber=?,qqnumber=? where userid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,users.getUsername());
            ps.setString(2,users.getUsersex());
            ps.setString(3,users.getPhonenumber());
            ps.setString(4,users.getQqnumber());
            ps.setInt(5,users.getUserid());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public void deleteUserByUserId(int userid){
        Connection conn = null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            PreparedStatement ps = conn.prepareStatement("delete from cyxusers where userid = ?");
            ps.setInt(1,userid);
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
         }finally{
            DBUtils.close(conn);
        }
    }
}
