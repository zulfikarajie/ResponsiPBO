/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewPackage;

/**
 *
 * @author apang
 */

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
