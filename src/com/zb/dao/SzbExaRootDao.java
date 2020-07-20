package com.zb.dao;

import com.zb.pojo.Szb_ExaRoot;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SzbExaRootDao {
    public Szb_ExaRoot login(Szb_ExaRoot szb_exaRoot){
        Szb_ExaRoot szb_exaRoot1 = null;
        Connection conn = null;
        try {
            conn= DBUtils.getConnectionByDatasource();
            String sql="select SZBexaAdRoot,SZBpwd from exaadroot where SZBexaAdRoot=? and SZBpwd=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, szb_exaRoot.getExaAdRoot());
            ps.setString(2, szb_exaRoot.getPwd());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){

                szb_exaRoot1 = new Szb_ExaRoot();
                szb_exaRoot1.setExaAdRoot(rs.getString("SZBexaAdRoot"));
                szb_exaRoot1.setPwd(rs.getString("SZBpwd"));
                szb_exaRoot1.setId(rs.getString("SZBexaID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
            System.out.println("关闭");
        }
        return szb_exaRoot1;
    }

    public void addRoot(Szb_ExaRoot szb_exaRoot){
        Connection conn=null;
        try {
            conn= DBUtils.getConnectionByDatasource();
            System.out.println(conn);
            String sql="insert into exaadroot values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,szb_exaRoot.getExaAdRoot());
            ps.setString(2,szb_exaRoot.getPwd());
            ps.setString(3,null);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public List<Szb_ExaRoot> findAllRoot(){
        Connection conn= DBUtils.getConnectionByDatasource();
        List<Szb_ExaRoot> list=new ArrayList<>();
        try {
            String sql="select * from exaadroot";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                Szb_ExaRoot root= new Szb_ExaRoot();
                root.setExaAdRoot(rs.getString("SZBexaAdRoot"));
                root.setPwd(rs.getString("SZBpwd"));
                root.setId(rs.getString("SZBexaID"));
                list.add(root);
                System.out.println(root.getExaAdRoot());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return list;
    }

    public void rootDelete(String exaRoot){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql="delete from exaadroot where SZBexaAdRoot=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,exaRoot);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public Szb_ExaRoot rootFindByExaRoot(String exaRoot){
        Connection conn = DBUtils.getConnectionByDatasource();
        Szb_ExaRoot szb_exaRoot = null;
        String sql="select * from exaadroot where SZBexaAdRoot=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,exaRoot);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                szb_exaRoot = new Szb_ExaRoot();
                szb_exaRoot.setExaAdRoot(exaRoot);
                szb_exaRoot.setPwd(rs.getString("SZBpwd"));
                szb_exaRoot.setId(rs.getString("SZBexaID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return szb_exaRoot;
    }

    public void rootUpdate(Szb_ExaRoot szb_exaRoot){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql="update exaadroot set SZBexaAdRoot=?,SZBpwd=?,SZBexaID=? where SZBexaAdRoot=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,szb_exaRoot.getExaAdRoot());
            ps.setString(2,szb_exaRoot.getPwd());
            ps.setString(3,szb_exaRoot.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

}
