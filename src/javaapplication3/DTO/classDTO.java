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
public class classDTO {
    
    private String maLop;
    private String tenLop;
    private String maKhoiLop;
    private String maNamHoc;
    private int siSo;
    private String maGiaoVien;

    public classDTO(String maLop, String tenLop, String maKhoiLop, String maNamHoc, int siSo, String maGiaoVien) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maKhoiLop = maKhoiLop;
        this.maNamHoc = maNamHoc;
        this.siSo = siSo;
        this.maGiaoVien = maGiaoVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getMaKhoiLop() {
        return maKhoiLop;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public int getSiSo() {
        return siSo;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setMaKhoiLop(String maKhoiLop) {
        this.maKhoiLop = maKhoiLop;
    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }
    
    @Override
    public String toString() {
        return this.tenLop;
    }
    
}
