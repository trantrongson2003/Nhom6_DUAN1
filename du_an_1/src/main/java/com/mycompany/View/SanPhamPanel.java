/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.DomainModels.*;
import com.mycompany.Service.*;
import com.mycompany.Service.IPM.*;
import com.mycompany.ViewModel.BanHang.HoaDonViewModels;
import com.mycompany.ViewModel.BanHang.SanPhamViewModelBanHang;
import com.mycompany.ViewModel.NhanVien.NhanVienViewModel;
import com.mycompany.ViewModel.SanPham.SanPhamViewModelSP;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kunrl
 */
public class SanPhamPanel extends javax.swing.JPanel {

    MauSacService msSacService = new MauSacServiceImp();
    HangService hangService = new HangServiceImp();
    LoaiSPService loaiSPService = new LoaiSPServiceImp();
    NhaCungCapService nhaCungCapService = new NhaCungCapServiceImp();
    NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImp();
    ChiTietSPService ctspsService = new CTSPSerivceIpm();
    SanPhamService spService = new SanPhamServiceImp();
    public static SanPhamPanel sanPhamPanel;

    int count = 1;
    int tongsoTrang = 1;
    int tranghientai = 0;

    public SanPhamPanel() {
        initComponents();
        sanPhamPanel = this;
        loadCBBMS();
        loadCBBLoai();
        loadCBBHang();
        loadCBBNCC();
        loadCBBNSX();
        fillTable();
        loadTableChiTietSP(ctspsService.getAllSPDangKinhDoanh());
        if (ctspsService.totalCount() % 5 == 0) {
            tongsoTrang = (int) (ctspsService.totalCount() / 5);
        } else {
            tongsoTrang = (int) (ctspsService.totalCount() / 5 + 1);
        }

    }

