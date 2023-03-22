/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.GiamGiaChiTiet;
import com.mycompany.DomainModels.PhieuGiamGia;
import com.mycompany.ViewModel.KhuyenMai.KhuyenMaiViewModel;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface KhuyenMaiService {

    List<KhuyenMaiViewModel> getKhuyenMai();

    Integer add(GiamGiaChiTiet gg);
    Integer addPGG(PhieuGiamGia pgg);

    Integer update(GiamGiaChiTiet gg);

}
