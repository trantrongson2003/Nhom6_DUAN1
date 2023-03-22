/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.SanPham;
import com.mycompany.Repository.SanPhamRepository;
import com.mycompany.Service.SanPhamService;
import java.util.List;

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
    public List<SanPham> getAllChucVu() {
        return sanPhamRepository.getAllChucVu();
    }

    @Override
    public Integer addSP(SanPham sp) {
        return sanPhamRepository.addSP(sp);
    }

    @Override
    public Integer updateSP(SanPham sp) {
        return sanPhamRepository.updateSP(sp);
    }






   
   
 
    
}
