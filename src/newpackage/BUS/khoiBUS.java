/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;

import java.util.ArrayList;
import javaapplication3.DAO.gradeDAO;
import javaapplication3.DTO.gradeDTO;

/**
 *
 * @author azu
 */
public class khoiBUS {
    
    public static ArrayList<gradeDTO> listKhoi;
    
    public khoiBUS() {}
    
    public String[] getKhoi() {
        this.build();
        
        String[] stringKhoi = new String[listKhoi.size()];
        int index = 0;
        for(gradeDTO khoi : listKhoi) {
            stringKhoi[index] = khoi.getTenKhoi();
            index += 1;
        }
        
        return stringKhoi;
    }
    
    public String[] getMaNamHoc() {
        this.build();
        
        String[] stringKhoi = new String[listKhoi.size()];
        int index = 0;
        for(gradeDTO khoi : listKhoi) {
            stringKhoi[index] = khoi.getMaKhoi();
            index += 1;
        }
        
        return stringKhoi;
    }
    
    public void build() {
        if(listKhoi == null)
            listKhoi = new gradeDAO().getGrade();
    }
    
}
