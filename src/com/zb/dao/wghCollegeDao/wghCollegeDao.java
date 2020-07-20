package com.zb.dao.wghCollegeDao;



import com.zb.pojo.wghpojo.wghCollege;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class wghCollegeDao {
    public List<wghCollege> findAll() throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_wghcollege";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        wghCollege wghcollege =null;
        List<wghCollege> list = new ArrayList<>();
        while (rs.next()){
            wghcollege =new wghCollege();
            wghcollege.setWgh_id(rs.getInt("id"));
            wghcollege.setWgh_name(rs.getString("name"));
            wghcollege.setWgh_leader(rs.getString("leader"));
            wghcollege.setWgh_teacherNum(rs.getInt("teacher_num"));
            wghcollege.setWgh_studentNum(rs.getInt("student_num"));
            wghcollege.setWgh_promotionRate(rs.getString("promotion_rate"));
            list.add(wghcollege);
        }
        System.out.println(list);
        DBUtils.close(conn);

        return list;
    }

    public void addCollege(wghCollege wghcollege) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into tb_wghcollege values (null,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,wghcollege.getWgh_name());
        ps.setString(2,wghcollege.getWgh_leader());
        ps.setInt(3,wghcollege.getWgh_teacherNum());
        ps.setInt(4,wghcollege.getWgh_studentNum());
        ps.setString(5,wghcollege.getWgh_promotionRate());
        ps.executeUpdate();
        DBUtils.close(conn);
    }

    public wghCollege findById(Integer id){
        wghCollege wghcollege = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from tb_wghcollege where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                wghcollege = new wghCollege();
                wghcollege.setWgh_id(rs.getInt("id"));
                wghcollege.setWgh_name(rs.getString("name"));
                wghcollege.setWgh_leader(rs.getString("leader"));
                wghcollege.setWgh_teacherNum(rs.getInt("teacher_num"));
                wghcollege.setWgh_studentNum(rs.getInt("student_num"));
                wghcollege.setWgh_promotionRate(rs.getString("promotion_rate"));
              }
            } catch(SQLException e){
                e.printStackTrace();
            }finally{
                DBUtils.close(conn);
            }

        return wghcollege;
    }

    public void updateById(wghCollege wghcollege){
        Connection conn = null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql = "update tb_wghcollege set name=?,leader=?,teacher_num=?,student_num=?,promotion_rate=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,wghcollege.getWgh_name());
            ps.setString(2,wghcollege.getWgh_leader());
            ps.setInt(3,wghcollege.getWgh_teacherNum());
            ps.setInt(4,wghcollege.getWgh_studentNum());
            ps.setString(5,wghcollege.getWgh_promotionRate());
            ps.setInt(6,wghcollege.getWgh_id());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public void deleteById(Integer id) {
        Connection conn = null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql = "delete from tb_wghcollege where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public List<wghCollege> showRate(){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select name,promotion_rate from tb_wghcollege";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            wghCollege wghcollege = null;
            List<wghCollege> list = new ArrayList<>();
            while (rs.next()){
                wghcollege = new wghCollege();
                wghcollege.setWgh_name(rs.getString("name"));
                wghcollege.setWgh_promotionRate(rs.getString("promotion_rate"));
                list.add(wghcollege);
            }
            System.out.println(list);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return null;
    }


}
