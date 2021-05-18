/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;

import java.util.ArrayList;
import javaapplication3.DAO.yearDAO;
import javaapplication3.DTO.yearDTO;

/**
 *
 * @author azu
 */
public class yearBUS {
    
    public static ArrayList<yearDTO> listNamHoc = null;
    
    public yearBUS() {}
    
    public String[] getNamHoc() {
        this.build();
        
        String[] stringNamHoc = new String[listNamHoc.size()];
        int index = 0;
        for(yearDTO namhoc : listNamHoc) {
            stringNamHoc[index] = namhoc.getTenNamHoc();
            index += 1;
        }
        
        return stringNamHoc;
    }
    
    public String[] getMaNamHoc() {
        this.build();
        
        String[] stringNamHoc = new String[listNamHoc.size()];
        int index = 0;
        for(yearDTO namhoc : listNamHoc) {
            stringNamHoc[index] = namhoc.getMaNamHoc();
            index += 1;
        }
        
        return stringNamHoc;
    }
    
    public ArrayList<yearDTO> getNamHocDTO() {
       this.build();
       
       return this.listNamHoc;
    }
    
    public void build() {
        if(listNamHoc == null)
            listNamHoc = new yearDAO().getListYear();
    }
    
}
