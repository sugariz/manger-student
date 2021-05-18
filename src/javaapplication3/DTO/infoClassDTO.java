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

public class infoClassDTO {
    
    private String idStudent;
    private String surName;
    private String name;
    private String idClass;
    private String className;
    private yearDTO objYear;
    private ArrayList<scoreDTO> diemMieng;
    private ArrayList<scoreDTO> diem15Phut;
    private ArrayList<scoreDTO> diem1Tiet;
    private scoreDTO diemHocKy = null;

    public infoClassDTO() {
        diemMieng = new ArrayList<scoreDTO>();
        diem15Phut = new ArrayList<scoreDTO>();
        diem1Tiet = new ArrayList<scoreDTO>();
    }

    public String getSurname() {
        return surName;
    }
    
    public String getName() {
        return this.name;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String getSurName() {
        return surName;
    }
    
    public void setScoreHocKy(scoreDTO diemHocKy) {
        this.diemHocKy = diemHocKy;
    }
    
    public scoreDTO getDiemHocKy() {
        return this.diemHocKy;
    }

    public float generateDiemTongKet() {
        float sum = 0;
        if(diemMieng.size() < 1 || diem15Phut.size() < 1 ||  diem1Tiet.size() < 1 || diemHocKy == null)
            return -1;
        System.err.println(diemMieng.size());
        System.err.println(diem15Phut.size());
        System.err.println(diem1Tiet.size());
        System.err.println(diemHocKy);
        for(scoreDTO score : this.diemMieng)
            sum += score.getScore();
        for(scoreDTO score : this.diem15Phut)
            sum += score.getScore();
        for(scoreDTO score : this.diem1Tiet)
            sum += score.getScore() * 2;
        sum += diemHocKy.getScore() * 3;
        
        return sum/(diemMieng.size() + diem15Phut.size() + diem1Tiet.size() * 2 + 3);
    }

    public String getClassId() {
        return idClass;
    }

    public String getClassName() {
        return className;
    }

    public yearDTO getObjYear() {
        return objYear;
    }

    public ArrayList<scoreDTO> getDiemMieng() {
        return diemMieng;
    }

    public ArrayList<scoreDTO> getDiem15Phut() {
        return diem15Phut;
    }

    public ArrayList<scoreDTO> getDiem1Tiet() {
        return diem1Tiet;
    }

    public void setSurname(String surName) {
        this.surName = surName;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setObjYear(yearDTO objYear) {
        this.objYear = objYear;
    }

    public void setDiemMieng(ArrayList<scoreDTO> diemMieng) {
        this.diemMieng = diemMieng;
    }

    public void setDiem15Phut(ArrayList<scoreDTO> diem15Phut) {
        this.diem15Phut = diem15Phut;
    }

    public void setDiem1Tiet(ArrayList<scoreDTO> diem1Tiet) {
        this.diem1Tiet = diem1Tiet;
    }

    public void addDiemMieng(scoreDTO score) {
        this.diemMieng.add(score);
    }
    
    public void addDiem15Phut(scoreDTO score) {
        this.diem15Phut.add(score);
    }
    
    public void addDiem1Tiet(scoreDTO score) {
        this.diem1Tiet.add(score);
    }
    
}
