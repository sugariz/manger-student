/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;

import java.util.ArrayList;
import javaapplication3.DAO.studentDAO;
import javaapplication3.DTO.studentDTO;

/**
 *
 * @author azu
 */
public class studentBUS {
    
    public static ArrayList<studentDTO> listStudent = null;
    public static String idClass = null;
    
    public studentBUS() {
        
    }
    
    public ArrayList<studentDTO> getListStudentOfClass(String idClass) {
        this.build(idClass);
//        ArrayList<studentDTO> listStudent = new  ArrayList<studentDTO>();

        
        return listStudent;
    }
    
    public void build(String idClass) {
        if(listStudent == null)
            listStudent = new studentDAO().getListInfoStudent();
    }
    
}
