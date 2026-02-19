/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pantallas;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Andre
 */
public class InicioSesion extends JFrame{
    
    public InicioSesion() {
        setTitle("Club Pizza");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
        setVisible(true);
    }
    
    private void iniciarComponentes() {
        JFrame FrameInicio = new JFrame("Inicio de sesion");
        FrameInicio.setSize(300, 150);
        FrameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameInicio.setLayout(new GridLayout(20, 6));

        JLabel lblUsuario = new JLabel("usuario:");
        JTextField txtUsuario = new JTextField();

        JLabel lblContra = new JLabel("contraseña:");
        JPasswordField txtContra = new JPasswordField();
 
        JButton btnEntrar = new JButton("entrar");

        FrameInicio.add(lblUsuario);
        FrameInicio.add(txtUsuario);
        FrameInicio.add(lblContra);
        FrameInicio.add(txtContra);
        FrameInicio.add(new JLabel("")); 
        FrameInicio.add(btnEntrar);
        
        FrameInicio.setVisible(true);
    }
    
}