    public void loadTableChiTietSP(List<SanPhamViewModelSP> sp) {
        DefaultTableModel dtm1 = (DefaultTableModel) tblSP.getModel();
        dtm1.setRowCount(0);
        lblTotal.setText("Total: " + ctspsService.totalCount());
        count = sp.size();
        if (count % 5 == 0) {
            tongsoTrang = count / 5;
        } else {
            tongsoTrang = count / 5 + 1;
        }
        int n = 5 * (tranghientai);
        int m = n + 5;
        if (count % 5 == 0) {
            for (int i = n; i < m; i++) {
                dtm1.addRow(new Object[]{sp.get(i).getMa(),
                    sp.get(i).getTen(), sp.get(i).getMauSac(),
                    sp.get(i).getNhaSanXuat(), sp.get(i).getNhaCungCap(),
                    sp.get(i).getHang(),
                    sp.get(i).getLoai(), sp.get(i).getSize(),
                    sp.get(i).getSoLuong(), sp.get(i).getGiaNhap(),
                    sp.get(i).getGiaBan(),
                    sp.get(i).getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh",
                    sp.get(i).getBarcode()
                });
            }

        } else {
            if (tranghientai == tongsoTrang - 1) {
                int k = n + count % 5;
                for (int i = n; i < k; i++) {
                    dtm1.addRow(new Object[]{sp.get(i).getMa(),
                        sp.get(i).getTen(), sp.get(i).getMauSac(),
                        sp.get(i).getNhaSanXuat(), sp.get(i).getNhaCungCap(),
                        sp.get(i).getHang(),
                        sp.get(i).getLoai(), sp.get(i).getSize(),
                        sp.get(i).getSoLuong(), sp.get(i).getGiaNhap(),
                        sp.get(i).getGiaBan(),
                        sp.get(i).getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh",
                        sp.get(i).getBarcode()
                    });
                }
            } else {
                for (int i = n; i < m; i++) {
                    dtm1.addRow(new Object[]{sp.get(i).getMa(),
                        sp.get(i).getTen(), sp.get(i).getMauSac(),
                        sp.get(i).getNhaSanXuat(), sp.get(i).getNhaCungCap(),
                        sp.get(i).getHang(),
                        sp.get(i).getLoai(), sp.get(i).getSize(),
                        sp.get(i).getSoLuong(), sp.get(i).getGiaNhap(),
                        sp.get(i).getGiaBan(),
                        sp.get(i).getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh",
                        sp.get(i).getBarcode()
                    });
                }
            }

        }
        lblTrang.setText(tranghientai + 1 + "/" + tongsoTrang);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        cbbMS = new javax.swing.JComboBox<MauSac>();
        btnAddms = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbbNSX = new javax.swing.JComboBox<NhaSanXuat>();
        cbbNCC = new javax.swing.JComboBox<NhaCungCap>();
        cbbHang = new javax.swing.JComboBox<Hang>();
        cbbLoai = new javax.swing.JComboBox<LoaiSP>();
        txtSoLuong = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnAddNsx = new javax.swing.JButton();
        btnAddncc = new javax.swing.JButton();
        btnAddhang = new javax.swing.JButton();
        btnAddloai = new javax.swing.JButton();
        btnThungRac = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        txtSize = new javax.swing.JTextField();
        txtSize2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLui1 = new javax.swing.JButton();
        btnTien1 = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnTien = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        lblTrang = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(892, 595));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(1023, 605));

        jLabel5.setText("Mã sản phẩm");

        jLabel6.setText("Màu sắc");

        jLabel7.setText("Tên sản phẩm");

        jLabel8.setText("Nhà cung cấp");

        jLabel9.setText("Hãng");

        jLabel10.setText("Loại");

        btnThem.setBackground(new java.awt.Color(0, 255, 102));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addSanPham.png"))); // NOI18N
        btnThem.setText("   Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 255, 102));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reload.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 255, 102));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        cbbMS.setModel(new javax.swing.DefaultComboBoxModel<>());

        btnAddms.setBackground(new java.awt.Color(255, 255, 0));
        btnAddms.setForeground(new java.awt.Color(255, 255, 0));
        btnAddms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnAddms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddmsActionPerformed(evt);
            }
        });

        jLabel12.setText("Size");

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "37", "38", "39", "40" }));

        jLabel13.setText("Nhà sản xuất");

        cbbNSX.setModel(new javax.swing.DefaultComboBoxModel<>());

        cbbNCC.setModel(new javax.swing.DefaultComboBoxModel<>());

        cbbHang.setModel(new javax.swing.DefaultComboBoxModel<>());

        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>());

        jLabel14.setText("Số lượng");

        jLabel15.setText("Giá nhập");

        jLabel16.setText("Giá bán");

        btnAddNsx.setBackground(new java.awt.Color(255, 255, 0));
        btnAddNsx.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNsx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnAddNsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNsxActionPerformed(evt);
            }
        });

        btnAddncc.setBackground(new java.awt.Color(255, 255, 0));
        btnAddncc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnAddncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddnccActionPerformed(evt);
            }
        });

        btnAddhang.setBackground(new java.awt.Color(255, 255, 0));
        btnAddhang.setForeground(new java.awt.Color(255, 255, 255));
        btnAddhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnAddhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddhangActionPerformed(evt);
            }
        });

        btnAddloai.setBackground(new java.awt.Color(255, 255, 0));
        btnAddloai.setForeground(new java.awt.Color(255, 255, 0));
        btnAddloai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnAddloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddloaiActionPerformed(evt);
            }
        });

        btnThungRac.setBackground(new java.awt.Color(255, 51, 51));
        btnThungRac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnThungRac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThungRacActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(51, 255, 51));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnRemove.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel1.setText("Barcode");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(37, 37, 37))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(43, 43, 43)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBarcode)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(123, 123, 123)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddloai, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNSX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAddNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(btnAddhang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAddncc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(42, 42, 42)
                        .addComponent(cbbMS, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddms, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addComponent(btnThungRac, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi)
                .addGap(287, 287, 287))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddncc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddhang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnThungRac, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddloai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbbMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)))
                                    .addComponent(btnAddms, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Màu sắc", "Nhà sản xuất", "Nhà cung cấp", "Hãng", "Loại", "Size", "số lượng", "Giá nhập", "Giá bán", "Trạng thái", "Barcode"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSP);

        txtSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSizeMouseClicked(evt);
            }
        });
        txtSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSizeActionPerformed(evt);
            }
        });

        txtSize2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSize2CaretUpdate(evt);
            }
        });
        txtSize2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSize2ActionPerformed(evt);
            }
        });

        jLabel2.setText("đến");

        jLabel4.setText("Lọc Khoảng Giá Bán");

        jLabel3.setForeground(new java.awt.Color(250, 250, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N

        btnLui1.setText("<<");
        btnLui1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLui1ActionPerformed(evt);
            }
        });

        btnTien1.setText(">>");
        btnTien1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTien1ActionPerformed(evt);
            }
        });

        lblTotal.setText("Total: 0");

        btnTien.setText(">");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });

        btnLui.setText("<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        lblTrang.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(txtSize2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnLui1)
                                .addGap(18, 18, 18)
                                .addComponent(btnLui)
                                .addGap(32, 32, 32)
                                .addComponent(lblTrang)
                                .addGap(28, 28, 28)
                                .addComponent(btnTien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTien1)
                                .addGap(27, 27, 27)
                                .addComponent(lblTotal)
                                .addGap(337, 337, 337))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSize2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLui)
                    .addComponent(btnTien)
                    .addComponent(btnLui1)
                    .addComponent(btnTien1)
                    .addComponent(lblTotal)
                    .addComponent(lblTrang))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {                                   
        try {
            showForm(tblSP.getSelectedRow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                  

    private void btnAddloaiActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        new LoaiSPForm().setVisible(true);
    }                                          

    private void btnAddhangActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        new HangForm().setVisible(true);
    }                                          

    private void btnAddnccActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        new NCCForm().setVisible(true);
    }                                         

    private void btnAddNsxActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        new NSXForm().setVisible(true);
    }                                         

    private void btnAddmsActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        new MauSacForm().setVisible(true);
    }                                        

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtMa.setText("");
        txtSoLuong.setText("");
        txtTen.setText("");
        cbbHang.setSelectedIndex(0);
        cbbLoai.setSelectedIndex(0);
        cbbMS.setSelectedIndex(0);
        cbbNCC.setSelectedIndex(0);
        cbbNSX.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtBarcode.setText("");
    }                                         

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (tblSP.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Lỗi");
            return;
        }
        if (txtBarcode.getText().isBlank() || txtGiaBan.getText().isBlank() || txtSoLuong.getText().isBlank() || txtGiaNhap.getText().isBlank() || txtTen.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Đầy Đủ Thông Tin");
            return;
        }
        int soluong;
        try {
            soluong = Integer.parseInt(txtSoLuong.getText());
            if (soluong < 0) {
                JOptionPane.showMessageDialog(this, "Số Lượng Không Được Âm");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Là Số");
            return;
        }
        MauSac ms = (MauSac) cbbMS.getSelectedItem();
        LoaiSP loai = (LoaiSP) cbbLoai.getSelectedItem();
        NhaCungCap ncc = (NhaCungCap) cbbNCC.getSelectedItem();
        NhaSanXuat nsx = (NhaSanXuat) cbbNSX.getSelectedItem();
        Hang hang = (Hang) cbbHang.getSelectedItem();
        SanPham sp = new SanPham();
        sp.setMa(txtMa.getText());
        sp.setTen(txtTen.getText());

        if (spService.updateSP(sp) > 0) {
            ChiTietSP ctsp = new ChiTietSP();
            for (int i = 0; i < ctspsService.getAllSPDangKinhDoanh().size(); i++) {
                if (ctspsService.getAllSPDangKinhDoanh().get(i).getMa().equals(tblSP.getValueAt(tblSP.getSelectedRow(), 0))) {
                    ctsp.setId(ctspsService.getAllSPDangKinhDoanh().get(i).getId());
                }
            }
            ctsp.setSanPham(sp);
            ctsp.setMauSac(ms);
            ctsp.setLoaiSP(loai);
            ctsp.setNcc(ncc);
            ctsp.setNsx(nsx);
            ctsp.setHang(hang);
            ctsp.setSize((Integer.valueOf(cbbSize.getSelectedItem().toString())));
            ctsp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
            ctsp.setGiaNhap(new BigDecimal(txtGiaNhap.getText()));
            ctsp.setGiaBan(new BigDecimal(txtGiaBan.getText()));
            ctsp.setTrangThai(0);
            ctsp.setBarcode(txtBarcode.getText());
            if (ctspsService.Update(ctsp) > 0) {
                fillTable();
                btnLamMoiActionPerformed(evt);
            }
        }
        JOptionPane.showMessageDialog(this, "Sửa thành công");

    }                                      

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (txtBarcode.getText().isBlank() || txtGiaBan.getText().isBlank() || txtSoLuong.getText().isBlank() || txtGiaNhap.getText().isBlank() || txtTen.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Cui Lòng Nhập Đầy Đủ Thông Tin");
            return;
        }
        int soluong;
        try {
            soluong = Integer.parseInt(txtSoLuong.getText());
            if (soluong < 0) {
                JOptionPane.showMessageDialog(this, "Số Lượng Không Được Âm");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Là Số");
            return;
        }

        try {
            MauSac ms = (MauSac) cbbMS.getSelectedItem();
            LoaiSP loai = (LoaiSP) cbbLoai.getSelectedItem();
            NhaCungCap ncc = (NhaCungCap) cbbNCC.getSelectedItem();
            NhaSanXuat nsx = (NhaSanXuat) cbbNSX.getSelectedItem();
            Hang hang = (Hang) cbbHang.getSelectedItem();
            SanPham sp = new SanPham();
            sp.setMa(txtMa.getText());
            sp.setTen(txtTen.getText());
            if (spService.addSP(sp) > 0) {
                System.out.println(sp);
                ChiTietSP ctsp = new ChiTietSP();
                ctsp.setSanPham(sp);
                ctsp.setMauSac(ms);
                ctsp.setLoaiSP(loai);
                ctsp.setNcc(ncc);
                ctsp.setNsx(nsx);
                ctsp.setHang(hang);
                ctsp.setThoiGianBH(5);
                ctsp.setMoTa("Không");
                ctsp.setSize((Integer.valueOf(cbbSize.getSelectedItem().toString())));
                ctsp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
                ctsp.setGiaNhap(new BigDecimal(txtGiaNhap.getText()));
                ctsp.setGiaBan(new BigDecimal(txtGiaBan.getText()));
                ctsp.setTrangThai(0);
                ctsp.setBarcode(txtBarcode.getText());
                System.out.println(ctsp);
                if (ctspsService.add(ctsp) > 0) {
                    fillTable();
                    btnLamMoiActionPerformed(evt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }                                       

    private void btnThungRacActionPerformed(java.awt.event.ActionEvent evt) {                                            
        ThungRacSPForm trsp = new ThungRacSPForm();
        trsp.setVisible(true);
    }                                           

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
            int row = tblSP.getSelectedRow();
            String id = null;
            if (row == - 1) {
                JOptionPane.showMessageDialog(this, "Mởi Chọn Dòng");
                return;
            }

            int comfirm = JOptionPane.showConfirmDialog(this, "Xác Nhận Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
            if (comfirm != JOptionPane.YES_OPTION) {
                return;
            }

            for (int i = 0; i < ctspsService.getAllSPDangKinhDoanh().size(); i++) {
                if (ctspsService.getAllSPDangKinhDoanh().get(i).getMa().equals(tblSP.getValueAt(row, 0))) {

                    id = ctspsService.getAllSPDangKinhDoanh().get(i).getId();
                }

            }
            ctspsService.deletePGG(id);
            ctspsService.UpdateThungRac(id);
            fillTable();
            JOptionPane.showMessageDialog(this, "Đã Được Chuyển Đến Thùng Rác");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                      

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:

    }                                          

    private void txtSizeMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:

    }                                    

    private void txtSizeActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void txtSize2CaretUpdate(javax.swing.event.CaretEvent evt) {                                     
        // TODO add your handling code here:
        try {
            if (txtSize.getText().equals("")) {
                //                txtKhoangGia2.setEnabled(false);
                fillDSSP();
            } else if (txtSize2.getText().equals("")) {
                fillDSSP();
            } else {
                fillDSSPByKhoangGia(new BigDecimal(txtSize.getText()), new BigDecimal(txtSize2.getText()));
            }
        } catch (Exception e) {
        }
    }                                    

    private void txtSize2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {                                       
        // TODO add your handling code here:
        if (txtTimKiem.getText().equals("")) {
            fillDSSP();
        } else {
            fillDSSPBySearch(txtTimKiem.getText());
        }
    }                                      

    private void btnLui1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        tranghientai = 0;
        loadTableChiTietSP(ctspsService.getAllSPDangKinhDoanh());
    }                                       

    private void btnTien1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        tranghientai = tongsoTrang - 1;
        loadTableChiTietSP(ctspsService.getAllSPDangKinhDoanh());
    }                                        

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {                                        
        tranghientai++;
        if (tranghientai > tongsoTrang - 1) {
            tranghientai = tongsoTrang - 1;
        }
        loadTableChiTietSP(ctspsService.getAllSPDangKinhDoanh());
    }                                       

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {                                       
        tranghientai--;
        if (tranghientai < 0) {
            tranghientai = 0;
        }
        loadTableChiTietSP(ctspsService.getAllSPDangKinhDoanh());
    }                                      


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAddNsx;
    private javax.swing.JButton btnAddhang;
    private javax.swing.JButton btnAddloai;
    private javax.swing.JButton btnAddms;
    private javax.swing.JButton btnAddncc;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnLui1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThungRac;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnTien1;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Hang> cbbHang;
    private javax.swing.JComboBox<LoaiSP> cbbLoai;
    private javax.swing.JComboBox<MauSac> cbbMS;
    private javax.swing.JComboBox<NhaCungCap> cbbNCC;
    private javax.swing.JComboBox<NhaSanXuat> cbbNSX;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTrang;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtSize2;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration                   

    public void loadCBBMS() {
        for (MauSac ms : msSacService.GetALLMS()) {
            cbbMS.addItem(ms);
        }

    }

    public void loadCBBLoai() {

        for (LoaiSP loai : loaiSPService.getALLloai()) {
            cbbLoai.addItem(loai);
        }

    }

    public void loadCBBHang() {

        for (Hang h : hangService.GetALLHang()) {
            cbbHang.addItem(h);
        }

    }

    public void loadCBBNCC() {

        for (NhaCungCap ncc : nhaCungCapService.GetALLNCC()) {
            cbbNCC.addItem(ncc);
        }

    }

    public void loadCBBNSX() {

        for (NhaSanXuat nsx : nhaSanXuatService.GetALLNSX()) {
            cbbNSX.addItem(nsx);
        }

    }

    public void fillTable() {
        DefaultTableModel tblModel = (DefaultTableModel) tblSP.getModel();
        tblModel.setRowCount(0);
        for (SanPhamViewModelSP sp : ctspsService.getAllSPDangKinhDoanh()) {
            tblModel.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getMauSac(), sp.getNhaSanXuat(), sp.getNhaCungCap(), sp.getHang(),
                sp.getLoai(), sp.getSize(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(),
                sp.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh", sp.getBarcode()});
        }
    }

    private void showForm(int row) {
        txtMa.setText(tblSP.getValueAt(row, 0).toString());
        txtTen.setText(tblSP.getValueAt(row, 1).toString());
        txtSoLuong.setText(tblSP.getValueAt(row, 8).toString());
        txtGiaNhap.setText(tblSP.getValueAt(row, 9).toString());
        txtGiaBan.setText(tblSP.getValueAt(row, 10).toString());
        cbbSize.setSelectedItem(tblSP.getValueAt(row, 7));
        txtBarcode.setText(tblSP.getValueAt(row, 12).toString());

        Object ms = tblSP.getValueAt(row, 2);
        Integer slMS = cbbMS.getItemCount();
        for (int i = 0; i < slMS; i++) {
            MauSac mauSac = cbbMS.getItemAt(i);
            if (mauSac.getTen().equals((String) ms)) {
                cbbMS.setSelectedIndex(i);
            }
        }
        Object nsx = tblSP.getValueAt(row, 3);
        Integer slnsx = cbbNSX.getItemCount();
        for (int i = 0; i < slnsx; i++) {
            NhaSanXuat nsxMoi = cbbNSX.getItemAt(i);
            if (nsxMoi.getTen().equals((String) nsx)) {
                cbbNSX.setSelectedIndex(i);
            }
        }
        Object ncc = tblSP.getValueAt(row, 4);
        Integer slncc = cbbNCC.getItemCount();
        for (int i = 0; i < slncc; i++) {
            NhaCungCap cungCap = cbbNCC.getItemAt(i);
            if (cungCap.getTen().equals((String) ncc)) {
                cbbNCC.setSelectedIndex(i);
            }
        }
        Object hang = tblSP.getValueAt(row, 5);
        Integer slhang = cbbHang.getItemCount();
        for (int i = 0; i < slhang; i++) {
            Hang hangMoi = cbbHang.getItemAt(i);
            if (hangMoi.getTen().equals((String) hang)) {
                cbbHang.setSelectedIndex(i);
            }
        }
        Object loai = tblSP.getValueAt(row, 6);
        Integer slloai = cbbLoai.getItemCount();
        for (int i = 0; i < slloai; i++) {
            LoaiSP loaiSP = cbbLoai.getItemAt(i);
            if (loaiSP.getTen().equals((String) loai)) {
                cbbLoai.setSelectedIndex(i);
            }
        }

    }

    public void fillDSSP() {
        DefaultTableModel tblModel = (DefaultTableModel) tblSP.getModel();
        DecimalFormat dmf = new DecimalFormat("###.####");
        tblModel.setRowCount(0);
        for (SanPhamViewModelSP sp : ctspsService.getAllSPDangKinhDoanh()) {
            tblModel.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getMauSac(), sp.getNhaSanXuat(), sp.getNhaCungCap(), sp.getHang(), sp.getLoai(), sp.getSize(), sp.getSoLuong(), dmf.format(sp.getGiaNhap()), dmf.format(sp.getGiaBan()), sp.getTrangThai(), sp.getBarcode()});
        }
    }

    public void fillDSSPByKhoangGia(BigDecimal gia, BigDecimal gia2) {
        DefaultTableModel tblModel = (DefaultTableModel) tblSP.getModel();
        DecimalFormat dmf = new DecimalFormat("###.####");
        tblModel.setRowCount(0);
        for (SanPhamViewModelSP sp : ctspsService.getSPByKhoangGia(gia, gia2)) {
            tblModel.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getMauSac(), sp.getNhaSanXuat(), sp.getNhaCungCap(), sp.getHang(), sp.getLoai(), sp.getSize(), sp.getSoLuong(), dmf.format(sp.getGiaNhap()), dmf.format(sp.getGiaBan()), sp.getTrangThai(), sp.getBarcode()});
        }
    }

    public void fillDSSPBySize(Integer size, Integer size2) {
        DefaultTableModel tblModel = (DefaultTableModel) tblSP.getModel();
        DecimalFormat dmf = new DecimalFormat("###.####");
        tblModel.setRowCount(0);
        for (SanPhamViewModelSP sp : ctspsService.getSPBySize(size, size2)) {
            tblModel.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getMauSac(), sp.getNhaSanXuat(), sp.getNhaCungCap(), sp.getHang(), sp.getLoai(), sp.getSize(), sp.getSoLuong(), dmf.format(sp.getGiaNhap()), dmf.format(sp.getGiaBan()), sp.getTrangThai(), sp.getBarcode()});
        }
    }

    public void fillDSSPBySearch(String timKiem) {
        DefaultTableModel tblModel = (DefaultTableModel) tblSP.getModel();
        DecimalFormat dmf = new DecimalFormat("###.####");
        tblModel.setRowCount(0);
        for (SanPhamViewModelSP sp : ctspsService.getSPBySearch(timKiem)) {
            tblModel.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getMauSac(), sp.getNhaSanXuat(), sp.getNhaCungCap(), sp.getHang(), sp.getLoai(), sp.getSize(), sp.getSoLuong(), dmf.format(sp.getGiaNhap()), dmf.format(sp.getGiaBan()), sp.getTrangThai() == 0 ? "Đang Kinh Doanh" : "Ngừng Kinh Doanh", sp.getBarcode()});
        }
    }

}
