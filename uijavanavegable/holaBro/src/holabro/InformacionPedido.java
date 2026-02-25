/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InformacionPedido extends JPanel {
    
    private VentanaPrincipal ventana;
    private static int pedidoCount = 0;
    
    public InformacionPedido(VentanaPrincipal ventana){
        pedidoCount = 0;
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Cuadro principal
        JPanel cuadro = crearPanel(100, 100, 1720, 800, new Color(2, 128, 205));
        this.add(cuadro);

        // Etiquetas informativas del pedido
        cuadro.add(etiqueta("Cliente: Sisy Soto", 50, 30, 900, 100, 80, true));
        cuadro.add(etiqueta("Total: $100", 300, 600, 400, 100, 30, true));
        cuadro.add(etiqueta("Fecha y hora: 15/02/26 10:00:00", 300, 650, 700, 100, 30, true));

        // Area de lista con Scroll
        JPanel listaPedidos = new JPanel();
        listaPedidos.setLayout(null);
        listaPedidos.setBackground(new Color(2, 128, 205));

        JScrollPane scroll = new JScrollPane(listaPedidos);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        scroll.setBounds((int)(50 * xf), (int)(150 * yf), (int)(1620 * xf), (int)(400 * yf));
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(20); // Scroll fluido
        scroll.getViewport().setBackground(new Color(2, 128, 205));
        cuadro.add(scroll);

        // Agregamos pedidos de prueba
        agregarPedido(listaPedidos, "Pizza Pepperoni Grande", "15/02/26", ventana);

        // Botones de accion y navegacion
        JButton agregar = boton("Agregar", 900, 570, 600, 120, 40);
        agregar.setVisible(DatosGlobales.esexpress);
        agregar.addActionListener(e -> { ventana.mostrarPantalla(new Carrito(ventana)); });
        cuadro.add(agregar);

        JLabel salir = etiqueta("Regresar", 50, 940, 400, 80, 40, true);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new Pedidos(ventana)); 
            }
        });
        this.add(salir);

        // Se ajusta la x de carrito para que no salga de la pantalla
        JLabel carrito = etiqueta("Carrito", 1550, 940, 400, 80, 40, true);
        carrito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new Carrito(ventana));
            }
        });
        this.add(carrito);
    }


    private static void agregarPedido(JPanel contenedor, String producto, String fecha, VentanaPrincipal ventana) {
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        JPanel fila = new JPanel();
        fila.setLayout(null);
        fila.setBackground(new Color(0, 76, 153));

        int y = pedidoCount * 110; 
        fila.setBounds(0, (int)(y * yf), (int)(1400 * xf), (int)(100 * yf));

        JLabel lblNom = new JLabel(producto);
        lblNom.setFont(new Font("Arial", Font.BOLD, (int)(50 * yf)));
        lblNom.setForeground(Color.WHITE);
        lblNom.setBounds((int)(30 * xf), (int)(10 * yf), (int)(800 * xf), (int)(80 * yf));
        fila.add(lblNom);

        JLabel lblFec = new JLabel(fecha);
        lblFec.setFont(new Font("Arial", Font.BOLD, (int)(30 * yf)));
        lblFec.setForeground(Color.WHITE);
        lblFec.setBounds((int)(1150 * xf), (int)(10 * yf), (int)(200 * xf), (int)(80 * yf));
        fila.add(lblFec);

        contenedor.add(fila);
        pedidoCount++;

        // Aqui se actualiza la altura en base a los pedidos
        int altoContenido = (int)((pedidoCount * 110) * yf);
        contenedor.setPreferredSize(new Dimension((int)(1400 * xf), altoContenido));
    }

    private JLabel etiqueta(String t, int x, int y, int w, int h, int f, boolean bold) {
        JLabel l = new JLabel(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        l.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        l.setFont(new Font("Arial", bold ? Font.BOLD : Font.PLAIN, (int)(f * yf)));
        l.setForeground(Color.WHITE);
        return l;
    }

    private JButton boton(String t, int x, int y, int w, int h, int f) {
        JButton b = new JButton(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        b.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        b.setFont(new Font("Arial", Font.BOLD, (int)(f * yf)));
        b.setBackground(new Color(0, 102, 204));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        return b;
    }

    private JPanel crearPanel(int x, int y, int w, int h, Color c) {
        JPanel p = new JPanel();
        p.setLayout(null);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        p.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        p.setBackground(c);
        return p;
    }
}
