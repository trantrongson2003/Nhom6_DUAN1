package com.mycompany.View;

import com.mycompany.DomainModels.KhachHang;
import com.mycompany.Service.IPM.KHServiceIpm;
import com.mycompany.Service.KHService;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KhachHangPanel extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    KHService svKH = new KHServiceIpm();
    private int row;
    int count = 1;
    int tongsoTrang = 1;
    int tranghientai = 0;

    public KhachHangPanel() {
        initComponents();
//        loadFind(svKH.getList());
loadFind(svKH.find(txt_find.getText().trim()));
    }

    public KhachHang getFormData() {
        String maStr = txtMa.getText().trim();
        String tenStr = txtTen.getText().trim();

        String ngaysinhStr = txtNgaySinh.getText().trim();
        String sdtStr = txtSDT.getText().trim();
        String diachiStr = txtDiaChi.getText().trim();
        int trangThaiStr = 0;
        if (rdLauNam.isSelected()) {
            trangThaiStr = 1;
        }

        if (maStr.equals("") || tenStr.equals("")
                || ngaysinhStr.equals("")
                || sdtStr.equals("") || diachiStr.equals("")) {
            JOptionPane.showMessageDialog(this, "Không Được Để Trống!");
            return null;
        }
        java.sql.Date nsDate = java.sql.Date.valueOf(ngaysinhStr);
        KhachHang kh = new KhachHang(null, maStr, tenStr, nsDate, sdtStr, diachiStr, trangThaiStr);
        return kh;

    }

