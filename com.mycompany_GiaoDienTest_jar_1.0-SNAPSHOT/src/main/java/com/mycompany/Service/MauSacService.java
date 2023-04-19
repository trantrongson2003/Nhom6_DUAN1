/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author kunrl
 */
public interface MauSacService {

    List<MauSac> GetALLMS();

    void insert(MauSac sp);

    void update(String id, MauSac sp);

    void delete(String Ma);
}
