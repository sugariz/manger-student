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
public class hocKyDTO {
    private String maHocKy;
    private String tenHocKy;

    public hocKyDTO(String maHocKy, String tenHocKy) {
        this.maHocKy = maHocKy;
        this.tenHocKy = tenHocKy;
    }

    public String getMaHocKy() {
        return maHocKy;
    }

    public String getTenHocKy() {
        return tenHocKy;
    }

    public void setMaHocKy(String maHocKy) {
        this.maHocKy = maHocKy;
    }

    public void setTenHocKy(String tenHocKy) {
        this.tenHocKy = tenHocKy;
    }
    
}
