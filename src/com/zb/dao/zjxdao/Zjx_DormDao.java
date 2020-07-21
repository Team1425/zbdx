package com.zb.dao.zjxdao;

import com.zb.pojo.zjxpojo.Zjx_Dorm;
import com.zb.utils.zjxutils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Zjx_DormDao {
    //查找
    public List<Zjx_Dorm> findAll() throws Exception {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from zjx_dorm";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Zjx_Dorm dorm =null;
        List<Zjx_Dorm> list = new ArrayList<>();
        while (rs.next()){
            dorm =new Zjx_Dorm();
            dorm.setId(rs.getInt("id"));
            dorm.setName1(rs.getString("name1"));
            dorm.setStu_id(rs.getInt("stu_id"));
            dorm.setStu_tel(rs.getString("stu_tel"));
            dorm.setName2(rs.getString("name2"));
            dorm.setName3(rs.getString("name3"));
            dorm.setName4(rs.getString("name4"));
            dorm.setAddr(rs.getString("addr"));
            list.add(dorm);
        }
        System.out.println(list);
        return list;
    }
    //添加
    public void addDorm(Zjx_Dorm dorm) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into zjx_dorm values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,dorm.getId());
        ps.setString(2,dorm.getName1());
        ps.setInt(3,dorm.getStu_id());
        ps.setString(4,dorm.getStu_tel());
        ps.setString(5,dorm.getName2());
        ps.setString(6,dorm.getName3());
        ps.setString(7,dorm.getName4());
        ps.setString(8,dorm.getAddr());
        ps.executeUpdate();
        DBUtils.close(conn);
    }
    //查找指定
    public Zjx_Dorm findById(Integer id){
        Zjx_Dorm dorm = null;
        Connection conn =null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from zjx_dorm where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                dorm = new Zjx_Dorm();
                dorm.setId( rs.getInt("id"));
                dorm.setName1(rs.getString("name1"));
                dorm.setStu_id(rs.getInt("stu_id"));
                dorm.setStu_tel(rs.getString("stu_tel"));
                dorm.setName2(rs.getString("name2"));
                dorm.setName3(rs.getString("name3"));
                dorm.setName4(rs.getString("name4"));
                dorm.setAddr(rs.getString("addr"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return dorm;
    }
    //修改
    public void updateById(Zjx_Dorm dorm){
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "update zjx_dorm set name1=?,stu_id=?,stu_tel=?,name2=?,name3=?,name4=?,addr=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dorm.getName1());
            ps.setInt(2,dorm.getStu_id());
            ps.setString(3,dorm.getStu_tel());
            ps.setString(4,dorm.getName2());
            ps.setString(5,dorm.getName3());
            ps.setString(6,dorm.getName4());
            ps.setString(7,dorm.getAddr());
            ps.setInt(8,dorm.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    //删除
    public void deleteById(Integer id){
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "delete from zjx_dorm where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
}
