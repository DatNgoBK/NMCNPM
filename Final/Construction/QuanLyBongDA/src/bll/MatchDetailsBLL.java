/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.MatchDetailsDAL;
import dto.MatchDetails;
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
public class MatchDetailsBLL {
    
    /**
     * Phương thức hiển thị thông tin cầu thủ lên giao diện chi tiết trận đấu
     * @param table Bảng kết quả hiển thị
     * @param scheduleID Mã trận đấu
     * @param clubID Mã CLB
     */
    
    public static void updatePlayerInGame(JTable table, String scheduleID, String clubID){
        try {
            ResultSet rs = MatchDetailsDAL.queryPlayerInGame(scheduleID, clubID);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("TT");
            dtm.addColumn("Tên Cầu Thủ");
            int i = 0;
            while(rs.next()){
                Object[] obj = new Object[2];
                obj[0] = i + 1;
                obj[1] = rs.getString("playerName");
                i++;
                dtm.addRow(obj);
            }
            table.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(MatchDetailsBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức thêm cầu thủ vào chi tiết trận đấu, gọi đến phương thức truy vấn CSDL để thêm chi tiết
     * @param matchDetails Chi tiết trận đấu
     */
    
    public static void addPlayerInGame(MatchDetails matchDetails){
        MatchDetailsDAL.addPlayerInGame(matchDetails.getScheduleID(), matchDetails.getPlayerID());
    }
    
    /**
     * Phương thức xóa cầu thủ khỏi chi tiết trận đấu, gọi đến phương thức truy vấn CSDL để xóa chi tiết
     * @param matchDetails Chi tiết trận đấu
     */
    
    public static void deletePlayerInGame(MatchDetails matchDetails){
        MatchDetailsDAL.deletePlayerInGame(matchDetails.getScheduleID(), matchDetails.getPlayerID());
    }
}
