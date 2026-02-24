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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class PizzaDetallado {

    
    public static void main(String[] args) {
        JFrame jf = new JFrame("Detalles de Pizza");
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
            
            JLabel nombre = new JLabel("NOMBRE");
            nombre.setFont(new Font("Arial", Font.BOLD, 80));
            nombre.setBounds(140, 110, 650, 80);
            nombre.setForeground(Color.WHITE);
            
            JLabel ingredientes = new JLabel("Ingredientes: ");
            ingredientes.setFont(new Font("Arial", Font.BOLD, 60));
            ingredientes.setBounds(840, 50, 650, 80);
            ingredientes.setForeground(Color.WHITE);
            
            JLabel precio = new JLabel("Precio: ");
            precio.setFont(new Font("Arial", Font.BOLD, 60));
            precio.setBounds(840, 130, 650, 80);
            precio.setForeground(Color.WHITE);
            
            JTextArea notas = new JTextArea();
            notas.setFont(new Font("Arial", Font.PLAIN, 30));
            notas.setBounds(800, 260, 850, 400);
            notas.setLineWrap(true);
            notas.setWrapStyleWord(true);
            
            JLabel salir = new JLabel("Regresar");
            salir.setFont(new Font("Arial", Font.BOLD, 40));
            salir.setBounds(50, 940, 400, 80);
            salir.setForeground(Color.WHITE);
            
            JLabel carrito = new JLabel("Carrito");
            carrito.setFont(new Font("Arial", Font.BOLD, 40));
            carrito.setBounds(1725, 940, 400, 80);
            carrito.setForeground(Color.WHITE);
            
            JButton agregarNota = new JButton("Agregar Nota");
            agregarNota.setFont(new Font("Arial", Font.BOLD, 40));
            agregarNota.setBounds(130, 550, 600, 120);
            agregarNota.setBackground(new Color(0, 102, 204));
            agregarNota.setForeground(Color.WHITE);
            agregarNota.setFocusPainted(false);
          
            
            
           
            fondo.add(cuadro);
            fondo.add(salir);
            fondo.add(carrito);
            cuadro.add(nombre);
            cuadro.add(ingredientes);
            cuadro.add(precio);
            cuadro.add(notas);
            cuadro.add(agregarNota);
            
            
    
            

    } catch (Exception e) {
        e.printStackTrace();
    }
    
   
    jf.setVisible(true);
    }
    
}
