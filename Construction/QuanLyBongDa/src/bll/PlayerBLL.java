/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.PlayerDAL;
import dto.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ha The Dang
 */
public class PlayerBLL {
    public static DefaultComboBoxModel dcb;
    public static DefaultTableModel dtm;
     public static DefaultTableModel dtm1;
    public static DefaultListModel<String> dlm;
    
    /**
     * Phương thức lấy thông tin Cầu thủ thông qua phương thức truy vấn CSDL, để hiển thị lên giao diện
     * @param table Bảng để hiển thị thông tin càu thủ
     */
    public static void showPlayerInformation(JTable table){
        try {
            ResultSet rs = PlayerDAL.queryPlayerInformation();
            dtm = new DefaultTableModel();
            dtm.addColumn("Mã");
            dtm.addColumn("Tên");
            dtm.addColumn("Vị trí");
            dtm.addColumn("Chiều cao");
            dtm.addColumn("Cân nặng");
            dtm.addColumn("Ngày sinh");
            dtm.addColumn("Giới tính");
            dtm.addColumn("Quốc tịch");
            dtm.addColumn("CLB");
            while (rs.next()) {
                Object[] player = new Object[9];
                player[0] = rs.getString("playerID");
                player[1] = rs.getString("playerName");
                player[2] = rs.getString("position");
                player[3] = rs.getInt("height");
                player[4] = rs.getInt("weight");
                player[5] = rs.getDate("dateOfBirth");
                player[6] = rs.getString("sex");
                player[7] = rs.getString("country");
                player[8] = rs.getString("clubName");
                dtm.addRow(player);
            }
            
            table.setModel(dtm);
            
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(130);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(80);
            table.getColumnModel().getColumn(4).setPreferredWidth(80);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(70);
            table.getColumnModel().getColumn(7).setPreferredWidth(80);
            table.getColumnModel().getColumn(8).setPreferredWidth(100);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức Lấy thông tin Cầu thủ theo tên cầu thủ thông qua phương thức truy vấn CSDL, để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param playerName Tên cầu thủ
     */
    
    public static void showResultPlayerNameSearch(JTable table, String playerName){
        ResultSet rs = PlayerDAL.queryPlayerNameSearch(playerName);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã cầu thủ");
            dtm1.addColumn("Họ tên");
            dtm1.addColumn("Vị trí");
            dtm1.addColumn("Chiều cao");
            dtm1.addColumn("Cân nặng");
            dtm1.addColumn("Ngày sinh");
            dtm1.addColumn("Giới tính");
            dtm1.addColumn("Nơi ở");
            dtm1.addColumn("Mã CLB");
            while (rs.next()) {
                Object[] player = new Object[9];
                player[0] = rs.getString("playerID");
                player[1] = rs.getString("playerName");
                player[2] = rs.getString("position");
                player[3] = rs.getInt("height");
                player[4] = rs.getInt("weight");
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
     * Phương thức Lấy thông tin Cầu thủ theo mã cầu thủ thông qua phương thức truy vấn CSDL, để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param id Mã cầu thủ
     */
    
    public static void showResultPlayerIDSearch(JTable table, String id){
        ResultSet rs = PlayerDAL.queryPlayerIDSearch(id);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã cầu thủ");
            dtm1.addColumn("Họ tên");
            dtm1.addColumn("Vị trí");
            dtm1.addColumn("Chiều cao");
            dtm1.addColumn("Cân nặng");
            dtm1.addColumn("Ngày sinh");
            dtm1.addColumn("Giới tính");
            dtm1.addColumn("Nơi ở");
            dtm1.addColumn("Mã CLB");
            while (rs.next()) {
                Object[] player = new Object[9];
                player[0] = rs.getString("playerID");
                player[1] = rs.getString("playerName");
                player[2] = rs.getString("position");
                player[3] = rs.getInt("height");
                player[4] = rs.getInt("weight");
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
     * Phương thức thêm thông tin cầu thủ vào CSDL gọi đến phương thức truy vấn CSDL để thêm cầu thủ
     * @param player cầu thủ
     */
    public static void addPlayer(Player player){
        PlayerDAL.queryAddPlayer(player.getPlayerID(), player.getPlayerName(), player.getPosition(), player.getHeight(), player.getWeight(), player.getDateOfBirth(), player.getSex(),  player.getCountry(), player.getClubID());
    }
    
    /**
     * Phương thức cập nhật thông tin cầu thủ vào CSDL gọi đến phương thức truy vấn CSDL để cập nhật cầu thủ
     * @param player cầu thủ
     */

    public static void updatePlayer(Player player){
        PlayerDAL.queryUpdatePlayer(player.getPlayerName(), player.getPosition(), player.getHeight(), player.getWeight(), player.getDateOfBirth(), player.getSex(),  player.getCountry(), player.getClubID(), player.getPlayerID());
    }

    
    /**
     * Phương thức xóa thông tin cầu thủ vào CSDL gọi đến phương thức truy vấn CSDL để xóa cầu thủ
     * @param player cầu thủ
     */
    public static void deletePlayer(Player player){
        PlayerDAL.queryDeletePlayer(player.getPlayerID());
    }
    
    /**
     * Phương thức hiển thị tên cầu thủ lên giao diện, lấy thông tin tên cầu thủ từ việc gọi phương thức truy vấn CSDL
     * @param list JList để hiển thị danh sách tên
     * @param data Mã CLB 
     */
    
    public static void addPlayerNameInList(JList<String> list, String data){
        try {
            ResultSet rs = PlayerDAL.queryPlayerNameInAClub(data);
            dlm = new DefaultListModel<String>();
            while(rs.next()){
                dlm.addElement(rs.getString("playerName"));
            }
            list.setModel(dlm);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Phương thức lấy kết quả thống kê số cầu thủ của 1 câu lạc bộ để hiển thị lên giao diện
     * @param data Mã CLB
     * @param txtKQ JTextField chứa kết quả thống kê.
     */
    
    
    public static void thongKePlayer(String data, JTextField txtKQ){
        try {
            ResultSet rs = PlayerDAL.queryCountPlayerInClub(data);
            while(rs.next())
                txtKQ.setText(rs.getString("soluong")+ ""); 
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức lấy thông tin các cầu thủ của một CLB hiển thị lên combobox
     * @param data mã CLB
     * @param cbo Combobox chứa kết quả .
     */
    
    public static void receivePlayerInformation(String data, JComboBox<Player> cbo){
        try {
            ResultSet rs = PlayerDAL.queryPlayerInAClub(data);
            dcb = new DefaultComboBoxModel();
            while(rs.next()){
                Player player = new Player(rs.getString("playerID"), rs.getString("playerName"), rs.getString("position"), rs.getInt("height"), rs.getInt("weight"), rs.getDate("dateOfBirth"), rs.getString("sex"), rs.getString("country"), rs.getString("clubID"));
                dcb.addElement(player);
            }
            cbo.setModel(dcb);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
