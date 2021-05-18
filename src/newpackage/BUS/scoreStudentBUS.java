/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;
import javaapplication3.DAO.scoreDAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DAO.coefficientDAO;
import javaapplication3.DAO.subjectDAO;
import javaapplication3.DTO.coefficientDTO;
import javaapplication3.DTO.scoreDTO;
import javaapplication3.DTO.subjectDTO;

/**
 *
 * @author azu
 */
public class scoreStudentBUS {
    
    public static ArrayList<scoreDTO> results = null;
    public static ArrayList<coefficientDTO> coefficientList = null;
    public static ArrayList<subjectDTO> listSubject = null;
    
    public scoreStudentBUS() {}

    public String[][] getScoreListOfStudent(String maHS, String maHocKy, String maNamHoc) {
        String[] subjects = {"Toán", "Sinh Học","Vật Lý","Hóa Học", "Lịch Sử", "Địa Lý","Tiếng Anh","Thể Dục","Tin Học"};
        String[][] data = {{"        Toán", "", "", "", "", ""},
                           {"        Sinh Học", "", "", "", "", ""},
                           {"        Vật Lý", "", "", "", "", ""},
                           {"        Hóa Học", "", "", "", "", ""},
                           {"        Lịch Sử", "", "", "", "", ""},
                           {"        Địa Lý", "", "", "", "", ""},
                           {"        Tiếng Anh", "", "", "", "", ""},
                           {"        Thể Dục", "", "", "", "", ""},
                           {"        Công Nghệ", "", "", "", "", ""}};
        float[] scoreTongKet = new float[subjects.length];
        int[] heSo = new int[subjects.length];

        try {
            if(results == null)
                results = new scoreDAO().getScoreListOfStudent(maHS);
            if(listSubject == null)
                listSubject = new subjectDAO().getListSubject();
            for(scoreDTO score : results) {
                if(score.getIdYears().equals(maNamHoc) && score.getIdSemester().equals(maHocKy)) {
                    String nameSubject = listSubject.stream().filter(obj -> obj.getIdSubject().equals(score.getIdSubject()))
                        .findFirst().get().getNameSubject();
                    int index = java.util.Arrays.asList(subjects).indexOf(nameSubject);
                    if(index == -1) continue;
//                    int coefficient = listSubject.stream().filter(obj -> obj.getIdSubject().equals(score.getIdSubject()))
//                        .findFirst().get().getCoefficient();
                        
                    switch (score.getIdScoreType()) {
                        case "MIENG":
                            System.err.println(score.getScore());
                            this.doit(data, index, 1, String.valueOf(score.getScore()));
                            scoreTongKet[index] += score.getScore() * 1;
                            heSo[index] += 1;
                            break;
                        case "15PHUT":
                            this.doit(data, index, 2, String.valueOf(score.getScore()));
                            scoreTongKet[index] += score.getScore() * 1;
                            heSo[index] += 1;
                            break;
                        case "1TIET":
                            this.doit(data, index, 3, String.valueOf(score.getScore()));
                            scoreTongKet[index] += score.getScore() * 2;
                            heSo[index] += 2;
                            break;
                        case "HOCKY":
                            this.doit(data, index, 4, String.valueOf(score.getScore()));
                            scoreTongKet[index] += score.getScore() * 3;
                            heSo[index] += 3;
                            break;
                    }
                    
                }
            }

            for(int i = 0; i < subjects.length; i++)
                if(data[i][4] != "")
                    data[i][5] = String.valueOf(scoreTongKet[i]/heSo[i]);
                    
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return data;
    }
    
    private void doit(String[][] data, int index, int i, String score) {
        if(data[index][i] == "")
            data[index][i] = String.format("%s",score);
        else
            data[index][i] = String.format("%s, %s", data[index][i], score);
    }
    
    public static void main(String[] args) {
        try {
            new scoreStudentBUS().getScoreListOfStudent("3119410456", "HK1", "NH1920");
        }
        catch(Exception e) {
            
        }
    }
    
}
