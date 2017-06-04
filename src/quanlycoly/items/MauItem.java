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
public class MauItem {
    
    String shMau ;
    String maDT;
    String date;
    double length;
    double fromLength;
    double toLength;

    public MauItem(String shMau, String maDT, String date, double length, double fromLength, double toLength) {
        this.shMau = shMau;
        this.maDT = maDT;
        this.date = date;
        this.length = length;
        this.fromLength = fromLength;
        this.toLength = toLength;
    }

    public String getShMau() {
        return shMau;
    }

    public void setShMau(String shMau) {
        this.shMau = shMau;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getFromLength() {
        return fromLength;
    }

    public void setFromLength(double fromLength) {
        this.fromLength = fromLength;
    }

    public double getToLength() {
        return toLength;
    }

    public void setToLength(double toLength) {
        this.toLength = toLength;
    }

    
    
    
    
}
