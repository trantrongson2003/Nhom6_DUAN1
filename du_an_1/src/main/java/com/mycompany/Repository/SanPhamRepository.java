/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.SanPham;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.hibernate.Session;

/**
 *
 * @author FPT
 */
public class SanPhamRepository {
    public Integer updateSP(SanPham sp){
         Integer row = null;
         try(Connection con = DBContext.getConnection()) {
             
             String sql = "update SanPham set Ten = ? where Ma = ?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, sp.getTen());
             ps.setString(2, sp.getMa());
             row = ps.executeUpdate();
         } catch (Exception e) {
             return -1;
         }
         return row;
     }
    
    public Integer addSP(SanPham sp){
        try(Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(sp);
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}
