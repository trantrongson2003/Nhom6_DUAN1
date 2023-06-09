/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DomainModels;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "GiamGiaChiTiet")
public class GiamGiaChiTiet implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String Id;
    @ManyToOne
    @JoinColumn(name = "IdGG")
    private PhieuGiamGia phieuGiamGia;
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP chiTietSP;
    private BigDecimal GiaTriGG;
    private Integer TrangThai;
   
}
