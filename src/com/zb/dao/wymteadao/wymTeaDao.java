package com.zb.dao.wymteadao;

import com.zb.pojo.wymteacher.wymTeacher;
import com.zb.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class wymTeaDao {

    public List<wymTeacher> findAll(){
        Connection conn = null;
        List<wymTeacher> list = null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from wymteacher";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            wymTeacher wymTeacher = null;
            list = new ArrayList<>();
            while (rs.next()){
                wymTeacher = new wymTeacher();
                wymTeacher.setWymTeaId(rs.getInt("wymTeaId"));
                wymTeacher.setWymTeaJobnum(rs.getString("wymTeaJobnum"));
                wymTeacher.setWymTeaName(rs.getString("wymTeaName"));
                wymTeacher.setWymTeaSex(rs.getString("wymTeaSex"));
                wymTeacher.setWymTeaBirthday(rs.getDate("wymTeaBirthday"));
                wymTeacher.setWymTeaIdcard(rs.getString("wymTeaIdcard"));
                wymTeacher.setWymTeaStartdate(rs.getDate("wymTeaStartdate"));
                wymTeacher.setWymTeaCollege(rs.getString("wymTeaCollege"));
                wymTeacher.setWymTeaProfession(rs.getString("wymTeaProfession"));
                wymTeacher.setWymTeaZhicheng(rs.getString("wymTeaZhicheng"));
                wymTeacher.setWymTeaZhengzhimm(rs.getString("wymTeaZhengzhimm"));
                wymTeacher.setWymTeaPhonenum(rs.getString("wymTeaPhonenum"));
                wymTeacher.setWymTeaEmail(rs.getString("wymTeaEmail"));
                wymTeacher.setWymTeaState(rs.getString("wymTeaState"));
                list.add(wymTeacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return list;
    }

    public void addTeacher (wymTeacher wymTeacher){
        Connection conn = null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql = "insert into wymteacher values (null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,wymTeacher.getWymTeaJobnum());
            ps.setString(2,wymTeacher.getWymTeaName());
            ps.setString(3,wymTeacher.getWymTeaSex());
            ps.setTimestamp(4,new Timestamp(new Date().getTime()));
            ps.setString(5,wymTeacher.getWymTeaIdcard());
            ps.setTimestamp(6,new Timestamp(new Date().getTime()));
            ps.setString(7,wymTeacher.getWymTeaCollege());
            ps.setString(8,wymTeacher.getWymTeaProfession());
            ps.setString(9,wymTeacher.getWymTeaZhicheng());
            ps.setString(10,wymTeacher.getWymTeaZhengzhimm());
            ps.setString(11,wymTeacher.getWymTeaPhonenum());
            ps.setString(12,wymTeacher.getWymTeaEmail());
            ps.setString(13,wymTeacher.getWymTeaState());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public wymTeacher findById(Integer wymTeaId){
        Connection conn = null;
        wymTeacher wymTeacher = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from wymtracher where wymTeaId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wymTeaId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                wymTeacher = new wymTeacher();
                wymTeacher.setWymTeaId(rs.getInt("wymTeaId"));
                wymTeacher.setWymTeaJobnum(rs.getString("wymTeaJobnum"));
                wymTeacher.setWymTeaName(rs.getString("wymTeaName"));
                wymTeacher.setWymTeaSex(rs.getString("wymTeaSex"));
                wymTeacher.setWymTeaBirthday(rs.getDate("wymTeaBirthday"));
                wymTeacher.setWymTeaIdcard(rs.getString("wymTeaIdcard"));
                wymTeacher.setWymTeaStartdate(rs.getDate("wymTeaStartdate"));
                wymTeacher.setWymTeaCollege(rs.getString("wymTeaCollege"));
                wymTeacher.setWymTeaProfession(rs.getString("wymTeaProfession"));
                wymTeacher.setWymTeaZhicheng(rs.getString("wymTeaZhicheng"));
                wymTeacher.setWymTeaZhengzhimm(rs.getString("wymTeaZhengzhimm"));
                wymTeacher.setWymTeaPhonenum(rs.getString("wymTeaPhonenum"));
                wymTeacher.setWymTeaEmail(rs.getString("wymTeaEmail"));
                wymTeacher.setWymTeaState(rs.getString("wymTeaState"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn);
        }
        return wymTeacher;
    }

    public void updateById(wymTeacher wymTeacher){
        Connection conn = null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql = "update wymteacher set wymTeaJobnum=?,wymTeaName=?,wymTeaSex=?,wymTeaBirthday=?,wymTeaIdcard=?,wymTeaStartdate=?,wymTeaCollege=?,wymTeaProfession=?,wymTeaZhicheng=?,wymTeaZhengzhimm=?,wymTeaPhonenum=?,wymTeaEmail=?,wymTeaState=?,wymTeaId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wymTeacher.getWymTeaId());
            ps.setString(1,wymTeacher.getWymTeaJobnum());
            ps.setString(2,wymTeacher.getWymTeaName());
            ps.setString(3,wymTeacher.getWymTeaSex());
            ps.setDate(4,new java.sql.Date(wymTeacher.getWymTeaBirthday().getTime()));
            ps.setString(5,wymTeacher.getWymTeaIdcard());
            ps.setDate(6,new java.sql.Date(wymTeacher.getWymTeaStartdate().getTime()));
            ps.setString(7,wymTeacher.getWymTeaCollege());
            ps.setString(8,wymTeacher.getWymTeaProfession());
            ps.setString(9,wymTeacher.getWymTeaZhicheng());
            ps.setString(10,wymTeacher.getWymTeaZhengzhimm());
            ps.setString(11,wymTeacher.getWymTeaPhonenum());
            ps.setString(12,wymTeacher.getWymTeaEmail());
            ps.setString(13,wymTeacher.getWymTeaState());
            ps.setInt(14,wymTeacher.getWymTeaId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }

    }

    public void deleteById(Integer id){
        Connection conn = null;
        try{
            conn = DBUtils.getConnectionByDatasource();
            String sql = "delete from wymteacher where wymTeaId = ?";
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
