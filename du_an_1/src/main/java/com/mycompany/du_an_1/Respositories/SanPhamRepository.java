/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.du_an_1.Respositories;

import com.mycompany.du_an_1.DomainModel.LoaiSanPham;
import com.mycompany.du_an_1.DomainModel.SanPham;
import com.mycompany.du_an_1.Untilities.HibernateConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author phuoc
 */
public class SanPhamRepository {

    private static final Session session = HibernateConfig.getFACTORY().openSession();
    private Transaction transaction = session.getTransaction();

    String sql = "from SanPham cv order by cast (SUBSTRING(cv.ma,4,3) as int) desc";

    public ArrayList<SanPham> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery(sql);
        ArrayList<SanPham> listCV = (ArrayList<SanPham>) query.getResultList();
        session.close();
        return listCV;
    }

    public String insert(SanPham sp) {
        try {
            transaction.begin();
            session.saveOrUpdate(sp);
            transaction.commit();
            return "ok";
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return "NotOk";
        }
    }

    public SanPham getObj(String ma) {
        SanPham s = null;
        try {
            Query query = session.createQuery("SELECT c FROM SanPham c WHERE c.ma = :ma ");
            query.setParameter("ma", ma);
            s = (SanPham) query.getSingleResult();
        } catch (Exception e) {
        }
        return s;
    }

    public String delete(SanPham sp) {
        try {
            transaction.begin();
            session.delete(sp);
            transaction.commit();
            return "Ok";
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return "NotOk";
        }
    }

    public static void main(String[] args) {
        SanPhamRepository cv = new SanPhamRepository();
        SanPham sp1 = new SanPham(null, "sp0013", "vans", new Date(), new Date(), 0);
//        ChucVu cv2 = new ChucVu("CV02", "OKE", new Date(), new Date(), 0);  
        SanPham sp3 = cv.getObj("CV0111");
        sp3.setTen("ok");
        System.out.println(cv.insert(sp3));

//        cv.insert(cv1);
//                System.out.println(cv.getList().size());
        for (SanPham sp : cv.getAll()) {
            System.out.println(sp.goi());
        }

    }

    

}
