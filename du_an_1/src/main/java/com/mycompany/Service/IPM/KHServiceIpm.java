/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.KhachHang;
import com.mycompany.Repository.KHRepository;
import com.mycompany.Service.KHService;
import com.mycompany.ViewModel.BanHang.KHViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class KHServiceIpm implements KHService {

    KHRepository kHRepository;

    public KHServiceIpm() {
        this.kHRepository = new KHRepository();
    }

    @Override
    public List<KHViewModel> getAllKH() {
        List<KhachHang> lst = kHRepository.getAllKH();
        List<KHViewModel> lst_View = new ArrayList<>();
        for (KhachHang kh : lst) {
            KHViewModel kh_View = new KHViewModel();
            kh_View.setId(kh.getId());
            kh_View.setMaKh(kh.getMa());
            kh_View.setHoTen(kh.getHoTen());
            kh_View.setDiaChi(kh.getDiaChi());
            kh_View.setNgaySinh(kh.getNgaySinh());
            kh_View.setSDT(kh.getSdt());
            kh_View.setTrangThai(kh.getTrangThai());
            lst_View.add(kh_View);
        }
        return lst_View;
    }

    @Override
    public List<KHViewModel> getByKH(String timKiem) {
        List<KhachHang> lst = kHRepository.getByKH(timKiem);
        List<KHViewModel> lst_View = new ArrayList<>();
        for (KhachHang kh : lst) {
            KHViewModel kh_View = new KHViewModel();
            kh_View.setId(kh.getId());
            kh_View.setMaKh(kh.getMa());
            kh_View.setHoTen(kh.getHoTen());
            kh_View.setDiaChi(kh.getDiaChi());
            kh_View.setNgaySinh(kh.getNgaySinh());
            kh_View.setSDT(kh.getSdt());
            kh_View.setTrangThai(kh.getTrangThai());
            lst_View.add(kh_View);
        }
        return lst_View;
    }

    @Override
    public Integer addKH(KhachHang kh) {
        return kHRepository.addKH(kh);
    }

    @Override
    public ArrayList<KhachHang> getList() {
        return kHRepository.getAllKhachHang();
    }

    @Override
    public void INSERT(KhachHang kh) {
        kHRepository.insert(kh);
    }

    @Override
    public void DELETE(String ma) {
        kHRepository.delete(ma);
    }

    @Override
    public void UPDATE(KhachHang kh, String ma) {
        kHRepository.update(kh, ma);
    }

    @Override
    public ArrayList<KhachHang> find(String sdt) {
        return kHRepository.findKhachHang(sdt);
    }

    @Override
    public ArrayList<KhachHang> getListThungRacKH() {
        return kHRepository.getAllThungRacKH();
    }

    @Override
    public Integer updateThungRacKH(String ma) {
        return kHRepository.updateThungRacKH(ma);
    }

    @Override
    public Integer KhoiPhucThungRacKH(String ma) {
        return kHRepository.KhoiPhucThungRacKH(ma);
    }

    @Override
    public long totalCount() {
     return kHRepository.totalCount();
    }

}
