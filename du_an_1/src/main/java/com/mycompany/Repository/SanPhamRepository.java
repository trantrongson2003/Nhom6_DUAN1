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
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kunrl
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
    public List<SanPham> getAllChucVu() {
        Transaction trans = null;
        List<SanPham> listcv = new ArrayList();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            trans = sess.beginTransaction();
            listcv = sess.createQuery("Select sp FROM SanPham sp order by sp.Ma asc").list();

            trans.commit();
        }
        return listcv;
    }
    
    public void delete(String Id) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE from SanPham WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
