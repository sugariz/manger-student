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
public class scoreDTO {
    
    private int idScore;
    private String idStudent;
    private String idYears;
    private String idSemester;
    private String idClass;
    private String idScoreType;
    private String idSubject;
    private float score;

    public scoreDTO(int idScore, String idStudent, String idYears, String idSemester, String idClass, String idScoreType, String idSubject, float score) {
        this.idScore = idScore;
        this.idStudent = idStudent;
        this.idYears = idYears;
        this.idSemester = idSemester;
        this.idClass = idClass;
        this.idScoreType = idScoreType;
        this.idSubject = idSubject;
        this.score = score;
    }

    public int getIdScore() {
        return idScore;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String getIdYears() {
        return idYears;
    }

    public String getIdSemester() {
        return idSemester;
    }

    public String getIdClass() {
        return idClass;
    }

    public String getIdScoreType() {
        return idScoreType;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public float getScore() {
        return score;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public void setIdYears(String idYears) {
        this.idYears = idYears;
    }

    public void setIdSemester(String idSemester) {
        this.idSemester = idSemester;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public void setIdScoreType(String idScoreType) {
        this.idScoreType = idScoreType;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public void setScore(float score) {
        this.score = score;
    }
    
    @Override
    public String toString() {
        return String.format("%.2f", this.score);
    }

}
