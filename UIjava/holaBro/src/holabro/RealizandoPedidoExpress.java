/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Usuario
 */
public class RealizandoPedidoExpress {
    
    private static int pedidoCount = 0;

    public static void main(String[] args) {
        JFrame jf = new JFrame("Detalle Pedido Express");
        jf.setSize(1920, 1080); 
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);

        try {
            
            JPanel fondo = new JPanel();
            fondo.setLayout(null);
            fondo.setBackground(new Color(0, 102, 180));
            fondo.setBounds(0, 0, 1920, 1080);
            jf.setContentPane(fondo);

            JPanel cuadro = new JPanel();
            cuadro.setLayout(null);
            cuadro.setBackground(new Color(2, 128, 205));
            cuadro.setBounds(100, 100, 1720, 800);
            fondo.add(cuadro);

            JLabel titulo = new JLabel("Cliente: Sisy Soto");
            titulo.setFont(new Font("arial", Font.BOLD, 80));
            titulo.setBounds(50, 30, 900, 100);
            titulo.setForeground(Color.WHITE);
            cuadro.add(titulo);
            
            JLabel total = new JLabel("Total: $100");
            total.setFont(new Font("Arial", Font.BOLD, 30));
            total.setBounds(300, 600, 400, 100);
            total.setForeground(Color.WHITE);
            cuadro.add(total);
            
            JLabel fechaHora = new JLabel("Fecha y hora: 15/02/26 10:00:00");
            fechaHora.setFont(new Font("Arial", Font.BOLD, 30));
            fechaHora.setBounds(300, 650, 700, 100);
            fechaHora.setForeground(Color.WHITE);
            cuadro.add(fechaHora);

            JPanel listaPedidos = new JPanel();
            listaPedidos.setLayout(null);
            listaPedidos.setBackground(new Color(2, 128, 205));
            listaPedidos.setPreferredSize(new Dimension(1400, 1000)); 

            JScrollPane scroll = new JScrollPane(listaPedidos);
            scroll.setBounds(50, 150, 1620, 400); 
            scroll.setBorder(null);
            scroll.getViewport().setBackground(new Color(2, 128, 205));
            cuadro.add(scroll);

   
            JButton agregar = new JButton("Agregar");
            agregar.setFont(new Font("Arial", Font.BOLD, 40));
            agregar.setBounds(900, 570, 600, 120);
            agregar.setBackground(new Color(0, 102, 204));
            agregar.setForeground(Color.WHITE);
            agregar.setFocusPainted(false);
            cuadro.add(agregar);

            JLabel salir = new JLabel("Regresar");
            salir.setFont(new Font("arial", Font.BOLD, 40));
            salir.setBounds(50, 940, 400, 80);
            salir.setForeground(Color.WHITE);
            fondo.add(salir);
            
            JLabel carrito = new JLabel("Carrito");
            carrito.setFont(new Font("Arial", Font.BOLD, 40));
            carrito.setBounds(1725, 940, 400, 80);
            carrito.setForeground(Color.WHITE);
            fondo.add(carrito);

        } catch (Exception e) {
            e.printStackTrace();
        }

        jf.setVisible(true);
    }


    private static void agregarPedido(JPanel contenedor, String cliente, String fecha) {
        JPanel fila = new JPanel();
        fila.setLayout(null);
        fila.setBackground(new Color(0, 76, 153));

        int y = pedidoCount * 110; 
        fila.setBounds(0, y, 1400, 100);

        JLabel lblNom = new JLabel(cliente);
        lblNom.setFont(new Font("arial", Font.BOLD, 50));
        lblNom.setForeground(Color.WHITE);
        lblNom.setBounds(30, 10, 600, 80);
        fila.add(lblNom);

        JLabel lblFec = new JLabel(fecha);
        lblFec.setFont(new Font("arial", Font.BOLD, 30));
        lblFec.setForeground(Color.WHITE);
        lblFec.setBounds(1150, 10, 200, 80);
        fila.add(lblFec);

        
        contenedor.add(fila);
        pedidoCount++;

        
        if (y + 110 > contenedor.getPreferredSize().height) {
            contenedor.setPreferredSize(new Dimension(1400, y + 200));
        }
    }
     
}
