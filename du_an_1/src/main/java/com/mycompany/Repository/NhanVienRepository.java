/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.NhanVien;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import com.mycompany.ViewModel.NhanVien.NhanVienViewModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author FPT
 */
public class NhanVienRepository {


    public NhanVien getLogin(String userName, String pass) {
        NhanVien nv = new NhanVien();
        String hql = "Select nv From NhanVien nv join nv.chucVu where nv.TenTK like '" + userName + "' and nv.MatKhau like '" + pass + "'";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            nv = (NhanVien) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return nv;
    }

    Transaction trans = null;

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> listnv = new ArrayList();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            trans = sess.beginTransaction();
            listnv = sess.createQuery("FROM NhanVien where TrangThai = 0").list();
            trans.commit();
        }
        return listnv;
    }

    public NhanVien finByMa(String ma) {
        NhanVien product;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT p FROM NhanVien p WHERE p.Ma = :ma";
            TypedQuery<NhanVien> query = session.createQuery(hql, NhanVien.class);
            query.setParameter("ma", ma);
            product = query.getSingleResult();
        }
        return product;
    }

     public List<NhanVien> search(String searchkey) {
        List<NhanVien> listCTSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE Ma like concat (:searchkey,'%') "
                    + "OR Sdt like concat (:searchkey,'%') "
                    );
            query.setParameter("searchkey", searchkey);
            listCTSP = query.getResultList();
            return listCTSP;
        } catch (Exception e) {
        }
        return null;
    }
    public NhanVien insertNhanVien(NhanVien nv) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(nv);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                nv.setId(null);
                // nv = null;
            }
        } finally {
            return nv;
        }
    }

    public List<NhanVien> searchphone(String sdt) {
        List<NhanVien> listCTSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang WHERE Sdt=:sdt "
            );
            query.setParameter("sdt", sdt);
            listCTSP = query.getResultList();
            return listCTSP;
        } catch (Exception e) {
        }
        return null;
    }
    
    public NhanVien updateNhanVien(String ma, NhanVien nv) {
//     int row =0;
//        try {
//            Connection conn = DBContext.getConnection();
//            if (conn != null) {
//                String qualy = "UPDATE NhanVien set Id=?, HoTen=?,TenTK=?, MatKhau=?, GioiTinh=?, DiaChi=?, Sdt=?, IdCV=?, TrangThai=?  where Ma=? ";
//                PreparedStatement ps = conn.prepareStatement(qualy);
//
//                ps.setString(1, sv.getId());
//                ps.setString(2, sv.getHoTen());
//                ps.setString(3, sv.getTenTK());
//                ps.setString(4, sv.getMatKhau());
//                ps.setString(5, sv.getGioiTinh());
//                ps.setString(6, sv.getDiaChi());
//                ps.setString(7, sv.getSdt());
//                ps.setString(8, sv.getChucVu().getTen());
//                ps.setInt(9, sv.getTrangThai());
//                ps.setString(10, ma);
//
//                ps.executeUpdate();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return row >0;
//      return nv;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {

            trans = session.beginTransaction();
            try {
                //nv.setMa(id);
                session.update(nv);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();

            }
        } finally {
            return nv;
        }
    }
    
     public Integer update(NhanVienViewModel nv, String ma) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "UPDATE NHANVIEN SET HOTEN = ?, TenTK = ?, MatKhau = ?,GioiTinh = ?, DIACHI = ? ,SDT = ?,IdCV=?,TrangThai=? WHERE MA = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getTenTK());
            ps.setString(3, nv.getMatKhau());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getSdt());
            ps.setString(7, nv.getTencv().getId());
            
//            ps.setDate(2, (Date) nv.get());
//            ps.setString(8, nv.getChucVu());
            
            ps.setInt(8, nv.getTrangThai());
            ps.setString(9, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteNhanVien(String ma) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            trans = sess.beginTransaction();
            String hql = "Delete from NhanVien c where c.Ma = :ma";
            Query query = sess.createQuery(hql);
            query.setParameter("ma", ma);
            query.executeUpdate();

            trans.commit();
        }

    }

    
    
     //namtvph
        public void updateThungRacNV (String ma){
            try {
                Connection con = DBContext.getConnection();
                String sql = "update NhanVien set TrangThai = 2 where Ma = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, ma);
                ps.execute();
            } catch (Exception e) {
            }
        }
         public void KhoiPhucNV (String ma){
            try {
                Connection con = DBContext.getConnection();
                String sql = "update NhanVien set TrangThai = 0 where Ma = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, ma);
                ps.execute();
            } catch (Exception e) {
            }
        }
        
      public List<NhanVien> getAllThungRacNV() {
        List<NhanVien> listnv = new ArrayList();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            trans = sess.beginTransaction();
            listnv = sess.createQuery("FROM NhanVien where TrangThai = 2").list();
            trans.commit();
        }
        return listnv;
    }   
      public static void main(String[] args) {
        NhanVienRepository nhanVienRepository = new NhanVienRepository();
        NhanVien nv = new NhanVien();
    }
}
