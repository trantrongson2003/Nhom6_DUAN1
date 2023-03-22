/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.NhaSanXuat;
import java.util.List;

/**
 *
 * @author kunrl
 */
public interface NhaSanXuatService {

    List<NhaSanXuat> GetALLNSX();

    void insert(NhaSanXuat sp);

    void update(String id, NhaSanXuat sp);

    void delete(String Ma);
}
