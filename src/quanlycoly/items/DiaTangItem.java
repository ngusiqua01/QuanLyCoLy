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
public class DiaTangItem {
    String maDT;
    String tenDT;
    String maCT;
    String mota;

    public DiaTangItem(String maDT, String tenDT, String maCT, String mota) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.maCT = maCT;
        this.mota = mota;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
    
    
}
