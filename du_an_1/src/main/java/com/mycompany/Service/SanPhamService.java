/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author kunrl
 */
public interface SanPhamService {

    public List<SanPham> getAllChucVu();

     public Integer addSP(SanPham sp);

    public Integer updateSP(SanPham sp);
    
    void delete(String Ma);


}
