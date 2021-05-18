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
public class coefficientDTO {
    
    private String idCoefficient;
    private String nameCoefficient;
    private int Coefficient;

    public coefficientDTO(String nameCoefficient, int Coefficient, String idCoefficient) {
        this.nameCoefficient = nameCoefficient;
        this.Coefficient = Coefficient;
        this.idCoefficient = idCoefficient;
    }

    public String getNameCoefficient() {
        return nameCoefficient;
    }

    public String getIdCoefficient() {
        return idCoefficient;
    }

    public int getCoefficient() {
        return Coefficient;
    }

    public void setNameCoefficient(String nameCoefficient) {
        this.nameCoefficient = nameCoefficient;
    }

    public void setCoefficient(int Coefficient) {
        this.Coefficient = Coefficient;
    }

    public void setIdCoefficient(String idCoefficient) {
        this.idCoefficient = idCoefficient;
    }
    
    @Override
    public String toString() {
        return this.nameCoefficient;
    }

}
