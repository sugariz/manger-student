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
public class arrayLopDTO {
    
    public ArrayList<String> lop;
    public ArrayList<String> maLop;

    public arrayLopDTO() {
        this.lop = new ArrayList<String>();
        this.maLop = new ArrayList<String>();
    }

    public ArrayList<String> getLop() {
        return lop;
    }

    public ArrayList<String> getMaLop() {
        return maLop;
    }

    public void setLop(ArrayList<String> lop) {
        this.lop = lop;
    }

    public void setMaLop(ArrayList<String> maLop) {
        this.maLop = maLop;
    }
    
    public void addLop(String lop) {
        this.lop.add(lop);
    }
    
    public void addMaLop(String maLop) {
        this.maLop.add(maLop);
    }
    
}
