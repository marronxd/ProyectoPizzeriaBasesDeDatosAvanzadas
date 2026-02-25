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
    private JPanel listaContenido; // panel que guarda las pizzas pizza pizza chiquis pizza chiquis chiquis
    private static int items = 0; // contador de posiciones de fila

    public Carrito(VentanaPrincipal ventana) {
        items = 0; // se reinicia al entrar
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // cuadro principal
        JPanel cuadro = crearPanel(100, 100, 1720, 800, new Color(2, 128, 205));
        this.add(cuadro);

        // Titulo
        cuadro.add(etiqueta("CARRITO", 140, 110, 650, 80, 80, true));

        // configuraciomn para el scroll 
        listaContenido = new JPanel();
        listaContenido.setLayout(null);
        listaContenido.setBackground(new Color(2, 128, 205));

        JScrollPane scroll = new JScrollPane(listaContenido);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        
        // posicionamos el scroll dentro del cuadro
        scroll.setBounds((int)(140 * xf), (int)(200 * yf), (int)(1450 * xf), (int)(430 * yf));
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getViewport().setBackground(new Color(2, 128, 205));
        cuadro.add(scroll);

        // ejemplos por ahora que no hay base de datos
        agregarFila("Pepperoni (1)", 120.0);
        agregarFila("Hawaiana (2)", 280.0);
        agregarFila("Mexicana (1)", 150.0);

        // siguiente
        JButton siguiente = boton("Siguiente", 935, 650, 600, 120, 40);
        siguiente.addActionListener(e -> { 
            ventana.mostrarPantalla(new ConfirmarPedido(ventana)); 
        });
        cuadro.add(siguiente);

        // f: regresar
        JLabel salir = etiqueta("Regresar", 50, 940, 400, 80, 40, true);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new MenuPizza(ventana));
            }
        });
        this.add(salir);
    }

    // metodo para filas dinamicas
    private void agregarFila(String texto, double precio) {
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        
        // fila para la pizza
        JPanel fila = crearPanel(0, items * 110, 1400, 100, new Color(0, 76, 153));
        
        // texto de la pizza chiquis
        fila.add(etiqueta(texto + ": $" + precio, 30, 10, 600, 80, 50, true));

        // nomas te deja editar el pedido de cantidad si no es express
        fila.add(etiqueta("X", 1280, 10, 100, 80, 30, true));
        if (!DatosGlobales.esexpress) {
            fila.add(etiqueta("-", 1245, 10, 100, 80, 30, true));
            fila.add(etiqueta("+", 1200, 10, 100, 80, 40, true));
        }

        listaContenido.add(fila);
        items++;
        
        // mas calculos del tamaño de la lista
        listaContenido.setPreferredSize(new Dimension((int)(1400 * xf), (int)((items * 110) * yf)));
        listaContenido.revalidate();
        listaContenido.repaint();
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

