/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Util;


import com.mycompany.DomainModels.*;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author FPT
 */
public class HibernateUtil {
    private static final SessionFactory FACTORY;
    
    static {
        Configuration conf = new Configuration();
        Properties pro = new Properties();
        pro.put(Environment.DIALECT,"org.hibernate.dialect.SQLServerDialect" );
        pro.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        pro.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=SHOP_BAN_GIAY_TEAM2_PRO1041;encrypt=true;trustServerCertificate=true");
        pro.put(Environment.USER,"sa" );
        pro.put(Environment.PASS,"123456789" );
        
        pro.put(Environment.SHOW_SQL,"true" );
        
        conf.setProperties(pro);
         conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(GiamGiaChiTiet.class);
        conf.addAnnotatedClass(Hang.class);
        conf.addAnnotatedClass(HinhThucThanhToan.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(LoaiSP.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(NhaCungCap.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(PhieuGiamGia.class);
       
        
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(serviceRegistry);
    }
    
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
