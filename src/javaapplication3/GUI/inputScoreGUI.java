/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javaapplication3.DTO.hocKyDTO;
import javaapplication3.DTO.gradeDTO;
import javaapplication3.DTO.yearDTO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import newpackage.BUS.giaoVienBoMonBUS;
import newpackage.BUS.yearBUS;
import javaapplication3.DTO.classDTO;
import javaapplication3.DTO.subjectDTO;
import javaapplication3.DTO.infoClassDTO;
import newpackage.BUS.nhapDiemBUS;
import javaapplication3.DTO.scoreDTO;
import javaapplication3.DTO.semesterDTO;
import javaapplication3.DTO.studentDTO;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import newpackage.BUS.semesterBUS;

/**
 *
 * @author azu
 */

public class inputScoreGUI {

    private Font fontOfLabel = new Font("DENSE", Font.BOLD, 14);
    private JPanel panelScore;
    private JPanel panelOption;
    private JPanel panelChangeData;
    private JTextField textSTT;
    private JTextField textHoTen;
    private JTextField textDiem;
    private aTable tableData;
    private JLabel labelDiem;
    private JScrollPane scrollPanelScore;
    private JComboBox<yearDTO> jComboBoxYears = new JComboBox<yearDTO>();
    private JComboBox<classDTO> jComboBoxClass = new JComboBox<classDTO>();
    private JComboBox<gradeDTO> jComboBoxGrade = new JComboBox<gradeDTO>();
    private JComboBox<subjectDTO> jComboBoxMonHoc = new JComboBox<subjectDTO>();
    private JComboBox<hocKyDTO> jComboBoxSemester = new JComboBox<hocKyDTO>();
    private int permistion = 0;
    private String maGv;
    giaoVienBoMonBUS giaoVienBoMonBus;
    
    ArrayList<infoClassDTO> thongTinDiem;
    nhapDiemBUS nhapDiemBus;
    int indexChose = -1;
    String type = "";

    String[] headers = {"STT", "Họ và tên", "M1", "M2", "15P1", "15P2", "1T1", "1T2", "Thi", "ĐTB"};

    public inputScoreGUI(String maGv, JPanel myPanel) {
        super();
        this.maGv = maGv;
        this.giaoVienBoMonBus = new giaoVienBoMonBUS(this.maGv);
        nhapDiemBus = new nhapDiemBUS(this.maGv);
        this.build(myPanel);
    }

    private void build(JPanel myPanel) {
        this.panelScore = new JPanel();
        this.panelOption = new JPanel();
        this.panelChangeData = new JPanel();
        
        this.configPanel(panelScore, Color.WHITE, new Dimension(950, 450));
        this.configPanel(panelOption, Color.WHITE, new Dimension(950, 50));
        this.configPanel(panelChangeData, Color.WHITE, new Dimension(950, 100));

        this.buildPanelOption(jComboBoxYears, jComboBoxSemester, jComboBoxGrade, jComboBoxClass, jComboBoxMonHoc);
        this.buildPanelScore(jComboBoxYears, jComboBoxSemester, jComboBoxGrade, jComboBoxClass, jComboBoxMonHoc);
        this.buildPanelChangeData();
        
        myPanel.add(this.panelOption);
        myPanel.add(this.panelChangeData);
        myPanel.add(this.scrollPanelScore);

    }

