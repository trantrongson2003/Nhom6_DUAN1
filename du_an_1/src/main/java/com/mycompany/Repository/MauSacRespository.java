/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.MauSac;
import com.mycompany.Util.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kunrl
 */
public class MauSacRespository {
     public List<MauSac> getALLMS(){
        List<MauSac> lst = new ArrayList<>();
        try (Connection con = DBContext.getConnection()){
            String sql = "select * from mausac";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                lst.add(new MauSac(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return lst;
    }
  
     public void insert(MauSac b){
        try {
            Connection conn =DBContext.getConnection();
            String sql="INSERT INTO MauSac(Ma,Ten)VALUES(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, b.getMa());
            ps.setString(2, b.getTen());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void update(String Id,MauSac b){
        try {
            Connection conn =DBContext.getConnection();
            String sql="UPDATE MauSac SET Ma=?,Ten=? WHERE Id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, b.getMa());
            ps.setString(2, b.getTen());
            ps.setString(3, b.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(String Id){
        try {
            Connection conn =DBContext.getConnection();
            String sql="DELETE SanPham WHERE Id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,Id );
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
