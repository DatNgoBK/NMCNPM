/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.CoachDAL;
import dto.Coach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CoachBLL {
    
    public static DefaultTableModel dtm;
    public static DefaultTableModel dtm1;
    
    /**
     * Phương thức lấy thông tin HLV thông qua phương thức truy vấn CSDL để hiển thị lên giao diện
     * @param table Bảng để hiển thị thông tin HLV
     */

    public static void showCoachInformation(JTable table){
        try {
            ResultSet rs = CoachDAL.queryCoachInformation();
            dtm = new DefaultTableModel();
            dtm.addColumn("Mã");
            dtm.addColumn("Tên");
            dtm.addColumn("Vị trí");
            dtm.addColumn("Mail");
            dtm.addColumn("Điện thoại");
            dtm.addColumn("Ngày sinh");
            dtm.addColumn("Giới tính");
            dtm.addColumn("Quốc tịch");
            dtm.addColumn("CLB");
            while (rs.next()) {
                Object[] coach = new Object[9];
                coach[0] = rs.getString("coachID");
                coach[1] = rs.getString("coachName");
                coach[2] = rs.getString("position");
                coach[3] = rs.getString("email");
                coach[4] = rs.getString("phone");
                coach[5] = rs.getDate("dateOfBirth");
                coach[6] = rs.getString("sex");
                coach[7] = rs.getString("country");
                coach[8] = rs.getString("clubName");
                dtm.addRow(coach);
            }
            table.setModel(dtm);
            table.getColumnModel().getColumn(0).setPreferredWidth(70);
            table.getColumnModel().getColumn(1).setPreferredWidth(130);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(70);
            table.getColumnModel().getColumn(7).setPreferredWidth(80);
            table.getColumnModel().getColumn(8).setPreferredWidth(80);
        } catch (SQLException ex) {
            Logger.getLogger(CoachBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức Lấy thông tin HLV theo tên HLV thông qua phương thức truy vấn CSDL để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param coachName Tên HLV
     */
    
    public static void showResultCoachNameSearch(JTable table, String coachName){
        ResultSet rs = CoachDAL.queryCoachNameSearch(coachName);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã HLV");
            dtm1.addColumn("Họ tên");
            dtm1.addColumn("Vị trí");
            dtm1.addColumn("Email");
            dtm1.addColumn("Số ĐT");
            dtm1.addColumn("Ngày sinh");
            dtm1.addColumn("Giới tính");
            dtm1.addColumn("Nơi ở");
            dtm1.addColumn("Mã CLB");
            while (rs.next()) {
                Object[] player = new Object[9];
                player[0] = rs.getString("coachID");
                player[1] = rs.getString("coachName");
                player[2] = rs.getString("position");
                player[3] = rs.getString("email");
                player[4] = rs.getString("phone");
                player[5] = rs.getDate("dateOfBirth");
                player[6] = rs.getString("sex");
                player[7] = rs.getString("country");
                player[8] = rs.getString("clubID");
                dtm1.addRow(player);
            }
            table.setModel(dtm1);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức Lấy thông tin HLV theo mã HLV thông qua phương thức truy vấn CSDL để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param id Mã HLV
     */
    
    public static void showResultCoachIDSearch(JTable table, String id){
        ResultSet rs = CoachDAL.queryCoachIDSearch(id);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã HLV");
            dtm1.addColumn("Họ tên");
            dtm1.addColumn("Vị trí");
            dtm1.addColumn("Email");
            dtm1.addColumn("Số ĐT");
            dtm1.addColumn("Ngày sinh");
            dtm1.addColumn("Giới tính");
            dtm1.addColumn("Nơi ở");
            dtm1.addColumn("Mã CLB");
            while (rs.next()) {
                Object[] player = new Object[9];
                player[0] = rs.getString("coachID");
                player[1] = rs.getString("coachName");
                player[2] = rs.getString("position");
                player[3] = rs.getString("email");
                player[4] = rs.getString("phone");
                player[5] = rs.getDate("dateOfBirth");
                player[6] = rs.getString("sex");
                player[7] = rs.getString("country");
                player[8] = rs.getString("clubID");
                dtm1.addRow(player);
            }
            table.setModel(dtm1);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức thêm thông tin HLV vào CSDL gọi đến phương thức truy vấn CSDL để thêm HLV
     * @param coach câu lạc bộ 
     */


    public static void addCoach(Coach coach){
        CoachDAL.queryAddCoach(coach.getCoachID(), coach.getCoachName(), coach.getPosition(), coach.getEmail(), coach.getPhone(), coach.getDateOfBirth(),coach.getSex(), coach.getCountry(), coach.getClubID());
    }
    
    /**
     * Phương thức sửa thông tin HLV vào CSDL gọi đến phương thức truy vấn CSDL để sửa HLV
     * @param coach câu lạc bộ 
     */

    public static void updateCoach(Coach coach){
        CoachDAL.queryUpdateCoach(coach.getCoachName(), coach.getPosition(), coach.getEmail(), coach.getPhone(), coach.getDateOfBirth(),coach.getSex(), coach.getCountry(), coach.getClubID(), coach.getCoachID());
    }
    
    /**
     * Phương thức xóa thông tin HLV vào CSDL gọi đến phương thức truy vấn CSDL để xóa HLV
     * @param coach câu lạc bộ 
     */

    public static void deleteCoach(Coach coach){
        CoachDAL.queryDeleteCoach(coach.getCoachID());
    }
}
