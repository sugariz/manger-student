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
public class giaoVienBoMonDTO {
    
    private String maGv;
    private String monHoc;
    private String lopHoc;
    private String maNamHoc;
    private String maKhoiLop;

    public giaoVienBoMonDTO(String maGv, String monHoc, String lopHoc, String maNamHoc, String maKhoiLop) {
        this.maGv = maGv;
        this.monHoc = monHoc;
        this.lopHoc = lopHoc;
        this.maNamHoc = maNamHoc;
        this.maKhoiLop = maKhoiLop;
    }

    public String getMaGv() {
        return maGv;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public String getMaKhoiLop() {
        return maKhoiLop;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public void setMaKhoiLop(String maKhoiLop) {
        this.maKhoiLop = maKhoiLop;
    }

}
