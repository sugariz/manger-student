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
public class subjectDTO {
    
    private String idSubject;
    private String nameSubject;
    private int numberCourse;
    private int coefficient;

    public subjectDTO(String idSubject, String nameSubject, int numberCourse, int coefficient) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.numberCourse = numberCourse;
        this.coefficient = coefficient;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public int getNumberCourse() {
        return numberCourse;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public void setNumberCourse(int numberCourse) {
        this.numberCourse = numberCourse;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
    
    @Override
    public String toString() {
        return this.nameSubject;
    }
    
}
