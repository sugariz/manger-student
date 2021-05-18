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
public class nhapDiemDTO {
    
    private String maHS;
    private String maMon;
    private String maHocKy;
    private String maLoai;
    private String maLop;
    private String maNamHoc;
    private float diem;

    public nhapDiemDTO(String maHS, String maMon, String maHocKy, String maLoai, String maLop, String maNamHoc, float diem) {
        this.maHS = maHS;
        this.maMon = maMon;
        this.maHocKy = maHocKy;
        this.maLoai = maLoai;
        this.maLop = maLop;
        this.maNamHoc = maNamHoc;
        this.diem = diem;
    }

    public String getMaHS() {
        return maHS;
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

    public float getDiem() {
        return diem;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
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

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
}
