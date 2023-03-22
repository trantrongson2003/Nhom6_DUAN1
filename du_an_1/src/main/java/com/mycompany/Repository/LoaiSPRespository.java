/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.*;
import com.mycompany.Util.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kunrl
 */
public class LoaiSPRespository {
     public List<LoaiSP> getALLLoai(){
        List<LoaiSP> lst = new ArrayList<>();
        try (Connection con = DBContext.getConnection()){
            String sql = "select * from LoaiSP";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                lst.add(new LoaiSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return lst;
    }
       public void insert(LoaiSP b){
       try {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date((date.getTime()));
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO LoaiSP(Ma,Ten,NgayTao,NgaySua)VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getMa());
            ps.setString(2, b.getTen());
            ps.setDate(3, sqlDate);
            ps.setDate(4, sqlDate);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(String Id,LoaiSP b){
       try {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date((date.getTime()));
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE LoaiSP SET Ma=?,Ten=?, NgaySua =?  WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getMa());
            ps.setString(2, b.getTen());
            ps.setDate(3, sqlDate);
            ps.setString(4, b.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(String Ma){
        try {
            Connection conn =DBContext.getConnection();
            String sql="DELETE LoaiSP WHERE Ma=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,Ma );
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
