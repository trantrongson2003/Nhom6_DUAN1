/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewModel.BanHang;

import com.mycompany.DomainModels.KhachHang;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author FPT
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoaDonViewModels {
     private String Id;
    private String Ma;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String TenNV;
    private Integer TrangThai;
    private Date NgayShip;
    private KhachHang khachHang;
    private Date NgayNhanHang;
    private Date NgayDaNhanHang;
    private BigDecimal PhiShip;
    private String DiaChiNhan;
    private BigDecimal tongTien;
    private String GhiChu;
    private String SDTNguoiGiaoHang;
    
    public String getTrangThai(){
        if(TrangThai == 0){
            return "Chưa Thanh Toán";
        }else if(TrangThai == 1){
            return "Chờ Thanh Toán";
        }else if(TrangThai == 2){
            return "Đã Hủy";
        }else if(TrangThai == 3){
            return "Đang Giao Hang";
        }else if(TrangThai == 4){
            return "Đơn Giao Hoàn Thành";
        }else{
            return "Đã Thành Toán";
        }
    }

    public HoaDonViewModels(String Ma, Date ngayThanhToan, Integer TrangThai, BigDecimal tongTien) {
        this.Ma = Ma;
        this.ngayThanhToan = ngayThanhToan;
        this.TrangThai = TrangThai;
        this.tongTien = tongTien;
    }
    
    
}
