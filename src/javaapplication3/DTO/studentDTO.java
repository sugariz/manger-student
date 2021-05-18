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
public class studentDTO {
    
    private String idStudent;
    private String surname;
    private String name;
    private String dob;
    private String address;
    private String a;
    private String email;
    private String phoneNumber;

    public studentDTO(String idStudent, String surname, String name, String dob, String address, String a, String email, String phoneNumber) {
        this.idStudent = idStudent;
        this.surname = surname;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.a = a;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public studentDTO(String idStudent, String surname, String name) {
        this.idStudent = idStudent;
        this.surname = surname;
        this.name = name;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getA() {
        return a;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", this.surname, this.name);
    }
    
}
