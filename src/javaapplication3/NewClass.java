/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import javax.swing.*;

/**
 *
 * @author azu
 */
public class NewClass {
    
    public static void main(String[] args) throws Exception {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                try {
                    new NewClass1();
                }
                catch(Exception e) {
                    System.err.println(e);
                }
            }
        };
       SwingUtilities.invokeLater(r);
    }
}
