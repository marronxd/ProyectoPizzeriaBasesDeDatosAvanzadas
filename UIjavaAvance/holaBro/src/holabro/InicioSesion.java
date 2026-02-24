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
        this.setBounds(0, 0, 1920, 1080);

        JLabel correo = new JLabel("Correo: ");
        correo.setFont(new Font("Arial", Font.PLAIN, 60));
        correo.setBounds(500, 210, 300, 60);
        this.add(correo);

        JTextField textoUsuario2 = new JTextField(20);
        textoUsuario2.setBounds(735, 200, 600, 80);
        textoUsuario2.setFont(new Font("Arial", Font.PLAIN, 40));
        this.add(textoUsuario2);

        JLabel contrasenia = new JLabel("Contraseña: ");
        contrasenia.setFont(new Font("Arial", Font.PLAIN, 60));
        contrasenia.setBounds(380, 310, 350, 60);
        this.add(contrasenia);

        JTextField textoUsuario = new JTextField(20);
        textoUsuario.setBounds(735, 300, 600, 80);
        textoUsuario.setFont(new Font("Arial", Font.PLAIN, 40));
        this.add(textoUsuario);

       
        JLabel registrar1 = new JLabel("¿No tienes cuenta?");
        registrar1.setFont(new Font("Arial", Font.PLAIN, 30));
        registrar1.setBounds(800, 440, 400, 60);
        this.add(registrar1);

        JLabel registrar2 = new JLabel("Registrate");
        registrar2.setFont(new Font("Arial", Font.PLAIN, 30));
        registrar2.setBounds(1065, 440, 400, 60);
        registrar2.setForeground(Color.WHITE);
        
        registrar2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new RegistroUsuario(ventana));}});
        this.add(registrar2);

        JPanel lineaSubrayado = new JPanel();
        lineaSubrayado.setBackground(Color.WHITE);
        lineaSubrayado.setBounds(1065, 485, 135, 2); 
        this.add(lineaSubrayado);

        JButton iniciarSesion = new JButton("Iniciar Sesión");
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 40));
        iniciarSesion.setBounds(735, 550, 600, 120);
        iniciarSesion.setBackground(new Color(0, 102, 204));
        iniciarSesion.setForeground(Color.WHITE);
        iniciarSesion.setFocusPainted(false);
        iniciarSesion.addActionListener(e -> { ventana.mostrarPantalla(new PedidosCliente(ventana));});
        this.add(iniciarSesion);

       
        JLabel regresar = new JLabel("Regresar");
        regresar.setFont(new Font("Arial", Font.PLAIN, 30));
        regresar.setBounds(900, 900, 400, 60);
        regresar.setForeground(Color.WHITE);
        
        
        regresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new InicioPrograma(ventana)); }});
        this.add(regresar);
    }
}
