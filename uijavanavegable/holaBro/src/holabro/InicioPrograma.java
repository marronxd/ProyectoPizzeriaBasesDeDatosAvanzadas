/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InicioPrograma extends JPanel {
    private VentanaPrincipal ventana;
    
    public InicioPrograma(VentanaPrincipal ventana){
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));
        this.setBounds(0,0,1920,1080);
        
        JButton cliente = boton("Cliente", 235, 550, 600, 120);
        cliente.addActionListener(e -> { ventana.mostrarPantalla(new InicioSesion(ventana)); DatosGlobales.esempleado = false; DatosGlobales.esexpress = false;});
        this.add(cliente);
        JButton empleado = boton("Empleado", 1050, 550, 600, 120);
        empleado.addActionListener(e -> { ventana.mostrarPantalla(new InicioSesion(ventana)); DatosGlobales.esempleado = true; DatosGlobales.esexpress = false;});
        
        this.add(empleado);
        JButton express = boton("Express", 1500, 900, 300, 80);
        express.addActionListener(e -> { DatosGlobales.esexpress = true; ventana.mostrarPantalla(new Pedidos(ventana));});
        this.add(express);
        JButton salir = boton("Salir", 150, 900, 150, 80);
        salir.addActionListener(e -> { System.exit(0);}); // este comando es para cerrar un programa, el 0 indica que todo bien
        this.add(salir);
    }
    
    private JButton boton(String string, int x, int y, int gordis, int altura){
        JButton boton = new JButton(string);
        
        double xc = ventana.getXcorrecto();
        double yc = ventana.getYcorrecto();
        
        if (xc <= 0) xc = 1.0;
        if (yc <= 0) yc = 1.0;
        
        int nx = (int) (x * xc);
        int ny = (int) (y * yc);
        int ng = (int) (gordis * xc);
        int na = (int) (altura * yc);
        
        boton.setBounds(nx, ny, ng, na);
        
        boton.setFont(new Font("Arial", Font.BOLD, 40));
        boton.setBackground(new Color(0, 102, 204));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        return boton;
    }
    
    
}
