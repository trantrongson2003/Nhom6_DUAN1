/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.LoaiSP;
import com.mycompany.Repository.LoaiSPRespository;
import com.mycompany.Service.LoaiSPService;
import java.util.List;

/**
 *
 * @author kunrl
 */
public class LoaiSPServiceImp implements LoaiSPService{
    LoaiSPRespository loaiSPRespository = new LoaiSPRespository();

    @Override
    public List<LoaiSP> getALLloai() {
        return loaiSPRespository.getALLLoai();
        }

    @Override
    public void insert(LoaiSP sp) {
        loaiSPRespository.insert(sp);
    }

    @Override
    public void update(String id, LoaiSP sp) {
        loaiSPRespository.update(id, sp);
    }

    @Override
    public void delete(String Ma) {
        loaiSPRespository.delete(Ma);
    }
    
}
