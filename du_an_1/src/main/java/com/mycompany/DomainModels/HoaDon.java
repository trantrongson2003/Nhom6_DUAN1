/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DomainModels;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "HoaDon")
public class HoaDon implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String Id;
    private String MaHD;
    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;
    private Date NgayTao;
    private Date NgayThanhToan;
    private Date NgayShip;
    private Date NgayNhanHang;
    private Date NgayDaNhanHang;
    private BigDecimal PhiShip;
    private String DiaChiGiaoHang;
    private BigDecimal TongTien;
    private String GhiChu;
    private String SDTNguoiGiaoHang;
    private Integer TrangThai;

    public HoaDon(String MaHD, Date NgayThanhToan, BigDecimal TongTien, Integer TrangThai) {
        this.MaHD = MaHD;
        this.NgayThanhToan = NgayThanhToan;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
    }
    
    
    
}
