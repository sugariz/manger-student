/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.classDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class classDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public classDAO() {
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<classDTO> getLop() {
        ArrayList<classDTO> listLop = new ArrayList<classDTO>();
        String query = "SELECT * FROM lop";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                classDTO lop = new classDTO(
                    results.getString(1),
                    results.getString(2),
                    results.getString(3),
                    results.getString(4),
                    results.getInt(5),
                    results.getString(6)
                );
                listLop.add(lop);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return listLop;
    }
    
}
