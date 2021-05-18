/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azu
 */
public class database {
    
    String[] headers;
    Vector<Vector<String>> rowData;
    Vector<String> row;
    ResultSet results;
    mySQLConnect connect;
    
    public database() throws Exception {
        connect = new mySQLConnect("localhost", "root", "", "QUAN_LY_HOC_SINH");
        
//        connect.Close();
    }
    
    public String[][] getScore(String maHS) {
        
        String query = 
            "SELECT RS.TENMONHOC, " +
                "(CASE WHEN RS.MALOAI ='MIENG' THEN RS.DIEM ELSE NULL END) AS 'MIENG', " +
                "(CASE WHEN RS.MALOAI ='15PHUT'THEN RS.DIEM ELSE NULL END) AS '15 PHUT', " +
                "(CASE WHEN RS.MALOAI ='1TIET'THEN RS.DIEM ELSE NULL END) AS '1 TIET', " +
                "(CASE WHEN RS.MALOAI ='HOCKY'THEN RS.DIEM ELSE NULL END) AS 'HOCKY' " +
            "FROM (SELECT DIEM.MALOAI, DIEM.DIEM, MONHOC.TENMONHOC " +
                "FROM `DIEM`, `LOAIDIEM`, `MONHOC` " +
                "WHERE DIEM.MALOAI = LOAIDIEM.MALOAI AND DIEM.MAMON = MONHOC.MAMONHOC AND DIEM.MAHS = " + maHS + ") AS RS ";
        row = new Vector<String>();
        String[] sujects = {"Toán", "Sinh Học","Vật Lý","Hóa Học", "Lịch Sử", "Địa Lý","Tiếng Anh","Thể Dục","Tin Học"};
        String[][] data = {{"        Toán", "", "", "", "", "10"},
                           {"        Sinh Học", "", "", "", "", ""},
                           {"        Vật Lý", "", "", "", "", ""},
                           {"        Hóa Học", "", "", "", "", ""},
                           {"        Lịch Sử", "", "", "", "", ""},
                           {"        Địa Lý", "", "", "", "", ""},
                           {"        Tiếng Anh", "", "", "", "", ""},
                           {"        Thể Dục", "", "", "", "", ""},
                           {"        Công Nghệ", "", "", "", "", ""}};
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                int index = java.util.Arrays.asList(sujects).indexOf(results.getString(1));
                if(index != -1) {
                    for(int i = 2; i <= 5; i++) {
                        if (results.getString(i) != null) {
                            if(data[index][i - 1] == "")
                                data[index][i - 1] = String.format("%s",results.getString(i));
                            else
                                data[index][i - 1] = String.format("%s, %s", data[index][i - 1], results.getString(i));
                            break;
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            System.err.println(e);
            return data;
        }
        
        return data;
    }
    
    public Vector<String> getStudentInClass(String _class, String _year, String _semester) throws Exception {
        String query = "SELECT HOCSINH.MAHS, HOCSINH.Họ, HOCSINH.Tên "
                + "FROM `CHITIETLOP`, `HOCSINH`"
                + " WHERE MANAMHOC =" + _year
                + " AND MALOP = " + _class
                + " AND CHITIETLOP.MAHOCSINH = HOCSINH.MAHS";
        results = connect.executeQuery(query);
        Vector<String> data = new Vector<String>();
        while(results.next()) {
            data.addElement(results.getString(1));
        }
        
        return data;
    }
    
    public Vector<Vector<String>> getQuery(String[] headers) throws Exception {
        results = connect.executeQuery("SELECT * FROM HOCSINH");
        
        this.headers = headers;
        rowData = new Vector<Vector<String>>(); 
        row = new Vector<String>();
        
        while (results.next()) {
            for(String header : this.headers)
                row.addElement(results.getString(header));
            rowData.addElement((Vector<String>)row.clone());
            row.clear();
        }
        
        return rowData;
    }
    
    public USER login() throws Exception {
        
        
        USER user = new USER();
        return user;
    }
    
    public void update() throws Exception {
        connect.executeUpdate("UPDATE HOCSINH SET TÊN='123'");
    }
    
    public void addRow(JTable myTable) {
        DefaultTableModel model =(DefaultTableModel) myTable.getModel();
        Vector data = new Vector();
        model.addRow(data);
        myTable.setModel(model);
    }
    
    public void addRowToDatabase(String query) throws Exception {
        connect.executeUpdate("INSERT INTO HOCSINH " + "VALUES" + query);
    }
    
    public void deleteRowToDatabase(String query) throws Exception {
        connect.executeUpdate("DELETE FROM HOCSINH WHERE HOCSINH.MAHS=" + query);
    }
    
    public void editRowToDatabase(String query) throws Exception {
//        connect.executeUpdate("UPDATE HOCSINH SET " + query);
    }
    
    public void deleteRow(JTable myTable) {
        DefaultTableModel model = (DefaultTableModel) myTable.getModel();
        if (myTable.getSelectedRow() == -1) {
            if (myTable.getRowCount() == 0) {
//                lblError.setText("Bảng trống!");
            }
            else{
//                lblError.setText("Bạn cần phải chọn một dòng");
            }
        }
        else{
            model.removeRow(myTable.getSelectedRow());
        }
    }
    
    public void updateRow(JTable myTable) {
        if (myTable.getSelectedRow()==-1) {
            if (myTable.getRowCount()==0) {
//                lblError.setText("Bảng trống!");
            }
            else{
//                lblError.setText("Bạn cần phải chọn một dòng");
            }
        }
        else{
            DefaultTableModel model = (DefaultTableModel) myTable.getModel();
//            model.setValueAt(txtTennisPlayer.getText(), dgvTennisPlayer.getSelectedRow(), 0);
//            model.setValueAt(cboGrandSlam.getSelectedItem().toString(), dgvTennisPlayer.getSelectedRow(), 1);
//            model.setValueAt(txtChampion.getText(), dgvTennisPlayer.getSelectedRow(), 2);
        }
    }
    
    public static void main(String[] args) {
        try {
//            new database().getScore();
        }
        catch(Exception e) {
            
        }
    }
}
