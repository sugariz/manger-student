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
public class yearDTO {
    
    private String maNamHoc;
    private String tenNamHoc;

    public yearDTO(String maNamHoc, String tenNamHoc) {
        this.maNamHoc = maNamHoc;
        this.tenNamHoc = tenNamHoc;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public String getTenNamHoc() {
        return tenNamHoc;
    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public void setTenNamHoc(String tenNamHoc) {
        this.tenNamHoc = tenNamHoc;
    }
    
    @Override
    public String toString() {
        return this.tenNamHoc;
    }
    
}
