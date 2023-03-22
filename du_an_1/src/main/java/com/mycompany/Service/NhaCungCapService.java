/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.NhaCungCap;
import java.util.List;

/**
 *
 * @author kunrl
 */
public interface NhaCungCapService {

    List<NhaCungCap> GetALLNCC();

    void insert(NhaCungCap sp);

    void update(String id, NhaCungCap sp);

    void delete(String Ma);
}
