/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.NhanVien;
import com.mycompany.Repository.ChiTietSPRepository;
import com.mycompany.Service.ChiTietSPService;
import com.mycompany.ViewModel.BanHang.HoaDonViewModels;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import com.mycompany.ViewModel.NhanVien.NhanVienViewModel;
import com.mycompany.ViewModel.SanPham.SanPhamViewModelSP;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class CTSPSerivceIpm implements ChiTietSPService {

    private ChiTietSPRepository chiTietSPRepository;

    public CTSPSerivceIpm() {
        this.chiTietSPRepository = new ChiTietSPRepository();
    }

    @Override
    public List<SanPhamViewModelBanHang> getSPBanHang(int soTrang) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllPhanTrang(soTrang);
        List<SanPhamViewModelBanHang> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelBanHang sp = new SanPhamViewModelBanHang();
            sp.setId(chiTietSP.getId());
            sp.setMaSP(chiTietSP.getSanPham().getMa());
            sp.setTenSP(chiTietSP.getSanPham().getTen());
            sp.setLoaiSP(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLunog(chiTietSP.getSoLuong());
            sp.setDonGia(chiTietSP.getGiaBan());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public int countSanPhamBanHang() {
        return chiTietSPRepository.countSanPhamBanHang();
    }
    //--------------------------------------

    @Override
    public List<SanPhamViewModelSP> getAllSPNgungKinhDoanh() {
        List<ChiTietSP> lst = chiTietSPRepository.getAllSPNgungKinhDoanh();
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setNhaCungCap(chiTietSP.getNcc().getTen());
            sp.setHang(chiTietSP.getHang().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLuong(chiTietSP.getSoLuong());
            sp.setGiaNhap(chiTietSP.getGiaNhap());
            sp.setGiaBan(chiTietSP.getGiaBan());
            sp.setTrangThai(chiTietSP.getTrangThai());
            sp.setBarcode(chiTietSP.getBarcode());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public Integer updateSPKhiMua(ChiTietSP sp) {
        return chiTietSPRepository.updateSPKhiMua(sp);
    }

    @Override
    public Integer Update(ChiTietSP sp) {

        return chiTietSPRepository.Update(sp);
    }

    @Override
    public ChiTietSP getSPByQRCode(String barcode) {
        return chiTietSPRepository.getSPByQRCode(barcode);
    }

    @Override
    public Integer add(ChiTietSP ct) {
        return chiTietSPRepository.Add(ct);
    }

    @Override
    public List<SanPhamViewModelBanHang> getSPBanHangBySearch(String timKiem) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllBySearch(timKiem);
        List<SanPhamViewModelBanHang> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelBanHang sp = new SanPhamViewModelBanHang();
            sp.setId(chiTietSP.getId());
            sp.setMaSP(chiTietSP.getSanPham().getMa());
            sp.setTenSP(chiTietSP.getSanPham().getTen());
            sp.setLoaiSP(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLunog(chiTietSP.getSoLuong());
            sp.setDonGia(chiTietSP.getGiaBan());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public List<SanPhamViewModelBanHang> getSPBanHangByKhoangGia(BigDecimal gia, BigDecimal gia2) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllByKhoangGia(gia, gia2);
        List<SanPhamViewModelBanHang> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelBanHang sp = new SanPhamViewModelBanHang();
            sp.setId(chiTietSP.getId());
            sp.setMaSP(chiTietSP.getSanPham().getMa());
            sp.setTenSP(chiTietSP.getSanPham().getTen());
            sp.setLoaiSP(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLunog(chiTietSP.getSoLuong());
            sp.setDonGia(chiTietSP.getGiaBan());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public List<SanPhamViewModelSP> getSPByKhoangGia(BigDecimal gia, BigDecimal gia2) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllByKhoangGia(gia, gia2);
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setNhaCungCap(chiTietSP.getNcc().getTen());
            sp.setHang(chiTietSP.getHang().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLuong(chiTietSP.getSoLuong());
            sp.setGiaNhap(chiTietSP.getGiaNhap());
            sp.setGiaBan(chiTietSP.getGiaBan());
            sp.setTrangThai(chiTietSP.getTrangThai());
            sp.setBarcode(chiTietSP.getBarcode());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public List<SanPhamViewModelSP> getSPBySize(Integer size, Integer size2) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllBySIze(size, size2);
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setNhaCungCap(chiTietSP.getNcc().getTen());
            sp.setHang(chiTietSP.getHang().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLuong(chiTietSP.getSoLuong());
            sp.setGiaNhap(chiTietSP.getGiaNhap());
            sp.setGiaBan(chiTietSP.getGiaBan());
            sp.setTrangThai(chiTietSP.getTrangThai());
            sp.setBarcode(chiTietSP.getBarcode());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public List<SanPhamViewModelSP> getSPBySearch(String timKiem) {
        List<ChiTietSP> lst = chiTietSPRepository.getAllBySearch(timKiem);
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setNhaCungCap(chiTietSP.getNcc().getTen());
            sp.setHang(chiTietSP.getHang().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLuong(chiTietSP.getSoLuong());
            sp.setGiaNhap(chiTietSP.getGiaNhap());
            sp.setGiaBan(chiTietSP.getGiaBan());
            sp.setTrangThai(chiTietSP.getTrangThai());
            sp.setBarcode(chiTietSP.getBarcode());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public void UpdateThungRac(String id) {
        chiTietSPRepository.updateThungRac(id);
    }

    @Override
    public List<SanPhamViewModelSP> getListThungRacSP() {
        List<SanPhamViewModelSP> list = new ArrayList();
        for (ChiTietSP chiTietSP : chiTietSPRepository.getAllThungRacSP()) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setNhaCungCap(chiTietSP.getNcc().getTen());
            sp.setHang(chiTietSP.getHang().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLuong(chiTietSP.getSoLuong());
            sp.setGiaNhap(chiTietSP.getGiaNhap());
            sp.setGiaBan(chiTietSP.getGiaBan());
            sp.setTrangThai(chiTietSP.getTrangThai());
            sp.setBarcode(chiTietSP.getBarcode());
            list.add(sp);
        }
        return list;
    }

    @Override
    public void delete(String id) {
        chiTietSPRepository.delete(id);
    }

    @Override
    public List<SanPhamViewModelBanHang> getSPBanHang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer KhoiPhuc(String id) {
        return chiTietSPRepository.KhoiPhucSP(id);
    }

    @Override
    public List<SanPhamViewModelSP> getAllSPDangKinhDoanh() {
        List<ChiTietSP> lst = chiTietSPRepository.getAllSPDangKinhDoanh();
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setNhaCungCap(chiTietSP.getNcc().getTen());
            sp.setHang(chiTietSP.getHang().getTen());
            sp.setSize(chiTietSP.getSize());
            sp.setSoLuong(chiTietSP.getSoLuong());
            sp.setGiaNhap(chiTietSP.getGiaNhap());
            sp.setGiaBan(chiTietSP.getGiaBan());
            sp.setTrangThai(chiTietSP.getTrangThai());
            sp.setBarcode(chiTietSP.getBarcode());
            lst_view.add(sp);
        }
        return lst_view;
    }

    @Override
    public ArrayList<SanPhamViewModelSP> finbySize(int size) {
        ArrayList<SanPhamViewModelSP> list = new ArrayList();
        var HD = chiTietSPRepository.finByTrangThai(size);
        for (ChiTietSP chiTietSP : HD) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setSize(chiTietSP.getSize());
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setNhaCungCap(chiTietSP.getNcc().getTen());
            sp.setHang(chiTietSP.getHang().getTen());
            sp.setSoLuong(chiTietSP.getSoLuong());
            sp.setGiaNhap(chiTietSP.getGiaNhap());
            sp.setGiaBan(chiTietSP.getGiaBan());
            sp.setTrangThai(chiTietSP.getTrangThai());
            sp.setBarcode(chiTietSP.getBarcode());
            list.add(sp);
        }
        return list;
    }

    public static void main(String[] args) {

    }

    @Override
    public void deletePGG(String id) {
          chiTietSPRepository.deletePGG(id);
    }

    @Override
    public long totalCount() {
        return chiTietSPRepository.totalCount();
    }

}