    private void buildPanelScore(JComboBox... comboBoxs) {
        ArrayList<Object[]> dataBody;
        
        thongTinDiem = nhapDiemBus.getScore(
                ((subjectDTO)comboBoxs[4].getSelectedItem()).getIdSubject(),
                ((semesterDTO)comboBoxs[1].getSelectedItem()).getMaHocKy(),
                ((classDTO)comboBoxs[3].getSelectedItem()).getMaLop(),
                ((yearDTO)comboBoxs[0].getSelectedItem()).getMaNamHoc());
        
        dataBody = this.createData(thongTinDiem);
        
        tableData = new aTable(dataBody, headers);
        this.configTable(tableData, 0);
        scrollPanelScore = new JScrollPane(tableData);
        this.setScrollPanel(scrollPanelScore, 450);
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aTableMouseClicked(evt, tableData);
            }
        });
    }
    
    private ArrayList<Object[]> createData(ArrayList<infoClassDTO> thongTinDiem) {
        ArrayList<Object[]> dataBody = new ArrayList<Object[]>();
        for(int i = 0; i < thongTinDiem.size(); i++) {
            int index = 0;
            infoClassDTO ttd = thongTinDiem.get(i);
            Object[] rowData = new Object[3 + 2 + 2 + 2 + 1];
            rowData[index] = i + 1;
            index += 1;
            // filter
            rowData[index] = new studentDTO(ttd.getIdStudent(), ttd.getSurname(), ttd.getName());
            index += 1;
            for(scoreDTO score : ttd.getDiemMieng()) {
                rowData[index] = score;
                index += 1;
            }
            index = 4;
            for(scoreDTO score : ttd.getDiem15Phut()) {
                rowData[index] = score;
                index += 1;
            }
            index = 6;
            for(scoreDTO score : ttd.getDiem1Tiet()) {
                rowData[index] = score;
                index += 1;
            }
            index = 8;
            if(ttd.getDiemHocKy() != null)
                rowData[index] = ttd.getDiemHocKy();
            index = 9;
            float scoreFinal = ttd.generateDiemTongKet();
            if(scoreFinal != -1)
                rowData[index] = scoreFinal;
            dataBody.add(rowData);
        }
        
        return dataBody;
    }

    private void buildPanelOption(JComboBox... comboBoxs) {
        ArrayList<yearDTO> oYears = null;
        ArrayList<semesterDTO> oSemester = null;
        ArrayList<gradeDTO> oGrades = null;
        ArrayList<subjectDTO> oSubjects = null;
        ArrayList<classDTO> oClass = null;
        oYears = new yearBUS().getNamHocDTO();
        if (oYears.size() == 0) {
            comboBoxs[0].addItem("none");
        }
        else
            oSemester = new semesterBUS().getSemesterDTO();
        if (oSemester.size() == 0) {
            comboBoxs[1].addItem("none");
        }
        else
            oGrades = this.giaoVienBoMonBus.getKhoi(oYears.get(0).getMaNamHoc());
        if (oGrades.size() == 0) {
            comboBoxs[2].addItem("none");
        }
        else
            oClass = this.giaoVienBoMonBus.getLopHoc(oYears.get(0).getMaNamHoc(), oGrades.get(0).getMaKhoi());
        if (oClass == null) {
            comboBoxs[3].addItem("none");
        }
        else
            oSubjects = this.giaoVienBoMonBus.getMonHoc(oClass.get(0).getMaLop());
        if (oSubjects == null) {
            comboBoxs[4].addItem("none");
        }

        oYears.forEach(cnsmr -> {
            comboBoxs[0].addItem(cnsmr);
        });
        
        oSemester.forEach(cnsmr -> {
            comboBoxs[1].addItem(cnsmr);
        });
        
        oClass.forEach(cnsmr -> {
            comboBoxs[3].addItem(cnsmr);
        });
        
        oGrades.forEach(cnsmr -> {
            comboBoxs[2].addItem(cnsmr);
        });

        oSubjects.forEach(cnsmr -> {
            comboBoxs[4].addItem(cnsmr);
        });
        
        JLabel labelYears = new JLabel("Năm học");
        labelYears.setFont(fontOfLabel);
        JLabel labelClass = new JLabel("Lớp");
        labelClass.setFont(fontOfLabel);
        JLabel labelGrade = new JLabel("Khối");
        labelGrade.setFont(fontOfLabel);
        JLabel labelSemester = new JLabel("Học kỳ");
        labelSemester.setFont(fontOfLabel);
        JLabel labelMonHoc = new JLabel("Môn học");
        labelMonHoc.setFont(fontOfLabel);
        
        JButton buttonXem = new JButton("Xem");
        this.configButton(buttonXem, new Dimension(70, 30));

        this.panelOption.add(labelYears);
        this.panelOption.add(comboBoxs[0]);
        this.panelOption.add(labelSemester);
        this.panelOption.add(jComboBoxSemester);
        this.panelOption.add(labelGrade);
        this.panelOption.add(comboBoxs[2]);
        this.panelOption.add(labelClass);
        this.panelOption.add(comboBoxs[3]);
        this.panelOption.add(labelMonHoc);
        this.panelOption.add(comboBoxs[4]);
        this.panelOption.add(buttonXem);

        this.action(comboBoxs[0], comboBoxs[2], this.giaoVienBoMonBus, oGrades, this.maGv);
        this.action(comboBoxs[2], comboBoxs[3], this.giaoVienBoMonBus, oClass, this.maGv, oYears.get(0).getMaNamHoc());
        this.action(comboBoxs[3], comboBoxs[4], this.giaoVienBoMonBus, oSubjects, this.maGv, oGrades.get(0).getMaKhoi());
                
        this.configJComboBox(comboBoxs[0], new Dimension(110, 30));
        this.configJComboBox(comboBoxs[1], new Dimension(90, 30));
        this.configJComboBox(comboBoxs[2], new Dimension(60, 30));
        this.configJComboBox(comboBoxs[3], new Dimension(80, 30));
        this.configJComboBox(comboBoxs[4], new Dimension(100, 30));
        
        buttonXem.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                buttonXemAction(comboBoxs[0], comboBoxs[1], comboBoxs[2], comboBoxs[3], comboBoxs[4]);
            }
        } );
    }

    private void buildPanelChangeData() {
        JLabel labelSTT = new JLabel("STT");
        JLabel labelHoTen = new JLabel("Họ tên");
        labelDiem = new JLabel("Miệng");

        textSTT = new JTextField();
        textHoTen = new JTextField();
        textDiem = new JTextField();
        
        labelDiem.setPreferredSize(new Dimension(60, 30));
        
        this.configInput(textSTT, new Dimension(30, 30), false, true);
        this.configInput(textHoTen, new Dimension(200, 30), false, true);
        this.configInput(textDiem, new Dimension(50, 30), true, false);
        textSTT.setEditable(false);
        textSTT.setHorizontalAlignment(JTextField.CENTER);
        textHoTen.setEditable(false);
        textDiem.setHorizontalAlignment(JTextField.CENTER);
        
        labelSTT.setFont(fontOfLabel);
        labelHoTen.setFont(fontOfLabel);
        labelDiem.setFont(fontOfLabel);

        JButton buttonCapNhat = new JButton("Cập nhật");
        this.configButton(buttonCapNhat, new Dimension(100, 30));

        this.panelChangeData.add(labelSTT);
        this.panelChangeData.add(textSTT);
        this.panelChangeData.add(labelHoTen);
        this.panelChangeData.add(textHoTen);
        this.panelChangeData.add(labelDiem);
        this.panelChangeData.add(textDiem);
        this.panelChangeData.add(buttonCapNhat);
        
        buttonCapNhat.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                actionUpdate();
            }
        });
    }

    private void actionUpdate() {
        String score = textDiem.getText();
        try {
            Float.parseFloat(score);
            }
        catch(Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Vui lòng nhập số từ 0 đến 10", "ERROR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tableData.getModel();
        int row = tableData.getSelectedRow();
        int column = tableData.getSelectedColumn();
        Object cellTable = model.getValueAt(row, column);
        int idScore = -1;
        if(cellTable != null)
            idScore = ((scoreDTO)model.getValueAt(row, column)).getIdScore();

        scoreDTO newScore = new scoreDTO(
                    idScore,
                    ((studentDTO)model.getValueAt(row, 1)).getIdStudent(),
                    ((yearDTO)jComboBoxYears.getSelectedItem()).getMaNamHoc(),
                    ((semesterDTO)jComboBoxSemester.getSelectedItem()).getMaHocKy(),
                    ((classDTO)jComboBoxClass.getSelectedItem()).getMaLop(),
                    type,
                    ((subjectDTO)jComboBoxMonHoc.getSelectedItem()).getIdSubject(),
                    textDiem.getText().equals("") ? -1 : Float.parseFloat(textDiem.getText())
                );
        
        if(permistion == 1) {
            if(score.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Vui lòng nhập số từ 0 đến 10", "ERROR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                nhapDiemBus.insertScore(newScore);
                loadPage();
                configTable(tableData, 0);
            }
        }
        else {
            if(score.equals("")) {
                nhapDiemBus.deleteScore(newScore);
                model.setValueAt(newScore, row, column);
                loadPage();;
                configTable(tableData, 0);
            }
            else {
                nhapDiemBus.updateScore(newScore);
                loadPage();
                configTable(tableData, 0);
            }
        }
    }
    
    private void loadPage() {
        ArrayList<infoClassDTO> thongTinDiem = nhapDiemBus.getScore(
        ((subjectDTO)jComboBoxMonHoc.getSelectedItem()).getIdSubject(),
        ((semesterDTO)jComboBoxSemester.getSelectedItem()).getMaHocKy(),
        ((classDTO)jComboBoxClass.getSelectedItem()).getMaLop(),
        ((yearDTO)jComboBoxYears.getSelectedItem()).getMaNamHoc());
        ArrayList<Object[]> dataRow = this.createData(thongTinDiem);
        javax.swing.table.DefaultTableModel tm = new javax.swing.table.DefaultTableModel(new Object[0][0], headers);
        for(Object[] ele : dataRow) {
            tm.addRow(ele);
        }
        tableData.setData(tm);
        tableData.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableData.getColumnModel().getColumn(1).setPreferredWidth(140);
    }
    
    private void buttonXemAction(JComboBox... comboBoxs) {
        loadPage();
        configTable(tableData, 0);
    }

    private void action(JComboBox jComboAction, JComboBox jComboResult, giaoVienBoMonBUS giaoVienBomon, Object gener, String... maybe) {
        class MyItemListener implements ItemListener {

            public void itemStateChanged(ItemEvent evt) {
                JComboBox cb = (JComboBox) evt.getSource();
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    Object condi = cb.getSelectedItem();
                    ArrayList<Object> result;
                    DefaultComboBoxModel dcm = new DefaultComboBoxModel();
                    jComboResult.setModel(dcm);

                    switch (condi.getClass().getSimpleName()) {
                        case "yearDTO":
                            ((ArrayList<gradeDTO>) gener).clear();
                            ((ArrayList<gradeDTO>) gener).addAll(giaoVienBomon.getKhoi(((yearDTO) condi).getMaNamHoc()));
                            break;
                        case "gradeDTO":
                            ((ArrayList<classDTO>) gener).clear();
                            ((ArrayList<classDTO>) gener).addAll(giaoVienBomon.getLopHoc(maybe[1], ((gradeDTO) condi).getMaKhoi()));
                            break;
                        case "classDTO":
                            ((ArrayList<subjectDTO>) gener).clear();
                            ((ArrayList<subjectDTO>) gener).addAll(giaoVienBomon.getMonHoc(((classDTO) condi).getMaLop()));
                            break;
                        case "semesterDTO":

                        default:
                            ((ArrayList<Object>) gener).clear();
                    }
                    if (((ArrayList<Object>) gener).isEmpty()) {
                        dcm.addElement("none");
                    }
                    for (Object newRow : ((ArrayList<Object>) gener)) {
                        dcm.addElement(newRow);
                    }
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    // Item is no longer selected
                }
            }
        }

        jComboAction.addItemListener(new MyItemListener());
    }

    private void aTableMouseClicked(MouseEvent evn, aTable tableData) {
        DefaultTableModel model = (DefaultTableModel) tableData.getModel();
        int selectRow = tableData.getSelectedRow();
        int selectColumn = tableData.getSelectedColumn();
        if (selectRow == 0 || selectColumn == 0 || selectColumn == 1 || selectColumn == 9) {
            return;
        }
        textSTT.setText(model.getValueAt(selectRow, 0) != null ? model.getValueAt(selectRow, 0).toString() : null);
        textHoTen.setText(model.getValueAt(selectRow, 1) != null ? model.getValueAt(selectRow, 1).toString() : null);
        String scoreSelect = model.getValueAt(selectRow, selectColumn) != null ? model.getValueAt(selectRow, selectColumn).toString() : null;
        if(scoreSelect == null) {
            permistion = 1;
            textDiem.setText("");
        }
        else {
            permistion = 2;
            textDiem.setText(scoreSelect);
        }
        switch (selectColumn) {
            case 2:
                indexChose = 1;
                type = "MIENG";
                labelDiem.setText("Miệng"); break;
            case 3:
                type = "MIENG";
                indexChose = 2;
                labelDiem.setText("Miệng"); break;
            case 4:
                type = "15PHUT";
                indexChose = 1;
                labelDiem.setText("15 phút"); break;
            case 5:
                type = "15PHUT";
                indexChose = 2;
                labelDiem.setText("15 phút"); break;
            case 6:
                type = "1TIET";
                indexChose = 1;
                labelDiem.setText("1 tiết"); break;
            case 7:
                type = "1TIET";
                indexChose = 2;
                labelDiem.setText("1 tiết"); break;
            case 8:
                type = "HOCKY";
                indexChose = 1;
                labelDiem.setText("Học kỳ"); break;
        }
    }

    private void setScrollPanel(JScrollPane myScrollPane, int height) {
        myScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        myScrollPane.setPreferredSize(new Dimension(950, height));
        myScrollPane.setBackground(new Color(255, 255, 255));
    }

    private void configPanel(JPanel myPanel, Color colorBackGround, Dimension size) {
        myPanel.setBackground(colorBackGround);
        myPanel.setPreferredSize(size);
    }
    
    private void configJComboBox(JComboBox combobox, Dimension size) {
        UIManager.put("ComboBox.background", new ColorUIResource(Color.WHITE));
        UIManager.put("JTextField.background", new ColorUIResource(Color.WHITE));
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.WHITE));
        UIManager.put("ComboBox.selectionForeground", new ColorUIResource(new Color(72,128,248)));
        combobox.setFont(new Font("DENSE", Font.PLAIN, 14));
        combobox.getEditor().getEditorComponent().setBackground(Color.WHITE);
        ((JTextField) combobox.getEditor().getEditorComponent()).setBackground(Color.WHITE);
        combobox.setPreferredSize(size);
        combobox.setBorder(new javax.swing.border.LineBorder(new Color(206,210,214), 1));

        combobox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = super.createArrowButton();
                b.setBorder(new EmptyBorder(0, 0, 0, 0));
                b.setBackground(Color.WHITE);
                b.setBorderPainted(false);
                return b; 
           }
        });
    }
    
    private void configInput(JTextField myTextField, Dimension size, boolean check, boolean disable) {
        myTextField.setFont(new Font("DENSE", Font.PLAIN, 16));
        myTextField.setPreferredSize(size);
        myTextField.setBorder(new javax.swing.border.LineBorder(new Color(206, 210, 214), 1));
        if(!disable)
            myTextField.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    myTextField.setBorder(new javax.swing.border.LineBorder(new Color(1, 122, 255), 1));
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    myTextField.setBorder(new javax.swing.border.LineBorder(new Color(166, 170, 173), 1));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    myTextField.setBorder(new javax.swing.border.LineBorder(new Color(206, 210, 214), 1));
                }
            });
        if(check)
            myTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                @Override
                public void changedUpdate(javax.swing.event.DocumentEvent e) {
                    warn();
                }
                @Override
                public void removeUpdate(javax.swing.event.DocumentEvent e) {
                    warn();
                }
                @Override
                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    warn();
                }
                public void warn() {
                    try {
                        float num = Float.parseFloat(myTextField.getText());
                        if(num < 0 || num > 10)
                            myTextField.setBorder(new javax.swing.border.LineBorder(new Color(232, 64, 64), 1));
                        else
                            myTextField.setBorder(new javax.swing.border.LineBorder(new Color(1, 122, 255), 1));
                    }
                    catch (NumberFormatException e) {
                        myTextField.setBorder(new javax.swing.border.LineBorder(new Color(232, 64, 64), 1));
                    }
                }
            });
    }
    
    private void configButton(JButton myButton, Dimension size) {
        myButton.setPreferredSize(size);
        myButton.setFont(fontOfLabel);
        myButton.setBackground(new Color(1, 122, 255));
        myButton.setForeground(Color.WHITE);
        myButton.setFocusPainted(false);
        myButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                myButton.setBackground(new Color(1, 122, 255));
            }
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                myButton.setBackground(new Color(0, 80, 200));
            }
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myButton.setBackground(new Color(12, 98, 228));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myButton.setBackground(new Color(1, 122, 255));
            }
        });
    }
    
    private void configTable(JTable table, int column) {
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(column).setCellRenderer( centerRenderer );
    }
    
    public static void main(String[] args) {
//        nhapDiemGUI myFrame = new nhapDiemGUI();
//        myFrame.pack();
//        myFrame.setLocationRelativeTo(null);
//        myFrame.setVisible(true);
//        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
