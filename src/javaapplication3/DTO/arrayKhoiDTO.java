/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DTO;

import java.util.ArrayList;

/**
 *
 * @author azu
 */
public class arrayKhoiDTO {
    
    private ArrayList<String> khoi;
    private ArrayList<String> maKhoi;
    
    public arrayKhoiDTO() {
        khoi = new ArrayList<String>();
        maKhoi = new ArrayList<String>();
    }

    public ArrayList<String> getKhoi() {
        return khoi;
    }

    public ArrayList<String> getMaKhoi() {
        return maKhoi;
    }

    public void setKhoi(ArrayList<String> khoi) {
        this.khoi = khoi;
    }

    public void setMaKhoi(ArrayList<String> maKhoi) {
        this.maKhoi = maKhoi;
    }
    
    public void addKhoi(String khoi) {
        this.khoi.add(khoi);
    }
    
    public void addMaKhoi(String maKhoi) {
        this.maKhoi.add(maKhoi);
    }
    
}
