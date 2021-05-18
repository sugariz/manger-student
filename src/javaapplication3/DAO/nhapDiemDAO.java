/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.nhapDiemDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class nhapDiemDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public nhapDiemDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    private String idScore;
    private String idStudent;
    private String idYears;
    private String idSemester;
    private String idClass;
    private String idScoreType;
    private String idSubject;
    private float score;
    
    public ArrayList<nhapDiemDTO> getDiem(String maGV) {
        ArrayList<nhapDiemDTO> listDiem = new ArrayList<nhapDiemDTO>();
        String query = "SELECT diem.MADIEM, diem.MAHS, diem.MANAMHOC, diem.MAHOCKY, diem.MALOP, diem.MALOAI, diem.MAMON, diem.DIEM " +
                        "FROM diem, monhoc, giaovienbomon " +
                        "WHERE DIEM.MAMON = MONHOC.MAMONHOC AND MONHOC.MAMONHOC = GIAOVIENBOMON.MAMONHOC AND GIAOVIENBOMON.MAGV = '" + maGV +"'";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                nhapDiemDTO diem = new nhapDiemDTO(
                    results.getString(1),
                    results.getString(2),
                    results.getString(3),
                    results.getString(4),
                    results.getString(5),
                    results.getString(6),
                    results.getFloat(7)
                );
                listDiem.add(diem);
            }
        }
        catch(Exception e) {
            
        }
        
        return listDiem;
    }
    
    public void setDiem() {
        String query = "INSERT INTO HOCSINH VALUES ()";
    }
    
}
