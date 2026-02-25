/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPizza extends JPanel {
    private VentanaPrincipal ventana;

    public MenuPizza(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Cuadro principal
        JPanel cuadro = crearPanel(100, 100, 1720, 800, new Color(2, 128, 205));
        this.add(cuadro);

        // Titulo
        JLabel nombre = etiqueta("ELIGE TU PIZZA", 140, 110, 650, 80, 80, true);
        cuadro.add(nombre);

        // Fila 1 - Pepperoni
        JButton filaPedido = botonFila("Pepperoni", 150, 250, 1400, 100);
        filaPedido.addActionListener(e -> { ventana.mostrarPantalla(new PizzaDetallado(ventana)); });
        cuadro.add(filaPedido);

        // Fila 2 - Queso
        JButton filaPedido2 = botonFila("Queso", 150, 360, 1400, 100);
        filaPedido2.addActionListener(e -> { ventana.mostrarPantalla(new PizzaDetallado(ventana)); });
        cuadro.add(filaPedido2);

        // Fila 3 - Hawaiana
        JButton filaPedido3 = botonFila("Hawaiana", 150, 470, 1400, 100);
        filaPedido3.addActionListener(e -> { ventana.mostrarPantalla(new PizzaDetallado(ventana)); });
        cuadro.add(filaPedido3);

        // Botones de navegación de regresar y carrito
        JLabel salir = etiqueta("Regresar", 50, 940, 400, 80, 40, true);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new Pedidos(ventana)); 
            }
        });
        this.add(salir);

        JLabel carrito = etiqueta("Carrito", 1550, 940, 400, 80, 40, true); 
        carrito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new Carrito(ventana));
            }
        });
        this.add(carrito);
    }


    private JButton botonFila(String nombrePizza, int x, int y, int w, int h) {
        JButton btn = new JButton();
        btn.setLayout(null);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        btn.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        btn.setBackground(new Color(0, 76, 153));
        btn.setFocusPainted(false);
        btn.setBorder(null);

        JLabel lbl = new JLabel(nombrePizza);
        lbl.setFont(new Font("Arial", Font.BOLD, (int)(50 * yf)));
        lbl.setForeground(Color.WHITE);
        lbl.setBounds((int)(30 * xf), (int)(10 * yf), (int)(400 * xf), (int)(80 * yf));
        btn.add(lbl);

        return btn;
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