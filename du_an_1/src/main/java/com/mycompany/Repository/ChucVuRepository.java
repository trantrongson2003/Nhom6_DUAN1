/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.ChucVu;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kunrl
 */
public class ChucVuRepository {

  
    public List<ChucVu> getAllChucVu() {
        Transaction trans = null;
        List<ChucVu> listcv = new ArrayList();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            trans = sess.beginTransaction();
            listcv = sess.createQuery("FROM ChucVu").list();

            trans.commit();
        }
        return listcv;
    }

    public List<ChucVu> getALL() {
        List<ChucVu> lst = new ArrayList<>();
        try ( Connection con = DBContext.getConnection()) {
            String sql = "select * from ChucVu";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return lst;
    }

    public void insert(ChucVu cv) {
        try {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date((date.getTime()));
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO ChucVu (Ma,Ten,NgayTao,TrangThai)VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.setDate(3, sqlDate);
            
            ps.setInt(4, cv.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String Ma, ChucVu cv) {
        try {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date((date.getTime()));
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE ChucVu SET Ten=?, TrangThai =? WHERE Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getTen());
            ps.setInt(2, cv.getTrangThai());
//            ps.setDate(3, sqlDate);
//            ps.setString(4, b.getId());
            ps.setString(3, Ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String Id) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE from ChucVu WHERE Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ChucVu getByTen(String ma) {
        ChucVu cv;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT p FROM ChucVu p WHERE p.Ten = :ma";
            TypedQuery<ChucVu> query = session.createQuery(hql, ChucVu.class);
            query.setParameter("ma", ma);
            cv = query.getSingleResult();
        }
        return cv;
    }


    public ChucVu insertChucVu(ChucVu cv) {
         try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(cv);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                //cv.setId(null);
                 cv = null;
            }
        } finally {
            return cv;
        }
    }

    public ChucVu updateChucVu(ChucVu cv, String ma, String ten, Date ngayTao,Integer trangthai) {
        Transaction trans = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            trans = sess.beginTransaction();
            cv.setMa(ma);
            cv.setTen(ten);
            cv.setNgayTao(ngayTao);
            cv.setTrangThai(trangthai);
            sess.update(cv);
            trans.commit();
        }
        return cv;
    }
}
