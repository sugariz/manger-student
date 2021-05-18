/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;

import java.util.ArrayList;
import javaapplication3.DAO.semesterDAO;
import javaapplication3.DTO.semesterDTO;

/**
 *
 * @author azu
 */
public class semesterBUS {
    
    public static ArrayList<semesterDTO> listSemester = null;
    
    public semesterBUS() {
        
    }
    
    public ArrayList<semesterDTO> getSemesterDTO() {
        this.build();
        
        return this.listSemester;
    }
    
    private void build() {
        if(listSemester == null)
            listSemester = new semesterDAO().getListSemester();
    }
    
}
