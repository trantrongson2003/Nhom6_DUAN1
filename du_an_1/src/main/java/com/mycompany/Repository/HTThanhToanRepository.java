/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.HinhThucThanhToan;
import com.mycompany.Util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author FPT
 */
public class HTThanhToanRepository {
    //Hunglqph20358
     public Integer addHTTT(HinhThucThanhToan httt){
        
        try(Session sess = HibernateUtil.getFACTORY().openSession()) {
           sess.getTransaction().begin();
           sess.save(httt);
           sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}
