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
public class diemDTO {
    String maChiTietDiem;
    String maHocSinh;
    String maMon;
    String maHocKy;
    String maLoai;
    String maLop;
    String maNamHoc;
    String diem;

    public diemDTO(String maChiTietDiem, String maHocSinh, String maMon, String maHocKy, String maLoai, String maLop, String maNamHoc, String diem) {
        this.maChiTietDiem = maChiTietDiem;
        this.maHocSinh = maHocSinh;
        this.maMon = maMon;
        this.maHocKy = maHocKy;
        this.maLoai = maLoai;
        this.maLop = maLop;
        this.maNamHoc = maNamHoc;
        this.diem = diem;
    }

    public String getMaChiTietDiem() {
        return maChiTietDiem;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getMaHocKy() {
        return maHocKy;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public String getDiem() {
        return diem;
    }

    public void setMaChiTietDiem(String maChiTietDiem) {
        this.maChiTietDiem = maChiTietDiem;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setMaHocKy(String maHocKy) {
        this.maHocKy = maHocKy;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
    
}
