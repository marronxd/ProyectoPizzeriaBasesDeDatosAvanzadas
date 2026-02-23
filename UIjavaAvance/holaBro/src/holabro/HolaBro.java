/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class HolaBro {
    
    public static void main(String[] args) {

    JFrame jf = new JFrame("Inicio de Sesion");
    JPanel jp = new JPanel();
    jf.setSize(1920, 1080); 
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setResizable(false);
    jf.add(jp);

    try {
        
            JPanel fondo = new JPanel();
            fondo.setLayout(null);
            fondo.setBackground(new Color(0, 102, 180));
            jf.setContentPane(fondo);
            
            
            JLabel correo = new JLabel("Correo: ");
            correo.setFont(new Font("Arial", Font.PLAIN, 60));
            correo.setBounds(500, 210, 300, 60);
            
            JTextField textoUsuario = new JTextField(20);
            textoUsuario.setBounds(735, 300, 600, 80);
            textoUsuario.setFont(new Font("Arial", Font.PLAIN, 40));
            
            JLabel contrasenia = new JLabel("Contraseña: ");
            contrasenia.setFont(new Font("Arial", Font.PLAIN, 60));
            contrasenia.setBounds(380, 310, 350, 60);
            fondo.add(correo);
            fondo.add(contrasenia);
            
            JTextField textoUsuario2 = new JTextField(20);
            textoUsuario2.setBounds(735, 200, 600, 80);
            textoUsuario2.setFont(new Font("Arial", Font.PLAIN, 40));
            fondo.add(textoUsuario2);
            fondo.add(textoUsuario);
            
            JLabel registrar1 = new JLabel("¿No tienes cuenta?");
            registrar1.setFont(new Font("Arial", Font.PLAIN, 30));
            registrar1.setBounds(800, 440, 400, 60);
            fondo.add(registrar1);
            
            JLabel registrar2 = new JLabel("Registrate");
            registrar2.setFont(new Font("Arial", Font.PLAIN, 30));
            registrar2.setBounds(1065, 440, 400, 60);
            registrar2.setForeground(Color.WHITE);
            fondo.add(registrar2);
            
            JPanel lineaSubrayado = new JPanel();
            lineaSubrayado.setBackground(Color.WHITE);
            lineaSubrayado.setBounds(1065, 485, 135, 2); 
            fondo.add(lineaSubrayado);
            
            JButton iniciarSesion = new JButton("Iniciar Sesión");
            iniciarSesion.setFont(new Font("Arial", Font.BOLD, 40));
            iniciarSesion.setBounds(735, 550, 600, 120);
            iniciarSesion.setBackground(new Color(0, 102, 204));
            iniciarSesion.setForeground(Color.WHITE);
            iniciarSesion.setFocusPainted(false);
            fondo.add(iniciarSesion);
            
            JLabel regresar = new JLabel("Regresar");
            regresar.setFont(new Font("Arial", Font.PLAIN, 30));
            regresar.setBounds(900, 900, 400, 60);
            regresar.setForeground(Color.WHITE);
            fondo.add(regresar);

    } catch (Exception e) {
        e.printStackTrace();
    }
    
   
    jf.setVisible(true);
    
    }
}
