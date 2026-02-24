/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class InicioPrograma {

    
    public static void main(String[] args) {
    JFrame jf = new JFrame("Inicio de programa");
    JPanel jp = new JPanel();
    jf.setSize(1920, 1080); 
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setResizable(false);
    jf.add(jp);

    try {
        
            JPanel fondo = new JPanel();
            fondo.setLayout(null);
            fondo.setBackground(new Color(0, 102, 180));
            jf.setContentPane(fondo);
            
            
            JButton cliente = new JButton("Cliente");
            cliente.setFont(new Font("Arial", Font.BOLD, 40));
            cliente.setBounds(235, 550, 600, 120);
            cliente.setBackground(new Color(0, 102, 204));
            cliente.setForeground(Color.WHITE);
            cliente.setFocusPainted(false);
            fondo.add(cliente);
            
            JButton empleado = new JButton("Empleado");
            empleado.setFont(new Font("Arial", Font.BOLD, 40));
            empleado.setBounds(1050, 550, 600, 120);
            empleado.setBackground(new Color(0, 102, 204));
            empleado.setForeground(Color.WHITE);
            empleado.setFocusPainted(false);
            fondo.add(empleado);
            
            JButton express = new JButton("Express");
            express.setFont(new Font("Arial", Font.BOLD, 40));
            express.setBounds(1500, 900, 300, 80);
            express.setBackground(new Color(0, 102, 204));
            express.setForeground(Color.WHITE);
            express.setFocusPainted(false);
            fondo.add(express);
            
            
    } catch (Exception e) {
        e.printStackTrace();
    }
    
   
    jf.setVisible(true);
    
    }
    
    
}
