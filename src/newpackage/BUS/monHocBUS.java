/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;

import java.util.ArrayList;
import javaapplication3.DAO.subjectDAO;
import javaapplication3.DTO.subjectDTO;

/**
 *
 * @author azu
 */
public class monHocBUS {
    
    public static ArrayList<subjectDTO> listMonHoc = null;
    
    public monHocBUS() {
    }
    
    public String[] getKhoi() {
        this.build();
        
        String[] stringMonHoc = new String[listMonHoc.size()];
        int index = 0;
        for(subjectDTO monHoc : listMonHoc) {
            stringMonHoc[index] = monHoc.getNameSubject();
            index += 1;
        }
        
        return stringMonHoc;
    }
    
    public String[] getMaNamHoc() {
        this.build();
        
        String[] stringMonHoc = new String[listMonHoc.size()];
        int index = 0;
        for(subjectDTO monHoc : listMonHoc) {
            stringMonHoc[index] = monHoc.getIdSubject();
            index += 1;
        }
        
        return stringMonHoc;
    }
    
    public void build() {
        if(listMonHoc == null)
            listMonHoc = new subjectDAO().getListSubject();
    }
    
}
