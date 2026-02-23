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
public class PedidosCliente {

    
    public static void main(String[] args) {
    JFrame jf = new JFrame("Registro de usuario");
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
            
            JLabel nombre = new JLabel("PEDIDOS");
            nombre.setFont(new Font("Arial", Font.BOLD, 80));
            nombre.setBounds(140, 110, 400, 80);
            nombre.setForeground(Color.WHITE);
            
            JPanel filaPedido = new JPanel();
            filaPedido.setLayout(null);
            filaPedido.setBackground(new Color(0, 76, 153));
            filaPedido.setBounds(150, 250, 1400, 100);
            
            JLabel pedido = new JLabel("Pedido 1");
            pedido.setFont(new Font("Arial", Font.BOLD, 50));
            pedido.setBounds(30, 10, 400, 80);
            pedido.setForeground(Color.WHITE);
            
            JLabel fecha = new JLabel("15/02/26");
            fecha.setFont(new Font("Arial", Font.BOLD, 30));
            fecha.setBounds(1200, 10, 400, 80);
            fecha.setForeground(Color.WHITE);
            
            JLabel salir = new JLabel("Salir");
            salir.setFont(new Font("Arial", Font.BOLD, 40));
            salir.setBounds(50, 940, 400, 80);
            salir.setForeground(Color.WHITE);
            
            JPanel filaPedido2 = new JPanel();
            filaPedido2.setLayout(null);
            filaPedido2.setBackground(new Color(0, 76, 153));
            filaPedido2.setBounds(150, 360, 1400, 100);
            
            JLabel pedido2 = new JLabel("Pedido 2");
            pedido2.setFont(new Font("Arial", Font.BOLD, 50));
            pedido2.setBounds(30, 10, 400, 80);
            pedido2.setForeground(Color.WHITE);
            
            JLabel fecha2 = new JLabel("15/02/26");
            fecha2.setFont(new Font("Arial", Font.BOLD, 30));
            fecha2.setBounds(1200, 10, 400, 80);
            fecha2.setForeground(Color.WHITE);
            
            JPanel filaPedido3 = new JPanel();
            filaPedido3.setLayout(null);
            filaPedido3.setBackground(new Color(0, 76, 153));
            filaPedido3.setBounds(150, 470, 1400, 100);
            
            JLabel pedido3 = new JLabel("Pedido 3");
            pedido3.setFont(new Font("Arial", Font.BOLD, 50));
            pedido3.setBounds(30, 10, 400, 80);
            pedido3.setForeground(Color.WHITE);
            
            JLabel fecha3 = new JLabel("15/02/26");
            fecha3.setFont(new Font("Arial", Font.BOLD, 30));
            fecha3.setBounds(1200, 10, 400, 80);
            fecha3.setForeground(Color.WHITE);
           
            fondo.add(cuadro);
            fondo.add(salir);
            cuadro.add(nombre);
            filaPedido.add(pedido);
            filaPedido.add(fecha);
            filaPedido2.add(pedido2);
            filaPedido2.add(fecha2);
            filaPedido3.add(fecha3);
            filaPedido3.add(pedido3);
            cuadro.add(filaPedido);
            cuadro.add(filaPedido2);
            cuadro.add(filaPedido3);
            
            
            JButton realizarPedido = new JButton("Realizar pedido");
            realizarPedido.setFont(new Font("Arial", Font.BOLD, 50));
            realizarPedido.setBounds(1050, 75, 600, 120);
            realizarPedido.setBackground(new Color(2, 128, 205));
            realizarPedido.setForeground(Color.WHITE);
            realizarPedido.setFocusPainted(false);
            cuadro.add(realizarPedido);
            

    } catch (Exception e) {
        e.printStackTrace();
    }
    
   
    jf.setVisible(true);

    }
    
}
