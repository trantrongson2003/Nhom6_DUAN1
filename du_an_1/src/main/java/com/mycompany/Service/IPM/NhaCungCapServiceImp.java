/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.MauSac;
import com.mycompany.DomainModels.NhaCungCap;
import com.mycompany.Repository.NhaCungCapRespository;
import com.mycompany.Service.NhaCungCapService;
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
public class NhaCungCapServiceImp implements NhaCungCapService{
    NhaCungCapRespository nhacungcaprespository = new NhaCungCapRespository();
    @Override
    public List<NhaCungCap> GetALLNCC() {
    return nhacungcaprespository.getALLNCC();
    }

    @Override
    public void insert(NhaCungCap sp) {
        nhacungcaprespository.insert(sp);
    }

    @Override
    public void update(String id, NhaCungCap sp) {
        nhacungcaprespository.update(id, sp);
    }

    @Override
    public void delete(String Ma) {
        nhacungcaprespository.delete(Ma);
    }
     
}
