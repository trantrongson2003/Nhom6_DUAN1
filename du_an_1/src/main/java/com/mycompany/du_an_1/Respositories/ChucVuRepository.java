/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.du_an_1.Respositories;

import com.mycompany.du_an_1.DomainModel.ChucVu;
import com.mycompany.du_an_1.Untilities.HibernateConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kunrl
 */
public class ChucVuRepository {
//    Session session = HibernateConfig.getFACTORY().openSession();
    
    private static final Session session = HibernateConfig.getFACTORY().openSession();
    private Transaction transaction = session.getTransaction();
    
    String sql = "from ChucVu cv order by cast (SUBSTRING(cv.ma,4,3) as int) desc";

        public ArrayList<ChucVu> getAll() {
            Session session = HibernateConfig.getFACTORY().openSession();
            Query query = session.createQuery(sql);
            ArrayList<ChucVu> listCV = (ArrayList<ChucVu>) query.getResultList();
            session.close();
            return listCV;
        }
   
      public String insert(ChucVu cv) {
        try {
            transaction.begin();
            session.saveOrUpdate(cv);
            transaction.commit();
            return "ok";
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return "NotOk";
        }
    }
      public ChucVu getObj(String ma) {
        ChucVu s = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChucVu c WHERE c.ma = :ma ");
            query.setParameter("ma", ma);
            s = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
        }
        return s;
    }
          public String delete(ChucVu cv) {
        try {
            transaction.begin();
            session.delete(cv);
            transaction.commit();
            return "Ok";
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return "NotOk";
        }
    }

      

      public static void main(String[] args) {
        ChucVuRepository cv = new ChucVuRepository();
        ChucVu cv1 = new ChucVu(null,"CV0111", "OKTung", new Date(), new Date(), 0);
//        ChucVu cv2 = new ChucVu("CV02", "OKE", new Date(), new Date(), 0);  
          ChucVu cv3 =  cv.getObj("CV0111");
          cv3.setTen("OKTung");
System.out.println(cv.insert(cv3));
        
//        cv.insert(cv1);
        
//                System.out.println(cv.getList().size());
          for (ChucVu chucVu : cv.getAll()) {
              System.out.println(chucVu.goi());
          }
          
    }
  
}
