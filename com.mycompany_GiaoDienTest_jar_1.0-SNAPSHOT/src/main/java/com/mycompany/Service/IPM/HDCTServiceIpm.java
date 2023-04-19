/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.HoaDonChiTiet;
import com.mycompany.Repository.HDCTRepository;
import com.mycompany.Repository.HoaDonRepository;
import com.mycompany.Service.HoaDonChiTietService;
import com.mycompany.ViewModel.BanHang.GioHangViewModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class HDCTServiceIpm implements HoaDonChiTietService{
    HDCTRepository hDCTRepository;

    public HDCTServiceIpm() {
        this.hDCTRepository = new HDCTRepository();
    }
    
    
    @Override
    public List<GioHangViewModel> getAllHDCT(String maHD) {
        List<HoaDonChiTiet> lst = hDCTRepository.getAllHDCT(maHD);
        List<GioHangViewModel> lst_view = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet : lst) {
            GioHangViewModel gioHangViewModel = new GioHangViewModel();
            gioHangViewModel.setId(hoaDonChiTiet.getId());
            gioHangViewModel.setMaSP(hoaDonChiTiet.getChiTietSP().getSanPham().getMa());
            gioHangViewModel.setTenSP(hoaDonChiTiet.getChiTietSP().getSanPham().getTen());
            gioHangViewModel.setSoLuong(hoaDonChiTiet.getSoLuong());
            gioHangViewModel.setDonGia(hoaDonChiTiet.getDonGia().doubleValue());
            gioHangViewModel.setThanhTien(hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getDonGia().doubleValue());
            gioHangViewModel.setTrangThai(hoaDonChiTiet.getTrangThai());
            lst_view.add(gioHangViewModel);
        }
        return lst_view;
    }

    @Override
    public Integer addHDCT(HoaDonChiTiet hdct) {
       return hDCTRepository.addHDCT(hdct);
    }
    

    @Override
    public Integer updateSLHDCT(HoaDonChiTiet hdct) {
        return hDCTRepository.updateSLHDCT(hdct);
    }

    @Override
    public Integer deleteHDCTById(String id) {
        return hDCTRepository.deleteHDCTByID(id);
    }

    @Override
    public Integer updateHDCTTraHangToanPhan(HoaDonChiTiet hdct) {
        return hDCTRepository.updateHDCTTraHangToanPhan(hdct);
    }

    @Override
    public Integer deleteHDCTByIDHoaDon(String id) {
        return hDCTRepository.deleteHDCTByIDHoaDon(id);
    }
}
