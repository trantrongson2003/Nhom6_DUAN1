/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ViewModel.NhanVien;

import com.mycompany.DomainModels.ChucVu;

/**
 *
 * @author nqtin
 */
public class NhanVienViewModel {
    private String Id;
    private String Ma;
    private String HoTen;
    private String TenTK;
    private String MatKhau;
    private String GioiTinh;
    private String DiaChi;
    private String Sdt;
    private ChucVu tencv;
    private Integer TrangThai;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(String Id, String Ma, String HoTen, String TenTK, String MatKhau, String GioiTinh, String DiaChi, String Sdt, ChucVu tencv, Integer TrangThai) {
        this.Id = Id;
        this.Ma = Ma;
        this.HoTen = HoTen;
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.tencv = tencv;
        this.TrangThai = TrangThai;
    }

    

    
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public ChucVu getTencv() {
        return tencv;
    }

    public void setTencv(ChucVu tencv) {
        this.tencv = tencv;
    }

   
    public Integer getTrangThai() {
       
        return TrangThai;
    }

    public void setTrangThai(Integer TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public String gettrangthai() {
        if(getTrangThai() == 0){
            return "Đang làm";
        }else if(getTrangThai() == 1){
            return"Nghỉ phép";
        }else{
            return"Đã nghỉ";
        }
     
    }

    @Override
    public String toString() {
        return "tencv=" + tencv;
    }
}
