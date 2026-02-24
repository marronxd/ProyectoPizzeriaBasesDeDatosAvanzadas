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
public class DetallePedidoEmpleado {


    public static void main(String[] args) {
        JFrame jf = new JFrame("Panel de Empleados");
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

            
            JPanel barra = new JPanel();
            barra.setLayout(null);
            barra.setBackground(new Color(0, 95, 153));
            barra.setBounds(0, 0, 1920, 250);
            fondo.add(barra);

            JPanel btnPedidos = new JPanel();
            btnPedidos.setLayout(null);
            btnPedidos.setBackground(new Color(0, 76, 153)); 
            btnPedidos.setBounds(35, 50, 350, 150);
            barra.add(btnPedidos);

            JLabel lblPedidos = new JLabel("Pedidos", SwingConstants.CENTER);
            lblPedidos.setFont(new Font("Arial", Font.BOLD, 40));
            lblPedidos.setForeground(Color.WHITE);
            lblPedidos.setBounds(0, 45, 350, 60);
            btnPedidos.add(lblPedidos);

            JPanel btnPizzas = new JPanel();
            btnPizzas.setLayout(null);
            btnPizzas.setBackground(new Color(2, 128, 205)); 
            btnPizzas.setBounds(410, 50, 350, 150);
            barra.add(btnPizzas);

            JLabel lblPizzas = new JLabel("Pizzas", SwingConstants.CENTER);
            lblPizzas.setFont(new Font("Arial", Font.BOLD, 40));
            lblPizzas.setForeground(Color.WHITE);
            lblPizzas.setBounds(0, 45, 350, 60);
            btnPizzas.add(lblPizzas);

            JPanel btnClientes = new JPanel();
            btnClientes.setLayout(null);
            btnClientes.setBackground(new Color(2, 128, 205));
            btnClientes.setBounds(785, 50, 350, 150);
            barra.add(btnClientes);

            JLabel lblClientes = new JLabel("Clientes", SwingConstants.CENTER);
            lblClientes.setFont(new Font("Arial", Font.BOLD, 40));
            lblClientes.setForeground(Color.WHITE);
            lblClientes.setBounds(0, 45, 350, 60);
            btnClientes.add(lblClientes);

            JPanel btnCupones = new JPanel();
            btnCupones.setLayout(null);
            btnCupones.setBackground(new Color(2, 128, 205));
            btnCupones.setBounds(1160, 50, 350, 150);
            barra.add(btnCupones);

            JLabel lblCupones = new JLabel("Cupones", SwingConstants.CENTER);
            lblCupones.setFont(new Font("Arial", Font.BOLD, 40));
            lblCupones.setForeground(Color.WHITE);
            lblCupones.setBounds(0, 45, 350, 60);
            btnCupones.add(lblCupones);

            JPanel btnVentas = new JPanel();
            btnVentas.setLayout(null);
            btnVentas.setBackground(new Color(2, 128, 205));
            btnVentas.setBounds(1535, 50, 350, 150);
            barra.add(btnVentas);

            JLabel lblVentas = new JLabel("Ventas", SwingConstants.CENTER);
            lblVentas.setFont(new Font("Arial", Font.BOLD, 40));
            lblVentas.setForeground(Color.WHITE);
            lblVentas.setBounds(0, 45, 350, 60);
            btnVentas.add(lblVentas);

            JPanel cuadro = new JPanel();
            cuadro.setLayout(null);
            cuadro.setBackground(new Color(2, 128, 205));
            cuadro.setBounds(100, 300, 1720, 600);
            fondo.add(cuadro);

            JLabel nombre = new JLabel("Estado: PENDIENTE");
            nombre.setFont(new Font("Arial", Font.BOLD, 80));
            nombre.setBounds(50, 30, 850, 100);
            nombre.setForeground(Color.WHITE);
            cuadro.add(nombre);
          
            JLabel fechaHora = new JLabel("Fecha y hora: 17/02/26 09:10:20");
            fechaHora.setFont(new Font("Arial", Font.BOLD, 20));
            fechaHora.setBounds(50, 530, 850, 100);
            fechaHora.setForeground(Color.WHITE);
            cuadro.add(fechaHora);
            
            JLabel total = new JLabel("Total: $100");
            total.setFont(new Font("Arial", Font.BOLD, 20));
            total.setBounds(1200, 530, 400, 100);
            total.setForeground(Color.WHITE);
            cuadro.add(total);


            JPanel listaPedidos = new JPanel();
            listaPedidos.setLayout(null);
            listaPedidos.setBackground(new Color(2, 128, 205));
            listaPedidos.setPreferredSize(new Dimension(1400, 1500)); 

            JScrollPane scroll = new JScrollPane(listaPedidos);
            scroll.setBounds(50, 150, 1620, 400); 
            scroll.setBorder(null);
            cuadro.add(scroll);

            JPanel fila1 = crearFilaPedido("1 Pepperoni Chica", "100", 0);
            listaPedidos.add(fila1);
            
            JButton cancelar = new JButton("Cancelar");
            cancelar.setFont(new Font("Arial", Font.BOLD, 30));
            cancelar.setBounds(1000, 40, 200, 80);
            cancelar.setBackground(new Color(0, 102, 204));
            cancelar.setForeground(Color.WHITE);
            cancelar.setFocusPainted(false);
            cuadro.add(cancelar);
            
            JButton seguir = new JButton("Seguir");
            seguir.setFont(new Font("Arial", Font.BOLD, 30));
            seguir.setBounds(1250, 40, 200, 80);
            seguir.setBackground(new Color(0, 102, 204));
            seguir.setForeground(Color.WHITE);
            seguir.setFocusPainted(false);
            cuadro.add(seguir);
            
            JLabel salir = new JLabel("Salir");
            salir.setFont(new Font("Arial", Font.BOLD, 40));
            salir.setBounds(50, 940, 400, 80);
            salir.setForeground(Color.WHITE);
            fondo.add(salir);

        } catch (Exception e) {
            e.printStackTrace();
        }

        jf.setVisible(true);
    }

   
    private static JPanel crearFilaPedido(String texto, String fecha, int y) {
        JPanel fila = new JPanel();
        fila.setLayout(null);
        fila.setBackground(new Color(0, 76, 153));
        fila.setBounds(0, y, 1400, 100);

        JLabel lblNom = new JLabel(texto);
        lblNom.setFont(new Font("Arial", Font.BOLD, 50));
        lblNom.setForeground(Color.WHITE);
        lblNom.setBounds(30, 10, 600, 80);
        fila.add(lblNom);

        JLabel lblFec = new JLabel(fecha);
        lblFec.setFont(new Font("Arial", Font.BOLD, 30));
        lblFec.setForeground(Color.WHITE);
        lblFec.setBounds(1150, 10, 200, 80);
        fila.add(lblFec);

        return fila;
    }
    
    
}
