/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewModel.ThongKe;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThongKeViewModel {
    
    private String ma;
    private String tenSp;
    private String tenMausac;
    private String tenNcc;
    private String tenNsx;
    private String tenHang;
    private int soLuong;
    private int size;
    private BigDecimal giaban;
    private BigDecimal giaNhap;


}
