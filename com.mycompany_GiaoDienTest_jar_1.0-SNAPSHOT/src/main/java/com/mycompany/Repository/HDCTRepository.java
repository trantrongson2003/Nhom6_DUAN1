/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.HoaDonChiTiet;
import com.mycompany.Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author FPT
 */
public class HDCTRepository {
    
    //HungLQPH20358
    public List<HoaDonChiTiet> getAllHDCT(String maHD){
        List<HoaDonChiTiet> lst = new ArrayList<>();
        String hql = "Select hdct From HoaDonChiTiet hdct join hdct.chiTietSP ctsp join hdct.hoaDon hd where hd.MaHD like :ma";
        try(Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("ma", maHD);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
    
    public Integer addHDCT(HoaDonChiTiet hdct) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(hdct);
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
    public Integer updateSLHDCT(HoaDonChiTiet hdct){
        Integer row = null;
        String hql = "update HoaDonChiTiet set soLuong = :sl where Id = :id";
        try(Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
            q.setParameter("sl", hdct.getSoLuong());
            q.setParameter("id", hdct.getId());
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }
    
    public Integer updateHDCTTraHangToanPhan(HoaDonChiTiet hdct){
        Integer row = null;
        String hql = "update HoaDonChiTiet set TrangThai = :tt where Id = :id";
        try(Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
            q.setParameter("tt", hdct.getTrangThai());
            q.setParameter("id", hdct.getId());
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }
    
    public Integer deleteHDCTByID(String id){
        Integer row = null;
        String HQL = "Delete From HoaDonChiTiet where Id = :id";
        try(Session sess = HibernateUtil.getFACTORY().openSession()){
            sess.getTransaction().begin();
           Query q = sess.createQuery(HQL);
           q.setParameter("id", id);
           row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }
    public Integer deleteHDCTByIDHoaDon(String id){
        Integer row = null;
        String HQL = "Delete From HoaDonChiTiet where IdHoaDon = :id";
        try(Session sess = HibernateUtil.getFACTORY().openSession()){
            sess.getTransaction().begin();
           Query q = sess.createQuery(HQL);
           q.setParameter("id", id);
           row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }
    //HungLQPH20358
    //--------------------------------
    
    
    
}
