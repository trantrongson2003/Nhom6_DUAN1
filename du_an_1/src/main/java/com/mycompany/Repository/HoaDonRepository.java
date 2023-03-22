/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.HinhThucThanhToan;
import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.KhachHang;
import com.mycompany.DomainModels.NhanVien;
import com.mycompany.DomainModels.ThongKe;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author FPT
 */
public class HoaDonRepository {

    //HungLQPH20358
    public List<HoaDon> getAllHD() {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd join hd.nhanVien nv where hd.TrangThai = 0 or hd.TrangThai = 1 or hd.TrangThai = 3 order by hd.NgayTao desc ";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            lst =  q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return lst;
    }
  

    public int countHoaDon() {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("select Count(*) from HoaDon hd");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<HoaDon> getAllHDViewQLHD(int sotrang) {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "  select top 5 hd.MaHD, nv.HoTen as tenNV , kh.HoTen as tenKH, hd.TongTien , hd.NgayTao , hd.NgayThanhToan , hd.GhiChu, hd.TrangThai\n" +
"  From HoaDon hd left join khachHang kh on hd.IdKH = kh.Id left join nhanVien nv on hd.IdNV = nv.Id where hd.MaHD not in(Select top "+(sotrang-1)*5 +" MaHD From HoaDon order by NgayTao desc)  order by hd.NgayTao desc";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(hql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setHoTen(rs.getString("tenNV"));
                KhachHang kh = new KhachHang();
                kh.setHoTen(rs.getString("tenKH"));
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setKhachHang(kh);
                hd.setNhanVien(nv);
                hd.setTongTien(rs.getBigDecimal("TongTien"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                hd.setGhiChu(rs.getString("GhiChu"));
                hd.setTrangThai(rs.getInt("TrangThai"));
                lst.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<HoaDon> getAllHDViewQLHDByTrangThai(Integer trangThai) {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd left join hd.khachHang kh left join hd.nhanVien nv where hd.TrangThai = :tt";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("tt", trangThai);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<HoaDon> getAllHDViewQLHDBySearch(String timKiem) {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd left join hd.khachHang kh left join hd.nhanVien nv where hd.MaHD like :ma or nv.HoTen like :ten or kh.HoTen like :tenkh";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("ma", "%" + timKiem + "%");
            q.setParameter("ten", "%" + timKiem + "%");
            q.setParameter("tenkh", "%" + timKiem + "%");
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<HoaDon> getAllHDViewQLHDByNgay(Date ngay, Date ngay2) {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd left join hd.khachHang kh left join hd.nhanVien nv where hd.NgayTao between :ngay and :ngay1";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("ngay", ngay);
            q.setParameter("ngay1", ngay2);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<HoaDon> getAllHDByTrangThai(int tt) {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd join hd.nhanVien nv where hd.TrangThai = :tt1 or hd.TrangThai = :tt2 or hd.TrangThai = :tt3";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("tt1", tt);
            q.setParameter("tt2", tt);
            q.setParameter("tt3", tt);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<HoaDon> getAllHDCheckMa() {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public Integer addHD(HoaDon hd) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(hd);
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    public Integer updateHD(HoaDon hd) {
        Integer row = null;
        String hql = "update HoaDon set TongTien = :tong , TrangThai = :trangThai , IdKH = :kh, NgayThanhToan = :ntt, GhiChu = :gc where Id = :id";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
            String idKH = null;
            if (hd.getKhachHang() != null) {
                idKH = hd.getKhachHang().getId();
            }
            q.setParameter("tong", hd.getTongTien());
            q.setParameter("trangThai", hd.getTrangThai());
            q.setParameter("id", hd.getId());
            q.setParameter("kh", idKH);
            q.setParameter("ntt", hd.getNgayThanhToan());
            q.setParameter("gc", hd.getGhiChu());
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }

    public Integer updateHDDatHangThanhCong(HoaDon hd) {
        Integer row = null;
        String hql = "update HoaDon set TongTien = :tong, NgayThanhToan = :ngayttoan ,NgayDaNhanHang = :ngayDaNhanHang ,TrangThai = :tt where Id = :id";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
            q.setParameter("ngayttoan", hd.getNgayThanhToan());
            q.setParameter("tong", hd.getTongTien());
            q.setParameter("ngayDaNhanHang", hd.getNgayDaNhanHang());
            q.setParameter("tt", hd.getTrangThai());
            q.setParameter("id", hd.getId());
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }

    public Integer updateHDDatHang(HoaDon hd) {
        Integer row = null;
        String hql = "update HoaDon set TrangThai = :trangThai,"
                + "NgayShip = :ngayShip, NgayNhanHang = :ngayDuKien , "
                + "IdKH = :kh,PhiShip = :phiShip,DiaChiGiaoHang = :dc , GhiChu = :gc,SDTNguoiGiaoHang = :sdt where Id = :id";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
//            q.setParameter("tong", hd.getTongTien());
            q.setParameter("trangThai", hd.getTrangThai());
            q.setParameter("id", hd.getId());
            q.setParameter("kh", hd.getKhachHang());
            q.setParameter("ngayShip", hd.getNgayShip());
            q.setParameter("ngayDuKien", hd.getNgayNhanHang());
            q.setParameter("phiShip", hd.getPhiShip());
            q.setParameter("gc", hd.getGhiChu());
            q.setParameter("dc", hd.getDiaChiGiaoHang());
            q.setParameter("sdt", hd.getSDTNguoiGiaoHang());

            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }
    //Hunglqph20358
    //------------------------

    //tinhph23160
//    public List<HoaDon> getAllHoaDon() {
//        List<HoaDon> lst = new ArrayList<>();
//        Transaction tran = null;
//        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
//            tran = sess.beginTransaction();
//            lst = sess.createQuery("FROM HoaDon").list();
//            tran.commit();
//        }
//        return lst;
//    }
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where TrangThai=5 or TrangThai=4 or TrangThai=2"
            + " ORDER BY Cast(SUBSTRING(dbo.HoaDon.MaHD, 3,2) as int)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    
    public ArrayList<HoaDon> finByTrangThai(int ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where TrangThai like '%" + ma + "%'"
                     + "ORDER BY Cast(SUBSTRING(dbo.HoaDon.MaHD, 3,2) as int)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public static ArrayList<HoaDon> finByNgayThanhToan(String ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where NgayThanhToan like '%" + ma + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public ArrayList<HoaDon> finByNgayThanhToanandTH(int ma, int mi) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MaHD, NgayThanhToan, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where NgayThanhToan like '%" + ma + "%' and TrangThai like '%" + mi + "%'"
                    +  "ORDER BY Cast(SUBSTRING(dbo.HoaDon.MaHD, 3,2) as int)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public List<HoaDon> finByKhoangNgayThanhToan(Date ngay, Date ngay1) {
        List<HoaDon> lst = new ArrayList<>();
        String hql = "select hd From HoaDon hd where hd.NgayThanhToan between :ngay and :ngay1";
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery(hql);
            q.setParameter("ngay", ngay);
            q.setParameter("ngay1", ngay1);
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
  
    //-----------------
    //----------------------
}
