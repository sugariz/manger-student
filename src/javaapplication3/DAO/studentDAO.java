/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.studentDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class studentDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public studentDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<studentDTO> getListInfoStudent() {
        ArrayList<studentDTO> listStudent = new ArrayList<studentDTO>();
        String query = "SELECT * FROM hocsinh";
        
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                studentDTO student = new studentDTO(
                    results.getString(1),
                    results.getString(2),
                    results.getString(3),
                    results.getString(4),
                    results.getString(5),
                    results.getString(6),
                    results.getString(7),
                    results.getString(8)
                );
                listStudent.add(student);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return listStudent;
    }
    
}
