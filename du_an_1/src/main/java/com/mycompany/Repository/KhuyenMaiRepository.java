/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.GiamGiaChiTiet;
import com.mycompany.DomainModels.LoaiSP;
import com.mycompany.DomainModels.MauSac;
import com.mycompany.DomainModels.NhaCungCap;
import com.mycompany.DomainModels.PhieuGiamGia;
import com.mycompany.DomainModels.SanPham;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ACER
 */
public class KhuyenMaiRepository {
 public List<GiamGiaChiTiet> getAll() {
        List<GiamGiaChiTiet> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            CriteriaBuilder builder = sess.getCriteriaBuilder();
            CriteriaQuery<GiamGiaChiTiet> query = builder.createQuery(GiamGiaChiTiet.class);
            Root<GiamGiaChiTiet> gRoot = query.from(GiamGiaChiTiet.class);
            Root<PhieuGiamGia> spRoot = query.from(PhieuGiamGia.class);
            Root<ChiTietSP> cRoot = query.from(ChiTietSP.class);
            query = query.where(builder.equal(gRoot.get("phieuGiamGia"), spRoot.get("Id")),
                    builder.equal(gRoot.get("chiTietSP"), cRoot.get("Id"))
                    );
            query.select(gRoot);
            Query q = sess.createQuery(query);
            lst = q.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
   public Integer Add(GiamGiaChiTiet gg) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(gg);
            sess.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
      public Integer AddPGG(PhieuGiamGia pgg) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(pgg);
            sess.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
   public Integer Update(GiamGiaChiTiet gg) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.update(gg);
            sess.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
    public static void main(String[] args) {
     GiamGiaChiTiet gg=new GiamGiaChiTiet();
        new KhuyenMaiRepository().Add(gg);
    }
}