//    public void loadTable() {
//        model = (DefaultTableModel) tblBang.getModel();
//        model.setRowCount(0);
//        for (KhachHang kh : svKH.getList()) {
//            Object[] rowData = {
//                kh.getMa(),
//                kh.getHoTen(),
//                kh.getNgaySinh(),
//                kh.getSdt(),
//                kh.getDiaChi(),
//                kh.getTrangThai() == 1 ? "Lâu Năm" : "Mới"
//            };
//            model.addRow(rowData);
//
//        }
//    }

    public void loadFind(ArrayList<KhachHang> list) {
        model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0);
        for (KhachHang kh : list) {
            model.addRow(new Object[]{
                kh.getMa(),
                kh.getHoTen(),
                kh.getNgaySinh(),
                kh.getSdt(),
                kh.getDiaChi(),
                kh.getTrangThai()==1?"Lâu năm":"Mới"
            });
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        PopupMenu = new javax.swing.JPopupMenu();
        DeleteMenu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rdLauNam = new javax.swing.JRadioButton();
        rdMoi = new javax.swing.JRadioButton();
        btnThemKH = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXoaKH = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnThungRac = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        txt_find = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        DeleteMenu.setText("Delete");
        DeleteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMenuActionPerformed(evt);
            }
        });
        PopupMenu.add(DeleteMenu);

        jMenuItem2.setText("jMenuItem2");
        PopupMenu.add(jMenuItem2);

        jRadioButton1.setText("jRadioButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setPreferredSize(new java.awt.Dimension(892, 595));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setPreferredSize(new java.awt.Dimension(892, 595));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setPreferredSize(new java.awt.Dimension(892, 595));

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        btnThem.setPreferredSize(new java.awt.Dimension(1023, 605));

        jLabel5.setText("Mã KH");

        jLabel6.setText("Tên KH");

        jLabel8.setText("Ngày sinh");

        jLabel10.setText("Địa chỉ");

        jLabel11.setText("Trạng thái");

        buttonGroup1.add(rdLauNam);
        rdLauNam.setText("Lâu Năm");

        buttonGroup1.add(rdMoi);
        rdMoi.setText("Mới");

        btnThemKH.setBackground(new java.awt.Color(102, 255, 0));
        btnThemKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 255, 0));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(153, 255, 0));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnXoaKH.setBackground(new java.awt.Color(153, 255, 0));
        btnXoaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaKH.setText("Xóa");
        btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKHActionPerformed(evt);
            }
        });

        jLabel13.setText("SDT");

        btnThungRac.setBackground(new java.awt.Color(255, 0, 0));
        btnThungRac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnThungRac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThungRacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnThemLayout = new javax.swing.GroupLayout(btnThem);
        btnThem.setLayout(btnThemLayout);
        btnThemLayout.setHorizontalGroup(
            btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThemLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(39, 39, 39)
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT))
                .addGap(51, 51, 51)
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, btnThemLayout.createSequentialGroup()
                        .addComponent(rdLauNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdMoi))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, btnThemLayout.createSequentialGroup()
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThungRac, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, btnThemLayout.createSequentialGroup()
                            .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnLamMoi))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        btnThemLayout.setVerticalGroup(
            btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnThemLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel6))
                    .addGroup(btnThemLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(btnThemLayout.createSequentialGroup()
                                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(btnThemLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(27, 27, 27)
                                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(rdLauNam)
                                    .addComponent(rdMoi)))
                            .addGroup(btnThemLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(btnThungRac)))))
                .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnThemLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111))
                    .addGroup(btnThemLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ", "HỌ TÊN", "NGÀY SINH", "SDT", "ĐỊA CHỈ", "TRẠNG THÁI"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblBangMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        txt_find.setName(""); // NOI18N
        txt_find.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_findCaretUpdate(evt);
            }
        });
        txt_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_findActionPerformed(evt);
            }
        });
        txt_find.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_findKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 0));
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 389, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 841, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMenuActionPerformed
        KhachHang kh = getFormData();

        int tb = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            svKH.DELETE(kh.getMa());
            loadTableChiTietSP(svKH.getList());
            JOptionPane.showMessageDialog(this, "Xóa Thành Công !");
        } else {
            JOptionPane.showMessageDialog(this, "Đã hủy!");
        }

    }//GEN-LAST:event_DeleteMenuActionPerformed

    private void txt_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_findActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_findActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        if(checkValidate()){
        int row = tblBang.getSelectedRow();

        KhachHang kh = getFormData();
        if (kh == null) {
            return;
        }
        this.svKH.INSERT(kh);
        loadTableChiTietSP(svKH.getList());
        JOptionPane.showMessageDialog(this, "Thêm Thành Công !");
        loadFind(svKH.find(txt_find.getText().trim()));
        }
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
         int row = this.tblBang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để sửa !");
            return;
        }
        if(checkValidate()){
       
        KhachHang kh = getFormData();
        int tb = JOptionPane.showConfirmDialog(this, "Bạn có muốn Sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            svKH.UPDATE(kh, kh.getMa());

            JOptionPane.showMessageDialog(this, "Sửa Thành Công !");
        } else {
            JOptionPane.showMessageDialog(this, "Đã hủy!");
        }
        loadFind(svKH.find(txt_find.getText().trim()));
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMa.setText("");
        txtTen.setText("");
        txtSDT.setText("");
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKHActionPerformed
        int row = this.tblBang.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để xóa !");
                return;
            }
