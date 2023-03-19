/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.du_an_1.Respositories;

import com.mycompany.du_an_1.DomainModel.LoaiSanPham;
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
public class LoaiSanPhamRepository {

    private static final Session session = HibernateConfig.getFACTORY().openSession();
    private Transaction transaction = session.getTransaction();

    String sql = "from LOAISP cv order by cast (SUBSTRING(cv.ma,4,3) as int) desc";

    public ArrayList<LoaiSanPham> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery(sql);
        ArrayList<LoaiSanPham> listCV = (ArrayList<LoaiSanPham>) query.getResultList();
        session.close();
        return listCV;
    }

    public String insert(LoaiSanPham lsp) {
        try {
            transaction.begin();
            session.saveOrUpdate(lsp);
            transaction.commit();
            return "ok";
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return "NotOk";
        }
    }

    public LoaiSanPham getObj(String ma) {
        LoaiSanPham s = null;
        try {
            Query query = session.createQuery("SELECT c FROM loaisp c WHERE c.ma = :ma ");
            query.setParameter("ma", ma);
            s = (LoaiSanPham) query.getSingleResult();
        } catch (Exception e) {
        }
        return s;
    }

    public String delete(LoaiSanPham lsp) {
        try {
            transaction.begin();
            session.delete(lsp);
            transaction.commit();
            return "Ok";
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return "NotOk";
        }
    }

    public static void main(String[] args) {
        LoaiSanPhamRepository cv = new LoaiSanPhamRepository();
        LoaiSanPham lsp1 = new LoaiSanPham(null, "lsp001", "giầy chạy bộ", new Date(), new Date(), 0);
//        ChucVu cv2 = new ChucVu("CV02", "OKE", new Date(), new Date(), 0);  
        LoaiSanPham lsp3 = cv.getObj("CV0111");
        lsp3.setTen("ok");
        System.out.println(cv.insert(lsp3));

//        cv.insert(cv1);
//                System.out.println(cv.getList().size());
        for (LoaiSanPham lsp : cv.getAll()) {
            System.out.println(lsp.goi());
        }

    }



}
