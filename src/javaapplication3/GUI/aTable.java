/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.GUI;

import java.util.ArrayList;
import javaapplication3.DTO.scoreDTO;

/**
 *
 * @author azu
 */
public class aTable extends javax.swing.JTable {
    
    private javax.swing.table.DefaultTableModel tm;
    private Object[][] dataRow;
    private Object[] headers;
    private java.awt.Color colorHeader;
    private java.awt.Color colorBody;
    private java.awt.Color colorFontHeader;    
    private java.awt.Color colorFontBody;
    
    public aTable(Object[][] dataRow, Object[] headers) {
        super();
        this.dataRow = dataRow;
        this.headers = headers;
        this.colorHeader = new java.awt.Color(68, 75, 93);
        this.colorBody = new java.awt.Color(100, 107, 125);
        this.colorFontHeader = new java.awt.Color(249, 249, 251);
        this.colorFontBody = new java.awt.Color(255, 255, 255);
        
        this.tm = new javax.swing.table.DefaultTableModel(dataRow, headers);
        tm.insertRow(0, headers);
        this.setModel(tm);
        this.configs();
    }
    
    public aTable(ArrayList<Object[]> dataRow, Object[] headers) {
        super();
//        this.dataRow = dataRow;
        this.headers = headers;
        this.colorHeader = new java.awt.Color(68, 75, 93);
        this.colorBody = new java.awt.Color(100, 107, 125);
        this.colorFontHeader = new java.awt.Color(249, 249, 251);
        this.colorFontBody = new java.awt.Color(255, 255, 255);
        
        this.tm = new javax.swing.table.DefaultTableModel(new Object[0][0], headers);
        for(Object[] ele : dataRow) {
            this.tm.addRow(ele);
        }
        tm.insertRow(0, headers);
        this.setModel(tm);
        this.configs();
    }
    
    public void setData(javax.swing.table.DefaultTableModel model) {
        tm = model;
        tm.insertRow(0, headers);
        this.setModel(tm);
        this.configs();
    }
    
    private void configs() {
        this.setRowHeight(35);
        this.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.setFocusable(false);
        this.setShowVerticalLines(false);
        this.setShowHorizontalLines(false);
        this.setRowSelectionAllowed(false);
        this.setTableHeader(null);
        this.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.getColumnModel().getColumn(1).setPreferredWidth(140);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));

        for(int i = 0; i < this.headers.length; i++)
            this.getColumnModel().getColumn(i).setCellRenderer(getRenderer());
    }
    
    private void setColorHeader(java.awt.Color colorHeader) {
        this.colorHeader = colorHeader;
    }
    
    private void setColorBody(java.awt.Color colorBody) {
        this.colorBody = colorBody;
    }
    
    private void setColorFontHeader(java.awt.Color colorFontHeader) {
        this.colorFontHeader = colorFontHeader;
    }
    
    private void setColorFontBody(java.awt.Color colorFontBody) {
        this.colorFontHeader = colorFontBody;
    }
    
    private javax.swing.table.TableCellRenderer getRenderer() {
        return new javax.swing.table.DefaultTableCellRenderer(){
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                java.awt.Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
                if(java.util.Arrays.asList(headers).contains(value)) {
                    tableCellRendererComponent.setFont(new java.awt.Font("DENSE", java.awt.Font.BOLD, 14));
                    tableCellRendererComponent.setForeground(colorHeader);
                }
                else
                    tableCellRendererComponent.setForeground(colorBody);
                if(row % 2 == 0)
                    tableCellRendererComponent.setBackground(colorFontHeader);
                else
                    tableCellRendererComponent.setBackground(colorFontBody);
                return tableCellRendererComponent;
            }
        };
    }
    
}
