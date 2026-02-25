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

/**
 *
 * @author Usuario
 */
public class PedidoConfirmado {

    
    public static void main(String[] args) {
    JFrame jf = new JFrame("Menu de Pizzas");
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
            
            JPanel cuadro = new JPanel();
            cuadro.setLayout(null);
            cuadro.setBackground(new Color(2, 128, 205));
            cuadro.setBounds(100, 100, 1720, 800);
            
            JLabel nombre = new JLabel("PEDIDO CONFIRMADO CON EXITO");
            nombre.setFont(new Font("Arial", Font.BOLD, 100));
            nombre.setBounds(25, 110, 2000, 80);
            nombre.setForeground(Color.WHITE);
            
            JButton agregarNota = new JButton("Regresar");
            agregarNota.setFont(new Font("Arial", Font.BOLD, 40));
            agregarNota.setBounds(130, 550, 600, 120);
            agregarNota.setBackground(new Color(0, 102, 204));
            agregarNota.setForeground(Color.WHITE);
            agregarNota.setFocusPainted(false);
            
           
            fondo.add(cuadro);
            cuadro.add(nombre);
            cuadro.add(agregarNota);
            
            
    
            

    } catch (Exception e) {
        e.printStackTrace();
    }
    
   
    jf.setVisible(true);
    }
    
}
