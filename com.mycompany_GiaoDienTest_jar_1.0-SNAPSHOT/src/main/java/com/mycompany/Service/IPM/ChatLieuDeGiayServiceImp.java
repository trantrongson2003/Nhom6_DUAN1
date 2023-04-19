/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.MauSac;
import com.mycompany.DomainModels.ChatLieuDeGiay;
import com.mycompany.Repository.ChatLieuDeGiayRespository;
import com.mycompany.Util.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.Service.ChatLieuDeGiayService;

/**
 *
 * @author kunrl
 */
public class ChatLieuDeGiayServiceImp implements ChatLieuDeGiayService{
    ChatLieuDeGiayRespository chatlieudegiayrepo = new ChatLieuDeGiayRespository();
  

    @Override
    public void insert(ChatLieuDeGiay sp) {
        chatlieudegiayrepo.insert(sp);
    }

    @Override
    public void update(String id, ChatLieuDeGiay sp) {
        chatlieudegiayrepo.update(id, sp);
    }

    @Override
    public void delete(String Ma) {
        chatlieudegiayrepo.delete(Ma);
    }

    @Override
    public List<ChatLieuDeGiay> GetALLCLDG() {
        return chatlieudegiayrepo.getALLCLDG();
        }
     
}
