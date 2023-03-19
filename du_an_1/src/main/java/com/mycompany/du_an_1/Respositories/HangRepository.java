/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.du_an_1.Respositories;

import com.mycompany.du_an_1.DomainModel.Hang;
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
public class HangRepository {
    
     private static final Session session = HibernateConfig.getFACTORY().openSession();
    private Transaction transaction = session.getTransaction();

    String sql = "from hang cv order by cast (SUBSTRING(cv.ma,4,3) as int) desc";

    public ArrayList<Hang> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery(sql);
        ArrayList<Hang> listCV = (ArrayList<Hang>) query.getResultList();
        session.close();
        return listCV;
    }

    public String insert(Hang hang) {
        try {
            transaction.begin();
            session.saveOrUpdate(hang);
            transaction.commit();
            return "ok";
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return "NotOk";
        }
    }

    public Hang getObj(String ma) {
        Hang s = null;
        try {
            Query query = session.createQuery("SELECT c FROM HANG c WHERE c.ma = :ma ");
            query.setParameter("ma", ma);
            s = (Hang) query.getSingleResult();
        } catch (Exception e) {
        }
        return s;
    }

    public String delete(Hang hang) {
        try {
            transaction.begin();
            session.delete(hang);
            transaction.commit();
            return "Ok";
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return "NotOk";
        }
    }

    public static void main(String[] args) {
        HangRepository cv = new HangRepository();
        Hang h1 = new Hang(null, "hang0012", "nike", new Date(), new Date(), 0);
//        ChucVu cv2 = new ChucVu("CV02", "OKE", new Date(), new Date(), 0);  
        Hang h3 = cv.getObj("CV0111");
        h3.setTen("ok");
        System.out.println(cv.insert(h3));

//        cv.insert(cv1);
//                System.out.println(cv.getList().size());
        for (Hang h : cv.getAll()) {
            System.out.println(h.goi());
        }

    }
    
}
