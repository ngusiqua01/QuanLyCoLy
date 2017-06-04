/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycoly.items;

/**
 *
 * @author ufo
 */
public class CongTrinhItem {
    String MaCT;
    String TenCT;
    String startDate;
    String endDate;
    double x;
    double y;
    double z;
    double depth;

    public CongTrinhItem(String MaCT, String TenCT, String startDate, String endDate, double x, double y, double z, double depth) {
        this.MaCT = MaCT;
        this.TenCT = TenCT;
        this.startDate = startDate;
        this.endDate = endDate;
        this.x = x;
        this.y = y;
        this.z = z;
        this.depth = depth;
    }

    public String getMaCT() {
        return MaCT;
    }

    public void setMaCT(String MaCT) {
        this.MaCT = MaCT;
    }

    public String getTenCT() {
        return TenCT;
    }

    public void setTenCT(String TenCT) {
        this.TenCT = TenCT;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
    
    
    
    
}
