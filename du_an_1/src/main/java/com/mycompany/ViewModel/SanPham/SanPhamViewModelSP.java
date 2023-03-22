/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewModel.SanPham;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kunrl
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SanPhamViewModelSP implements Serializable{

    private String Id;
    private String Ma;
    private String Ten;
    private String MauSac;
    private String NhaSanXuat;
    private String NhaCungCap;
    private String Hang;
    private String Loai;
    private Integer Size;
    private Integer SoLuong;
    private BigDecimal GiaNhap;
    private BigDecimal GiaBan;
    private Integer TrangThai;
    private String Barcode;

}
