/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.SanPham;
import com.mycompany.Repository.SanPhamRepository;
import com.mycompany.Service.SanPhamService;

/**
 *
 * @author kunrl
 */
public class SanPhamServiceImp implements SanPhamService{
    
   SanPhamRepository sanPhamRepository;

    public SanPhamServiceImp() {
        this.sanPhamRepository = new SanPhamRepository();
    }
   
   
    @Override
    public Integer updateSP(SanPham sp) {
        return sanPhamRepository.updateSP(sp);
    }

    @Override
    public Integer addSP(SanPham sp) {
        return sanPhamRepository.addSP(sp);
    }
    
    
}
