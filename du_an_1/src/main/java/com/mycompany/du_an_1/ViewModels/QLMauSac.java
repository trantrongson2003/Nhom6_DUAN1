/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.du_an_1.ViewModels;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author kunrl
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QLMauSac {
    private int id;
    private String ma;
    private String ten;

    @Override
    public String toString() {
        return ten;
    }
    
}
