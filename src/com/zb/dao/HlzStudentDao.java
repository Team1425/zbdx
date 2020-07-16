package com.zb.dao;

import com.zb.pojo.HlzStudent;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HlzStudentDao {
    public int insert(HlzStudent student) {
        int i = 0;
        Connection conn = DBUtils.getConnectionByDatasource();
        try {
            String sql = "insert into hlzstudent values(null,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getSex());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getNumber());
            i = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int delete(int id) {
        int i = 0;
        Connection conn = DBUtils.getConnectionByDatasource();
        try {
            String sql = "delete from hlzstudent where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            i = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public ArrayList<HlzStudent> selectAll() {
        ArrayList<HlzStudent> list = new ArrayList<>();
        Connection conn = DBUtils.getConnectionByDatasource();
        try {
            String sql = "select * from hlzstudent";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HlzStudent student = new HlzStudent();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setAge(rs.getInt("age"));
                student.setNumber(rs.getString("number"));

                list.add(student);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public HlzStudent findById(int id) {
        HlzStudent student = new HlzStudent();
        Connection conn = DBUtils.getConnectionByDatasource();
        try {
            String sql = "select * from hlzstudent where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setAge(rs.getInt("age"));
                student.setNumber(rs.getString("number"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public int update(HlzStudent student) {
        int i = 0;
        Connection conn = DBUtils.getConnectionByDatasource();
        try {
            String sql = "update hlzstudent set name = ?, sex = ?, age = ?, number = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getSex());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getNumber());
            ps.setInt(5, student.getId());
            i = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
