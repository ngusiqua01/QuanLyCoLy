/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycoly.GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import quanlycoly.Database;
import quanlycoly.Utils;
import quanlycoly.items.CongTrinhItem;

/**
 *
 * @author ufo
 */
public class QuanLyThongTinCongTrinh extends javax.swing.JFrame {

    Database mDatabase;

    /**
     * Creates new form QuanLyThongTinCongTrinh
     */
    public QuanLyThongTinCongTrinh() {
        initComponents();
        Utils.setCenterScreen(this);
        initDB();
        initTable();

    }

    public void initDB() {
        mDatabase = Database.newInstance();
    }

    public void initTable() {
        ArrayList<CongTrinhItem> listCongTrinhItems = mDatabase.getListCongTrinh();
        System.out.println("quanlycoly.GUI.QuanLyThongTinCongTrinh.initTable() listCongTrinhItems = " + listCongTrinhItems.size());
        DefaultTableModel model = (DefaultTableModel) tableCongTrinh.getModel();
        int count = model.getRowCount();
        for (int i = 0; i < count; i++) {
            System.out.println("quanlycoly.GUI.QuanLyThongTinCongTrinh.initTable() model.getRowCount() = " + model.getRowCount());
            model.removeRow(0);
        }
        for (int i = 0; i < listCongTrinhItems.size(); i++) {
            CongTrinhItem item = listCongTrinhItems.get(i);
            model.addRow(new Object[]{i + 1, item.getMaCT(), item.getTenCT(), item.getStartDate(),
                item.getEndDate(), item.getX(), item.getY(), item.getZ(), item.getDepth()});
        }

        //============================
        tableCongTrinh.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {

            }
        });

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
        MaCTField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TenCTField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        xDimenField = new javax.swing.JTextField();
        yDimenField = new javax.swing.JTextField();
        zDimenField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCongTrinh = new javax.swing.JTable();
        startDateField = new javax.swing.JFormattedTextField();
        endDateField = new javax.swing.JFormattedTextField();
        lbWarning = new javax.swing.JLabel();
        depthDimenField = new javax.swing.JFormattedTextField();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Thông Tin Công Trình");

        jLabel1.setText("Mã Công Trình:");

        MaCTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaCTFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Công Trình: ");

        jLabel3.setText("Tọa độ X");

        jLabel4.setText("Tọa độ Y");

        jLabel5.setText("Cao độ Z");

        zDimenField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zDimenFieldActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addGap(183, 183, 183)
                .addComponent(btnDelete)
                .addGap(150, 150, 150))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)))
        );

        jLabel6.setText("Ngày Khởi Công");

        jLabel7.setText("Ngày Kết Thúc");

        jLabel8.setText("Chiều sâu LK");

        tableCongTrinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã CT", "Tên CT", "Ngày KC", "Ngày KT", "ToaDo X", "ToaDo Y", "CaoDo Z", "Chiều sâu LK"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCongTrinh.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableCongTrinh.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableCongTrinh);
        if (tableCongTrinh.getColumnModel().getColumnCount() > 0) {
            tableCongTrinh.getColumnModel().getColumn(0).setResizable(false);
            tableCongTrinh.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        startDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        startDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateFieldActionPerformed(evt);
            }
        });

        endDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));

        lbWarning.setForeground(new java.awt.Color(255, 0, 0));

        depthDimenField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MaCTField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TenCTField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(startDateField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(depthDimenField))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(yDimenField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(xDimenField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(zDimenField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MaCTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(xDimenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TenCTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(yDimenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(zDimenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(depthDimenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbWarning.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zDimenFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zDimenFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zDimenFieldActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        lbWarning.setVisible(false);
        int[] indices = tableCongTrinh.getSelectedRows();
        tableCongTrinh.getSelectionModel().removeSelectionInterval(0, indices[indices.length - 1]);

        if (MaCTField.getText() == "" || TenCTField.getText() == "" || startDateField.getText().isEmpty() || endDateField.getText().isEmpty()
                || xDimenField.getText() == "" || yDimenField.getText() == "" || zDimenField.getText() == "" || depthDimenField.getText() == "") {
            lbWarning.setText("vui lòng nhập đầy đủ thông tin");
            lbWarning.setVisible(true);
            return;
        }
        try {
            String maCT = MaCTField.getText();
            String tenCT = TenCTField.getText();
            String inputBeginDate = startDateField.getText();
            System.out.println("quanlycoly.GUI.QuanLyThongTinCongTrinh.btnAddActionPerformed() beginDate = " + inputBeginDate);
            String sqlBeginDate = Utils.convertToDate(inputBeginDate);
            System.out.println("quanlycoly.GUI.QuanLyThongTinCongTrinh.btnAddActionPerformed() sqlDate = " + sqlBeginDate);
            String inputEndDate = endDateField.getText();
            String sqlEndDate = Utils.convertToDate(inputEndDate);

            double x = Double.valueOf(xDimenField.getText());
            double y = Double.valueOf(yDimenField.getText());
            double z = Double.valueOf(zDimenField.getText());
            double depth = Double.valueOf(depthDimenField.getText());

            mDatabase.addCongTrinh(maCT, tenCT, sqlBeginDate, sqlEndDate, x, y, z, depth);

//        double x = xDimenField.getText().t
        } catch (Exception ex) {
            Logger.getLogger(QuanLyThongTinCongTrinh.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        initTable();
        MaCTField.setText("");
        TenCTField.setText("");
        startDateField.setText("");
        endDateField.setText("");
        xDimenField.setText("");
        yDimenField.setText("");
        zDimenField.setText("");
        depthDimenField.setText("");


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        lbWarning.setVisible(false);
        int editIndex = tableCongTrinh.getSelectedRow();
        if (editIndex == -1) {
            lbWarning.setText("bạn cần chọn công trình cần sửa trước ");
            lbWarning.setVisible(true);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tableCongTrinh.getModel();
        String MaCT = model.getValueAt(editIndex, 1).toString();
        EditCongTrinhDialog editDialog = new EditCongTrinhDialog(this, false, MaCT, new EditRowListener() {
            @Override
            public void onSaveChange(String maCT) {
                initTable();
            }
        });

        editDialog.setVisible(true);

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        lbWarning.setVisible(false);
        int[] indicies = tableCongTrinh.getSelectedRows();
        if (indicies.length == 0) {
            lbWarning.setText("vui lòng chọn hàng cần xóa");
            lbWarning.setVisible(true);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableCongTrinh.getModel();
        for (int i = 0; i < indicies.length; i++) {
            String MaCT = model.getValueAt(indicies[i], 1).toString();
            mDatabase.deleteCongTrinh(MaCT);

        }
        Arrays.sort(indicies);
        for (int i = indicies.length - 1; i >= 0; i--) {
            model.removeRow(indicies[i]);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void startDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateFieldActionPerformed

    private void MaCTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaCTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaCTFieldActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Home frameHome = Home.newInstance();
        this.setVisible(false);
        if (!frameHome.isVisible()) {
            frameHome.setVisible(true);
        }
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyThongTinCongTrinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyThongTinCongTrinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyThongTinCongTrinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyThongTinCongTrinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyThongTinCongTrinh().setVisible(true);
            }
        });
    }

    public interface EditRowListener {

        public void onSaveChange(String maCT);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MaCTField;
    private javax.swing.JTextField TenCTField;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JFormattedTextField depthDimenField;
    private javax.swing.JFormattedTextField endDateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbWarning;
    private javax.swing.JFormattedTextField startDateField;
    private javax.swing.JTable tableCongTrinh;
    private javax.swing.JTextField xDimenField;
    private javax.swing.JTextField yDimenField;
    private javax.swing.JTextField zDimenField;
    // End of variables declaration//GEN-END:variables
}
