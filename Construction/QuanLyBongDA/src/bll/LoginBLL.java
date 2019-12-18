/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.LoginDAL;
import dto.Manager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ha The Dang
 */
public class LoginBLL {
    
    /**
     * Phương thức kiểm tra thông tin đăng nhập
     * @param username : tên đăng nhập
     * @param password : mật khẩu
     * @return một đối tượng của lớp Manager nếu đó trùng khớp thông tin trong CSDL, trả về null nếu sai TK hoặc MK
     */
    public static Manager checkLogin(String username, String password){
        try {
            ResultSet rs = LoginDAL.loginInformation();
            while(rs.next()){
                String user = rs.getString("username");
                String pass = rs.getString("password");
                if(user.equals(username) && pass.equals(password)){
                    Manager manager = new Manager(rs.getString("managerID"), rs.getString("managerName"), user , pass);
                    return manager;
                }
            }
            return null;
        } catch (SQLException ex) {
            //Logger.getLogger(LoginBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
