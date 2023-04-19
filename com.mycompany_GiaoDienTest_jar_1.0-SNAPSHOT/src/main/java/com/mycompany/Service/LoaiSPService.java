/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.LoaiSP;
import java.util.List;

/**
 *
 * @author kunrl
 */
public interface LoaiSPService {

    List<LoaiSP> getALLloai();

    void insert(LoaiSP sp);

    void update(String id, LoaiSP sp);

    void delete(String Ma);
}
