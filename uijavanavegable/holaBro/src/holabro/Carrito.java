/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Carrito extends JPanel {
    private VentanaPrincipal ventana;

    public Carrito(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Cuadro principal que contiene la lista
        JPanel cuadro = crearPanel(100, 100, 1720, 800, new Color(2, 128, 205));
        this.add(cuadro);

        // Titulo de la pantalla
        cuadro.add(etiqueta("CARRITO", 140, 110, 650, 80, 80, true));

        // Fila de pedido
        JPanel filaPedido = crearPanel(150, 250, 1400, 100, new Color(0, 76, 153));
        
        // Elementos internos de la fila 
        filaPedido.add(etiqueta("Pepperoni (1): $120", 30, 10, 500, 80, 50, true));
        filaPedido.add(etiqueta("X", 1280, 10, 400, 80, 30, true));
        filaPedido.add(etiqueta("-", 1245, 10, 400, 80, 30, true));
        filaPedido.add(etiqueta("+", 1200, 10, 400, 80, 40, true));
        
        cuadro.add(filaPedido);

        // Boton Siguiente para proceder al pago
        JButton siguiente = boton("Siguiente", 935, 650, 600, 120, 40);
        siguiente.addActionListener(e -> { 
            ventana.mostrarPantalla(new ConfirmarPedido(ventana)); 
        });
        cuadro.add(siguiente);

        // Opcion para regresar al menú de pizzas
        JLabel salir = etiqueta("Regresar", 50, 940, 400, 80, 40, true);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new MenuPizza(ventana));
            }
        });
        this.add(salir);
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
