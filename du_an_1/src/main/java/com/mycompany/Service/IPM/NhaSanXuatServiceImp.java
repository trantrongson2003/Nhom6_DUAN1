/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.NhaSanXuat;
import com.mycompany.Repository.NhaSanXuatRespository;
import com.mycompany.Service.NhaSanXuatService;
import java.util.List;

/**
 *
 * @author kunrl
 */
public class NhaSanXuatServiceImp implements NhaSanXuatService{
    NhaSanXuatRespository nhasanxuatrepo = new NhaSanXuatRespository();

    @Override
    public List<NhaSanXuat> GetALLNSX() {
        return nhasanxuatrepo.getALLNSX();
    }

    @Override
    public void insert(NhaSanXuat sp) {
        nhasanxuatrepo.insert(sp);
    }

    @Override
    public void update(String id, NhaSanXuat sp) {
        nhasanxuatrepo.update(id, sp);
    }

    @Override
    public void delete(String Ma) {
        nhasanxuatrepo.delete(Ma);
    }
    
}
