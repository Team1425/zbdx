package com.zb.dao;

import com.zb.pojo.Szb_Exa;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SzbExaDao {
    public List<Szb_Exa> findAll(){
        Connection conn= DBUtils.getConnectionByDatasource();
        List<Szb_Exa> list=new ArrayList<>();
        try {
            String sql="select * from exatable";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                Szb_Exa szb_exa = new Szb_Exa();
                szb_exa.setExa_id(rs.getString("SZBexaID"));
                szb_exa.setExa_name(rs.getString("SZBexaNAME"));
                szb_exa.setExa_room(rs.getString("SZBexaROOM"));
                szb_exa.setExa_time(rs.getString("SZBexaTIME"));
                szb_exa.setExa_teacher(rs.getString("SZBexaTEACHER"));
                szb_exa.setExa_teacherId(rs.getString("SZBexaTEACHERID"));
                list.add(szb_exa);
                System.out.println(szb_exa.getExa_id());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return list;
    }

    public void addExa(Szb_Exa exa) throws Exception {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into exatable values (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, exa.getExa_id());
        ps.setString(2, exa.getExa_name());
        ps.setString(3, exa.getExa_room());
        ps.setString(4, exa.getExa_time());
        ps.setString(5, exa.getExa_teacher());
        ps.setString(6, exa.getExa_teacherId());
        ps.executeUpdate();
        DBUtils.close(conn);

    }

    public Szb_Exa updateById (Szb_Exa exa) {

        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "update exatable set SZBexaNAME = ?, " +
                    "SZBexaROOM = ?, " +
                    "SZBexaTIME = ?, " +
                    "SZBexaTEACHER = ?, " +
                    "SZBexaTEACHERID = ? where SZBexaID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,exa.getExa_name());
            ps.setString(2,exa.getExa_room());
            ps.setString(3,exa.getExa_time());
            ps.setString(4,exa.getExa_teacher());
            ps.setString(5,exa.getExa_teacherId());
            ps.setString(6,exa.getExa_id());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn);
        }

        return null;
    }

    public void deleteById(String id) {
        Connection conn = null;

        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "delete from exatable where SZBexaId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn);
        }
    }

    public Szb_Exa findById(String id) {
        Szb_Exa exa = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from exatable where SZBexaID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                exa = new Szb_Exa();
                exa.setExa_id(rs.getString("SZBexaID"));
                exa.setExa_name(rs.getString("SZBexaNAME"));
                exa.setExa_room(rs.getString("SZBexaROOM"));
                exa.setExa_time(rs.getString("SZBexaTIME"));
                exa.setExa_teacher(rs.getString("SZBexaTEACHER"));
                exa.setExa_teacherId(rs.getString("SZBexaTEACHERID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn);
        }

        return exa;
    }
}
