/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.GiamGiaChiTiet;
import com.mycompany.DomainModels.Hang;
import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.LoaiSP;
import com.mycompany.DomainModels.MauSac;
import com.mycompany.DomainModels.NhaCungCap;
import com.mycompany.DomainModels.NhaSanXuat;
import com.mycompany.DomainModels.NhanVien;
import com.mycompany.DomainModels.SanPham;
import com.mycompany.Util.DBContext;
import com.mycompany.Util.HibernateUtil;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import com.mycompany.ViewModel.SanPham.SanPhamViewModelSP;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author FPT
 */
public class ChiTietSPRepository {

    //HungLQPH20358
    public List<ChiTietSP> getAll() {
        List<ChiTietSP> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("Select ctsp From ChiTietSP ctsp left join ctsp.loaiSP loai join ctsp.sanPham sp join ctsp.hang h join ctsp.mauSac ms where ctsp.TrangThai = 1");
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<ChiTietSP> getAllPhanTrang(int soTrang) {
        List<ChiTietSP> lst = new ArrayList<>();
        String sql = "select TOP 5 ctsp.Id, sp.Ma as MaSP, sp.Ten as TenSP ,loai.Ten as tenLoai ,ms.Ten as tenMauSac,ctsp.Size,ctsp.SoLuong,ctsp.GiaBan from ChiTietSP ctsp join SanPham sp on ctsp.IdGiay = sp.Id \n"
                + "  join LoaiSP loai on ctsp.IdLoaiSP = loai.Id join MauSac ms on ctsp.IdMauSac = ms.Id where sp.Ma not in (select top " + (soTrang - 1) * 5 + " Ma from SanPham order by Ma asc) and ctsp.TrangThai = 0 order by sp.Ma asc";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa(rs.getString("MaSP"));
                sp.setTen(rs.getString("TenSP"));
                LoaiSP loaisp = new LoaiSP();
                loaisp.setTen(rs.getString("tenLoai"));
                MauSac ms = new MauSac();
                ms.setTen(rs.getString("tenMauSac"));
                ChiTietSP ctsp = new ChiTietSP();
                ctsp.setId(rs.getString("Id"));
                ctsp.setSanPham(sp);
                ctsp.setLoaiSP(loaisp);
                ctsp.setMauSac(ms);
                ctsp.setSize(rs.getInt("Size"));
                ctsp.setSoLuong(rs.getInt("SoLuong"));
                ctsp.setGiaBan(rs.getBigDecimal("GiaBan"));
                lst.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public int countSanPhamBanHang() {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("select Count(*) from ChiTietSP ctsp");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<ChiTietSP> getAllBySearch(String timKiem) {
        List<ChiTietSP> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("Select ctsp From ChiTietSP ctsp join "
                    + "ctsp.sanPham sp join ctsp.loaiSP loai join ctsp.mauSac ms"
                    + " where sp.Ma like :tt1 OR sp.Ten like :tt2 or loai.Ten like :tt3 or ms.Ten like :tt4");
            q.setParameter("tt1", "%" + timKiem + "%");
            q.setParameter("tt2", "%" + timKiem + "%");
            q.setParameter("tt3", "%" + timKiem + "%");
            q.setParameter("tt4", "%" + timKiem + "%");
            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<ChiTietSP> getAllByKhoangGia(BigDecimal gia, BigDecimal gia2) {
        List<ChiTietSP> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("Select ctsp From ChiTietSP ctsp join "
                    + "ctsp.sanPham sp join ctsp.loaiSP loai join ctsp.mauSac ms"
                    + " where ctsp.GiaBan between :gia and :gia2");
            q.setParameter("gia", gia);
            q.setParameter("gia2", gia2);

            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<ChiTietSP> getAllBySIze(Integer size, Integer size2) {
        List<ChiTietSP> lst = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query q = sess.createQuery("Select ctsp From ChiTietSP ctsp join "
                    + "ctsp.sanPham sp join ctsp.loaiSP loai join ctsp.mauSac ms"
                    + " where ctsp.Size between :size and :size2" );
            q.setParameter("size", size);
            q.setParameter("size", size2);

            lst = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public ChiTietSP updateSP(String ma, ChiTietSP sp) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {

            Transaction trans = session.beginTransaction();
            try {
                //nv.setMa(id);
                session.update(sp);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();

            }
        } finally {
            return sp;
        }
    }

    public Integer updateSPKhiMua(ChiTietSP sp) {
        Integer row = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            String hql = "update ChiTietSP set SoLuong = :sl where Id = :id";
            sess.getTransaction().begin();
            Query q = sess.createQuery(hql);
            q.setParameter("sl", sp.getSoLuong());
            q.setParameter("id", sp.getId());
            row = q.executeUpdate();
            sess.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return row;
    }

    public ChiTietSP getSPByQRCode(String barcode) {
        ChiTietSP ctsp = new ChiTietSP();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select ctsp From ChiTietSP ctsp join ctsp.sanPham sp "
                    + "join ctsp.loaiSP lsp join ctsp.mauSac ms  where Barcode = :qr";
            Query q = sess.createQuery(hql);
            q.setParameter("qr", barcode);
            ctsp = (ChiTietSP) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ctsp;
    }
    //HUNGLQPH20358
    //-------------///

    public ArrayList<ChiTietSP> getAllSPNgungKinhDoanh() {
        ArrayList<ChiTietSP> list = new ArrayList<>();

        String select = "select ChiTietSP.Id ,SanPham.Ma as maSP,SanPham.Ten as tenSP ,MauSac.Ten as 'TenMS',NSX.Ten as 'TenNSX',NhaCungCap.Ten as 'TenNCC',Hang.Ten as 'TenHang',LoaiSP.Ten as 'TenLoai',ChiTietSP.Size,ChiTietSP.SoLuong,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,ChiTietSP.TrangThai,ChiTietSP.Barcode from ChiTietSP \n"
                + "join LoaiSP on LoaiSP.Id=ChiTietSP.IdLoaiSP\n"
                + "join NhaCungCap on NhaCungCap.Id=ChiTietSP.IdNhaCC\n"
                + "join NSX on NSX.Id=ChiTietSP.IdNsx\n"
                + "join SanPham on SanPham.Id=ChiTietSP.IdGiay\n"
                + "join Hang on Hang.Id=ChiTietSP.IdHang\n"
                + "join MauSac on MauSac.Id=ChiTietSP.IdMauSac\n"
                + "where ChiTietSP.TrangThai=1";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa(rs.getString("maSP"));
                LoaiSP loaisp = new LoaiSP();
                loaisp.setTen(rs.getString("TenLoai"));
                sp.setTen(rs.getString("tenSP"));
                MauSac ms = new MauSac();
                ms.setTen(rs.getString("TenMS"));
                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setTen(rs.getString("TenNSX"));
                NhaCungCap ncc = new NhaCungCap();
                ncc.setTen(rs.getString("TenNCC"));
                Hang h = new Hang();
                h.setTen(rs.getString("TenHang"));
                ChiTietSP ctsp = new ChiTietSP(rs.getString("Id"), sp, loaisp,
                        nsx, ms, h, ncc, null, null, rs.getInt("Size"), rs.getInt("SoLuong"),
                         rs.getBigDecimal("GiaNhap"), rs.getBigDecimal("GiaBan"), rs.getInt("TrangThai"), rs.getString("Barcode"));
                list.add(ctsp);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public ArrayList<ChiTietSP> getAllSPDangKinhDoanh() {
        ArrayList<ChiTietSP> list = new ArrayList<>();

        String select = "select ChiTietSP.Id ,SanPham.Ma as maSP,SanPham.Ten as tenSP ,MauSac.Ten as 'TenMS',NSX.Ten as 'TenNSX',NhaCungCap.Ten as 'TenNCC',Hang.Ten as 'TenHang',LoaiSP.Ten as 'TenLoai',ChiTietSP.Size,ChiTietSP.SoLuong,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,ChiTietSP.TrangThai,ChiTietSP.Barcode from ChiTietSP \n"
                + "join LoaiSP on LoaiSP.Id=ChiTietSP.IdLoaiSP\n"
                + "join NhaCungCap on NhaCungCap.Id=ChiTietSP.IdNhaCC\n"
                + "join NSX on NSX.Id=ChiTietSP.IdNsx\n"
                + "join SanPham on SanPham.Id=ChiTietSP.IdGiay\n"
                + "join Hang on Hang.Id=ChiTietSP.IdHang\n"
                + "join MauSac on MauSac.Id=ChiTietSP.IdMauSac\n"
                + "where ChiTietSP.TrangThai=0";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa(rs.getString("maSP"));
                LoaiSP loaisp = new LoaiSP();
                loaisp.setTen(rs.getString("TenLoai"));
                sp.setTen(rs.getString("tenSP"));
                MauSac ms = new MauSac();
                ms.setTen(rs.getString("TenMS"));
                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setTen(rs.getString("TenNSX"));
                NhaCungCap ncc = new NhaCungCap();
                ncc.setTen(rs.getString("TenNCC"));
                Hang h = new Hang();
                h.setTen(rs.getString("TenHang"));
                ChiTietSP ctsp = new ChiTietSP(rs.getString("Id"), sp, loaisp,
                        nsx, ms, h, ncc, null, null, rs.getInt("Size"), rs.getInt("SoLuong"),
                         rs.getBigDecimal("GiaNhap"), rs.getBigDecimal("GiaBan"), rs.getInt("TrangThai"), rs.getString("Barcode"));
                list.add(ctsp);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public Integer Update(ChiTietSP ct) {
        Integer row = null;
        try {
            Connection con = DBContext.getConnection();
            String sql = "update ChiTietSP set IdLoaiSP = ? , IdNsx = ?, IdMauSac = ?,IdHang = ?, IdNhaCC = ?  , MoTa = ? , Size = ? , SoLuong = ?\n"
                    + ",GiaNhap = ? , GiaBan = ? , TrangThai = ?,Barcode=? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            String idLoai = null;
            String idNsx = null;
            String IdMauSac = null;
            String IdHang = null;
            String IdNCC = null;
            if (ct.getLoaiSP() != null) {
                idLoai = ct.getLoaiSP().getId();
            }
            if (ct.getNsx() != null) {
                idNsx = ct.getNsx().getId();
            }
            if (ct.getMauSac() != null) {
                IdMauSac = ct.getMauSac().getId();
            }
            if (ct.getNcc() != null) {
                IdNCC = ct.getNcc().getId();
            }
            if (ct.getHang() != null) {
                IdHang = ct.getHang().getId();
            }
            ps.setString(1, idLoai);
            ps.setString(2, idNsx);
            ps.setString(3, IdMauSac);
            ps.setString(4, IdHang);
            ps.setString(5, IdNCC);

            ps.setString(6, ct.getMoTa());
            ps.setInt(7, ct.getSize());
            ps.setInt(8, ct.getSoLuong());
            ps.setBigDecimal(9, ct.getGiaNhap());
            ps.setBigDecimal(10, ct.getGiaBan());
            ps.setInt(11, ct.getTrangThai());
            ps.setString(12, ct.getBarcode());
            ps.setString(13, ct.getId());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer Add(ChiTietSP ctsp) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            sess.getTransaction().begin();
            sess.save(ctsp);
            sess.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    public void delete(String id) {
//        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
//            sess.getTransaction().begin();
//            
//            GiamGiaChiTiet ctsp= sess.get(GiamGiaChiTiet.class, id);
//            sess.delete(ctsp);
//            
//            sess.getTransaction().commit();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete ChiTietSP where Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public void updateThungRac(String id) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "update ChiTietSP set TrangThai = 1 where Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public Integer KhoiPhucSP(String id) {
        try {
            Connection con = DBContext.getConnection();
            String sql = "update ChiTietSP set TrangThai = 0 where Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public List<ChiTietSP> getAllThungRacSP() {
        List<ChiTietSP> list = new ArrayList();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = sess.beginTransaction();
            list = sess.createQuery("from ChiTietSP where TrangThai = 0").list();
            trans.commit();
        }
        return list;
    }

    public ArrayList<ChiTietSP> finByTrangThai(int size) {
        ArrayList<ChiTietSP> listsp = new ArrayList<>();
        String select = "select ChiTietSP.Id ,SanPham.Ma as maSP,SanPham.Ten as tenSP ,MauSac.Ten as 'TenMS',NSX.Ten as 'TenNSX',NhaCungCap.Ten as 'TenNCC',Hang.Ten as 'TenHang',LoaiSP.Ten as 'TenLoai',ChiTietSP.Size,ChiTietSP.SoLuong,ChiTietSP.GiaNhap,ChiTietSP.GiaBan,ChiTietSP.TrangThai,ChiTietSP.Barcode from ChiTietSP \n"
                + "join LoaiSP on LoaiSP.Id=ChiTietSP.IdLoaiSP\n"
                + "join NhaCungCap on NhaCungCap.Id=ChiTietSP.IdNhaCC\n"
                + "join NSX on NSX.Id=ChiTietSP.IdNsx\n"
                + "join SanPham on SanPham.Id=ChiTietSP.IdGiay\n"
                + "join Hang on Hang.Id=ChiTietSP.IdHang\n"
                + "join MauSac on MauSac.Id=ChiTietSP.IdMauSac\n"
                + "where ChiTietSP.Size like '%" + size + "%'";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa(rs.getString("maSP"));
                LoaiSP loaisp = new LoaiSP();
                loaisp.setTen(rs.getString("TenLoai"));
                sp.setTen(rs.getString("tenSP"));
                MauSac ms = new MauSac();
                ms.setTen(rs.getString("TenMS"));
                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setTen(rs.getString("TenNSX"));
                NhaCungCap ncc = new NhaCungCap();
                ncc.setTen(rs.getString("TenNCC"));
                Hang h = new Hang();
                h.setTen(rs.getString("TenHang"));
                ChiTietSP ctsp = new ChiTietSP(rs.getString("Id"), sp, loaisp,
                        nsx, ms, h, ncc, null, null, rs.getInt("Size"), rs.getInt("SoLuong"),
                         rs.getBigDecimal("GiaNhap"), rs.getBigDecimal("GiaBan"), rs.getInt("TrangThai"), rs.getString("Barcode"));
                listsp.add(ctsp);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public void deletePGG(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from GiamGiaChiTiet where IdChiTietSP = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
      public static long totalCount() {
        long total = 0;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String statement = "select count(*) from ChiTietSP";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            total = query.getSingleResult();
        }
        return total;
    }
    
}
