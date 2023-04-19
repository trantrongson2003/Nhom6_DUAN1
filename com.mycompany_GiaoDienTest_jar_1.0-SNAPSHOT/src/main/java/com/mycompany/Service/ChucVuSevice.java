/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.ChucVu;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nqtin
 */
public interface ChucVuSevice {

    List<ChucVu> getListChucVu();
    
    List<ChucVu> getAll();
    
     void insert(ChucVu cv);
       
       void update(String Ma, ChucVu sp);
       
       void delete(String id);

    ChucVu InsertChucVu(ChucVu cv);

    ChucVu updateChucVu(ChucVu cv, String ma, String ten, Date ngayTao,Integer trangthai);
}
