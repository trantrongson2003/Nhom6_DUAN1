/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.HinhThucThanhToan;
import com.mycompany.Repository.HTThanhToanRepository;
import com.mycompany.Service.HTThanhToanService;


/**
 *
 * @author FPT
 */
public class HTThanhToanServiceIpm implements HTThanhToanService{
    HTThanhToanRepository hTThanhToanRepository;
    public HTThanhToanServiceIpm() {
        this.hTThanhToanRepository = new HTThanhToanRepository();
    }

      
    @Override
    public Integer addHTTT(HinhThucThanhToan httt) {
        return hTThanhToanRepository.addHTTT(httt);
    }
    
    
    
}
