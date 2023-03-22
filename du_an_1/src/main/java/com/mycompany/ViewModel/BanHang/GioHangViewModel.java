/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewModel.BanHang;

import java.math.BigDecimal;
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
public class GioHangViewModel {
    private String Id;
    private String MaSP;
    private String TenSP;
    private Integer soLuong;
    private Double donGia;
    private Double ThanhTien;
    private Integer TrangThai;
   
    public String getTrangThai(){
        if(TrangThai == null){
            return "";
        }else{
            return "Trả Hàng";
        }
    }
   
}
