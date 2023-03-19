/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.du_an_1.Services;

import com.mycompany.du_an_1.DomainModel.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author kunrl
 */
public interface ChucVuService {

    ArrayList<ChucVu> getListChucVu();

    String insert(ChucVu cv);

    ChucVu getObj(String ma);

    String delete(ChucVu cv);
}