//KhachHang kh = new KhachHang();
 String ma = tblBang.getValueAt(row, 0).toString();

        int tb = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            svKH.DELETE(ma);
            loadTableChiTietSP(svKH.getList());
            JOptionPane.showMessageDialog(this, "Xóa Thành Công !");
        } else {
            JOptionPane.showMessageDialog(this, "Đã hủy!");
        }
        loadFind(svKH.find(txt_find.getText().trim()));
    }//GEN-LAST:event_btnXoaKHActionPerformed

    private void btnThungRacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThungRacActionPerformed
        ThungRacKHForm trkh = new ThungRacKHForm();
        trkh.setVisible(true);
    }//GEN-LAST:event_btnThungRacActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
       int index = tblBang.getSelectedRow();
        txtMa.setText(tblBang.getValueAt(index, 0).toString());
        txtTen.setText(tblBang.getValueAt(index, 1).toString());

        txtSDT.setText(tblBang.getValueAt(index, 3).toString());
        txtNgaySinh.setText(tblBang.getValueAt(index, 2).toString());

        txtDiaChi.setText(tblBang.getValueAt(index, 4).toString());

        if (tblBang.getValueAt(index, 5).toString().equals("Mới")) {
            rdMoi.setSelected(true);
        } else  {
            rdLauNam.setSelected(true);
        }
    }//GEN-LAST:event_tblBangMouseClicked

    private void tblBangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger() && tblBang.getSelectedRowCount() != 0) {
                PopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tblBangMouseReleased

    private void txt_findCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_findCaretUpdate
        String timkiem = txt_find.getText();
        this.svKH.search(timkiem);
//        loadTableChiTietSP(svKH.getList());

        loadFind(svKH.find(txt_find.getText().trim()));
    }//GEN-LAST:event_txt_findCaretUpdate

    private void txt_findKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_findKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_findKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String sdt = txt_find.getText();
        loadFind(svKH.find(sdt));
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DeleteMenu;
    private javax.swing.JPopupMenu PopupMenu;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JPanel btnThem;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThungRac;
    private javax.swing.JButton btnXoaKH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdLauNam;
    private javax.swing.JRadioButton rdMoi;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txt_find;
    // End of variables declaration//GEN-END:variables
 public void loadTableChiTietSP(List<KhachHang> kh) {
//        DefaultTableModel dtm1 = (DefaultTableModel) tblBang.getModel();
//        dtm1.setRowCount(0);
//        lblTotal.setText("Total: " + svKH.totalCount());
//        count = kh.size();
//        if (count % 5 == 0) {
//            tongsoTrang = count / 5;
//        } else {
//            tongsoTrang = count / 5 + 1;
//        }
//        int n = 5 * (tranghientai);
//        int m = n + 5;
//        if (count % 5 == 0) {
//            for (int i = n; i < m; i++) {
//                dtm1.addRow(new Object[]{kh.get(i).getMa(),
//                    kh.get(i).getHoTen(),
//                    kh.get(i).getNgaySinh(),
//                    kh.get(i).getSdt(),
//                    kh.get(i).getDiaChi(),
//                    kh.get(i).getTrangThai() == 1 ? "Lâu Năm" : "Mới",});
//            }
//
//        } else {
//            if (tranghientai == tongsoTrang - 1) {
//                int k = n + count % 5;
//                for (int i = n; i < k; i++) {
//                    dtm1.addRow(new Object[]{kh.get(i).getMa(),
//                        kh.get(i).getHoTen(),
//                        kh.get(i).getNgaySinh(),
//                        kh.get(i).getSdt(),
//                        kh.get(i).getDiaChi(),
//                        kh.get(i).getTrangThai() == 1 ? "Lâu Năm" : "Mới",});
//                }
//            } else {
//                for (int i = n; i < m; i++) {
//                    dtm1.addRow(new Object[]{kh.get(i).getMa(),
//                        kh.get(i).getHoTen(),
//                        kh.get(i).getNgaySinh(),
//                        kh.get(i).getSdt(),
//                        kh.get(i).getDiaChi(),
//                        kh.get(i).getTrangThai() == 1 ? "Lâu Năm" : "Mới",});
//                }
//            }
//            lblTrang.setText(tranghientai + 1 + "/" + tongsoTrang);
//        }
    }
public boolean checkValidate(){
    if(txtDiaChi.getText().isBlank()||txtMa.getText().isBlank()
            ||txtNgaySinh.getText().isBlank()||txtSDT.getText().isBlank()||txtTen.getText().isBlank()){
        JOptionPane.showMessageDialog(this, "Không được để trống");
        return false;
    }
    String sdt = "0[0-9]{9}";
    if(!txtSDT.getText().matches(sdt)){
        JOptionPane.showMessageDialog(this, "SDT phải đúng định dạng");
        return false;
    }
    return true;
}
}
