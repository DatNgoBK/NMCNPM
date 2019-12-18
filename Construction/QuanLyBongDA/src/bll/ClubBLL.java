/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.ClubDAL;
import dto.Club;
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
 * @author Dao Huy Chuong
 */
public class ClubBLL {

    public static DefaultComboBoxModel<Club> dcb;
    public static DefaultTableModel dtm1;
    
    /**
     * Phương thức lấy thông tin CLB từ phương thức truy vấn CSDL để hiện thị lên giao diện
     * @param cbo Combobox để hiển thị thông tin CLB
     */

    public static void showClubInformation(JComboBox<Club> cbo) {
        try {
            ResultSet rs = ClubDAL.queryClubInformation();
            dcb = new DefaultComboBoxModel<Club>();
            while (rs.next()) {
                Club club = new Club(rs.getString("clubID"), rs.getString("clubName"), rs.getString("address"), rs.getString("website"), rs.getString("stadiumID"));
                dcb.addElement(club);
            }
            cbo.setModel(dcb);
        } catch (SQLException ex) {
            Logger.getLogger(ClubBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức Lấy thông tin CLB theo tên CLB thông qua phương thức truy vấn CSDL để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param clubName Tên CLB
     */

    public static void showResultClubNameSearch(JTable table, String clubName) {
        ResultSet rs = ClubDAL.queryClubNameSearch(clubName);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã");
            dtm1.addColumn("Tên");
            dtm1.addColumn("Địa chỉ");
            dtm1.addColumn("Mã SVĐ");
            dtm1.addColumn("Trang Web");

            while (rs.next()) {
                Object[] player = new Object[5];
                player[0] = rs.getString("clubID");
                player[1] = rs.getString("clubName");
                player[2] = rs.getString("address");
                player[3] = rs.getString("stadiumID");
                player[4] = rs.getString("website");

                dtm1.addRow(player);
            }
            table.setModel(dtm1);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức Lấy thông tin CLB theo mã CLB thông qua phương thức truy vấn CSDL để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param id Mã CLB
     */

    public static void showResultClubIDSearch(JTable table, String id) {
        ResultSet rs = ClubDAL.queryClubIDSearch(id);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã");
            dtm1.addColumn("Tên");
            dtm1.addColumn("Địa chỉ");
            dtm1.addColumn("Mã SVĐ");
            dtm1.addColumn("Trang Web");

            while (rs.next()) {
                Object[] player = new Object[5];
                player[0] = rs.getString("clubID");
                player[1] = rs.getString("clubName");
                player[2] = rs.getString("address");
                player[3] = rs.getString("stadiumID");
                player[4] = rs.getString("website");

                dtm1.addRow(player);
            }
            table.setModel(dtm1);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức thêm thông tin CLB vào CSDL gọi đến phương thức truy vấn CSDL để thêm CLB
     * @param club Câu lạc bộ 
     */

    public static void addClub(Club club) {
        ClubDAL.queryAddClub(club.getClubID(), club.getClubName(), club.getAddress(), club.getWebsite(), club.getStadiumID());
    }
    
    /**
     * Phương thức cập nhật thông tin CLB vào CSDL gọi đến phương thức truy vấn CSDL để cập nhật CLB
     * @param club Câu lạc bộ 
     */

    public static void updateClub(Club club) {
        ClubDAL.queryUpdateClub(club.getClubName(), club.getAddress(), club.getWebsite(), club.getStadiumID(), club.getClubID());
    }
    
    /**
     * Phương thức xóa thông tin CLB vào CSDL gọi đến phương thức truy vấn CSDL để xóa CLB
     * @param club Câu lạc bộ 
     */

    public static void deleteClub(Club club) {
        ClubDAL.queryDeleteClub(club.getClubID());
    }
}
