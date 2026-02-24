/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class PedidosCliente extends JPanel {
    private static int pedidos = 0;
    
    private VentanaPrincipal ventana;
    
    public PedidosCliente(VentanaPrincipal ventana){
        pedidos = 0;
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));
        this.setBounds(0,0,1920,1080);
        
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


        JLabel salir = new JLabel("Salir");
        salir.setFont(new Font("Arial", Font.BOLD, 40));
        salir.setBounds(50, 940, 400, 80);
        salir.setForeground(Color.WHITE);
        
        salir.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            ventana.mostrarPantalla(new InicioPrograma(ventana)); }});
        this.add(salir);
        
        JPanel listaPedidos = new JPanel();
        listaPedidos.setLayout(null);
        listaPedidos.setBackground(new Color(2, 128, 205));
        listaPedidos.setBounds(140, 200, 1450, 500);
        listaPedidos.setPreferredSize(new Dimension(1400, 1000));
        
        
        agregarPedido(listaPedidos, "aaron", "12/12/12");
        
        cuadro.add(listaPedidos);
        this.add(cuadro);
        this.add(salir);
        cuadro.add(nombre);

        JButton realizarPedido = new JButton("Realizar pedido");
        realizarPedido.setFont(new Font("Arial", Font.BOLD, 50));
        realizarPedido.setBounds(1050, 75, 600, 120);
        realizarPedido.setBackground(new Color(2, 128, 205));
        realizarPedido.setForeground(Color.WHITE);
        realizarPedido.setFocusPainted(false);
        // realizarPedido.addActionListener(e -> { ventana.mostrarPantalla(new MenuPizza(ventana));});
        cuadro.add(realizarPedido);

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
