/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.MauSac;
import com.mycompany.Repository.MauSacRespository;
import com.mycompany.Service.MauSacService;
import com.mycompany.Util.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kunrl
 */
public class MauSacServiceImp implements MauSacService{
    MauSacRespository msRepo = new MauSacRespository();

    @Override
    public List<MauSac> GetALLMS() {
        return msRepo.getALLMS();
    }

    @Override
    public void insert(MauSac sp) {
        msRepo.insert(sp);
    }

    @Override
    public void update(String id, MauSac sp) {
        msRepo.update(id, sp);
    }
    

    @Override
    public void delete(String Ma) {
        msRepo.delete(Ma);
    }
}
