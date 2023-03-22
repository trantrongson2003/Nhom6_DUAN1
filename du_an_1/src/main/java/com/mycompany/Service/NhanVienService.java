/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.NhanVien;
import com.mycompany.ViewModel.NhanVien.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author FPT
 */
public interface NhanVienService {

    NhanVien getLogin(String userName, String pass);

    List<NhanVienViewModel> getListNhanVien();

    NhanVienViewModel getByMa(String id);

    NhanVienViewModel InsertNhanVien(NhanVienViewModel nv);

    void xoaNhanVien(String ma);

    NhanVienViewModel updateNhanVien(String ma, NhanVienViewModel nv);

    void UpdateThungRacNV(String ma);

    void KhoiPhucNV(String ma);

    List<NhanVienViewModel> getListThungRacNV();
}
