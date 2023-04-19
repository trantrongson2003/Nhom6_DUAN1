/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DomainModels;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author kunrl
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String Id;
    private String Ma;
    private String HoTen;
    private String TenTK;
    private String MatKhau;
    private String GioiTinh;
    private String DiaChi;
    private String Sdt;
    @ManyToOne
    @JoinColumn(name = "IdCV")
    private ChucVu chucVu;
    private Integer TrangThai;
    
}
