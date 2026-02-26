/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanjearCupon extends JPanel {

    private VentanaPrincipal ventana;

    public CanjearCupon(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Etiqueta y campo para el cupon
        this.add(etiqueta("Cupon: ", 500, 210, 300, 60, 60));
        
        JTextField textoUsuario = campoTexto(735, 200, 600, 80, 40);
        this.add(textoUsuario);

        // Boton para canjear xd
        JButton btnCanjear = boton("Canjear", 680, 350, 600, 120, 40);
        btnCanjear.addActionListener(e -> { 
            // Se regresa a confirmacion
            ventana.mostrarPantalla(new ConfirmarPedido(ventana)); 
        });
        this.add(btnCanjear);

        // Opcion para cancelar y volver
        JLabel regresar = etiqueta("Regresar", 900, 900, 400, 60, 30);
        regresar.setForeground(Color.WHITE);
        regresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new ConfirmarPedido(ventana));
            }
        });
        this.add(regresar);
    }

    private JLabel etiqueta(String t, int x, int y, int w, int h, int f) {
        JLabel l = new JLabel(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        l.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        l.setFont(new Font("Arial", Font.PLAIN, (int)(f * yf)));
        l.setForeground(Color.WHITE);
        return l;
    }

    private JTextField campoTexto(int x, int y, int w, int h, int f) {
        JTextField t = new JTextField();
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        t.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        t.setFont(new Font("Arial", Font.PLAIN, (int)(f * yf)));
        return t;
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
}
