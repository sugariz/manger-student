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
public class hocKyBUS {
    
    public static ArrayList<semesterDTO> listHocKy = null;
    
    public hocKyBUS() {}
    
    public String[] getHocKy() {
        this.build();
        
        String[] stringHocKy = new String[listHocKy.size()];
        int index = 0;
        for(semesterDTO hocky : listHocKy) {
            stringHocKy[index] = hocky.getTenHocKy();
            index += 1;
        }
        
        return stringHocKy;
    }
    
    public String[] getMaHocKy() {
        this.build();
        
        String[] stringHocKy = new String[listHocKy.size()];
        int index = 0;
        for(semesterDTO hocky : listHocKy) {
            stringHocKy[index] = hocky.getMaHocKy();
            index += 1;
        }
        
        return stringHocKy;
    }
    
    public void build() {
        if(listHocKy == null)
            listHocKy = new semesterDAO().getListSemester();
    }
    
}
