/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class VentanaPrincipal extends JFrame {
    
    public VentanaPrincipal(){
        this.setTitle("Sistema Club Pizza");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        mostrarPantalla(new InicioPrograma(this));
        this.setVisible(true);
        
    }
    
    public void mostrarPantalla(JPanel pantalla){
        this.setContentPane(pantalla);
        this.revalidate(); 
        this.repaint();
    }
    
    public static void main(String[] args) {
        new VentanaPrincipal();
    }
    
}
