/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.HinhThucThanhToan;
import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.HoaDonChiTiet;
import com.mycompany.DomainModels.KhachHang;
import com.mycompany.DomainModels.NhanVien;
import com.mycompany.DomainModels.SanPham;
import com.mycompany.Service.ChiTietSanPhamService;
import com.mycompany.Service.HTThanhToanService;
import com.mycompany.Service.HoaDonChiTietService;
import com.mycompany.Service.HoaDonService;
import com.mycompany.Service.IPM.ChiTietSanPhamImpl;
import com.mycompany.Service.IPM.HDCTServiceIpm;
import com.mycompany.Service.IPM.HTThanhToanServiceIpm;
import com.mycompany.Service.IPM.HoaDonServiceIpm;
import com.mycompany.ViewModel.BanHang.GioHangViewModel;
import com.mycompany.ViewModel.BanHang.HoaDonViewModels;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kunrl
 */
public class BanHangsPenal extends javax.swing.JPanel {

    /**
     * Creates new form BanHangsPenal
     */
    NhanVien nvView;
    ChiTietSanPhamService ctspservice = new ChiTietSanPhamImpl();
    HoaDonService hoadonservice = new HoaDonServiceIpm();
    HoaDonChiTietService hdctser = new HDCTServiceIpm();
    HTThanhToanService htttservice = new HTThanhToanServiceIpm();
    public static String idFormKH = null;
    public static BanHangsPenal banHangsPanel = null;

    public BanHangsPenal(NhanVien nv) {
        initComponents();
        nvView = nv;
        LoadDSSP(1);
        LoadHD();
    }

