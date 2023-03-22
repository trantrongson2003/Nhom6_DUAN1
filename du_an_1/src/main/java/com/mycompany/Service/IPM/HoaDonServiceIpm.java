/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Service.IPM;

import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.ThongKe;
import com.mycompany.Repository.HoaDonRepository;
import com.mycompany.Service.HoaDonService;
import com.mycompany.ViewModel.BanHang.HoaDonViewModels;
import com.mycompany.ViewModel.hoaDon.QLHoaDonViewModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FPT
 */
public class HoaDonServiceIpm implements HoaDonService {

    private HoaDonRepository hoaDonRepository;

    public HoaDonServiceIpm() {
        this.hoaDonRepository = new HoaDonRepository();
    }

    @Override
    public List<HoaDonViewModels> getAllHD() {
        List<HoaDon> lst = hoaDonRepository.getAllHD();
        List<HoaDonViewModels> lst_view = new ArrayList<>();
        for (HoaDon hoaDon : lst) {
            HoaDonViewModels hoaDonViewModels = new HoaDonViewModels();
            hoaDonViewModels.setId(hoaDon.getId());
            hoaDonViewModels.setMa(hoaDon.getMaHD());
            hoaDonViewModels.setNgayTao(hoaDon.getNgayTao());
            hoaDonViewModels.setTenNV(hoaDon.getNhanVien().getHoTen());
            hoaDonViewModels.setTrangThai(hoaDon.getTrangThai());
            hoaDonViewModels.setNgayShip(hoaDon.getNgayShip());
            hoaDonViewModels.setKhachHang(hoaDon.getKhachHang());
            hoaDonViewModels.setNgayNhanHang(hoaDon.getNgayNhanHang());
            hoaDonViewModels.setNgayDaNhanHang(hoaDon.getNgayDaNhanHang());
            hoaDonViewModels.setPhiShip(hoaDon.getPhiShip());
            hoaDonViewModels.setDiaChiNhan(hoaDon.getDiaChiGiaoHang());
            hoaDonViewModels.setGhiChu(hoaDon.getGhiChu());
            hoaDonViewModels.setSDTNguoiGiaoHang(hoaDon.getSDTNguoiGiaoHang());
            lst_view.add(hoaDonViewModels);
        }
        return lst_view;
    }
    
    @Override
    public int countHoaDon() {
        return hoaDonRepository.countHoaDon();
    }
    @Override
    public Integer addHD(HoaDon hd) {
        return hoaDonRepository.addHD(hd);
    }

    @Override
    public Integer updateHD(HoaDon hd) {
        return hoaDonRepository.updateHD(hd);
    }

    @Override
    public Integer updateHDDatHang(HoaDon hd) {
        return hoaDonRepository.updateHDDatHang(hd);
    }

    @Override
    public List<HoaDon> getAllHDCheckMa() {
        return hoaDonRepository.getAllHDCheckMa();
    }

    @Override
    public Integer updateHDDatHangThanhCong(HoaDon hd) {
        return hoaDonRepository.updateHDDatHangThanhCong(hd);
    }

    @Override
    public List<HoaDonViewModels> getAllHDByTrangThai(int tt) {
        List<HoaDon> lst = hoaDonRepository.getAllHDByTrangThai(tt);
        List<HoaDonViewModels> lst_view = new ArrayList<>();
        for (HoaDon hoaDon : lst) {
            HoaDonViewModels hoaDonViewModels = new HoaDonViewModels();
            hoaDonViewModels.setId(hoaDon.getId());
            hoaDonViewModels.setMa(hoaDon.getMaHD());
            hoaDonViewModels.setNgayTao(hoaDon.getNgayTao());
            hoaDonViewModels.setTenNV(hoaDon.getNhanVien().getHoTen());
            hoaDonViewModels.setTrangThai(hoaDon.getTrangThai());
            hoaDonViewModels.setNgayShip(hoaDon.getNgayShip());
            hoaDonViewModels.setKhachHang(hoaDon.getKhachHang());
            hoaDonViewModels.setNgayNhanHang(hoaDon.getNgayNhanHang());
            hoaDonViewModels.setNgayDaNhanHang(hoaDon.getNgayDaNhanHang());
            hoaDonViewModels.setPhiShip(hoaDon.getPhiShip());
            hoaDonViewModels.setDiaChiNhan(hoaDon.getDiaChiGiaoHang());
            hoaDonViewModels.setGhiChu(hoaDon.getGhiChu());
            hoaDonViewModels.setSDTNguoiGiaoHang(hoaDon.getSDTNguoiGiaoHang());
            lst_view.add(hoaDonViewModels);
        }
        return lst_view;
    }

    @Override
    public List<QLHoaDonViewModel> getAllHDViewQLHD(int soTrang) {
        List<HoaDon> lst = hoaDonRepository.getAllHDViewQLHD(soTrang);
        List<QLHoaDonViewModel> lst_view = new ArrayList<>();
        for (HoaDon hd : lst) {
            String hoTen= null;
            if(hd.getKhachHang() == null){
                hoTen = " ";
            }else{
                hoTen = hd.getKhachHang().getHoTen();
            }
            QLHoaDonViewModel ql = new QLHoaDonViewModel(hd.getMaHD(),
                    hd.getNhanVien().getHoTen(),hoTen,hd.getTongTien()
                    ,hd.getNgayTao(), hd.getNgayThanhToan(), hd.getGhiChu(),hd.getTrangThai());
            
            lst_view.add(ql);
        }
        return lst_view;
    }

