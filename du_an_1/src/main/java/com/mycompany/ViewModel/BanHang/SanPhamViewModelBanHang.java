/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewModel.BanHang;

import java.io.Serializable;
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
public class SanPhamViewModelBanHang implements Serializable{
    private String Id;
    private String maSP;
    private String tenSP;
    private String LoaiSP;
    private String MauSac;
    private Integer Size;
    private Integer SoLunog;
    private BigDecimal DonGia;
}
