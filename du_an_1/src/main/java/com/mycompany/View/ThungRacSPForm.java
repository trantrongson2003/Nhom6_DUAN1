/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.Service.ChiTietSPService;
import com.mycompany.Service.IPM.CTSPSerivceIpm;
import com.mycompany.ViewModel.NhanVien.NhanVienViewModel;
import com.mycompany.ViewModel.SanPham.SanPhamViewModelSP;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kunrl
 */
public class ThungRacSPForm extends javax.swing.JFrame {

    /**
     * Creates new form ThungRacKHForm
     */
    ChiTietSPService chiTietSPService = new CTSPSerivceIpm();
    ChiTietSPService ctsp = new CTSPSerivceIpm();

    public ThungRacSPForm() {
        initComponents();
        setLocationRelativeTo(null);
        LoadTable();
    }

    private void LoadTable() {
        DefaultTableModel model = (DefaultTableModel) tblThungRacSP.getModel();
        model.setRowCount(0);
        for (SanPhamViewModelSP nv : ctsp.getAllSPNgungKinhDoanh()) {
            model.addRow(new Object[]{
                nv.getMa(), nv.getTen(), nv.getMauSac(), nv.getNhaSanXuat(),
                nv.getChatLieuDeGiay(), nv.getHang(),
                nv.getLoai(), nv.getSize(), nv.getSoLuong(), nv.getGiaNhap(), nv.getGiaBan(), nv.getTrangThai() == 0 ? "Đang Kinh Doamh" : "Ngừng Kinh Doanh", nv.getBarcode()
            });
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

        PopMenu = new javax.swing.JPopupMenu();
        MenuKhoiPhucKH = new javax.swing.JMenuItem();
        MenuXoaKH = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThungRacSP = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        MenuKhoiPhucKH.setText("Khôi phục");
        MenuKhoiPhucKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuKhoiPhucKHActionPerformed(evt);
            }
        });
        PopMenu.add(MenuKhoiPhucKH);

        MenuXoaKH.setText("Xóa");
        MenuXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuXoaKHActionPerformed(evt);
            }
        });
        PopMenu.add(MenuXoaKH);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icons/reload.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        tblThungRacSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Màu Sắc", "Nhà Sản Xuất", "Nhà Cung Cấp", "Hãng", "Loại ", "Size", "Số Lượng", "Giá Nhập", "Giá Bán", "Trạng Thái", "Barcode"
            }
        ));
        tblThungRacSP.setOpaque(false);
        tblThungRacSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblThungRacSPMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblThungRacSP);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Thùng Rác Sản Phẩm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel2)
                .addGap(200, 200, 200)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tblThungRacSPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThungRacSPMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger() && tblThungRacSP.getSelectedRowCount() != 0) {
                PopMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tblThungRacSPMouseReleased

    private void MenuKhoiPhucKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuKhoiPhucKHActionPerformed
        // TODO add your handling code here:
        try {
            int row = tblThungRacSP.getSelectedRow();
            String id = null;
            if (row == - 1) {
                JOptionPane.showMessageDialog(this, "Mởi Chọn Dòng");
                return;
            }

            int comfirm = JOptionPane.showConfirmDialog(this, "Xác Nhận Khôi Phục", "Khôi Phục", JOptionPane.YES_NO_OPTION);
            if (comfirm != JOptionPane.YES_OPTION) {
                return;
            }

            for (int i = 0; i < chiTietSPService.getAllSPNgungKinhDoanh().size(); i++) {
                if (chiTietSPService.getAllSPNgungKinhDoanh().get(i).getMa().equals(tblThungRacSP.getValueAt(row, 0))) {

                    id = chiTietSPService.getAllSPNgungKinhDoanh().get(i).getId();
                }

            }
            if (chiTietSPService.KhoiPhuc(id) > 0) {
                LoadTable();
                SanPhamChiTietPanel.sanPhamPanel.fillTable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuKhoiPhucKHActionPerformed

    private void MenuXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuXoaKHActionPerformed
        // TODO add your handling code here:
        try {
            int row = tblThungRacSP.getSelectedRow();
            String id = null;
            if (row == - 1) {
                JOptionPane.showMessageDialog(this, "Mởi Chọn Dòng");
                return;
            }

            int comfirm = JOptionPane.showConfirmDialog(this, "Xác Nhận Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
            if (comfirm != JOptionPane.YES_OPTION) {
                return;
            }

            for (int i = 0; i < chiTietSPService.getAllSPNgungKinhDoanh().size(); i++) {
                if (chiTietSPService.getAllSPNgungKinhDoanh().get(i).getMa().equals(tblThungRacSP.getValueAt(row, 0))) {

                    id = chiTietSPService.getAllSPNgungKinhDoanh().get(i).getId();
                }
            }
            chiTietSPService.delete(id);
            LoadTable();
            JOptionPane.showMessageDialog(this, "Xóa Thành Công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_MenuXoaKHActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThungRacSPForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThungRacSPForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThungRacSPForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThungRacSPForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThungRacSPForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuKhoiPhucKH;
    private javax.swing.JMenuItem MenuXoaKH;
    private javax.swing.JPopupMenu PopMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThungRacSP;
    // End of variables declaration//GEN-END:variables
}