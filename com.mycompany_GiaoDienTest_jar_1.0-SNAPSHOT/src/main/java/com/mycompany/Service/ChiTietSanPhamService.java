package com.mycompany.Service;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import com.mycompany.ViewModel.SanPham.SanPhamViewModelSP;
import java.math.BigDecimal;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author kunrl
 */
public interface ChiTietSanPhamService {

    List<SanPhamViewModelBanHang> getSPBanHang(int soTrang);

    Integer updateSPKhiMua(ChiTietSP sp);

    Integer add(ChiTietSP ct);

    void UpdateThungRac(String id);

    Integer KhoiPhuc(String id);

    void delete(String id);

    List<SanPhamViewModelSP> getListThungRacSP();

    long totalCount();

    List<SanPhamViewModelSP> getAllSPNgungKinhDoanh();

    List<SanPhamViewModelSP> getAllSPDangKinhDoanh();

    Integer Update(ChiTietSP sp);

    List<SanPhamViewModelSP> getSPByKhoangGia(BigDecimal gia, BigDecimal gia2);

    List<SanPhamViewModelSP> getSPBySize(Integer size, Integer size2);

    List<SanPhamViewModelSP> getSPBySearch(String timKiem);

    List<SanPhamViewModelBanHang> getAllBySearch(String timKiem);

    List<SanPhamViewModelBanHang> getAllByKhoangGia(BigDecimal gia, BigDecimal gia2) ;
}
