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
public class semesterDTO {
    private String idSemester;
    private String nameSemester;

    public semesterDTO(String idSemester, String nameSemester) {
        this.idSemester = idSemester;
        this.nameSemester = nameSemester;
    }

    public String getMaHocKy() {
        return idSemester;
    }

    public String getTenHocKy() {
        return nameSemester;
    }

    public void setMaHocKy(String idSemester) {
        this.idSemester = idSemester;
    }

    public void setTenHocKy(String nameSemester) {
        this.nameSemester = nameSemester;
    }
    
    @Override
    public String toString() {
        return this.nameSemester;
    }
    
}
