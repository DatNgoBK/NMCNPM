/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bll.MatchDetailsBLL;
import bll.PlayerBLL;
import dto.MatchDetails;
import dto.Player;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Schedule;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;

/**
 *
 * @author Dat Ngo
 */
public class RegisterCompetitionDetailsUI extends javax.swing.JDialog {

    Schedule schedule;

    /**
     * Creates new form DangKiThiDauForm
     */
    public RegisterCompetitionDetailsUI(Schedule schedule) {
        super();
        this.schedule = schedule;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setRequestFocusEnabled(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Danh Sách Cầu Thủ Đội Nhà");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Danh Sách Cầu Thủ Đội Khách");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Đăng Kí Thi Đấu");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("OK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("In biên bản đăng kí");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4)))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2)
                                .addComponent(jButton3)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        PlayerBLL.receivePlayerInformation(schedule.getHomeTeamID(), jComboBox2);
        PlayerBLL.receivePlayerInformation(schedule.getVisitorTeamID(), jComboBox3);
        addData1();
        addData2();
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MatchDetails matchDetails = new MatchDetails(schedule.getScheduleID(), ((Player) jComboBox2.getSelectedItem()).getPlayerID());
        MatchDetailsBLL.addPlayerInGame(matchDetails);
        addData1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MatchDetails matchDetails = new MatchDetails(schedule.getScheduleID(), ((Player) jComboBox2.getSelectedItem()).getPlayerID());
        MatchDetailsBLL.deletePlayerInGame(matchDetails);
        addData1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MatchDetails matchDetails = new MatchDetails(schedule.getScheduleID(), ((Player) jComboBox3.getSelectedItem()).getPlayerID());
        MatchDetailsBLL.addPlayerInGame(matchDetails);
        addData2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MatchDetails matchDetails = new MatchDetails(schedule.getScheduleID(), ((Player) jComboBox3.getSelectedItem()).getPlayerID());
        MatchDetailsBLL.deletePlayerInGame(matchDetails);
        addData2();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int vt = jTable1.getSelectedRow();
        String name = jTable1.getValueAt(vt, 1).toString();
        for (int i = 0; i < jComboBox2.getItemCount(); i++) {
            if (jComboBox2.getItemAt(i).toString().equals(name)) {
                jComboBox2.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int vt = jTable2.getSelectedRow();
        String name = jTable2.getValueAt(vt, 1).toString();
        for (int i = 0; i < jComboBox3.getItemCount(); i++) {
            if (jComboBox3.getItemAt(i).toString().equals(name)) {
                jComboBox3.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        xuatFile1();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<Player> jComboBox2;
    private javax.swing.JComboBox<Player> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private void addData1() {
        MatchDetailsBLL.updatePlayerInGame(jTable1, schedule.getScheduleID(), schedule.getHomeTeamID());
    }

    private void addData2() {
        MatchDetailsBLL.updatePlayerInGame(jTable2, schedule.getScheduleID(), schedule.getVisitorTeamID());
    }

    /**
     * Tạo file pdf biên bản đăng kí thi đấu
     */
    public void xuatFile1() {
        JFileChooser chooser = new JFileChooser();
        int k = chooser.showSaveDialog(chooser);
        if (k == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                BaseFont base;
                com.itextpdf.text.Document document = new com.itextpdf.text.Document();
                PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream(file + ".pdf"));
                document.open();
                // add header1 paragraph
                Paragraph header1 = new Paragraph();
                base = BaseFont.createFont("c:/windows/fonts/Arial.ttf", BaseFont.IDENTITY_H, true);
                Font font = new Font(base, 11f, Font.BOLD);
                Font font1 = new Font(base, 10f, Font.NORMAL);
                header1.setFont(font);
                header1.add("TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI                CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");
                Paragraph header2 = new Paragraph();
                header2.setFont(font);
                header2.add("                Khoa Giáo dục thể chất                                  Độc lập - Tự do – Hạnh phúc\n"
                        + "                                                                             ----------------------------------\n"
                        + "                                                                                                        \n");
                Paragraph header3 = new Paragraph();
                header3.setFont(new Font(base, 13f, Font.BOLD));
                header3.add("                                            Biên Bản Đăng Kí Thi Đấu Bóng Đá\n\n");
                Paragraph header4 = new Paragraph();
                header4.setFont(new Font(base, 10f, Font.BOLD));
                header4.add("                   Mã trận:     " + schedule.getScheduleID() + "\n"
                        + "                   Ngày:        " + schedule.getDay() + "\n"
                        + "                   Thời gian:   " + schedule.getTime() + "\n"
                        + "                   ID xác nhận: " + schedule.getManagerID() + "\n\n");
                Paragraph para = new Paragraph();
                para.setFont(font1);
                PdfPTable t = new PdfPTable(jTable1.getColumnCount());
                for (int i = 0; i < jTable1.getColumnCount(); i++) {
                    Phrase phrase = new Paragraph();
                    phrase.setFont(font1);
                    phrase.add(jTable1.getColumnName(i));
                    t.addCell(phrase);
                }
                for (int rows = 0; rows < jTable1.getRowCount(); rows++) {
                    for (int cols = 0; cols < jTable1.getColumnCount(); cols++) {
                        Phrase phrase = new Paragraph();
                        phrase.setFont(font1);
                        phrase.add(jTable1.getModel().getValueAt(rows, cols).toString());
                        t.addCell(phrase);
                    }
                }
                PdfPTable t1 = new PdfPTable(jTable2.getColumnCount());
                for (int i = 0; i < jTable2.getColumnCount(); i++) {
                    Phrase phrase = new Paragraph();
                    phrase.setFont(font1);
                    phrase.add(jTable2.getColumnName(i));
                    t1.addCell(phrase);
                }
                for (int rows = 0; rows < jTable2.getRowCount(); rows++) {
                    for (int cols = 0; cols < jTable2.getColumnCount(); cols++) {
                        Phrase phrase = new Paragraph();
                        phrase.setFont(font1);
                        phrase.add(jTable2.getModel().getValueAt(rows, cols).toString());
                        t1.addCell(phrase);

                    }
                }

                para.add("                   Danh Sách Cầu Thủ Đội Chủ Nhà");
                para.add(t);
                para.add("                   Danh Sách Cầu Thủ Đội Khách");
                para.add(t1);

                document.add(header1);
                document.add(header2);
                document.add(header3);
                document.add(header4);
                document.add(para);
                document.close();
                write.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}