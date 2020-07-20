package com.zb.dao.hjdao;

import com.zb.pojo.hjpojo.hjStudent;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class hjStudentDao {
    public List<hjStudent> findAll(Integer id) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from hj_stu where hj_stu_grp_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        hjStudent hjstudent =null;
        List<hjStudent> list = new ArrayList<>();
        while (rs.next()){
            hjstudent=new hjStudent();
            hjstudent.setHj_stu_id(rs.getInt("hj_stu_id"));
            hjstudent.setHj_stu_no(rs.getInt("hj_stu_no"));
            hjstudent.setHj_stu_name(rs.getString("hj_stu_name"));
            hjstudent.setHj_stu_age(rs.getInt("hj_stu_age"));
            hjstudent.setHj_stu_sex(rs.getString("hj_stu_sex"));
            hjstudent.setHj_stu_phone(rs.getString("hj_stu_phone"));
            hjstudent.setHj_stu_grp_id(rs.getInt("hj_stu_grp_id"));
            hjstudent.setHj_stu_department(rs.getString("hj_stu_department"));
            list.add(hjstudent);
        }
        System.out.println(list);
        return list;
    }
    public hjStudent findById(Integer id) throws SQLException {
        Connection conn= DBUtils.getConnectionByDatasource();
        hjStudent hjStudent=null;
        String sql="select * from hj_stu where hj_stu_id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            hjStudent=new hjStudent();
            hjStudent.setHj_stu_id(rs.getInt("hj_stu_id"));
            hjStudent.setHj_stu_no(rs.getInt("hj_stu_no"));
            hjStudent.setHj_stu_name (rs.getString("hj_stu_name"));
            hjStudent.setHj_stu_age(rs.getInt("hj_stu_age"));
            hjStudent.setHj_stu_sex(rs.getString("hj_stu_sex"));
            hjStudent.setHj_stu_phone(rs.getString("hj_stu_phone"));
            hjStudent.setHj_stu_grp_id(rs.getInt("hj_stu_grp_id"));
            hjStudent.setHj_stu_department(rs.getString("hj_stu_department"));

        }
        DBUtils.close(conn);
        return hjStudent;
    }

    public void update(hjStudent hjStudent) {
        Connection conn=null;
        try {
            conn= DBUtils.getConnectionByDatasource();
            String sql="update hj_stu set hj_stu_no=?,hj_stu_name=?," +
                    "hj_stu_age=?,hj_stu_sex=?," +
                    "hj_stu_phone=?,hj_stu_grp_id=?," +
                    "hj_stu_department=? where hj_stu_id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,hjStudent.getHj_stu_no());
            ps.setString(2,hjStudent.getHj_stu_name());
            ps.setInt(3,hjStudent.getHj_stu_age());
            ps.setString(4,hjStudent.getHj_stu_sex());
            ps.setString(5,hjStudent.getHj_stu_phone());
            ps.setInt(6,hjStudent.getHj_stu_grp_id());
            ps.setString(7,hjStudent.getHj_stu_department());
            ps.setInt(8,hjStudent.getHj_stu_id());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            DBUtils.close(conn);
        }
    }

    public List<hjStudent> findByIdNew(Integer id) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from hj_stu where hj_stu_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        hjStudent hjstudent =null;
        List<hjStudent> list = new ArrayList<>();
        while (rs.next()){
            hjstudent=new hjStudent();
            hjstudent.setHj_stu_id(rs.getInt("hj_stu_id"));
            hjstudent.setHj_stu_no(rs.getInt("hj_stu_no"));
            hjstudent.setHj_stu_name(rs.getString("hj_stu_name"));
            hjstudent.setHj_stu_age(rs.getInt("hj_stu_age"));
            hjstudent.setHj_stu_sex(rs.getString("hj_stu_sex"));
            hjstudent.setHj_stu_phone(rs.getString("hj_stu_phone"));
            hjstudent.setHj_stu_grp_id(rs.getInt("hj_stu_grp_id"));
            hjstudent.setHj_stu_department(rs.getString("hj_stu_department"));
            list.add(hjstudent);
        }
        System.out.println(list);
        return list;
    }

    public void addStudent(hjStudent hjstudent) throws SQLException {
        Connection conn= DBUtils.getConnectionByDatasource();
        String sql="insert into hj_stu values(null,?,?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,hjstudent.getHj_stu_no());
        ps.setString(2,hjstudent.getHj_stu_name());
        ps.setInt(3,hjstudent.getHj_stu_age());
        ps.setString(4,hjstudent.getHj_stu_sex());
        ps.setString(5,hjstudent.getHj_stu_phone());
        ps.setInt(6,hjstudent.getHj_stu_grp_id());
        ps.setString(7,hjstudent.getHj_stu_department());
        ps.executeUpdate();
        DBUtils.close(conn);
    }

    public List<hjStudent> findAllNew() throws SQLException {
        Connection conn= DBUtils.getConnectionByDatasource();
        String sql = "select * from hj_stu";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        hjStudent hjstudent =null;
        List<hjStudent> list = new ArrayList<>();
        while (rs.next()){
            hjstudent=new hjStudent();
            hjstudent.setHj_stu_id(rs.getInt("hj_stu_id"));
            hjstudent.setHj_stu_no(rs.getInt("hj_stu_no"));
            hjstudent.setHj_stu_name(rs.getString("hj_stu_name"));
            hjstudent.setHj_stu_age(rs.getInt("hj_stu_age"));
            hjstudent.setHj_stu_sex(rs.getString("hj_stu_sex"));
            hjstudent.setHj_stu_phone(rs.getString("hj_stu_phone"));
            hjstudent.setHj_stu_grp_id(rs.getInt("hj_stu_grp_id"));
            hjstudent.setHj_stu_department(rs.getString("hj_stu_department"));
            list.add(hjstudent);
        }
        System.out.println(list);
        return list;
    }

    public void deleteStudent(Integer id) throws SQLException {
        Connection conn= DBUtils.getConnectionByDatasource();
        String sql="delete from hj_stu where hj_stu_id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        DBUtils.close(conn);

    }
}
