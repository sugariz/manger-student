/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.mySQLConnect;
import javaapplication3.DTO.subjectDTO;

/**
 *
 * @author azu
 */
public class subjectDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public subjectDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<subjectDTO> getListSubject() {
        ArrayList<subjectDTO> listSubject = new ArrayList<subjectDTO>();
        String query = "SELECT * FROM monhoc";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                subjectDTO subject = new subjectDTO(
                    results.getString(1),
                    results.getString(2),
                    results.getInt(3),
                    results.getInt(4)
                );
                listSubject.add(subject);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return listSubject;
    }
    
}
