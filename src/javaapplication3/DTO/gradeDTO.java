/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DTO;

/**
 *
 * @author azu
 */
public class gradeDTO {
    
    private String maKhoi;
    private String tenKhoi;

    public gradeDTO(String maKhoi, String tenKhoi) {
        this.maKhoi = maKhoi;
        this.tenKhoi = tenKhoi;
    }

    public String getMaKhoi() {
        return maKhoi;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public void setMaKhoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }
    
    @Override
    public String toString() {
        return this.tenKhoi;
    }
    
}
