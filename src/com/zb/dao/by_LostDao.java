package com.zb.dao;

import com.zb.pojo.by_Lost;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class by_LostDao {


    public List<by_Lost> findAll(){
        Connection conn = null;
        List<by_Lost> list = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from by_lost";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            by_Lost lost = null;
            list = new ArrayList<>();
            while (rs.next()){
                lost = new by_Lost();
                lost.setId(rs.getInt("id"));
                lost.setType(rs.getString("type"));
                lost.setTrait(rs.getString("trait"));
                lost.setTime(rs.getTimestamp("time"));
                lost.setLost_loc(rs.getString("lost_loc"));
                lost.setGet_loc(rs.getString("get_loc"));
                list.add(lost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return list;

    }

    public void addLost(by_Lost lost){
        Connection conn = null;

        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "insert into by_lost values (null,?,?,default,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,lost.getType());
            ps.setString(2,lost.getTrait());
            ps.setString(3,lost.getLost_loc());
            ps.setString(4,lost.getGet_loc());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }


    }

    public by_Lost findById(Integer id){

        Connection conn = null;
        by_Lost lost = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from by_lost where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                lost = new by_Lost();
                lost.setId(rs.getInt("id"));
                lost.setType(rs.getString("type"));
                lost.setTrait(rs.getString("trait"));
                lost.setTime(rs.getTimestamp("time"));
                lost.setLost_loc(rs.getString("lost_loc"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }

        return lost;
    }

    public void updateLost(by_Lost lost){
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "update by_lost set type=?,trait=?,time=?,lost_loc=?,get_loc=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,lost.getType());
            ps.setString(2,lost.getTrait());
            ps.setTimestamp(3,lost.getTime());
            ps.setString(4,lost.getLost_loc());
            ps.setString(5,lost.getGet_loc());
            ps.setInt(6,lost.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public void deleteById(Integer id){
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "delete from by_lost where id=?";
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
