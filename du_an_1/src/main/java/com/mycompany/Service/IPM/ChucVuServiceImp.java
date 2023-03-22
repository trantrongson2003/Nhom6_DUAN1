/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.ChucVu;
import com.mycompany.Repository.ChucVuRepository;
import com.mycompany.Service.ChucVuSevice;
import java.util.List;

/**
 *
 * @author nqtin
 */
public class ChucVuServiceImp implements ChucVuSevice{
    private ChucVuRepository rep;
     //tinhnqph23160
    
    public ChucVuServiceImp(){
        rep = new ChucVuRepository();
    }
    @Override
    public List<ChucVu> getListChucVu(){
        return rep.getAllChucVu();
    }
    @Override
    public ChucVu InsertChucVu(ChucVu cv){
        return rep.insertChucVu(cv);
    }
     @Override
    public ChucVu updateChucVu(ChucVu cv, String ma, String ten, Integer trangthai){
        return rep.updateChucVu(cv, ma, ten, trangthai);
    }
}
