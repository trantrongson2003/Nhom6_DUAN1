/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.Repository.ChiTietSanPhamRepository;
import com.mycompany.Service.ChiTietSanPhamService;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import com.mycompany.ViewModel.SanPham.SanPhamViewModelSP;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kunrl
 */
public class ChiTietSanPhamImpl implements ChiTietSanPhamService {

    private ChiTietSanPhamRepository chitietsprepo = new ChiTietSanPhamRepository();

    @Override
    public List<SanPhamViewModelBanHang> getSPBanHang(int soTrang) {
        List<ChiTietSP> lst = chitietsprepo.getAllPhanTrang(soTrang);
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
    public Integer updateSPKhiMua(ChiTietSP sp) {
        return chitietsprepo.updateSPKhiMua(sp);
    }

    @Override
    public Integer add(ChiTietSP ct) {
        return chitietsprepo.Add(ct);
    }

    @Override
    public void UpdateThungRac(String id) {
        chitietsprepo.updateThungRac(id);
    }

    @Override
    public Integer KhoiPhuc(String id) {
        return chitietsprepo.KhoiPhucSP(id);
    }

    @Override
    public void delete(String id) {
        chitietsprepo.delete(id);
    }

    @Override
    public List<SanPhamViewModelSP> getListThungRacSP() {
        List<SanPhamViewModelSP> list = new ArrayList();
        for (ChiTietSP chiTietSP : chitietsprepo.getAllThungRacSP()) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setChatLieuDeGiay(chiTietSP.getChatLieuDeGiay().getTen());
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
    public long totalCount() {
        return chitietsprepo.totalCount();
    }

    @Override
    public List<SanPhamViewModelSP> getAllSPNgungKinhDoanh() {
        List<ChiTietSP> lst = chitietsprepo.getAllSPNgungKinhDoanh();
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setChatLieuDeGiay(chiTietSP.getChatLieuDeGiay().getTen());
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
    public List<SanPhamViewModelSP> getAllSPDangKinhDoanh() {
        List<ChiTietSP> lst = chitietsprepo.getAllSPDangKinhDoanh();
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setChatLieuDeGiay(chiTietSP.getChatLieuDeGiay().getTen());
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
    public Integer Update(ChiTietSP sp) {
        return chitietsprepo.Update(sp);
    }

    @Override
    public List<SanPhamViewModelSP> getSPByKhoangGia(BigDecimal gia, BigDecimal gia2) {
            List<ChiTietSP> lst = chitietsprepo.getAllByKhoangGia(gia, gia2);
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setChatLieuDeGiay(chiTietSP.getChatLieuDeGiay().getTen());
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
        List<ChiTietSP> lst = chitietsprepo.getAllBySIze(size, size2);
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setChatLieuDeGiay(chiTietSP.getChatLieuDeGiay().getTen());
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
        List<ChiTietSP> lst = chitietsprepo.getAllBySearch(timKiem);
        List<SanPhamViewModelSP> lst_view = new ArrayList<>();
        for (ChiTietSP chiTietSP : lst) {
            SanPhamViewModelSP sp = new SanPhamViewModelSP();
            sp.setId(chiTietSP.getId());
            sp.setMa(chiTietSP.getSanPham().getMa());
            sp.setTen(chiTietSP.getSanPham().getTen());
            sp.setLoai(chiTietSP.getLoaiSP().getTen());
            sp.setMauSac(chiTietSP.getMauSac().getTen());
            sp.setNhaSanXuat(chiTietSP.getNsx().getTen());
            sp.setChatLieuDeGiay(chiTietSP.getChatLieuDeGiay().getTen());
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

}
