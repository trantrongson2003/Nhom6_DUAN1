/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.ChucVu;
import com.mycompany.Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nqtin
 */
public class ChucVuRepository {

    //tinhnqph23160
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
    //tinhnqph23160

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
    //tinhnqph23160

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

    public ChucVu updateChucVu(ChucVu cv, String ma, String ten, Integer trangthai) {
        Transaction trans = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            trans = sess.beginTransaction();
            cv.setMa(ma);
            cv.setTen(ten);
            cv.setTrangThai(trangthai);

            sess.update(cv);
            trans.commit();
        }
        return cv;
    }
}
