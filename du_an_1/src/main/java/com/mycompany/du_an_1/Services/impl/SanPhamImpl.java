/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.du_an_1.Services.impl;

import com.mycompany.du_an_1.DomainModel.SanPham;
import com.mycompany.du_an_1.Respositories.SanPhamRepository;
import com.mycompany.du_an_1.Services.SanPhamService;
import java.util.ArrayList;

/**
 *
 * @author phuoc
 */
public class SanPhamImpl implements SanPhamService{

    public SanPhamRepository repo = new SanPhamRepository();
    
    @Override
    public ArrayList<SanPham> getlistSanPham() {
        return this.repo.getAll();
    }

    @Override
    public String insert(SanPham sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPham getObj(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(SanPham sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
