/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.du_an_1.Services;

import com.mycompany.du_an_1.DomainModel.SanPham;
import java.util.ArrayList;

/**
 *
 * @author phuoc
 */
public interface SanPhamService {
    
    ArrayList<SanPham> getlistSanPham();

    String insert(SanPham sp);

    SanPham getObj(String ma);

    String delete(SanPham sp);
    
}
