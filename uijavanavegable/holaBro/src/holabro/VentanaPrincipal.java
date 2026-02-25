/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class VentanaPrincipal extends JFrame {
    
    private JPanel panelActual;
    
    public VentanaPrincipal(){
        this.setTitle("Sistema Club Pizza");
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(null);
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // cada vez que se mueva la ventana, redibujamos el panel actual
                if (panelActual != null) {
                    revalidarEscala(); }}});
        
        this.setVisible(true);
        mostrarPantalla(new InicioPrograma(this));
        
        
        
    }
    
    public void mostrarPantalla(JPanel pantalla){
        this.panelActual = pantalla;
        this.setContentPane(panelActual); 
        revalidarEscala();
    }
    
    private void revalidarEscala(){
        this.revalidate();
        this.repaint();
    }
    
    public double getXcorrecto(){
        return (double) this.getWidth() / 1920.0;
    }
    
    public double getYcorrecto(){
        return (double) this.getHeight() / 1080.0;
    }
    
    public static void main(String[] args) {
        new VentanaPrincipal();
    }
    
}
