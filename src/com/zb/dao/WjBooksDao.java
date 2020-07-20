package com.zb.dao;

import com.zb.pojo.WjBooks;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WjBooksDao<conn> {

    public List<WjBooks> findAll() throws SQLException {
        Connection conn= DBUtils.getConnectionByDatasource();
        String sql = "select * from wjbooks";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        WjBooks wjBooks = null;
        List<WjBooks> list = new ArrayList<>();
        while (rs.next()){
            wjBooks = new WjBooks();
            wjBooks.setId(rs.getInt("id"));
            wjBooks.setBooksname(rs.getString("booksname"));
            wjBooks.setAuthor(rs.getString("author"));
            wjBooks.setISBN(rs.getString("ISBN"));
            wjBooks.setPh(rs.getString("ph"));
            wjBooks.setPrice(rs.getString("price"));
            wjBooks.setPd(rs.getString("pd"));
            list.add(wjBooks);
        }
        System.out.println(list);
        DBUtils.close(conn);
        return list;
    }

    public void addBooks(WjBooks wjBooks) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into booksdb.wjbooks values(null,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,wjBooks.getBooksname());
        ps.setString(2,wjBooks.getAuthor());
        ps.setString(3,wjBooks.getISBN());
        ps.setString(4,wjBooks.getPh());
        ps.setString(5,wjBooks.getPrice());
        ps.setString(6,wjBooks.getPd());
        ps.executeUpdate();
        DBUtils.close(conn);
    }

    public WjBooks findById(Integer id){
        WjBooks wjBooks = null;
        Connection conn = null;

        try {
            conn =  DBUtils.getConnectionByDatasource();
            String sql = "select * from wjbooks where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet  rs =  ps.executeQuery();
            while (rs.next()){
                wjBooks= new WjBooks();
                wjBooks.setId(rs.getInt("id"));
                wjBooks.setBooksname(rs.getString("booksname"));
                wjBooks.setAuthor(rs.getString("author"));
                wjBooks.setISBN(rs.getString("ISBN"));
                wjBooks.setPh(rs.getString("ph"));
                wjBooks.setPrice(rs.getString("price"));
                wjBooks.setPd(rs.getString("pd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
       return wjBooks;
    }

    public void updateById(WjBooks wjBooks){
        Connection conn =null;

        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "update wjbooks set booksname=?,author=?,ISBN=?,ph=?,price=?,pd=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,wjBooks.getBooksname());
            ps.setString(2,wjBooks.getAuthor());
            ps.setString(3,wjBooks.getISBN());
            ps.setString(4,wjBooks.getPh());
            ps.setString(5,wjBooks.getPrice());
            ps.setString(6,wjBooks.getPd());
            ps.setInt(7,wjBooks.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public void deleteById(Integer id){
        Connection conn = null;

        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "delete from wjbooks where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }

    }

    public List<WjBooks> showPrice(){
        Connection conn = null;

        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select booksname,price from wjbooks";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            WjBooks wjBooks = null;
            List<WjBooks> list = new ArrayList<>();
            while (rs.next()){
                wjBooks = new WjBooks();
                wjBooks.setBooksname(rs.getString("booksname"));
                wjBooks.setPrice(rs.getString("price"));
                list.add(wjBooks);
            }
            return list;


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return null;
    }
    
}


