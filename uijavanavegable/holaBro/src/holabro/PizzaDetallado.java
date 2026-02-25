/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaDetallado extends JPanel {

    private VentanaPrincipal ventana;

    public PizzaDetallado(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Cuadro principal escalado
        JPanel cuadro = crearPanel(100, 100, 1720, 800, new Color(2, 128, 205));
        this.add(cuadro);

        // Etiquetas con info
        cuadro.add(etiqueta("NOMBRE", 140, 110, 650, 80, 80, true));
        cuadro.add(etiqueta("Ingredientes: ", 840, 50, 650, 80, 60, true));
        cuadro.add(etiqueta("Precio: ", 840, 130, 650, 80, 60, true));

        // Area de notas escalada
        JTextArea notas = areaTexto(800, 260, 850, 400, 30);
        cuadro.add(notas);

        // Botones de accion y navegacion
        JButton agregarNota = boton("Agregar", 130, 550, 600, 120, 40);
        agregarNota.addActionListener(e -> { 
            ventana.mostrarPantalla(new MenuPizza(ventana)); 
        });
        cuadro.add(agregarNota);

        JLabel salir = etiqueta("Regresar", 50, 940, 400, 80, 40, true);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new MenuPizza(ventana));
            }
        });
        this.add(salir);

        
        JLabel carrito = etiqueta("Carrito", 1550, 940, 400, 80, 40, true);
        this.add(carrito);
    }


    private JLabel etiqueta(String t, int x, int y, int w, int h, int f, boolean bold) {
        JLabel l = new JLabel(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        l.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        l.setFont(new Font("Arial", bold ? Font.BOLD : Font.PLAIN, (int)(f * yf)));
        l.setForeground(Color.WHITE);
        return l;
    }

    private JTextArea areaTexto(int x, int y, int w, int h, int f) {
        JTextArea a = new JTextArea();
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        a.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        a.setFont(new Font("Arial", Font.PLAIN, (int)(f * yf)));
        a.setLineWrap(true);
        a.setWrapStyleWord(true);
        return a;
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

