/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistroUsuario extends JPanel {
    private VentanaPrincipal ventana;

    public RegistroUsuario(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Fila 1 - Nombres
        this.add(etiqueta("Nombre: ", 140, 110, 300, 60, 40));
        this.add(campoTexto(310, 110, 350, 50, 40));
        
        this.add(etiqueta("Apellido Paterno: ", 677, 110, 350, 60, 27));
        this.add(campoTexto(890, 110, 300, 50, 40));
        
        this.add(etiqueta("Apellido Materno: ", 1205, 110, 350, 60, 27));
        this.add(campoTexto(1425, 110, 300, 50, 40));

        // Fila 2 - Usuario, Contra y Correo
        this.add(etiqueta("Usuario: ", 150, 210, 300, 60, 40));
        this.add(campoTexto(310, 210, 350, 50, 40));
        
        this.add(etiqueta("Contraseña: ", 672, 210, 350, 60, 35));
        this.add(campoContrasenia(890, 210, 300, 50, 40));
        
        this.add(etiqueta("Correo: ", 1230, 210, 350, 60, 40));
        this.add(campoTexto(1375, 210, 350, 50, 40));

        // Fila 3 - Fecha, Calle y Número
        this.add(etiqueta("Fecha de Nacimiento: ", 150, 310, 300, 60, 25));
        this.add(campoTexto(407, 310, 350, 50, 40));
        
        this.add(etiqueta("Calle: ", 775, 310, 350, 60, 35));
        this.add(campoTexto(875, 310, 300, 50, 40));
        
        this.add(etiqueta("Numero: ", 1200, 310, 350, 60, 40));
        this.add(campoTexto(1375, 310, 150, 50, 40));

        // Fila 4 - Colonia, CP, Telefono y la Etiqueta
        this.add(etiqueta("Colonia: ", 150, 410, 300, 60, 40));
        this.add(campoTexto(307, 410, 450, 50, 40));
        
        this.add(etiqueta("CP: ", 775, 410, 350, 60, 35));
        this.add(campoTexto(842, 410, 150, 50, 40));
        
        this.add(etiqueta("Telefono: ", 1000, 410, 350, 60, 40));
        this.add(campoTexto(1175, 410, 250, 50, 40));
        
        this.add(etiqueta("Etiqueta: ", 1427, 410, 350, 60, 40));
        this.add(campoTexto(1585, 410, 150, 50, 40));

        // Navegacion inferior
        JLabel regresar = etiqueta("Ya cuento con una cuenta", 845, 550, 400, 60, 30);
        regresar.setForeground(Color.WHITE);
        regresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new InicioSesion(ventana));
            }
        });
        this.add(regresar);

        this.add(crearLinea(845, 600, 340, 2));

        JButton btnRegistrar = boton("Registrarse", 720, 650, 600, 120, 50);
        btnRegistrar.addActionListener(e -> { 
            ventana.mostrarPantalla(new InicioSesion(ventana)); 
        });
        this.add(btnRegistrar);
    }


    private JLabel etiqueta(String t, int x, int y, int w, int h, int f) {
        JLabel l = new JLabel(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        l.setBounds((int)(x*xf), (int)(y*yf), (int)(w*xf), (int)(h*yf));
        l.setFont(new Font("Arial", Font.PLAIN, (int)(f*yf)));
        return l;
    }

    private JTextField campoTexto(int x, int y, int w, int h, int f) {
        JTextField t = new JTextField();
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        t.setBounds((int)(x*xf), (int)(y*yf), (int)(w*xf), (int)(h*yf));
        t.setFont(new Font("Arial", Font.PLAIN, (int)(f*yf)));
        return t;
    }

    private JPasswordField campoContrasenia(int x, int y, int w, int h, int f) {
        JPasswordField p = new JPasswordField();
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        p.setBounds((int)(x*xf), (int)(y*yf), (int)(w*xf), (int)(h*yf));
        p.setFont(new Font("Arial", Font.PLAIN, (int)(f*yf)));
        return p;
    }

    private JButton boton(String t, int x, int y, int w, int h, int f) {
        JButton b = new JButton(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        b.setBounds((int)(x*xf), (int)(y*yf), (int)(w*xf), (int)(h*yf));
        b.setFont(new Font("Arial", Font.BOLD, (int)(f*yf)));
        b.setBackground(new Color(0, 102, 204));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        return b;
    }

    private JPanel crearLinea(int x, int y, int w, int h) {
        JPanel p = new JPanel();
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        p.setBackground(Color.WHITE);
        p.setBounds((int)(x*xf), (int)(y*yf), (int)(w*xf), (int)(h*yf));
        return p;
    }
}
