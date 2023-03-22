/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DomainModels;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author FPT
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String Id;
    
    @ManyToOne
    @JoinColumn(name = "IdGiay")
    private SanPham sanPham;
    
    @ManyToOne
    @JoinColumn(name = "IdLoaiSP")
    private LoaiSP loaiSP;
    
    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NhaSanXuat nsx;
    
    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    
    @ManyToOne
    @JoinColumn(name = "IdHang")
    private Hang hang;
    
    @ManyToOne
    @JoinColumn(name = "IdNhaCC")
    private NhaCungCap ncc;
    
    private Integer ThoiGianBH;
    private String MoTa;
    private Integer Size;
    private Integer SoLuong;
    private BigDecimal GiaNhap;
    private BigDecimal GiaBan;
    private Integer TrangThai;
    private String Barcode;
//    @OneToMany
//    private List<GiamGiaChiTiet> giamGiaChiTiets;
}
