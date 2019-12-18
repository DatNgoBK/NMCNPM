/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.MatchResultDAL;
import dto.MatchResult;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dat Ngo
 */
public class MatchResultBLL {
    public static DefaultTableModel dtm;
    
    
    /**
     * Phương thức hiển thị kết quả trận đấu 
     * @param scheduleID mã trận
     * @param txtHome chứa kết quả số bàn thắng đội nhà
     * @param txtVisitor chứa kết quả số bàn thắng đội khách
     * @return trả về true khi trước đó trận đấu chưa có kết quả, false nếu trận đấu trước đó đã có KQ
     */
    public static boolean showResult(String scheduleID,JTextField txtHome,JTextField txtVisitor){
        try {
            ResultSet rs = MatchResultDAL.showResult(scheduleID);
            if(rs == null){
                return false;
            }
            while(rs.next()){
                txtHome.setText(rs.getInt("homeTeamGoal")+"");
                txtVisitor.setText(rs.getInt("visitorTeamGoal")+"");
                
            }
            return true;
        } catch (SQLException ex) {
        }
        return true;
    }
    
      /**
     * Phương thức thêm kết quả trận đấu khi trước đó trận đấu chưa có kết quả
     * @param matchResult  Kết quả trận đấu
     */
    
    public static void addResult(MatchResult matchResult){
        MatchResultDAL.addResult(matchResult.getScheduleID(), matchResult.getHomeTeamGoal()+"", matchResult.getVisitorTeamGoal()+"");
    }
    
    /**
     * Phương thức cập nhật kết quả trận đấu khi trước đó trận đấu đã có kết quả
     * @param matchResult  Kết quả trận đấu
     */
    
    public static void updateResult(MatchResult matchResult){
         MatchResultDAL.updateResult(matchResult.getHomeTeamGoal()+"", matchResult.getVisitorTeamGoal()+"", matchResult.getScheduleID());
    }
    
    
    /**
     * Phương thức lấy thông tin BXH từ việc gọi phương thức truy vấn CSDL, sau đó hiển thị lên giao diện
     * @param table Bảng chứa kết quả
     */
    
    public static void showChart(JTable table){
        try {
            ResultSet rs = MatchResultDAL.queryReceiveScoreChart();
            dtm = new DefaultTableModel();
            dtm.addColumn("TT");
            dtm.addColumn("Tên Đội");
            dtm.addColumn("Số Trận");
            dtm.addColumn("Thắng");
            dtm.addColumn("Thua");
            dtm.addColumn("Hòa");
            dtm.addColumn("BT");
            dtm.addColumn("SBT");
            dtm.addColumn("HS");
            dtm.addColumn("Điểm");
            int i= 1;
            while(rs.next()){
                Object[] inf = new Object[10];
                inf[0] = i;
                inf[1] = rs.getString("TenCLB");
                int temp1 = rs.getInt("SoTran");
                int temp2 = rs.getInt("Thang");
                int temp3 = rs.getInt("Thua");
                int temp4 = temp1 - temp2 - temp3;
                int temp5 = rs.getInt("BT");
                int temp6 = rs.getInt("SBT");
                inf[2] = temp1;
                inf[3] = temp2;
                inf[4] = temp3;
                inf[5] = temp4;
                inf[6] = temp5;
                inf[7] = temp6;
                inf[8] = temp5 - temp6;
                inf[9] = temp2 * 3 + temp4;
                i++;
                dtm.addRow(inf);
            }
            table.setModel(dtm);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
        } catch (SQLException ex) {
            Logger.getLogger(MatchResultBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
