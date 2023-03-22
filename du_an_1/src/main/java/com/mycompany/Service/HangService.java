/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.Hang;
import java.util.List;

/**
 *
 * @author kunrl
 */
public interface HangService {

    List<Hang> GetALLHang();

    void insert(Hang sp);

    void update(String id, Hang sp);

    void delete(String Ma);
}
