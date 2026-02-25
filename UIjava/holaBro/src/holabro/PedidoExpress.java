/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import holabro.InicioSesion;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class PedidoExpress extends JPanel {

    private static int pedidos = 0;

    private VentanaPrincipal ventana;
    
    public PedidoExpress(VentanaPrincipal ventana){
        pedidos = 0;
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));
        this.setBounds(0,0,1920,1080);
        
        JPanel barra = new JPanel();
        barra.setLayout(null);
        barra.setBackground(new Color(0, 95, 153));
        barra.setBounds(0, 0, 1920, 250);
        this.add(barra);

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
        this.add(cuadro);

        JLabel titulo = new JLabel("EXPRESS");
        titulo.setFont(new Font("arial", Font.BOLD, 80));
        titulo.setBounds(50, 30, 400, 100);
        titulo.setForeground(Color.WHITE);
        cuadro.add(titulo);


        JPanel listaPedidos = new JPanel();
        listaPedidos.setLayout(null);
        listaPedidos.setBackground(new Color(2, 128, 205));
        listaPedidos.setPreferredSize(new Dimension(1400, 1000)); 

        JScrollPane scroll = new JScrollPane(listaPedidos);
        scroll.setBounds(50, 150, 1620, 400); 
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(2, 128, 205));
        cuadro.add(scroll);
        
        JLabel salir = new JLabel("Salir");
        salir.setFont(new Font("arial", Font.BOLD, 40));
        salir.setBounds(50, 940, 400, 80);
        salir.setForeground(Color.WHITE);
        
        salir.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            ventana.mostrarPantalla(new InicioPrograma(ventana)); }});
        this.add(salir);

        salir.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            ventana.mostrarPantalla(new InicioPrograma(ventana)); }});
        this.add(salir);
        
        agregarPedido(listaPedidos, "aaron", "12/12/12");
    }
    

    private static void agregarPedido(JPanel contenedor, String cliente, String fecha) {
        JPanel fila = new JPanel();
        fila.setLayout(null);
        fila.setBackground(new Color(0, 76, 153));

        int y = pedidos * 110; 
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
        pedidos++;

        if (y + 110 > contenedor.getPreferredSize().height) {
            contenedor.setPreferredSize(new Dimension(1400, y + 200));
        }
    }
}
