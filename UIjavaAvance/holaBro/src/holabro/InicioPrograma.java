/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class InicioPrograma extends JPanel {
    private VentanaPrincipal ventana;
    
    public InicioPrograma(VentanaPrincipal ventana){
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));
        this.setBounds(0,0,1920,1080);
        
        JButton cliente = boton("Cliente", 235, 550, 600, 120);
        cliente.addActionListener(e -> { ventana.mostrarPantalla(new InicioSesion(ventana));});
        this.add(cliente);
        JButton empleado = boton("Empleado", 1050, 550, 600, 120);
        empleado.addActionListener(e -> { ventana.mostrarPantalla(new InicioSesion(ventana));});
        this.add(empleado);
        JButton express = boton("Express", 1500, 900, 300, 80);
        express.addActionListener(e -> { ventana.mostrarPantalla(new PedidoExpress(ventana));});
        this.add(express);
        JButton salir = boton("Salir", 150, 900, 150, 80);
        salir.addActionListener(e -> { System.exit(0);}); // este comando es para cerrar un programa, el 0 indica que todo bien
        this.add(salir);
    }
    
    private JButton boton(String string, int x, int y, int gordis, int altura){
        JButton boton = new JButton(string);
        boton.setFont(new Font("Arial", Font.BOLD, 40));
        boton.setBounds(x, y, gordis, altura);
        boton.setBackground(new Color(0, 102, 204));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        return boton;
    }
    
    
}
