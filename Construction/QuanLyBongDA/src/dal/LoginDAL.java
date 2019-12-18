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
 * @author Ha The Dang
 */


public class LoginDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    
    
    /**
     * Phương thức truy vấn cơ sở dữ liệu bảng Quản lý
     * @return Các bản ghi chứa thông tin của quản lý
     */
    public static ResultSet loginInformation(){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Manager ");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
           // Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
