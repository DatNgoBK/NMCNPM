/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.StadiumDAL;
import dto.Stadium;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class StadiumBLL {
    
    public static DefaultTableModel dtm;
    public static DefaultTableModel dtm1;
    private static DefaultComboBoxModel dcb;

    /**
     * Phương thức lấy thông tin SVĐ thông qua phương thức truy vấn CSDL để hiển thị lên giao diện
     * @param table Bảng để hiển thị thông tin SVĐ
     */
    
    public static void showStadiumInformation(JTable table){
        try {
            ResultSet rs = StadiumDAL.queryStadiumInformation();
            dtm = new DefaultTableModel();
            dtm.addColumn("Mã");
            dtm.addColumn("Tên");
            dtm.addColumn("Năm thành lập");
            dtm.addColumn("Sức chứa");
            dtm.addColumn("Ghi chú");
            while (rs.next()) {
                Object[] stadium = new Object[9];
                stadium[0] = rs.getString("stadiumID");
                stadium[1] = rs.getString("stadiumName");
                stadium[2] = rs.getString("foundedYear");
                stadium[3] = rs.getString("capacity");
                stadium[4] = rs.getString("note");
                dtm.addRow(stadium);
            }
            table.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(StadiumBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức lấy thông tin CLB từ phương thức truy vấn CSDL để hiện thị lên giao diện
     * @param cbo Combobox để hiển thị thông tin SVĐ
     */
    
    public static void showStadiumInformationCbo(JComboBox<Stadium> cbo){
        try {
            ResultSet rs = StadiumDAL.queryStadiumInformation();
            dcb = new DefaultComboBoxModel();
            while (rs.next()) {
                Stadium stadium = new Stadium(rs.getString("stadiumID"), rs.getString("stadiumName"), rs.getString("foundedYear"), Integer.valueOf(rs.getString("capacity")), rs.getString("note"));
                dcb.addElement(stadium);
            }
            cbo.setModel(dcb);
        } catch (SQLException ex) {
            Logger.getLogger(ClubBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức Lấy thông tin SVĐ theo tên SVĐ thông qua phương thức truy vấn CSDL để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param stadiumName Tên SVĐ
     */
    
    public static void showResultStadiumNameSearch(JTable table, String stadiumName){
        ResultSet rs = StadiumDAL.queryStadiumNameSearch(stadiumName);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã SVĐ");
            dtm1.addColumn("Tên SVĐ");
            dtm1.addColumn("Sức chứa");
            dtm1.addColumn("Ghi chú");
            while (rs.next()) {
                Object[] player = new Object[4];
                player[0] = rs.getString("stadiumID");
                player[1] = rs.getString("stadiumName");
                player[2] = rs.getString("capacity");
                player[3] = rs.getString("note");
                
                dtm1.addRow(player);
            }
            table.setModel(dtm1);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức Lấy thông tin SVĐ theo mã SVĐ thông qua phương thức truy vấn CSDL để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param id Mã SVĐ
     */
    
    public static void showResultStadiumIDSearch(JTable table, String id){
        ResultSet rs = StadiumDAL.queryStadiumIDSearch(id);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã SVĐ");
            dtm1.addColumn("Tên SVĐ");
            dtm1.addColumn("Sức chứa");
            dtm1.addColumn("Ghi chú");
            
            while (rs.next()) {
                Object[] player = new Object[4];
                player[0] = rs.getString("stadiumID");
                player[1] = rs.getString("stadiumName");
                player[2] = rs.getString("capacity");
                player[3] = rs.getString("note");
                dtm1.addRow(player);
            }
            table.setModel(dtm1);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức thêm thông tin SVĐ vào CSDL gọi đến phương thức truy vấn CSDL để thêm SVĐ
     * @param stadium Sân vận động 
     */

    public static void addStadium(Stadium stadium){
        StadiumDAL.queryAddStadium(stadium.getStadiumID(), stadium.getStadiumName(), stadium.getFoundedYear(), stadium.getCapacity()+"", stadium.getNote());
    }
    
    /**
     * Phương thức cập nhật thông tin SVĐ vào CSDL gọi đến phương thức truy vấn CSDL để cập nhật SVĐ
     * @param stadium Sân vận động 
     */

    public static void updateStadium(Stadium stadium){
        StadiumDAL.queryUpdateStadium(stadium.getStadiumName(), stadium.getFoundedYear(), stadium.getCapacity()+"", stadium.getNote(), stadium.getStadiumID());
    }
    
    
    /**
     * Phương thức xóa thông tin SVĐ vào CSDL gọi đến phương thức truy vấn CSDL để xóa SVĐ
     * @param stadium Sân vận động 
     */
    public static void deleteStadium(Stadium stadium){
        StadiumDAL.queryDeleteStadium(stadium.getStadiumID());
    }
}