    @Override
    public List<QLHoaDonViewModel> getAllHDViewQLHDByTrangThai(Integer trangThai) {
        List<HoaDon> lst = hoaDonRepository.getAllHDViewQLHDByTrangThai(trangThai);
        List<QLHoaDonViewModel> lst_view = new ArrayList<>();
        for (HoaDon hd : lst) {
            String hoTen= null;
            if(hd.getKhachHang() == null){
                hoTen = " ";
            }else{
                hoTen = hd.getKhachHang().getHoTen();
            }
            QLHoaDonViewModel ql = new QLHoaDonViewModel(hd.getMaHD(),
                    hd.getNhanVien().getHoTen(),hoTen,hd.getTongTien()
                    ,hd.getNgayTao(), hd.getNgayThanhToan(), hd.getGhiChu(),hd.getTrangThai());
            
            lst_view.add(ql);
        }
        return lst_view;
    }
    @Override
    public List<QLHoaDonViewModel> getAllHDViewQLHDBySearch(String timKiem) {
         List<HoaDon> lst = hoaDonRepository.getAllHDViewQLHDBySearch(timKiem);
        List<QLHoaDonViewModel> lst_view = new ArrayList<>();
        for (HoaDon hd : lst) {
            String hoTen= null;
            if(hd.getKhachHang() == null){
                hoTen = " ";
            }else{
                hoTen = hd.getKhachHang().getHoTen();
            }
            QLHoaDonViewModel ql = new QLHoaDonViewModel(hd.getMaHD(),
                    hd.getNhanVien().getHoTen(),hoTen,hd.getTongTien()
                    ,hd.getNgayTao(), hd.getNgayThanhToan(), hd.getGhiChu(),hd.getTrangThai());
            
            lst_view.add(ql);
        }
        return lst_view;
    }
    @Override
    public List<QLHoaDonViewModel> getAllHDViewQLHDByNgay(Date ngay, Date ngay2) {
         List<HoaDon> lst = hoaDonRepository.getAllHDViewQLHDByNgay(ngay, ngay2);
        List<QLHoaDonViewModel> lst_view = new ArrayList<>();
        for (HoaDon hd : lst) {
            String hoTen= null;
            if(hd.getKhachHang() == null){
                hoTen = " ";
            }else{
                hoTen = hd.getKhachHang().getHoTen();
            }
            QLHoaDonViewModel ql = new QLHoaDonViewModel(hd.getMaHD(),
                    hd.getNhanVien().getHoTen(),hoTen,hd.getTongTien()
                    ,hd.getNgayTao(), hd.getNgayThanhToan(), hd.getGhiChu(),hd.getTrangThai());
            
            lst_view.add(ql);
        }
        return lst_view;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    //-----------------------------
    @Override
    public List<HoaDonViewModels> GetListHoaSon() {
        List<HoaDonViewModels> list = new ArrayList();
        var HD = hoaDonRepository.getAllHoaDon();
        for (HoaDon hd : HD) {
            list.add(new HoaDonViewModels(hd.getMaHD(), hd.getNgayThanhToan(), hd.getTrangThai(), hd.getTongTien()));
        }
        return list;
    }

    @Override
    public ArrayList<HoaDonViewModels> finbyngaythanhToan(String timkiem) {
        ArrayList<HoaDonViewModels> list = new ArrayList();
        var HD = hoaDonRepository.finByNgayThanhToan(timkiem);
        for (HoaDon hd : HD) {
            list.add(new HoaDonViewModels(hd.getMaHD(), hd.getNgayThanhToan(), hd.getTrangThai(), hd.getTongTien()));
        }
        return list;
    }
    
    @Override
    public ArrayList<HoaDon> finByNgayThanhToanandTrangThai(int ma, int mi) {
        return hoaDonRepository.finByNgayThanhToanandTH(ma,mi);
    }
    
    @Override
    public ArrayList<HoaDonViewModels> finbyngaytrangThai(int ma) {
         ArrayList<HoaDonViewModels> list = new ArrayList();
        var HD = hoaDonRepository.finByTrangThai(ma);
        for (HoaDon hd : HD) {
            list.add(new HoaDonViewModels(hd.getMaHD(), hd.getNgayThanhToan(), hd.getTrangThai(), hd.getTongTien()));
        }
        return list;
    }
    
    @Override
    public List<HoaDonViewModels> finByKhoangNgayThanhToan(Date ngay1, Date ngay2) {
        List<HoaDonViewModels> list = new ArrayList();
        var HD = hoaDonRepository.finByKhoangNgayThanhToan(ngay1,ngay2);
        for (HoaDon hd : HD) {
            list.add(new HoaDonViewModels(hd.getMaHD(), hd.getNgayThanhToan(), hd.getTrangThai(), hd.getTongTien()));
        }
        return list;
    }

    
    


}
