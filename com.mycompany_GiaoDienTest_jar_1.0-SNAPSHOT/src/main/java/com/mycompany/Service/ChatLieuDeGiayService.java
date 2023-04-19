/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.Service;

import com.mycompany.DomainModels.ChatLieuDeGiay;
import java.util.List;

/**
 *
 * @author kunrl
 */
public interface ChatLieuDeGiayService {

    List<ChatLieuDeGiay> GetALLCLDG();

    void insert(ChatLieuDeGiay sp);

    void update(String id, ChatLieuDeGiay sp);

    void delete(String Ma);
}
