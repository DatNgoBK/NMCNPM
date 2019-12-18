/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.ManagerDAL;
import dto.Manager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Dao Huy Chuong
 */
public class ManagerBLL {
    public static DefaultComboBoxModel<Manager>dcb;
    
    /**
     * Phương thức hiển thị thông tin quản lí , gọi đến phương thức truy vấn CSDL để lấy thông tin
     * @param cbo Hiển thị KQ
     */
    public static void addToCombobox(JComboBox<Manager> cbo){
        try {
            ResultSet rs = ManagerDAL.addManagerInformation();
            dcb = new DefaultComboBoxModel<>();
            while(rs.next()){
                Manager manager = new Manager(rs.getString("managerID"), rs.getString("managerName"), rs.getString("username"), rs.getString("password"));
                dcb.addElement(manager);
            }
            cbo.setModel(dcb);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
