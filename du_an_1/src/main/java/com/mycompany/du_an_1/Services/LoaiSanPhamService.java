/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.du_an_1.Services;

import com.mycompany.du_an_1.DomainModel.LoaiSanPham;
import java.util.ArrayList;


/**
 *
 * @author phuoc
 */
public interface LoaiSanPhamService {
    
    ArrayList<LoaiSanPham> getlistSanPham();

    String insert(LoaiSanPham lsp);

    LoaiSanPham getObj(String ma);

    String delete(LoaiSanPham lsp);
    
}
