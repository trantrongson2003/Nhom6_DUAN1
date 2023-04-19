/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.HoaDonChiTiet;
import com.mycompany.ViewModel.BanHang.GioHangViewModel;
import java.util.List;

/**
 *
 * @author FPT
 */
public interface HoaDonChiTietService {
    List<GioHangViewModel> getAllHDCT(String mahd);
    
    Integer addHDCT(HoaDonChiTiet hdct);
    
    Integer updateSLHDCT(HoaDonChiTiet hdct);
    
    Integer updateHDCTTraHangToanPhan(HoaDonChiTiet hdct);
    
    Integer deleteHDCTById(String id);
    
    Integer deleteHDCTByIDHoaDon(String id);
    
}
