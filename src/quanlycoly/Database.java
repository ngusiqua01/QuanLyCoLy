/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycoly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlycoly.items.CongTrinhItem;
import quanlycoly.items.DiaTangItem;
import quanlycoly.items.MauItem;

/**
 *
 * @author ufo
 */
public class Database {

    public static final String CONGTRINHTABLE = "congtrinh";
    public static final String USERTABLE = "nguoidung";
    public static final String DIATANGTABLE = "diatang";
    public static final String MAUTABLE = "mau";
    public static final String THINGHIEMTABLE = "ketquathinghiem";

    static Database mDatabase;

    Statement stmt;

    private Database() {

    }

    public static Database newInstance() {
        if (mDatabase == null) {
            mDatabase = new Database();
            mDatabase.connectDB();
        }

        return mDatabase;
    }

    public void connectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycoly", "root", "");
            stmt = con.createStatement();
            System.out.println("quanlycoly.Database.connectDB() done");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void closeDB() {
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkPassWord(String username, String password) {
        try {
            String query = "select count(*) from `" + USERTABLE + "` where `TenND` = '" + username + "' and `MatKhau` = MD5('" + password + "') ";
            System.out.println("quanlycoly.Database.checkPassWord() query - " + query);
            ResultSet rs = stmt.executeQuery(query);
//            System.out.println("quanlycoly.Database.checkPassWord() rs.next() = "+rs.next());
            rs.first();
            int count = rs.getInt(1);
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return false;

    }
    //===============================QUAN LY CONG TRINH================================   

    public CongTrinhItem getCongTrinh(String maCT) {
        CongTrinhItem item = null;
        try {

            String query = "select * from " + CONGTRINHTABLE + " where `MaCT` = '" + maCT + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            String tenCT = rs.getString("TenCT");
            String beginDate = Utils.convertToDate(rs.getDate("NgayCT").toString());
            String endDate = Utils.convertToDate(rs.getDate("NgayKT").toString());
            double x = rs.getDouble("ToaDoX");
            double y = rs.getDouble("ToaDoY");
            double z = rs.getDouble("CaoDoZ");
            double depth = rs.getDouble("ChieuSauLK");

            item = new CongTrinhItem(maCT, tenCT, beginDate, endDate, x, y, z, depth);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public ArrayList<CongTrinhItem> getListCongTrinh() {
        ArrayList<CongTrinhItem> listCongTrinh = new ArrayList<>();
        try {

            String query = "select * from " + CONGTRINHTABLE + " limit 10";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String maCT = rs.getString("MaCT");
                String tenCT = rs.getString("TenCT");
                String beginDate = Utils.convertToDate(rs.getDate("NgayCT").toString());
                String endDate = Utils.convertToDate(rs.getDate("NgayKT").toString());
                double x = rs.getDouble("ToaDoX");
                double y = rs.getDouble("ToaDoY");
                double z = rs.getDouble("CaoDoZ");
                double depth = rs.getDouble("ChieuSauLK");

                System.out.println("quanlycoly.Database.getListCongTrinh() beginDate = " + beginDate);

                CongTrinhItem item = new CongTrinhItem(maCT, tenCT, beginDate, endDate, x, y, z, depth);
                listCongTrinh.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listCongTrinh;
    }

    public void addCongTrinh(String maCT, String tenCT, String beginDate, String endDate, double x, double y, double z, double depth) {
        String addQuery = "INSERT INTO `congtrinh` (`MaCT`, `TenCT`, `NgayCT`, `NgayKT`, `ToaDoX`, `ToaDoY`, `CaoDoZ`, `ChieuSauLK`) "
                + "VALUES ('" + maCT + "', '" + tenCT + "', '" + beginDate + "', '" + endDate + "', '" + x + "', '" + y + "', '" + z + "', '" + depth + "')";

        try {
            stmt.executeUpdate(addQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateCongTrinh(String maCT, String tenCT, String beginDate, String endDate, double x, double y, double z, double depth) {
        String updateQuery = "update `" + CONGTRINHTABLE + "`"
                + " set `TenCT` =  '" + tenCT + "',  `NgayCT` =  '" + beginDate + "', "
                + "`NgayKT` = '" + endDate + "', `ToaDoX` =  '" + x + "', `ToaDoY` = '" + y + "', `CaoDoZ` = '" + z + "', `ChieuSauLK` = '" + depth + "'"
                + " where `MaCT` = '" + maCT + "'";
        System.out.println("quanlycoly.Database.updateCongTrinh() updateQuery = " + updateQuery);
        try {
            stmt.executeUpdate(updateQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteCongTrinh(String maCT) {
        String deleteQuery = "DELETE FROM `" + CONGTRINHTABLE + "` WHERE `congtrinh`.`MaCT` = '" + maCT + "'";
        System.out.println("quanlycoly.Database.deleteCongTrinh() deleteQuery = " + deleteQuery);
        try {
            int i = stmt.executeUpdate(deleteQuery);
            System.out.println("quanlycoly.Database.deleteCongTrinh() delete row return " + i);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//==============================QUAN LY DIA TANG====================================
    public ArrayList<DiaTangItem> getListDiaTang() {
        ArrayList<DiaTangItem> listDiaTang = new ArrayList<>();
        try {

            String query = "select * from " + DIATANGTABLE + " limit 10";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String maDT = rs.getString("MaDT");
                String tenCT = rs.getString("TenDT");
                String maCT = rs.getString("MaCT");
                String mota = rs.getString("MoTa");

                DiaTangItem item = new DiaTangItem(maDT, tenCT, maCT, mota);
                listDiaTang.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDiaTang;
    }

    public DiaTangItem getDiaTang(String maDT) {
        DiaTangItem item = null;
        try {

            String query = "select * from " + DIATANGTABLE + " where `MaDT` = '" + maDT + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            String tenDT = rs.getString("TenDT");
            String maCT = rs.getString("MaCT");
            String mota = rs.getString("MoTa");

            item = new DiaTangItem(maDT, tenDT, maCT, mota);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public void addDiaTang(String maDT, String tenDT, String maCT, String mota) {
        String addQuery = "INSERT INTO `" + DIATANGTABLE + "` (`MaDT`, `TenDT`, `MaCT`, `MoTa`) "
                + "VALUES ('" + maDT + "', '" + tenDT + "', '" + maCT + "', '" + mota + "')";

        try {
            stmt.executeUpdate(addQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateDiaTang(String maDT, String tenDT, String maCT, String mota) {
        String updateQuery = "update `" + DIATANGTABLE + "`"
                + " set `TenDT` =  '" + tenDT + "',  `MaCT` =  '" + maCT + "', `MoTa` = '" + mota + "'"
                + " where `MaDT` = '" + maDT + "'";
        System.out.println("quanlycoly.Database.updateDiaTang() updateQuery = " + updateQuery);
        try {
            stmt.executeUpdate(updateQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteDiaTang(String maDT) {
        String deleteQuery = "DELETE FROM `" + DIATANGTABLE + "` WHERE `MaDT` = '" + maDT + "'";
        System.out.println("quanlycoly.Database.deleteDiaTang() deleteQuery = " + deleteQuery);
        try {
            int i = stmt.executeUpdate(deleteQuery);
            System.out.println("quanlycoly.Database.deleteDiaTang() delete row return " + i);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //================================= QUAN LY THONG TIN MAU =====================================
    public ArrayList<MauItem> getListMau() {
        ArrayList<MauItem> listDiaTang = new ArrayList<>();
        try {

            String query = "select * from " + MAUTABLE + " limit 10";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String maDT = rs.getString("MaDT");
                String shMau = rs.getString("SHMau");
                String date = Utils.convertToDate(rs.getString("NgayLayMau"));
                double length = rs.getDouble("ChieuDaiMau");
                double fromLength = rs.getDouble("ChieuDaiMauTu");
                double toLength = rs.getDouble("ChieuDaiMauDen");

                MauItem item = new MauItem(shMau, maDT, date, length, fromLength, toLength);
                listDiaTang.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDiaTang;
    }

    public MauItem getMau(String shMau) {
        MauItem item = null;
        try {

            String query = "select * from " + MAUTABLE + " where `SHMau` = '" + shMau + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            String maDT = rs.getString("MaDT");
            String date = Utils.convertToDate(rs.getString("NgayLayMau"));
            double length = rs.getDouble("ChieuDaiMau");
            double fromLength = rs.getDouble("ChieuDaiMauTu");
            double toLength = rs.getDouble("ChieuDaiMauDen");

            item = new MauItem(shMau, maDT, date, length, fromLength, toLength);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public void addMau(String shMau, String maDT, String date, double length, double fromLength, double toLength) {
        String addQuery = "INSERT INTO `" + MAUTABLE + "` (`SHMau`, `MaDT`, `NgayLayMau`, `ChieuDaiMau`, `ChieuDaiMauTu`, `ChieuDaiMauDen`) "
                + "VALUES ('" + shMau + "', '" + maDT + "', '" + date + "', '" + length + "', '" + fromLength + "', '" + toLength + "')";

        try {
            stmt.executeUpdate(addQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateMau(String shMau, String maDT, String date, double length, double fromLength, double toLength) {
        String updateQuery = "update `" + MAUTABLE + "`"
                + " set   `MaDT` =  '" + maDT + "', `NgayLayMau` = '" + date + "',"
                + " `ChieuDaiMau` = '" + length + "', `ChieuDaiMauTu` = '" + fromLength + "', `ChieuDaiMauDen` = '" + toLength + "'"
                + " where `SHMau` =  '" + shMau + "'";
        System.out.println("quanlycoly.Database.updateDiaTang() updateQuery = " + updateQuery);
        try {
            stmt.executeUpdate(updateQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteMau(String shMau) {
        String deleteQuery = "DELETE FROM `" + MAUTABLE + "` WHERE `SHMau` = '" + shMau + "'";
        System.out.println("quanlycoly.Database.deleteMau() deleteQuery = " + deleteQuery);
        try {
            int i = stmt.executeUpdate(deleteQuery);
            System.out.println("quanlycoly.Database.deleteMau() delete row return " + i);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
