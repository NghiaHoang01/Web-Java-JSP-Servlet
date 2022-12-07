/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.connection.DBConnect;
import com.model.User;
import com.sun.javafx.font.FontConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sun.security.rsa.RSACore;

/**
 *
 * @author Administrator
 */
public class UserDao {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public User userLogin(String email, String pass) {
        User user = null;
        try {
            conn = new DBConnect().getConnection();
            pst = this.conn.prepareStatement("select * from users where UserEmail = ? and Password = ?");
            pst.setString(1, email);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public boolean getUserEmail(String userEmail) {
        boolean result = false;
        try {
            conn = new DBConnect().getConnection();
            pst = conn.prepareStatement("select UserEmail from users where UserEmail = ?");
            pst.setString(1, userEmail);
            rs = pst.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
        }
        return result;
    }

    public boolean userSignUp(User user) {
        boolean result = false;

        try {
            conn = new DBConnect().getConnection();
            pst = conn.prepareStatement("insert into users (UserName,Password,UserEmail) values (?,?,?)");
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getUserPassword());
            pst.setString(3, user.getUserEmail());

            int kq = pst.executeUpdate();
            if (kq > 0) {
                result = true;
            }

        } catch (Exception e) {
        }

        return result;
    }
}
