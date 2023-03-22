/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.Hang;
import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.MauSac;
import com.mycompany.DomainModels.NhaCungCap;
import com.mycompany.DomainModels.NhaSanXuat;
import com.mycompany.DomainModels.SanPham;
import com.mycompany.DomainModels.ThongKe;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import com.mycompany.ViewModel.ThongKe.ThongKeViewModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bridj.cpp.std.list;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author kunrl
 */
public class ThongKeRepository {

    public ArrayList<ChiTietSP> getAllSP() {
        ArrayList<ChiTietSP> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection()) {

            String sql = "select SanPham.Ma as 'Ma', SanPham.Ten as 'TenSP', MauSac.Ten as 'TenMS', NhaCungCap.Ten as 'TenNCC', NSX.Ten as 'TenNSX', Hang.Ten as 'TenHang', SoLuong, Size, GiaBan, GiaNhap from ChiTietSP\n"
                    + "join SanPham on SanPham.Id = ChiTietSP.IdGiay\n"
                    + "join MauSac on MauSac.Id = ChiTietSP.IdMauSac\n"
                    + "join NhaCungCap on NhaCungCap.Id = ChiTietSP.IdNhaCC\n"
                    + "join NSX on NSX.Id = ChiTietSP.IdNsx\n"
                    + "join Hang on Hang.Id = ChiTietSP.IdHang\n"
                    + "where SoLuong < 10";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                String masp = rs.getString("Ma");
                String tensp = rs.getString("TenSP");
                String tenms = rs.getString("TenMS");
                String tenncc = rs.getString("TenNCC");
                String tennsx = rs.getString("TenNSX");
                String tenhang = rs.getString("TenHang");
                int soluong = rs.getInt("SoLuong");
                int size = rs.getInt("Size");
                BigDecimal GiaBan = rs.getBigDecimal("GiaBan");
                BigDecimal GiaNhap = rs.getBigDecimal("GiaNhap");
                MauSac ms = new MauSac();
                ms.setTen(tenms);
                SanPham sp = new SanPham();
                sp.setMa(masp);
                sp.setTen(tensp);
                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setTen(tennsx);
                Hang hang = new Hang();
                hang.setTen(tenhang);
                NhaCungCap ncc = new NhaCungCap();
                ncc.setTen(tenncc);
            
                ChiTietSP tk = new ChiTietSP(null,sp,null, nsx, ms, hang, ncc, null,null,size, soluong, GiaNhap, GiaBan,null,null);
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //----Tinhph232160
    
    public ArrayList<ThongKe> finByBieuDo() {

        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT year(NgayThanhToan) as ngay, sum(TongTien) as Tien\n" +
"                     FROM HoaDon \n" +
"					 where TrangThai =5 or TrangThai =4\n" +
"					 Group by year(NgayThanhToan)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("Tien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    
   
    public static ArrayList<ThongKe> finByNgayThanhToanNamanhTT(int ma, int mi) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Year(NgayThanhToan) as Ngay, TongTien, TrangThai \n" +
"                     FROM HoaDon where Year(NgayThanhToan) like '" + ma + "%'and TrangThai like '" + mi + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                bhsp.setTien(rs.getInt("TrangThai"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public static ArrayList<ThongKe> finByNgayThanhToanThanganhTT(int ma, int mi) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Month(NgayThanhToan) as Ngay, TongTien, TrangThai \n" +
"                     FROM HoaDon where Month(NgayThanhToan) like '" + ma + "%'and TrangThai like '" + mi + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                bhsp.setTien(rs.getInt("TrangThai"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public static ArrayList<ThongKe> finByNgayThanhToanandNgay(int ma, int mi) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Day(NgayThanhToan) as Ngay, TongTien, TrangThai \n" +
"                     FROM HoaDon where Day(NgayThanhToan) like '" + ma + "%'and TrangThai like '" + mi + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                bhsp.setTien(rs.getInt("TrangThai"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public static ArrayList<ThongKe> finByNgayThanhToanNgay(int ma) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Day(NgayThanhToan) as Ngay, TongTien \n" +
"                     FROM HoaDon where Day(NgayThanhToan) like '" + ma + "' and TrangThai=5 or TrangThai=4 or TrangThai = 2";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public static ArrayList<ThongKe> finByNgayThanhToanThang(int ma) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Month(NgayThanhToan) as Ngay, TongTien \n" +
"                     FROM HoaDon where Month(NgayThanhToan) like '" + ma + "' and TrangThai=5 or TrangThai=4 or TrangThai = 2";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    
    
     public static ArrayList<ThongKe> finByNgayThanhToanNam(int ma) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Year(NgayThanhToan) as Ngay, TongTien \n" +
"                     FROM HoaDon where Year(NgayThanhToan) like '" + ma + "' and TrangThai=5 or TrangThai=4 or TrangThai = 2";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    
    }
     public static ArrayList<ThongKe> finByTongtienNgayThanhToanNgay(int ma) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Day(NgayThanhToan) as Ngay, TongTien \n" +
"                     FROM HoaDon where Day(NgayThanhToan) like '" + ma + "' and TrangThai=5 or TrangThai=4 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public static ArrayList<ThongKe> finByTongtienNgayThanhToanThang(int ma) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Month(NgayThanhToan) as Ngay, TongTien \n" +
"                     FROM HoaDon where Month(NgayThanhToan) like '" + ma + "' and TrangThai=5 or TrangThai=4 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    
    
     public static ArrayList<ThongKe> finByTongtienNgayThanhToanNam(int ma) {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Year(NgayThanhToan) as Ngay, TongTien \n" +
"                     FROM HoaDon where Year(NgayThanhToan) like '" + ma + "' and TrangThai=5 or TrangThai=4";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    
    }
     

}
