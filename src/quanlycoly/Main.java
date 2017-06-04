/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycoly;

import java.awt.Dimension;
import java.awt.Toolkit;
import quanlycoly.GUI.LoginFrame;
import javax.swing.JFrame;
import quanlycoly.GUI.Home;
import quanlycoly.GUI.QuanLyThongTinCongTrinh;

/**
 *
 * @author ufo
 */
public class Main {

    Database mDatabase;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        JFrame jFrame = Home.newInstance();
        JFrame jFrame = new LoginFrame();
//        jFrame.setTitle("Đăng Nhập Hệ Thống");
        jFrame.show();
//        jFrame.setVisible(false);

//        Main main = new Main();
//        main.initDB();
    }

    public void initDB() {
        mDatabase = Database.newInstance();

    }

}
