package Pantallas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Inicio extends JFrame {

    public Inicio() {
        setTitle("Club Pizza");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
        setVisible(true);
    }

    private void iniciarComponentes() {
        JPanel panelBotones = new JPanel();

        JButton btnExpress = new JButton("Express");
        JButton btnCliente = new JButton("Cliente");
        JButton btnEmpleado = new JButton("Empleado");

        panelBotones.add(btnExpress);
        panelBotones.add(btnCliente);
        panelBotones.add(btnEmpleado);
        
        this.add(panelBotones);
    }

    public static void main(String[] args) {
        
    }
}