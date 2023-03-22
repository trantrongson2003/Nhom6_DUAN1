/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.Repository.ChiTietSPRepository;
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
public interface ChiTietSPService {

    List<SanPhamViewModelBanHang> getSPBanHang();

    List<SanPhamViewModelBanHang> getSPBanHang(int soTrang);

    int countSanPhamBanHang();

    List<SanPhamViewModelBanHang> getSPBanHangBySearch(String timKiem);

    List<SanPhamViewModelBanHang> getSPBanHangByKhoangGia(BigDecimal gia, BigDecimal gia2);

    List<SanPhamViewModelSP> getAllSPNgungKinhDoanh();

    List<SanPhamViewModelSP> getAllSPDangKinhDoanh();

    Integer updateSPKhiMua(ChiTietSP sp);

    Integer Update(ChiTietSP sp);

    ChiTietSP getSPByQRCode(String barcode);

    Integer add(ChiTietSP ct);

    List<SanPhamViewModelSP> getSPByKhoangGia(BigDecimal gia, BigDecimal gia2);

    List<SanPhamViewModelSP> getSPBySize(Integer size, Integer size2);

    List<SanPhamViewModelSP> getSPBySearch(String timKiem);

    void UpdateThungRac(String id);

    Integer KhoiPhuc(String id);

    void delete(String id);

    List<SanPhamViewModelSP> getListThungRacSP();

    ArrayList<SanPhamViewModelSP> finbySize(int size);

    void deletePGG(String id);
    
     long totalCount();

}
