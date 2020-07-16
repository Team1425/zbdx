package com.zb.dao;

import com.zb.pojo.Yzzcd;
import com.zb.pojo.Yzzct;
import com.zb.pojo.Yzzuser;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YzzuserDao {
    public Yzzuser denglu(Yzzuser yzzuser){
        Yzzuser yzzuser1 =null;
        Connection conn = null;
        try {
            conn= DBUtils.getConnectionByDatasource();
            String sql="select id,username,password,type from yzzuser where username=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, yzzuser.getUsername());
            ps.setString(2, yzzuser.getPassword());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                yzzuser1 = new Yzzuser();
                yzzuser1.setUsername(rs.getString("username"));
                yzzuser1.setPassword(rs.getString("password"));
                yzzuser1.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
            System.out.println("guanbi");
        }
        /*System.out.println(yzzuser1.getType());*/
         return yzzuser1;
    }
    public void adduser(Yzzuser yzzuser){
        Connection conn=null;
        try {
            conn= DBUtils.getConnectionByDatasource();
            String sql="insert into yzzuser values(null,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,yzzuser.getUsername());
            ps.setString(2,yzzuser.getPassword());
            ps.setString(3,yzzuser.getType());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    public List<Yzzct> findall(){
        Connection conn= DBUtils.getConnectionByDatasource();
        List<Yzzct> list=new ArrayList<>();
        try {
            String sql="select * from yzzct";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                Yzzct yzzct= new Yzzct();
                yzzct.setId(rs.getInt("id"));
                yzzct.setCT_name(rs.getString("CT_name"));
                yzzct.setCT_tel(rs.getString("CT_tel"));
                yzzct.setCT_addr(rs.getString("CT_addr"));
                yzzct.setCT_sale(rs.getString("CT_sale"));
                list.add(yzzct);
                System.out.println(yzzct.getCT_addr());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return list;
    }
    public void ctadd(Yzzct yzzct){
        Connection conn= DBUtils.getConnectionByDatasource();
        String sql="insert into yzzct values(null,?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,yzzct.getCT_name());
            ps.setString(2,yzzct.getCT_tel());
            ps.setString(3,yzzct.getCT_addr());
            ps.setString(4,yzzct.getCT_sale());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    public void ctdelete(Integer id){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql="delete from yzzct where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    public Yzzct ctfindbyid(Integer id){
        Connection conn = DBUtils.getConnectionByDatasource();
        Yzzct yzzct=null;
        String sql="select * from yzzct where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
              yzzct=new Yzzct();
              yzzct.setId(id);
              yzzct.setCT_name(rs.getString("CT_name"));
              yzzct.setCT_addr(rs.getString("CT_addr"));
              yzzct.setCT_tel(rs.getString("CT_tel"));
              yzzct.setCT_sale(rs.getString("CT_sale"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        /*System.out.println("findbyid"+id+yzzct.getId());*/
        return yzzct;
    }
    public void ctupdate(Yzzct yzzct){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql="update yzzct set CT_name=?,CT_tel=?,CT_addr=?,CT_sale=? where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,yzzct.getCT_name());
            ps.setString(2,yzzct.getCT_tel());
            ps.setString(3,yzzct.getCT_addr());
            ps.setString(4,yzzct.getCT_sale());
            ps.setInt(5,yzzct.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    public  List<Yzzcd> findallcd(){
        Connection conn= DBUtils.getConnectionByDatasource();
        List<Yzzcd> list=new ArrayList<>();
        try {
            String sql="select cd.id,cd.ct_id,cd.CD_name,cd.CD_price,cd.CD_type,ct.CT_name from yzzcd cd  join yzzct ct on cd.ct_id=ct.id";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Yzzcd yzzcd=new Yzzcd();
                yzzcd.setId(rs.getInt("id"));
                yzzcd.setCt_id(rs.getInt("ct_id"));
                yzzcd.setCD_name(rs.getString("CD_name"));
                yzzcd.setCD_price(rs.getString("CD_price"));
                yzzcd.setCD_type(rs.getString("CD_type"));
                yzzcd.setCT_name(rs.getString("CT_name"));
                list.add(yzzcd);
                System.out.println(yzzcd.getCD_type()+yzzcd.getCT_name());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭");
            DBUtils.close(conn);
        }

        return list;
    }
    public int id(Yzzcd yzzcd) {
        System.out.println("获取id");
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql="select id from yzzct where CT_name=?";
        int a=0;
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,yzzcd.getCT_name());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                a=rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return a;
    }
    public void cdadd(Yzzcd yzzcd){
        int a=id(yzzcd);
        Connection conn= DBUtils.getConnectionByDatasource();
        String sql="insert into yzzcd values(null,?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,a);
            ps.setString(2,yzzcd.getCD_name());
            ps.setString(3,yzzcd.getCD_price());
            ps.setString(4,yzzcd.getCD_type());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }

    }
    public void cddelete(Integer id){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql="delete from yzzcd where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    public Yzzcd cdfingbyid(Integer id){
        Connection conn = DBUtils.getConnectionByDatasource();
        Yzzcd yzzcd=null;
        String sql="select cd.id,cd.ct_id,cd.CD_name,cd.CD_price,cd.CD_type,ct.CT_name from yzzcd cd  join yzzct ct on cd.ct_id=ct.id where cd.id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                yzzcd=new Yzzcd();
                yzzcd.setId(rs.getInt("id"));
                yzzcd.setCt_id(rs.getInt("ct_id"));
                yzzcd.setCD_name(rs.getString("CD_name"));
                yzzcd.setCD_price(rs.getString("CD_price"));
                yzzcd.setCD_type(rs.getString("CD_type"));
                yzzcd.setCT_name(rs.getString("CT_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return yzzcd;
    }
    public void cdupdate(Yzzcd yzzcd){
        int a=id(yzzcd);
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql="update yzzcd set ct_id=?,CD_name=?,CD_price=?,CD_type=? where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,a);
            ps.setString(2,yzzcd.getCD_name());
            ps.setString(3,yzzcd.getCD_price());
            ps.setString(4,yzzcd.getCD_type());
            ps.setInt(5,yzzcd.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }




    }



