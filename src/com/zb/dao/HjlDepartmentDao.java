package com.zb.dao;

import com.zb.pojo.HjlDepartment;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-14 7:56
 * @description:
 */
public class HjlDepartmentDao {
    public int insert_dep(HjlDepartment department){
        int i=0;
        Connection conn= DBUtils.getConnectionByDatasource();
        try {
            String insert_sql="insert into  department values(null,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(insert_sql);
            ps.setString(1,department.getDepart_name());
            ps.setInt(2,department.getRoom_num());
            ps.setString(3,department.getDepart_dir());
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public int delete_dep(int id){
        int i=0;
        Connection conn=DBUtils.getConnectionByDatasource();
        try {
            String delete_sql="delete from department where depart_id=?";
            PreparedStatement ps=conn.prepareStatement(delete_sql);
            ps.setInt(1,id);
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public ArrayList<HjlDepartment> selectAll_dep(){
        ArrayList<HjlDepartment> list =new ArrayList<>();
        Connection conn=DBUtils.getConnectionByDatasource();
        try {
            String selectAll_sql="select * from department ";
            PreparedStatement ps=conn.prepareStatement(selectAll_sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                HjlDepartment department=new HjlDepartment();
                department.setDepart_id(rs.getInt("depart_id"));
                department.setDepart_name(rs.getString("depart_name"));
                department.setRoom_num(rs.getInt("room_num"));
                department.setDepart_dir(rs.getString("depart_dir"));
                list.add(department);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public HjlDepartment findById_dep(int id){
        HjlDepartment department=new HjlDepartment();
        Connection conn=DBUtils.getConnectionByDatasource();
        try {
            String findById_sql="select * from department where depart_id=?";
            PreparedStatement ps=conn.prepareStatement(findById_sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                department.setDepart_id(rs.getInt("depart_id"));
                department.setDepart_name(rs.getString("depart_name"));
                department.setRoom_num(rs.getInt("room_num"));
                department.setDepart_dir(rs.getString("depart_dir"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }
    public  int update_dep(HjlDepartment department){
        int i=0;
        Connection conn=DBUtils.getConnectionByDatasource();
        try{
            String update_sql="update  department set depart_name=?,room_num=?,depart_dir=? where depart_id=?";
            PreparedStatement ps=conn.prepareStatement(update_sql);
            ps.setString(1,department.getDepart_name());
            ps.setInt(2,department.getRoom_num());
            ps.setString(3,department.getDepart_dir());
            ps.setInt(4,department.getDepart_id());
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
