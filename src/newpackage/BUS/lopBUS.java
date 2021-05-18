/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;

import java.util.ArrayList;
import javaapplication3.DAO.classDAO;
import javaapplication3.DTO.classDTO;

/**
 *
 * @author azu
 */
public class lopBUS {
    
    public static ArrayList<classDTO> listLop = null;
    
    public lopBUS() {}
    
    public String[] getLop() {
        this.build();
        
        String[] stringLop = new String[listLop.size()];
        int index = 0;
        for(classDTO lop : listLop) {
            stringLop[index] = lop.getTenLop();
            index += 1;
        }
        
        return stringLop;
    }
    
    public String[] getMaNamHoc() {
        this.build();
        
        String[] stringLop = new String[listLop.size()];
        int index = 0;
        for(classDTO lop : listLop) {
            stringLop[index] = lop.getMaNamHoc();
            index += 1;
        }
        
        return stringLop;
    }
    
    public void build() {
        if(listLop == null) {
            listLop = new classDAO().getLop();
        }
    }
    
}
