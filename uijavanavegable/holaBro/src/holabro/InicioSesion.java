/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InicioSesion extends JPanel {
    private VentanaPrincipal ventana;

    public InicioSesion(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));
        
        // Correo y su campo
        JLabel correo = etiqueta("Correo: ", 500, 210, 300, 60, 60);
        this.add(correo);

        JTextField textoUsuario2 = campoTexto(735, 200, 600, 80, 40);
        this.add(textoUsuario2);

        // Contraseña y su campo 
        JLabel contrasenia = etiqueta("Contraseña: ", 380, 310, 350, 60, 60);
        this.add(contrasenia);

        JPasswordField textoUsuario = campoContrasenia(735, 300, 600, 80, 40);
        this.add(textoUsuario);

        // Registro
        JLabel registrar1 = etiqueta("¿No tienes cuenta?", 800, 440, 400, 60, 30);
        this.add(registrar1);

        JLabel registrar2 = etiqueta("Registrate", 1065, 440, 400, 60, 30);
        registrar2.setForeground(Color.WHITE);
        registrar2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new RegistroUsuario(ventana));
            }
        });
        this.add(registrar2);

        // Linea de subrayado e
        this.add(crearLinea(1065, 485, 135, 2));

        // Boton para iniciar sesion
        JButton iniciarSesion = boton("Iniciar Sesión", 735, 550, 600, 120, 40);
        iniciarSesion.addActionListener(e -> { 
            ventana.mostrarPantalla(new Pedidos(ventana));
        });
        this.add(iniciarSesion);

        // Boton para regresar
        JLabel regresar = etiqueta("Regresar", 900, 900, 400, 60, 30);
        regresar.setForeground(Color.WHITE);
        regresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new InicioPrograma(ventana));
            }
        });
        this.add(regresar);
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


