/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewModel.hoaDon;

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
public class QLHoaDonViewModel {
    private String maHD;
    private String hoTenNV;
    private String tenKH;
    private BigDecimal tongTien;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String ghiChu;
    private Integer trangThai;
    
     public String getTrangThai(){
        if(trangThai == 0){
            return "Chưa Thanh Toán";
        }else if(trangThai == 1){
            return "Chờ Thanh Toán";
        }else if(trangThai == 2){
            return "Đã Hủy";
        }else if(trangThai == 3){
            return "Đang Giao Hang";
        }else if(trangThai == 4){
            return "Đơn Giao Hoàn Thành";
        }else{
            return "Đã Thành Toán";
        }
    }
}
