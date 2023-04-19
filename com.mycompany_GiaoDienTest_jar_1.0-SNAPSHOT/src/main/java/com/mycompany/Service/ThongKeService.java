/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.ThongKe;
import com.mycompany.ViewModel.ThongKe.ThongKeViewModel;
import java.util.ArrayList;

/**
 *
 * @author kunrl
 */
public interface ThongKeService {
    
    ArrayList<ThongKeViewModel> getAllSanPhamThongKe();
    
    ArrayList<ThongKe> finByBieuDo();

    ArrayList<ThongKe> finByNgayThanhToanandNgay(int ma, int mi);

    ArrayList<ThongKe> finByNgayThanhToaThangnandTT(int ma, int mi);

    ArrayList<ThongKe> finByNgayThanhToannamandTT(int ma, int mi);

    ArrayList<ThongKe> finByNgayThanhToanNam(int ma);

    ArrayList<ThongKe> finbyngaythanhToanThang(int ma);

    ArrayList<ThongKe> finbyngaythanhToanNgay(int ma);
    
    ArrayList<ThongKe> finTongtienByNgayThanhToanNam(int ma);

    ArrayList<ThongKe> finbyTongtienngaythanhToanThang(int ma);

    ArrayList<ThongKe> finbyTongtienngaythanhToanNgay(int ma);
}
