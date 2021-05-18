/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.infoClassDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class infoClassDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public infoClassDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<infoClassDTO> getClassList() {
        ArrayList<infoClassDTO> classList = new ArrayList<infoClassDTO>();
        String query = "SELECT lop.MALOP, lop.TENLOP, hocsinh.MAHS, hocsinh.HO, hocsinh.TEN "
                + "FROM chitietlop, lop, hocsinh "
                + "WHERE chitietlop.MALOP = lop.MALOP AND chitietlop.MAHOCSINH = hocsinh.MAHS";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                infoClassDTO student = new infoClassDTO();
                student.setIdClass(results.getString(1));
                student.setClassName(results.getString(2));
                student.setIdStudent(results.getString(3));
                student.setSurName(results.getString(4));
                student.setName(results.getString(5));
                classList.add(student);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return classList;
    }
    
}
