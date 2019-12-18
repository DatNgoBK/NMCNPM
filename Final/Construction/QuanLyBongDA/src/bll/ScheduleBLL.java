/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.ScheduleDAL;
import dto.Schedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dat Ngo
 */
public class ScheduleBLL {

    public static DefaultTableModel dtm;
    public static DefaultTableModel dtm1;

    /**
     * Phương thức lấy thông tin lịch thi đấu thông qua phương thức truy vấn CSDL để hiển thị lên giao diện
     * @param table Bảng để hiển thị thông tin Lịch thi đấu
     */
    public static void showScheduleInformation(JTable table) {
        try {
            ResultSet rs = ScheduleDAL.queryScheduleInformation();
            dtm = new DefaultTableModel();
            dtm.addColumn("Mã");
            dtm.addColumn("Vòng");
            dtm.addColumn("Ngày");
            dtm.addColumn("Thời gian");
            dtm.addColumn("Sân");
            dtm.addColumn("Đội nhà");
            dtm.addColumn("Đội khách");
            dtm.addColumn("Người xác nhận");
            while (rs.next()) {
                Object[] schedule = new Object[8];
                schedule[0] = rs.getString("scheduleID");
                schedule[1] = rs.getString("round");
                schedule[2] = rs.getString("day");
                schedule[3] = rs.getString("time");
                schedule[4] = rs.getString("stadiumName");
                schedule[5] = rs.getString("homeTeamName");
                schedule[6] = rs.getString("visitorTeamName");
                schedule[7] = rs.getString("managerName");
                dtm.addRow(schedule);
            }
            table.setModel(dtm);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(70);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(80);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(110);
            table.getColumnModel().getColumn(6).setPreferredWidth(110);
            table.getColumnModel().getColumn(7).setPreferredWidth(140);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức Lấy thông tin Lịch thi đấu theo mã thông qua phương thức truy vấn CSDL, để hiển thị
     * @param table Bảng để hiển thị kết quả
     * @param id Mã Lịch thi đấu
     */

    public static void showResultScheduleIDSearch(JTable table, String id) {
        ResultSet rs = ScheduleDAL.queryScheduleIDSearch(id);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("Mã trận đấu");
            dtm1.addColumn("Mã đội nhà");
            dtm1.addColumn("Mã đội khách");
            dtm1.addColumn("Thời gian");
            dtm1.addColumn("Mã SVĐ");

            while (rs.next()) {
                Object[] player = new Object[5];
                player[0] = rs.getString("scheduleID");
                player[1] = rs.getString("homeTeamID");
                player[2] = rs.getString("visitorTeamID");
                player[3] = rs.getString("time");
                player[4] = rs.getString("stadiumID");

                dtm1.addRow(player);
            }
            table.setModel(dtm1);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức thêm thông tin Lịch thi đấu vào CSDL gọi đến phương thức truy vấn CSDL để thêm Lịch thi đấu
     * @param schedule Lịch thi đấu
     */

    public static void addSchedule(Schedule schedule) {
        ScheduleDAL.queryAddSchedule(schedule.getScheduleID(), schedule.getRound(), schedule.getDay(), schedule.getTime(), schedule.getStadiumID(), schedule.getHomeTeamID(), schedule.getVisitorTeamID(), schedule.getManagerID());
    }
    
    /**
     * Phương thức cập nhật thông tin Lịch thi đấu vào CSDL gọi đến phương thức truy vấn CSDL để cập nhật Lịch thi đấu
     * @param schedule Lịch thi đấu
     */

    public static void updateSchedule(Schedule schedule) {
        ScheduleDAL.queryUpdateSchedule(schedule.getRound(), schedule.getDay(), schedule.getTime(), schedule.getStadiumID(), schedule.getHomeTeamID(), schedule.getVisitorTeamID(), schedule.getManagerID(), schedule.getScheduleID());
    }
    
    /**
     * Phương thức xóa thông tin Lịch thi đấu vào CSDL gọi đến phương thức truy vấn CSDL để xóa Lịch thi đấu
     * @param schedule Lịch thi đấu
     */

    public static void deleteSchedule(Schedule schedule) {
        ScheduleDAL.queryDeleteSchedule(schedule.getScheduleID());
    }
}
