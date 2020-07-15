package com.zb.dao;

import com.zb.pojo.HjlDepartment;
import com.zb.pojo.HjlDoctor;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-13 22:20
 * @description:
 */
public class HjlDoctorDao {
    public  int insert_doc(HjlDoctor doctor){
        int i=0;
        Connection conn= DBUtils.getConnectionByDatasource();
        try {
            String insert_sql="insert into doctor values(null,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(insert_sql);
            ps.setInt(1,doctor.getDepart_id());
            ps.setString(2,doctor.getDoctor_name());
            ps.setString(3,doctor.getDoctor_tel());
            ps.setString(4,doctor.getDoctor_addr());
            ps.setString(5,doctor.getDoctor_sex());
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public int delete_doc(int id){
        int i=0;
        Connection conn=DBUtils.getConnectionByDatasource();
        try {
            String delete_sql="delete from doctor where doctor_id=?";
            PreparedStatement ps=conn.prepareStatement(delete_sql);
            ps.setInt(1,id);
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public ArrayList<HjlDoctor> selectAll_doc(){
        ArrayList<HjlDoctor> list=new ArrayList<>();
        Connection conn=DBUtils.getConnectionByDatasource();
        try {
            String selectAll_doc="select * from doctor";
            PreparedStatement ps=conn.prepareStatement(selectAll_doc);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                HjlDoctor  doctor =new HjlDoctor();
                doctor.setDoctor_id(rs.getInt("doctor_id"));
                doctor.setDepart_id(rs.getInt("depart_id"));
                doctor.setDoctor_name(rs.getString("doctor_name"));
                doctor.setDoctor_tel(rs.getString("doctor_tel"));
                doctor.setDoctor_addr(rs.getString("doctor_addr"));
                doctor.setDoctor_sex(rs.getString("doctor_sex"));
                list.add(doctor);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public HjlDoctor findById_doc(int id){
        HjlDoctor  doctor =new HjlDoctor();
        Connection conn=DBUtils.getConnectionByDatasource();
        try {
            String selectAll_doc="select * from doctor where doctor_id=?";
            PreparedStatement ps=conn.prepareStatement(selectAll_doc);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                doctor.setDoctor_id(rs.getInt("doctor_id"));
                doctor.setDepart_id(rs.getInt("depart_id"));
                doctor.setDoctor_name(rs.getString("doctor_name"));
                doctor.setDoctor_tel(rs.getString("doctor_tel"));
                doctor.setDoctor_addr(rs.getString("doctor_addr"));
                doctor.setDoctor_sex(rs.getString("doctor_sex"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }
    public int update_doc( HjlDoctor doctor){
        int i=0;
        Connection conn=DBUtils.getConnectionByDatasource();
        try {
            String update_sql="update doctor set depart_id=?,doctor_name=?,doctor_tel=?,doctor_addr=?,doctor_sex=? where doctor_id=?";
            PreparedStatement ps=conn.prepareStatement(update_sql);
            ps.setInt(1,doctor.getDepart_id());
            ps.setString(2,doctor.getDoctor_name());
            ps.setString(3,doctor.getDoctor_tel());
            ps.setString(4,doctor.getDoctor_addr());
            ps.setString(5,doctor.getDoctor_sex());
            ps.setInt(6,doctor.getDoctor_id());
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
