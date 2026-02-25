/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;



public class PedidosEmpleado extends JPanel {

    private VentanaPrincipal ventana;

    public PedidosEmpleado(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Barra de navegacion superior
        JPanel barra = crearPanel(0, 0, 1920, 250, new Color(0, 95, 153));
        this.add(barra);

        // Botones de la barra de navegacion
        barra.add(botonNavegacion("Pedidos", 35, 50, 350, 150, true));
        barra.add(botonNavegacion("Pizzas", 410, 50, 350, 150, false));
        barra.add(botonNavegacion("Clientes", 785, 50, 350, 150, false));
        barra.add(botonNavegacion("Cupones", 1160, 50, 350, 150, false));
        barra.add(botonNavegacion("Ventas", 1535, 50, 350, 150, false));

        // Cuadro principal de pedidos
        JPanel cuadro = crearPanel(100, 300, 1720, 600, new Color(2, 128, 205));
        this.add(cuadro);

        // Titulo de la sección
        cuadro.add(etiqueta("PEDIDOS", 50, 30, 400, 100, 80, true));

        // Configuracion del scroll para la lista
        JPanel listaPedidos = new JPanel();
        listaPedidos.setLayout(null);
        listaPedidos.setBackground(new Color(2, 128, 205));

        JScrollPane scroll = new JScrollPane(listaPedidos);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        scroll.setBounds((int)(50 * xf), (int)(150 * yf), (int)(1620 * xf), (int)(400 * yf));
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(20); // Esto es para que este mas fluido el scroll
        cuadro.add(scroll);

        // Agregamos filas de prueba (escaladas)
        listaPedidos.add(crearFilaPedido("Aaron", "15/02/26", 0));
        listaPedidos.add(crearFilaPedido("Aaron 2", "15/02/26", 110));
        listaPedidos.add(crearFilaPedido("Aaron 3", "16/02/26", 220));

        // Ajustamos el tamaño preferido para que el scroll funcione
        listaPedidos.setPreferredSize(new Dimension((int)(1400 * xf), (int)(1500 * yf)));

        // Boton de salida
        this.add(etiqueta("Salir", 50, 940, 400, 80, 40, true));
    }


    private JPanel botonNavegacion(String texto, int x, int y, int w, int h, boolean activo) {
        JPanel p = crearPanel(x, y, w, h, activo ? new Color(0, 76, 153) : new Color(2, 128, 205));
        JLabel l = new JLabel(texto, SwingConstants.CENTER);
        double yf = ventana.getYcorrecto();
        l.setFont(new Font("Arial", Font.BOLD, (int)(40 * yf)));
        l.setForeground(Color.WHITE);
        l.setBounds(0, (int)(45 * yf), (int)(w * ventana.getXcorrecto()), (int)(60 * yf));
        p.add(l);
        return p;
    }

    private JButton crearFilaPedido(String cliente, String fecha, int y) {
        JButton fila = new JButton();
        fila.setLayout(null);
        fila.setBackground(new Color(0, 76, 153));
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        fila.setBounds(0, (int)(y * yf), (int)(1400 * xf), (int)(100 * yf));
        fila.setBorder(null);

        JLabel lblNom = new JLabel(cliente);
        lblNom.setFont(new Font("Arial", Font.BOLD, (int)(50 * yf)));
        lblNom.setForeground(Color.WHITE);
        lblNom.setBounds((int)(30 * xf), (int)(10 * yf), (int)(400 * xf), (int)(80 * yf));
        fila.add(lblNom);

        JLabel lblFec = new JLabel(fecha);
        lblFec.setFont(new Font("Arial", Font.BOLD, (int)(30 * yf)));
        lblFec.setForeground(Color.WHITE);
        lblFec.setBounds((int)(1150 * xf), (int)(10 * yf), (int)(200 * xf), (int)(80 * yf));
        fila.add(lblFec);

        fila.addActionListener(e -> { ventana.mostrarPantalla(new DetallePedidoEmpleado(ventana)); });
        return fila;
    }

    private JLabel etiqueta(String t, int x, int y, int w, int h, int f, boolean bold) {
        JLabel l = new JLabel(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        l.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        l.setFont(new Font("Arial", bold ? Font.BOLD : Font.PLAIN, (int)(f * yf)));
        l.setForeground(Color.WHITE);
        return l;
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