    public void LoadDSSP(int SoTrang) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblSanPham.getModel();
        DecimalFormat dmf = new DecimalFormat("###.####");
        tblmodel.setRowCount(0);
        for (SanPhamViewModelBanHang sp : ctspservice.getSPBanHang(SoTrang)) {
            tblmodel.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), sp.getMauSac(), sp.getSize(), sp.getSoLunog(), dmf.format(sp.getDonGia())});
        }

    }

    public void LoadHD() {
        DefaultTableModel tblmodel = (DefaultTableModel) tblHoaDon.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        tblmodel.setRowCount(0);
        for (HoaDonViewModels hd : hoadonservice.getAllHD()) {
            tblmodel.addRow(new Object[]{hd.getMa(), sdf.format(hd.getNgayTao()), hd.getTenNV(), hd.getTrangThai()});
        }
    }

    public void fillGioHang(String maHd) {
        DefaultTableModel tblModel = (DefaultTableModel) tblGioHang.getModel();
        DecimalFormat dmf = new DecimalFormat("###.####");
        tblModel.setRowCount(0);
        for (GioHangViewModel gh : hdctser.getAllHDCT(maHd)) {

            tblModel.addRow(new Object[]{gh.getMaSP(), gh.getTenSP(), gh.getSoLuong(), gh.getDonGia(), dmf.format(gh.getThanhTien()), gh.getTrangThai()});
        }
    }

    public String zenMaHD(List<HoaDon> list) {
        String maHD = "HD0";
        return maHD + (list.size() + 1);
    }

    private void showFormHD(int row) {
        txtMaHD.setText(tblHoaDon.getValueAt(row, 0).toString());
        txtNgayTao.setText(tblHoaDon.getValueAt(row, 1).toString());
    }

    int indexMaTrungGH;

    public boolean checkSPGH(String masp, List<GioHangViewModel> list) {
        for (int i = 0; i < list.size(); i++) {
            if (masp.equals(list.get(i).getMaSP())) {
                indexMaTrungGH = i;
                return true;
            }
        }
        return false;
    }

    int indexMaTrungDSSP;

    public boolean checkDSSP(String masp, List<SanPhamViewModelBanHang> list) {
        for (int i = 0; i < list.size(); i++) {
            if (masp.equals(list.get(i).getMaSP())) {
                indexMaTrungDSSP = i;
                return true;
            }
        }
        return false;
    }

    private void clearForm() {
        idFormKH = null;
        txtMaHD.setText("");
        txtNgayTao.setText("");
        txtKhachCanTra.setText("0.0");
        txtKhachTra.setText("");
        txtTongTien.setText("0.0");
        txtTienTraLai.setText("0.0");
        txtSDTKH.setText("");
        txtHoTenKH.setText("");

    }

    public void fillDSSPBySearch(String timKiem) {
        DefaultTableModel tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        for (SanPhamViewModelBanHang sp : ctspservice.getAllBySearch(timKiem)) {
            tblModel.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), sp.getMauSac(), sp.getSize(), sp.getSoLunog(), sp.getDonGia()});
        }
    }
    
      public void fillDSSPByKhoangGia(BigDecimal gia, BigDecimal gia2) {
        DefaultTableModel tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        for (SanPhamViewModelBanHang sp : ctspservice.getAllByKhoangGia(gia, gia2)) {
            tblModel.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), sp.getMauSac(), sp.getSize(), sp.getSoLunog(), sp.getDonGia()});
        }
    }
      
        private void fillHoaDonByTrangThai(int tt) {
        DefaultTableModel tblModel = (DefaultTableModel) tblHoaDon.getModel();
        tblModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (HoaDonViewModels hd : hoadonservice.getAllHDByTrangThai(tt)) {
            tblModel.addRow(new Object[]{hd.getMa(), sdf.format(hd.getNgayTao()), hd.getTenNV(), hd.getTrangThai()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton4 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        popUpMenu = new javax.swing.JPopupMenu();
        menuEdit = new javax.swing.JMenuItem();
        menuXoa = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        rdAll = new javax.swing.JRadioButton();
        rdChuaThanhToan = new javax.swing.JRadioButton();
        rdChoThanhToan = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnTaoHoaDon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemBySearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtkhoanggia1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtkhoanggia2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JLabel();
        txtHoTenKH = new javax.swing.JTextField();
        txtSDTKH = new javax.swing.JTextField();
        btnTTKH = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        txtTienTraLai = new javax.swing.JLabel();
        cbbHTTT = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        btnChoThanhToan = new javax.swing.JButton();
        btnHuyHd = new javax.swing.JButton();
        txtKhachTra = new javax.swing.JTextField();
        txtKhachCK = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtKhachCanTra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jRadioButton4.setText("jRadioButton4");

        jButton3.setText("jButton3");

        menuEdit.setText("jMenuItem1");
        popUpMenu.add(menuEdit);

        menuXoa.setText("jMenuItem2");
        popUpMenu.add(menuXoa);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chờ"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Ngày Tạo", "Tên Người Tạo", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        buttonGroup1.add(rdAll);
        rdAll.setSelected(true);
        rdAll.setText("Tất cả");
        rdAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAllActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdChuaThanhToan);
        rdChuaThanhToan.setText("Chưa thanh toán");
        rdChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChuaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdChoThanhToan);
        rdChoThanhToan.setText("Chờ thanh toán");
        rdChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChoThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(rdAll)
                        .addGap(35, 35, 35)
                        .addComponent(rdChuaThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(rdChoThanhToan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdAll)
                    .addComponent(rdChuaThanhToan)
                    .addComponent(rdChoThanhToan))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane3.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Loại SP", "Màu Sắc", "Size", "Số lượng", "Đơn giá"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tìm kiếm sản phẩm");

        txtTimKiemBySearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemBySearchCaretUpdate(evt);
            }
        });

        jLabel2.setText("Lọc khoảng giá");

        jLabel3.setText("Đến ");

        txtkhoanggia2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtkhoanggia2CaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiemBySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtkhoanggia1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtkhoanggia2)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemBySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtkhoanggia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtkhoanggia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tạo hóa đơn"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Mã HĐ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ngày tạo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("SDT KH");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Họ tên KH");

        txtMaHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMaHD.setText("--");

        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNgayTao.setText("--");

        btnTTKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(135, 135, 135)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHD))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayTao))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTTKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết"));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Tổng tiền");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Khách CK");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Khách cần trả");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Khách trả");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Tiền trả lại");

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTongTien.setText("0.0");

        txtTienTraLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTienTraLai.setText("0.0");

        cbbHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vui lòng Chọn HTTT", "Tiền Mặt", "Chuyển Khoản", "Cả Hai" }));
        cbbHTTT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbHTTTItemStateChanged(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane4.setViewportView(txtGhiChu);

        jButton4.setText("Thanh toán");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnChoThanhToan.setText("Chờ thanh toán");
        btnChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoThanhToanActionPerformed(evt);
            }
        });

        btnHuyHd.setText("Hủy HĐ");
        btnHuyHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHdActionPerformed(evt);
            }
        });

        txtKhachTra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtKhachTraCaretUpdate(evt);
            }
        });

        txtKhachCK.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtKhachCKCaretUpdate(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Hình TTT");

        jLabel8.setText("VNĐ");

        jLabel9.setText("VNĐ");

        jLabel16.setText("VNĐ");

        jLabel17.setText("VNĐ");

        jLabel18.setText("VNĐ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnChoThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuyHd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addComponent(jLabel19)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(59, 59, 59)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbHTTT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKhachTra)
                            .addComponent(txtKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKhachCanTra))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtTongTien))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtKhachCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTienTraLai)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChoThanhToan)
                    .addComponent(btnHuyHd)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        HoaDon hd = new HoaDon();
        hd.setMaHD(zenMaHD(hoadonservice.getAllHDCheckMa()));
        hd.setNgayTao(new Date());
        hd.setNhanVien(nvView);
        hd.setTrangThai(0);
        if (hoadonservice.addHD(hd) > 0) {
            LoadHD();
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        try {
            DecimalFormat dmf = new DecimalFormat("####.####");
            Double tongTien = 0.0;
            List<HoaDonViewModels> lst = hoadonservice.getAllHD();
            showFormHD(tblHoaDon.getSelectedRow());
            fillGioHang(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString());
            HoaDonViewModels hoaDonViewModels = lst.get(tblHoaDon.getSelectedRow());
            if (hoaDonViewModels.getKhachHang() == null) {
                txtSDTKH.setText("");
                txtHoTenKH.setText("");
            } else {
                txtSDTKH.setText(hoaDonViewModels.getKhachHang().getSdt());
                txtHoTenKH.setText(hoaDonViewModels.getKhachHang().getHoTen());
            }
            for (int i = 0; i < hdctser.getAllHDCT(txtMaHD.getText()).size(); i++) {
                tongTien += hdctser.getAllHDCT(txtMaHD.getText()).get(i).getThanhTien();
            }
            txtTongTien.setText(dmf.format(tongTien) + "");
            txtKhachCanTra.setText(txtTongTien.getText() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        try {
            if (tblSanPham.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng Chọn hóa đơn để thêm sản phẩm!!");
                return;
            }
            int row = tblSanPham.getSelectedRow();
            Integer soLuong = null;
            Integer tongSoLuong = Integer.valueOf(tblSanPham.getValueAt(row, 5).toString());
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            ChiTietSP sp = new ChiTietSP();
            String idHD = null;
            String idSP = null;
            HoaDon hd = new HoaDon();
            SanPham masp = new SanPham();
            ChiTietSP ctsp = new ChiTietSP();
            for (int i = 0; i < hoadonservice.getAllHD().size(); i++) {
                if (hoadonservice.getAllHD().get(i).getMa().equals(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0))) {
                    idHD = hoadonservice.getAllHD().get(i).getId();
                }
            }
            for (int i = 0; i < ctspservice.getSPBanHang(1).size(); i++) {
                if (ctspservice.getSPBanHang(1).get(i).getMaSP().equals(tblSanPham.getValueAt(row, 0))) {
                    idSP = ctspservice.getSPBanHang(1).get(i).getId();
                    masp.setMa(ctspservice.getSPBanHang(1).get(i).getMaSP());
                }
            }
            ctsp.setId(idSP);
            ctsp.setSanPham(masp);
            hd.setId(idHD);
            hdct.setChiTietSP(ctsp);
            hdct.setHoaDon(hd);
            Object slNhap = JOptionPane.showInputDialog("Vui Lòng Nhập Số Lượng");
            if (slNhap instanceof String) {
                soLuong = Integer.valueOf(slNhap.toString());
            } else {
                return;
            }
            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập SL lớn hơn 0!");
                return;
            }
            if (soLuong > tongSoLuong) {
                JOptionPane.showMessageDialog(this, "Số Lượng bạn nhập đã lớn hơn Số Lượng trong Kho");
                return;
            }
            hdct.setSoLuong(soLuong);
            hdct.setDonGia(new BigDecimal(tblSanPham.getValueAt(row, 6).toString()));
            tongSoLuong -= soLuong;
            if (checkSPGH(hdct.getChiTietSP().getSanPham().getMa(), hdctser.getAllHDCT(txtMaHD.getText()))) {
                GioHangViewModel gh = hdctser.getAllHDCT(txtMaHD.getText()).get(indexMaTrungGH);
                hdct.setSoLuong(gh.getSoLuong() + soLuong);
                hdct.setId(gh.getId());
                System.out.println(gh.getId());
                if (hdctser.updateSLHDCT(hdct) > 0) {
                    fillGioHang(txtMaHD.getText());
                    sp.setId(idSP);
                    sp.setSoLuong(tongSoLuong);
                    if (ctspservice.updateSPKhiMua(sp) > 0) {
                        LoadDSSP(1);
                    }
                }
            } else {
                if (hdctser.addHDCT(hdct) > 0) {
                    fillGioHang(txtMaHD.getText());
                    sp.setId(idSP);
                    sp.setSoLuong(tongSoLuong);
                    if (ctspservice.updateSPKhiMua(sp) > 0) {
                        LoadDSSP(1);
                    }
                }
            }
            DecimalFormat dmf = new DecimalFormat("####.####");
            Double tongTien = 0.0;
            for (int i = 0; i < hdctser.getAllHDCT(txtMaHD.getText()).size(); i++) {
                tongTien += hdctser.getAllHDCT(txtMaHD.getText()).get(i).getThanhTien();
            }
            txtTongTien.setText(dmf.format(tongTien) + "");
            txtKhachCanTra.setText(txtTongTien.getText() + "");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtKhachTraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtKhachTraCaretUpdate
        // TODO add your handling code here:
        try {
            DecimalFormat dmf = new DecimalFormat("####.####");
            Double khachCanTra = Double.parseDouble(txtKhachCanTra.getText());
            Double khachTra = Double.parseDouble(txtKhachTra.getText());
            Double khachCK = Double.parseDouble(txtKhachCK.getText());
            if ((khachTra + khachCK) < 0) {
                txtTienTraLai.setText("0.0");
                return;
            }
            double tongTien = (khachTra + khachCK) - khachCanTra;
            txtTienTraLai.setText(dmf.format(tongTien) + "");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtKhachTraCaretUpdate

    private void txtKhachCKCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtKhachCKCaretUpdate
        try {
            DecimalFormat dmf = new DecimalFormat("####.####");
            Double khachCanTra = Double.parseDouble(txtKhachCanTra.getText());
            Double khachTra = Double.parseDouble(txtKhachTra.getText());
            Double khachCK = Double.parseDouble(txtKhachCK.getText());
            if ((khachTra + khachCK) < 0) {
                txtTienTraLai.setText("0.0");
                return;
            }
            double tongTien = (khachTra + khachCK) - khachCanTra;
            txtTienTraLai.setText(dmf.format(tongTien) + "");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtKhachCKCaretUpdate

    private void cbbHTTTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbHTTTItemStateChanged
        // TODO add your handling code here:
        if (cbbHTTT.getSelectedIndex() == 0) {
            txtKhachTra.setEnabled(false);
            txtKhachCK.setEnabled(false);
            txtKhachTra.setText("0.0");
            txtKhachCK.setText("0.0");
        } else if (cbbHTTT.getSelectedIndex() == 1) {
            txtKhachCK.setEnabled(false);
            txtKhachTra.setEnabled(true);
            txtKhachCK.setText("0.0");
        } else if (cbbHTTT.getSelectedIndex() == 2) {
            txtKhachTra.setEnabled(false);
            txtKhachCK.setEnabled(true);
            txtKhachTra.setText("0.0");

        } else {
            txtKhachTra.setEnabled(true);
            txtKhachCK.setEnabled(true);
            txtKhachTra.setText("0.0");
            txtKhachCK.setText("0.0");
        }
    }//GEN-LAST:event_cbbHTTTItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            if (tblHoaDon.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn rồi thanh toán");
                return;
            }
            if (tblHoaDon.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Giỏ hàng đang trống không thể thanh toán");
                return;
            }
            Double khachCanTra = Double.parseDouble(txtKhachCanTra.getText());
            Double khachTra = Double.parseDouble(txtKhachTra.getText());
            Double khachCK = Double.parseDouble(txtKhachCK.getText());
            if ((khachTra + khachCK) < khachCanTra) {
                JOptionPane.showMessageDialog(this, "Số tiền khách đưa nhỏ hơn số tiền cần thanh toán");
                return;
            }
            String idHD = null;
            HoaDon hd = new HoaDon();
            KhachHang kh = new KhachHang();
            HinhThucThanhToan httt = new HinhThucThanhToan();
            kh.setId(idFormKH);
            for (int i = 0; i < hoadonservice.getAllHD().size(); i++) {
                if (hoadonservice.getAllHD().get(i).getMa().equals(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0))) {
                    idHD = hoadonservice.getAllHD().get(i).getId();
                }
            }
            hd.setId(idHD);
            hd.setTongTien(new BigDecimal(txtTongTien.getText()));
            hd.setKhachHang(kh);
            hd.setTrangThai(5);
            hd.setNgayThanhToan(new Date());
            hd.setGhiChu(txtGhiChu.getText());
            httt.setHoaDon(hd);
            if (cbbHTTT.getSelectedIndex() == 1) {
                httt.setLoaiThanhToan("tiền mặt");
                httt.setTongTien(new BigDecimal(khachTra));
                httt.setTrangThai(0);
                httt.setNgayThanhToan(new Date());
                htttservice.addHTTT(httt);
            } else if (cbbHTTT.getSelectedIndex() == 2) {
                httt.setLoaiThanhToan("chuyển khoản");
                httt.setTongTien(new BigDecimal(khachTra));
                httt.setTrangThai(0);
                httt.setNgayThanhToan(new Date());
                htttservice.addHTTT(httt);
            } else {
                HinhThucThanhToan httt2 = new HinhThucThanhToan();
                httt2.setHoaDon(hd);
                httt.setLoaiThanhToan("tiền mặt");
                httt.setTongTien(new BigDecimal(khachTra));
                httt.setTrangThai(0);
                httt.setNgayThanhToan(new Date());
                htttservice.addHTTT(httt);
                httt2.setLoaiThanhToan("chuyển khoản");
                httt2.setTongTien(new BigDecimal(khachTra));
                httt2.setTrangThai(0);
                httt2.setNgayThanhToan(new Date());
                htttservice.addHTTT(httt2);
            }
            if (hoadonservice.updateHD(hd) > 0) {
                JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
                int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn In Hóa Đơn không ?");
                if (luaChon == JOptionPane.YES_OPTION) {
                    new InHoaDon_JFrame().setVisible(true);
                    LoadDSSP(1);
                    fillGioHang("");
                      clearForm();
                } else {
                    LoadDSSP(1);
                    fillGioHang("");
                    clearForm();
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnTTKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTKHActionPerformed
        new KhachHangBanHang_JFrame().setVisible(true);
    }//GEN-LAST:event_btnTTKHActionPerformed

    private void btnChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoThanhToanActionPerformed
        try {
            if (tblHoaDon.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn Hóa đơn rồi mới thanh toán");
                return;
            }
            if (tblGioHang.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Giỏ hàng đang trống không thể thanh toán");
                return;
            }
            String idHD = null;
            HoaDon hd = new HoaDon();
            KhachHang kh = new KhachHang();
            hd.setId(idFormKH);
            for (int i = 0; i < hoadonservice.getAllHD().size(); i++) {
                if (hoadonservice.getAllHD().get(i).getMa().equals(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0))) {
                    idHD = hoadonservice.getAllHD().get(i).getId();
                }
            }
            hd.setId(idHD);
            hd.setTongTien(new BigDecimal(txtTongTien.getText()));
            hd.setKhachHang(kh);
            hd.setTrangThai(1);
            if (hoadonservice.updateHD(hd) > 0) {
                JOptionPane.showMessageDialog(this, "Hóa đơn đã chuyển sang chờ thanh toán");
                LoadHD();
                fillGioHang("");
                clearForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnChoThanhToanActionPerformed

    private void btnHuyHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHdActionPerformed
        // TODO add your handling code here:
        try {
            if (tblHoaDon.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn Hóa đơn muốn hủy");
                return;
            }
            if (tblGioHang.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Giỏ hàng đang trống không thể hủy");
                return;
            }
            Integer soluongGH = null;
            String maSPGH = null;
            String idSP = null;
            HoaDon hd = new HoaDon();

            Object traloi = JOptionPane.showInputDialog(this, "Vui lòng nhập lý do hủy");
            if (traloi instanceof String) {
                hd.setGhiChu(traloi.toString());
                hd.setNgayThanhToan(new Date());
            } else {
                return;
            }
            hd.setId(idFormKH);
            for (int i = 0; i < hoadonservice.getAllHD().size(); i++) {
                if (hoadonservice.getAllHD().get(i).getMa().equals(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0))) {
                    hd.setId(hoadonservice.getAllHD().get(i).getId());
                }
            }

            for (int i = 0; i < hdctser.getAllHDCT(txtMaHD.getText()).size(); i++) {
                ChiTietSP ctsp = new ChiTietSP();
                for (int j = 0; j < ctspservice.getSPBanHang(1).size(); j++) {
                    SanPhamViewModelBanHang sanPhamViewModelBanHang = ctspservice.getSPBanHang(1).get(i);
                    if (sanPhamViewModelBanHang.getMaSP().equals(hdctser.getAllHDCT(txtMaHD.getText()).get(i).getMaSP())) {
                        ctsp.setId(sanPhamViewModelBanHang.getId());
                        ctsp.setSoLuong((sanPhamViewModelBanHang.getSoLunog() + hdctser.getAllHDCT(txtMaHD.getText()).get(i).getSoLuong()));
                    }
                }
                if (ctspservice.updateSPKhiMua(ctsp) > 0) {
                    LoadDSSP(1);
                }
            }
            hd.setTongTien(new BigDecimal(txtTongTien.getText()));
            hd.setTrangThai(2);
            if (hdctser.deleteHDCTByIDHoaDon(hd.getId()) > 0) {
                if (hoadonservice.updateHD(hd) > 0) {
                    JOptionPane.showMessageDialog(this, "Hủy Hóa Đơn Thành Công!");
                    LoadHD();
                    fillGioHang("");
                    clearForm();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHuyHdActionPerformed

    private void txtTimKiemBySearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemBySearchCaretUpdate
        if (txtTimKiemBySearch.getText().equals("")) {
            LoadDSSP(1);
        } else {
            fillDSSPBySearch(txtTimKiemBySearch.getText());
        }
    }//GEN-LAST:event_txtTimKiemBySearchCaretUpdate

    private void txtkhoanggia2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtkhoanggia2CaretUpdate
        // TODO add your handling code here:
             try {
            if (txtkhoanggia1.getText().equals("")) {
                LoadDSSP(1);
            } else if (txtkhoanggia2.getText().equals("")) {
                LoadDSSP(1);
            } else {
                fillDSSPByKhoangGia(new BigDecimal(txtkhoanggia1.getText()), new BigDecimal(txtkhoanggia2.getText()));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtkhoanggia2CaretUpdate

    private void rdAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAllActionPerformed
        try {
            if (rdAll.isSelected()) {
                LoadHD();    
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdAllActionPerformed

    private void rdChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChuaThanhToanActionPerformed
        // TODO add your handling code here:
         try {
            if (rdChoThanhToan.isSelected()) {
                fillHoaDonByTrangThai(0);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdChuaThanhToanActionPerformed

    private void rdChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChoThanhToanActionPerformed
        // TODO add your handling code here:
           try {
            if (rdChuaThanhToan.isSelected()) {
                fillHoaDonByTrangThai(1);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdChoThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoThanhToan;
    private javax.swing.JButton btnHuyHd;
    private javax.swing.JButton btnTTKH;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbHTTT;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenuItem menuEdit;
    private javax.swing.JMenuItem menuXoa;
    private javax.swing.JPopupMenu popUpMenu;
    private javax.swing.JRadioButton rdAll;
    private javax.swing.JRadioButton rdChoThanhToan;
    private javax.swing.JRadioButton rdChuaThanhToan;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtGhiChu;
    public static javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextField txtKhachCK;
    private javax.swing.JTextField txtKhachCanTra;
    private javax.swing.JTextField txtKhachTra;
    public static javax.swing.JLabel txtMaHD;
    public static javax.swing.JLabel txtNgayTao;
    public static javax.swing.JTextField txtSDTKH;
    private javax.swing.JLabel txtTienTraLai;
    private javax.swing.JTextField txtTimKiemBySearch;
    public static javax.swing.JLabel txtTongTien;
    private javax.swing.JTextField txtkhoanggia1;
    private javax.swing.JTextField txtkhoanggia2;
    // End of variables declaration//GEN-END:variables
}
