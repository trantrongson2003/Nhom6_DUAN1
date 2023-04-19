/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.Hang;
import com.mycompany.Repository.HangRespository;
import com.mycompany.Service.HangService;
import java.util.List;

/**
 *
 * @author kunrl
 */
public class HangServiceImp implements HangService {

    HangRespository hangRespository = new HangRespository();

    @Override
    public List<Hang> GetALLHang() {
        return hangRespository.getALLHang();
    }
    
    @Override
    public void insert(Hang sp) {
        hangRespository.insert(sp);
    }
    
    @Override
    public void update(String id, Hang sp) {
        hangRespository.update(id, sp);
    }
    
    @Override
    public void delete(String Ma) {
        hangRespository.delete(Ma);
    }
    
}
