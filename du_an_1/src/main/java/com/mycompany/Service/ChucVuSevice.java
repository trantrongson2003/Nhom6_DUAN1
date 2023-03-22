/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author nqtin
 */
public interface ChucVuSevice {
    //tinhnqph23160

    List<ChucVu> getListChucVu();

    ChucVu InsertChucVu(ChucVu cv);

    ChucVu updateChucVu(ChucVu cv, String ma, String ten, Integer trangthai);
}
