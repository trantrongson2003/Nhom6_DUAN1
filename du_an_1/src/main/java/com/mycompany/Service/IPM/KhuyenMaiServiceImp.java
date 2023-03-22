/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.GiamGiaChiTiet;
import com.mycompany.DomainModels.PhieuGiamGia;
import com.mycompany.Repository.KhuyenMaiRepository;
import com.mycompany.Service.KhuyenMaiService;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import com.mycompany.ViewModel.KhuyenMai.KhuyenMaiViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhuyenMaiServiceImp implements KhuyenMaiService{
    KhuyenMaiRepository khuyenMaiRepository=new KhuyenMaiRepository();

    @Override
    public List<KhuyenMaiViewModel> getKhuyenMai() {
         List<GiamGiaChiTiet> lst = khuyenMaiRepository.getAll();
        List<KhuyenMaiViewModel> lst_view = new ArrayList<>();
        for (GiamGiaChiTiet ggct : lst) {
            KhuyenMaiViewModel km = new KhuyenMaiViewModel();
            km.setMa(ggct.getPhieuGiamGia().getMa());
            km.setLoaiGiamGia(ggct.getPhieuGiamGia().getLoaiGiamGia());
            km.setGiaTriGG(ggct.getGiaTriGG());
            km.setTen(ggct.getChiTietSP().getSanPham().getTen());
            km.setNgayBD(ggct.getPhieuGiamGia().getNgayBD());
            km.setNgayKT(ggct.getPhieuGiamGia().getNgayKT());
            km.setTrangThai(ggct.getPhieuGiamGia().getTrangThai());
            lst_view.add(km);
        }
        return lst_view;
    }

    @Override
    public Integer add(GiamGiaChiTiet gg) {
        return khuyenMaiRepository.Add(gg);
    }

    @Override
    public Integer update(GiamGiaChiTiet ggct) {
        return khuyenMaiRepository.Update(ggct);
    }

    @Override
    public Integer addPGG(PhieuGiamGia pgg) {
        return khuyenMaiRepository.AddPGG(pgg);
    }
   
    
}
