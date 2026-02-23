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
public class Carrito {

    
    public static void main(String[] args) {
    JFrame jf = new JFrame("Carrito");
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
            
            JLabel nombre = new JLabel("CARRITO");
            nombre.setFont(new Font("Arial", Font.BOLD, 80));
            nombre.setBounds(140, 110, 650, 80);
            nombre.setForeground(Color.WHITE);
            
            JPanel filaPedido = new JPanel();
            filaPedido.setLayout(null);
            filaPedido.setBackground(new Color(0, 76, 153));
            filaPedido.setBounds(150, 250, 1400, 100);
            
            JLabel pizza = new JLabel("Pepperoni (1): $120");
            pizza.setFont(new Font("Arial", Font.BOLD, 50));
            pizza.setBounds(30, 10, 500, 80);
            pizza.setForeground(Color.WHITE);
            
            JLabel quitar = new JLabel("X");
            quitar.setFont(new Font("Arial", Font.BOLD, 30));
            quitar.setBounds(1280, 10, 400, 80);
            quitar.setForeground(Color.WHITE);
            
            JLabel restar = new JLabel("-");
            restar.setFont(new Font("Arial", Font.BOLD, 30));
            restar.setBounds(1245, 10, 400, 80);
            restar.setForeground(Color.WHITE);
            
            JLabel sumar = new JLabel("+");
            sumar.setFont(new Font("Arial", Font.BOLD, 40));
            sumar.setBounds(1200, 10, 400, 80);
            sumar.setForeground(Color.WHITE);
            
            JLabel salir = new JLabel("Regresar");
            salir.setFont(new Font("Arial", Font.BOLD, 40));
            salir.setBounds(50, 940, 400, 80);
            salir.setForeground(Color.WHITE);
            
            JButton siguiente = new JButton("Siguiente");
            siguiente.setFont(new Font("Arial", Font.BOLD, 40));
            siguiente.setBounds(935, 650, 600, 120);
            siguiente.setBackground(new Color(0, 102, 204));
            siguiente.setForeground(Color.WHITE);
            siguiente.setFocusPainted(false);
            cuadro.add(siguiente);
 
            
            
           
            fondo.add(cuadro);
            fondo.add(salir);
            cuadro.add(nombre);
            filaPedido.add(pizza);
            filaPedido.add(quitar);
            filaPedido.add(restar);
            filaPedido.add(sumar);
            cuadro.add(filaPedido);
            
    
            

    } catch (Exception e) {
        e.printStackTrace();
    }
    
   
    jf.setVisible(true);
    }
    
}
