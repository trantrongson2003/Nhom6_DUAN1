/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewModel.KhuyenMai;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ACER
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KhuyenMaiViewModel {
    private String Ma;
    private String LoaiGiamGia;
    private BigDecimal GiaTriGG;
    private Date NgayBD;
    private Date NgayKT;
    private Integer TrangThai;
    private String Ten;
    
}
