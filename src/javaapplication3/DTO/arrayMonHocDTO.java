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
public class arrayMonHocDTO {

    private ArrayList<String> maMonHoc;
    private ArrayList<String> monHoc;

    public arrayMonHocDTO() {
        maMonHoc = new ArrayList<String>();
        monHoc = new ArrayList<String>();
    }

    public ArrayList<String> getMaMonHoc() {
        return maMonHoc;
    }

    public ArrayList<String> getMonHoc() {
        return monHoc;
    }

    public void setMaMonHoc(ArrayList<String> maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public void setMonHoc(ArrayList<String> monHoc) {
        this.monHoc = monHoc;
    }
    
    public void addMonHoc(String monHoc) {
        this.monHoc.add(monHoc);
    }
    
    public void addMaMonHoc(String maMonHoc) {
        this.maMonHoc.add(maMonHoc);
    }

}
