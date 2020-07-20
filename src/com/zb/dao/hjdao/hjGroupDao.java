package com.zb.dao.hjdao;

import com.zb.pojo.hjpojo.hjGroup;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class hjGroupDao {
    public List<hjGroup> findAll() throws Exception {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from hj_grp";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        hjGroup hjgroup =null;
        List<hjGroup> list = new ArrayList<>();
        while (rs.next()){
            hjgroup=new hjGroup();
            hjgroup.setHj_grp_id(rs.getInt("hj_grp_id"));
            hjgroup.setHj_grp_name(rs.getString("hj_grp_name"));
            hjgroup.setHj_grp_total(rs.getInt("hj_grp_total"));
            hjgroup.setHj_grp_money(rs.getString("hj_grp_money"));
            hjgroup.setHj_grp_type(rs.getString("hj_grp_type"));
            hjgroup.setHj_grp_activity(rs.getString("hj_grp_activity"));
            list.add(hjgroup);
        }
        System.out.println(list);
        return list;
    }
    public static void addGroup(hjGroup hjgroup) throws SQLException {
        Connection conn= DBUtils.getConnectionByDatasource();
        String sql="insert into hj_grp values(null,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,hjgroup.getHj_grp_name());
        ps.setInt(2,hjgroup.getHj_grp_total());
        ps.setString(3,hjgroup.getHj_grp_type());
        ps.setString(4,hjgroup.getHj_grp_money());
        ps.setString(5,hjgroup.getHj_grp_activity());
        ps.executeUpdate();
        DBUtils.close(conn);
    }
    public void deleteGroup(Integer id) throws SQLException {
       Connection conn=null;
       try {
           conn= DBUtils.getConnectionByDatasource();
           String sql="delete from hj_grp where hj_grp_id=?";
           PreparedStatement ps=conn.prepareStatement(sql);
           ps.setInt(1,id);
           ps.executeUpdate();
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           DBUtils.close(conn);
       }
    }

    public hjGroup findById(Integer id) {
        hjGroup hjgroup=null;
        Connection conn=null;
        try {
            conn= DBUtils.getConnectionByDatasource();
            String sql="select * from hj_grp where hj_grp_id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                hjgroup=new hjGroup();
                hjgroup.setHj_grp_id(rs.getInt("hj_grp_id"));
                hjgroup.setHj_grp_name(rs.getString("hj_grp_name"));
                hjgroup.setHj_grp_total(rs.getInt("hj_grp_total"));
                hjgroup.setHj_grp_money(rs.getString("hj_grp_money"));
                hjgroup.setHj_grp_type(rs.getString("hj_grp_type"));
                hjgroup.setHj_grp_activity(rs.getString("hj_grp_activity"));
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return hjgroup;
    }

    public void UpdateGroup(hjGroup hjgroup) {
        Connection conn=null;
        try {
            conn= DBUtils.getConnectionByDatasource();
            String sql="update hj_grp set hj_grp_name=?,hj_grp_total=?,hj_grp_type=?,hj_grp_money=?,hj_grp_activity=? where hj_grp_id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,hjgroup.getHj_grp_name());
            ps.setInt(2,hjgroup.getHj_grp_total());
            ps.setString(3,hjgroup.getHj_grp_type());
            ps.setString(4,hjgroup.getHj_grp_money());
            ps.setString(5,hjgroup.getHj_grp_activity());
            ps.setInt(6,hjgroup.getHj_grp_id());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
}
