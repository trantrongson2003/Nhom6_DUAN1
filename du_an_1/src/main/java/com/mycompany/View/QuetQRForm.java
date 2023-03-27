/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.View;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.mycompany.DomainModels.ChiTietSP;
import com.mycompany.DomainModels.HoaDon;
import com.mycompany.DomainModels.HoaDonChiTiet;
import com.mycompany.DomainModels.SanPham;
import com.mycompany.Service.ChiTietSPService;
import com.mycompany.Service.HoaDonChiTietService;
import com.mycompany.Service.IPM.CTSPSerivceIpm;
import com.mycompany.Service.IPM.HDCTServiceIpm;
import static com.mycompany.View.BanHangPanel.txtMaHD;
import static com.mycompany.View.BanHangPanel.txtTongTien;
import com.mycompany.ViewModel.BanHang.GioHangViewModel;
import com.mycompany.ViewModel.BanHang.HoaDonViewModels;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kunrl
 */
public class QuetQRForm extends javax.swing.JFrame implements Runnable, ThreadFactory {

    ChiTietSPService chiTietSPService;
    HoaDonChiTietService hoaDonChiTietService;
    ChiTietSPService ctspService;

    String idCTSP = null;
    String maSP = null;

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    int idCheckGh;
    Integer soLuong = null;

    /**
     * Creates new form QuetQRForm
     */
    public QuetQRForm() {
        initComponents();
        setLocationRelativeTo(null);
        initWebCam();
        chiTietSPService = new CTSPSerivceIpm();
        hoaDonChiTietService = new HDCTServiceIpm();
        ctspService = new CTSPSerivceIpm();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKetQua = new javax.swing.JTextField();
        lblKetQua = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLoaiSP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMauSac = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        pnCamera = new javax.swing.JPanel();
        pnWebCam = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quét sản phẩm");

        txtKetQua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtKetQuaCaretUpdate(evt);
            }
        });

        lblKetQua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKetQua.setText("Kết quả");

        lblMaSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaSP.setText("Mã SP");

        txtMaSP.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên SP");

        txtTenSP.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Loại");

        txtLoaiSP.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Màu sắc");

        txtMauSac.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Size");

        txtSize.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số lượng Tồn :");

        txtSoLuong.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Đơn giá");

        txtDonGia.setEnabled(false);

        btnThem.setBackground(new java.awt.Color(51, 255, 51));
        btnThem.setText("Thêm vào giỏ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 0, 51));
        btnThoat.setText("Hủy bỏ");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Thông tin sản phẩm");

        pnCamera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnCamera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnWebCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lblKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(txtTenSP))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnThem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(pnWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addComponent(pnCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMaSP)
                                .addComponent(txtLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        try {
            this.dispose();
        } catch (Exception e) {
        } finally {
            webcam.close();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            Integer tongSLSP = Integer.valueOf(txtSoLuong.getText());
            Integer tongSLuongGH = null;
            HoaDon hd = new HoaDon();
            hd.setId(BanHangPanel.banHangPanel.idHDQRCode);

            SanPham masp = new SanPham();
            masp.setMa(maSP);

            ChiTietSP ctsp = new ChiTietSP();

            ChiTietSP sp = new ChiTietSP();

            ctsp.setId(idCTSP);

            HoaDonChiTiet hdct = new HoaDonChiTiet();

            ctsp.setSanPham(masp);
            hdct.setHoaDon(hd);
            hdct.setChiTietSP(ctsp);
            hdct.setSoLuong(soLuong);
            hdct.setDonGia(new BigDecimal(txtDonGia.getText()));
            tongSLSP -= soLuong;

            if (checkMaTrung(hdct.getChiTietSP().getSanPham().getMa(), (List<GioHangViewModel>) hoaDonChiTietService.getAllHDCT(BanHangPanel.MaHDQRCode))) {
                GioHangViewModel gioHangViewModel = hoaDonChiTietService.getAllHDCT(BanHangPanel.MaHDQRCode).get(idCheckGh);
                tongSLuongGH = gioHangViewModel.getSoLuong();
                hdct.setId(gioHangViewModel.getId());
                hdct.setSoLuong(tongSLuongGH + soLuong);
                if (hoaDonChiTietService.updateSLHDCT(hdct) > 0) {
                    BanHangPanel.banHangPanel.fillGioHang(BanHangPanel.MaHDQRCode);
                    sp.setId(idCTSP);
                    sp.setSoLuong(tongSLSP);
                    if (chiTietSPService.updateSPKhiMua(sp) > 0) {
                        BanHangPanel.banHangPanel.fillDSSP(1);
                        JOptionPane.showMessageDialog(this, "Thêm Vào Giỏ Hàng Thành Công!");
                        this.dispose();
                    }
                }
            } else {
                if (hoaDonChiTietService.addHDCT(hdct) > 0) {
                    BanHangPanel.banHangPanel.fillGioHang(BanHangPanel.banHangPanel.MaHDQRCode);
                    sp.setId(idCTSP);
                    sp.setSoLuong(tongSLSP);
                    if (chiTietSPService.updateSPKhiMua(sp) > 0) {
                        BanHangPanel.banHangPanel.fillDSSP(1);
                        JOptionPane.showMessageDialog(this, "Thêm Vào Giỏ Hàng Thành Công!");
                        this.dispose();
                    }
                }
            }
         DecimalFormat dmf = new DecimalFormat("####.####");
            Double tongTien = 0.0;
            for (int i = 0; i < hoaDonChiTietService.getAllHDCT(txtMaHD.getText()).size(); i++) {
                tongTien += hoaDonChiTietService.getAllHDCT(txtMaHD.getText()).get(i).getThanhTien();
            }
            BanHangPanel.banHangPanel.txtTongTien.setText(dmf.format(tongTien) + "");
            BanHangPanel.banHangPanel.txtKhachCanTra.setText(dmf.format(tongTien) + "");
        } catch (Exception e) {

        } finally {
            webcam.close();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtKetQuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtKetQuaCaretUpdate
        try {
            String barcode = txtKetQua.getText();
            ChiTietSP ctsp = chiTietSPService.getSPByQRCode(barcode);
            idCTSP = ctsp.getId();
            maSP = ctsp.getSanPham().getMa();
            txtMaSP.setText(ctsp.getSanPham().getMa());
            txtTenSP.setText(ctsp.getSanPham().getTen());
            txtLoaiSP.setText(ctsp.getLoaiSP().getTen());
            txtMauSac.setText(ctsp.getMauSac().getTen());
            txtSize.setText(String.valueOf(ctsp.getSize()));
            txtSoLuong.setText(String.valueOf(ctsp.getSoLuong()));
            txtDonGia.setText(String.valueOf(ctsp.getGiaBan()));
            Object kq = JOptionPane.showInputDialog(this, "Vui lòng Nhập Số Lượng Cần Mua ?");
            if (kq instanceof String) {
                soLuong = Integer.valueOf(kq.toString());
            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtKetQuaCaretUpdate

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
            java.util.logging.Logger.getLogger(QuetQRForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuetQRForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuetQRForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuetQRForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuetQRForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblKetQua;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JPanel pnCamera;
    private javax.swing.JPanel pnWebCam;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtKetQua;
    private javax.swing.JTextField txtLoaiSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables

    private void initWebCam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        pnWebCam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 230));
        executor.execute(this);
    }

    public boolean checkMaTrung(String maSP, List<GioHangViewModel> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (maSP.equals(lst.get(i).getMaSP())) {
                idCheckGh = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                Logger.getLogger(QuetQRForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (result != null) {
                txtKetQua.setText(result.getText());
            }

        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
