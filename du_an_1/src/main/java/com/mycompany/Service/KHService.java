/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.KhachHang;
import com.mycompany.ViewModel.BanHang.KHViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public interface KHService {

    List<KHViewModel> getAllKH();

    List<KHViewModel> getByKH(String timKiem);

    Integer addKH(KhachHang kh);

    ArrayList<KhachHang> getList();

    public void INSERT(KhachHang kh);

    public void DELETE(String ma);

    public void UPDATE(KhachHang kh, String ma);

    ArrayList<KhachHang> find(String sdt);

    //    namtvph23205
    ArrayList<KhachHang> getListThungRacKH();

    Integer updateThungRacKH(String ma);

    Integer KhoiPhucThungRacKH(String ma);
    
    long totalCount();
}
