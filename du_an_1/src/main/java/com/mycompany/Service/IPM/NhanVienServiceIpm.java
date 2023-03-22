/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.NhanVien;
import com.mycompany.Repository.NhanVienRepository;
import com.mycompany.Service.NhanVienService;
import com.mycompany.ViewModel.NhanVien.NhanVienViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class NhanVienServiceIpm implements NhanVienService {

    NhanVienRepository rep;

    public NhanVienServiceIpm() {
        this.rep = new NhanVienRepository();
    }

    @Override
    public NhanVien getLogin(String userName, String pass) {
        return rep.getLogin(userName, pass);
    }

    @Override
    public List<NhanVienViewModel> getListNhanVien() {
        List<NhanVienViewModel> list = new ArrayList();
        var NV = rep.getAllNhanVien();
        for (NhanVien nv : NV) {
            list.add(new NhanVienViewModel(nv.getId(), nv.getMa(), nv.getHoTen(), nv.getTenTK(), nv.getMatKhau(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getChucVu(), nv.getTrangThai()));
        }
        return list;
    }

    @Override
    public NhanVienViewModel getByMa(String id) {

        var nv = rep.finByMa(id);
        return new NhanVienViewModel(nv.getId(), nv.getMa(), nv.getHoTen(), nv.getTenTK(), nv.getMatKhau(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getChucVu(), nv.getTrangThai());

    }

    @Override
    public NhanVienViewModel InsertNhanVien(NhanVienViewModel nv) {

        var NV = rep.insertNhanVien(new NhanVien(nv.getId(), nv.getMa(), nv.getHoTen(), nv.getTenTK(), nv.getMatKhau(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getTencv(), nv.getTrangThai()));

        return new NhanVienViewModel(NV.getId(), NV.getMa(), NV.getHoTen(), NV.getTenTK(), NV.getMatKhau(), NV.getGioiTinh(), NV.getDiaChi(), NV.getSdt(), NV.getChucVu(), NV.getTrangThai());

    }

    @Override
    public NhanVienViewModel updateNhanVien(String ma, NhanVienViewModel nv) {

        NhanVien nV = new NhanVien(null, nv.getMa(), nv.getHoTen(), nv.getTenTK(), nv.getMatKhau(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getTencv(), nv.getTrangThai());

        String id;
        for (NhanVien nhanVien : rep.getAllNhanVien()) {
            if (nv.getMa().equals(ma)) {
                nV.setId(nhanVien.getId());
            }
        }
        //return new NhanVienViewModel(NV.getId(), NV.getMa(), NV.getHoTen(), NV.getTenTK() ,NV.getMatKhau(), NV.getGioiTinh(), NV.getDiaChi(), NV.getSdt(), NV.getChucVu(), NV.getTrangThai());
        var NV = rep.updateNhanVien(ma, nV);
        return nv;
    }

    @Override
    public void xoaNhanVien(String ma) {
        rep.deleteNhanVien(ma);
    }
    
        @Override
    public void UpdateThungRacNV(String ma) {
        rep.updateThungRacNV(ma);
    }

    @Override
    public List<NhanVienViewModel> getListThungRacNV() {
         List<NhanVienViewModel> list = new ArrayList();
        var NV = rep.getAllThungRacNV();
        for (NhanVien nv : NV) {
            list.add(new NhanVienViewModel(nv.getId(), nv.getMa(), nv.getHoTen(), nv.getTenTK(), nv.getMatKhau(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getChucVu(), nv.getTrangThai()));
        }
        return list;
    }

    @Override
    public void KhoiPhucNV(String ma) {
        rep.KhoiPhucNV(ma);
    }

}
