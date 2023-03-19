/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.du_an_1.Services;

import com.mycompany.du_an_1.DomainModel.Hang;
import java.util.ArrayList;


/**
 *
 * @author phuoc
 */
public interface HangService {
      
    ArrayList<Hang> getlistSanPham();

    String insert(Hang h);

    Hang getObj(String ma);

    String delete(Hang h);
}
