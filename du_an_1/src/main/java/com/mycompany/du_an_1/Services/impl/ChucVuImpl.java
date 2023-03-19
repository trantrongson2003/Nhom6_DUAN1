/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.du_an_1.Services.impl;

import com.mycompany.du_an_1.DomainModel.ChucVu;
import com.mycompany.du_an_1.Respositories.ChucVuRepository;
import com.mycompany.du_an_1.Services.ChucVuService;
import java.util.ArrayList;

/**
 *
 * @author kunrl
 */
public class ChucVuImpl implements ChucVuService{
    public ChucVuRepository chucvurepository = new ChucVuRepository();
    @Override
    public ArrayList<ChucVu> getListChucVu() {
        return chucvurepository.getAll();
    }

    @Override
    public String insert(ChucVu cv) {
    return chucvurepository.insert(cv);
    }

    @Override
    public ChucVu getObj(String ma) {
       return chucvurepository.getObj(ma);
    }

    @Override
    public String delete(ChucVu cv) {
        return chucvurepository.delete(cv);
    }

   

    
 


    
}
