/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dao Huy Chuong
 */
public class ManagerDAL {
    
    /**
     * Phương thức truy vấn lấy thông tin của quản lý
     * @return Các bản ghi chứa thông tin quản lý
     */
    
    public static ResultSet addManagerInformation(){
        try {
            Connection cnn = ConnectDatabase.getConnect();
            PreparedStatement ps = cnn.prepareStatement("select * from Manager");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
