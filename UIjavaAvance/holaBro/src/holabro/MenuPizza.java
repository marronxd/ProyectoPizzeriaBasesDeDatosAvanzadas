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
public class MenuPizza {

    
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
            
            JLabel nombre = new JLabel("ELIGE TU PIZZA");
            nombre.setFont(new Font("Arial", Font.BOLD, 80));
            nombre.setBounds(140, 110, 650, 80);
            nombre.setForeground(Color.WHITE);
            
            JPanel filaPedido = new JPanel();
            filaPedido.setLayout(null);
            filaPedido.setBackground(new Color(0, 76, 153));
            filaPedido.setBounds(150, 250, 1400, 100);
            
            JLabel pizza = new JLabel("Pepperoni");
            pizza.setFont(new Font("Arial", Font.BOLD, 50));
            pizza.setBounds(30, 10, 400, 80);
            pizza.setForeground(Color.WHITE);
            
            JLabel detalles = new JLabel("?");
            detalles.setFont(new Font("Arial", Font.BOLD, 30));
            detalles.setBounds(1300, 10, 400, 80);
            detalles.setForeground(Color.WHITE);
            
            JLabel salir = new JLabel("Regresar");
            salir.setFont(new Font("Arial", Font.BOLD, 40));
            salir.setBounds(50, 940, 400, 80);
            salir.setForeground(Color.WHITE);
            
            JLabel carrito = new JLabel("Carrito");
            carrito.setFont(new Font("Arial", Font.BOLD, 40));
            carrito.setBounds(1725, 940, 400, 80);
            carrito.setForeground(Color.WHITE);
            
            JPanel filaPedido2 = new JPanel();
            filaPedido2.setLayout(null);
            filaPedido2.setBackground(new Color(0, 76, 153));
            filaPedido2.setBounds(150, 360, 1400, 100);
            
            JLabel pizza2 = new JLabel("Queso");
            pizza2.setFont(new Font("Arial", Font.BOLD, 50));
            pizza2.setBounds(30, 10, 400, 80);
            pizza2.setForeground(Color.WHITE);
            
            JLabel detalles2 = new JLabel("?");
            detalles2.setFont(new Font("Arial", Font.BOLD, 30));
            detalles2.setBounds(1300, 10, 400, 80);
            detalles2.setForeground(Color.WHITE);
            
            JPanel filaPedido3 = new JPanel();
            filaPedido3.setLayout(null);
            filaPedido3.setBackground(new Color(0, 76, 153));
            filaPedido3.setBounds(150, 470, 1400, 100);
            
            JLabel pizza3 = new JLabel("Hawaiana");
            pizza3.setFont(new Font("Arial", Font.BOLD, 50));
            pizza3.setBounds(30, 10, 400, 80);
            pizza3.setForeground(Color.WHITE);
            
            JLabel detalles3 = new JLabel("?");
            detalles3.setFont(new Font("Arial", Font.BOLD, 30));
            detalles3.setBounds(1300, 10, 400, 80);
            detalles3.setForeground(Color.WHITE);
           
            fondo.add(cuadro);
            fondo.add(salir);
            fondo.add(carrito);
            cuadro.add(nombre);
            filaPedido.add(pizza);
            filaPedido.add(detalles);
            filaPedido2.add(pizza2);
            filaPedido2.add(detalles2);
            filaPedido3.add(pizza3);
            filaPedido3.add(detalles3);
            cuadro.add(filaPedido);
            cuadro.add(filaPedido2);
            cuadro.add(filaPedido3);
            
    
            

    } catch (Exception e) {
        e.printStackTrace();
    }
    
   
    jf.setVisible(true);
    }
    
}
