/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfirmarPedido extends JPanel {

    private VentanaPrincipal ventana;

    public ConfirmarPedido(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Cuadro principal que contiene el resumen del carrito
        JPanel cuadro = crearPanel(100, 100, 1720, 800, new Color(2, 128, 205));
        this.add(cuadro);

        // Titulo
        cuadro.add(etiqueta("CONFIRMACION DE PEDIDO", 140, 110, 900, 80, 60, true));

        // Boton para canjear cupones
        JButton cupon = boton("Aplicar cupon", 1100, 70, 400, 120, 40);
        cupon.addActionListener(e -> { 
            ventana.mostrarPantalla(new CanjearCupon(ventana)); 
        });
        cuadro.add(cupon);

        // Resumen del pedido
        JPanel filaPedido = crearPanel(150, 250, 1400, 100, new Color(0, 76, 153));
        filaPedido.add(etiqueta("Pepperoni (1): $120", 30, 10, 500, 80, 50, true));
        cuadro.add(filaPedido);

        // Visualizacion del total
        cuadro.add(etiqueta("Total: $120", 230, 600, 500, 80, 50, true));

        // Boton de confirmacion xd
        JButton confirmar = boton("Confirmar", 935, 650, 600, 120, 40);
        confirmar.addActionListener(e -> { 
            ventana.mostrarPantalla(new PedidoConfirmado(ventana)); 
        });
        cuadro.add(confirmar);

        // Boton para regresar al carrito 
        JLabel salir = etiqueta("Regresar", 50, 940, 400, 80, 40, true);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new Carrito(ventana));
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
