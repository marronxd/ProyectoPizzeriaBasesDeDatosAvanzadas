/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class HolaBro {
    
    public static void main(String[] args) {

    JFrame jf = new JFrame("Inicio de Sesion");
    jf.setSize(1920, 1080); 
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    try {
        
        java.net.URL url = HolaBro.class.getResource("/imagenes/pantalla.png");

        if (url != null) {
           
            JLabel fondo = new JLabel(new ImageIcon(url));
            fondo.setLayout(null); 
            jf.setContentPane(fondo);
        } else {
            System.out.println("xd");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }


    jf.setVisible(true);
    
}
}
