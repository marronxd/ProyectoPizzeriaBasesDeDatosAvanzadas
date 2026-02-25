/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pedidos extends JPanel {
    private static int pedidos = 0;
    private VentanaPrincipal ventana;
    private JPanel listaPedidos;

    public Pedidos(VentanaPrincipal ventana) {
        pedidos = 0; // Aqui se se le puede agregar dinamicamente empleados
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Cuadro principal donde estan los pedidos
        JPanel cuadro = crearPanel(100, 100, 1720, 800, new Color(2, 128, 205));
        this.add(cuadro);

        // Título de la seccion
        JLabel nombre = etiqueta("PEDIDOS", 140, 110, 400, 80, 80, true);
        cuadro.add(nombre);

        // Boton para ir al menu de pizzas
        JButton realizarPedido = boton("Realizar pedido", 1050, 75, 600, 120, 50);
        realizarPedido.addActionListener(e -> { 
            ventana.mostrarPantalla(new MenuPizza(ventana)); 
        });
        cuadro.add(realizarPedido);

        // Contenedor interno para los pedidos
        this.listaPedidos = new JPanel();
        listaPedidos.setLayout(null);
        listaPedidos.setBackground(new Color(2, 128, 205));
        
        JScrollPane scroll = new JScrollPane(listaPedidos);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        double x = ventana.getXcorrecto();
        double y = ventana.getYcorrecto();

        // posicionamos el scroll
        scroll.setBounds((int)(140 * x), (int)(200 * y), (int)(1450 * x), (int)(500 * y));
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(2, 128, 205));

        // agregamos el scroll al cuadro principal
        cuadro.add(scroll);

        // Ejemplo de pedido agregado
        agregarPedido(listaPedidos, "aaron", "12/12/12", ventana);
        agregarPedido(listaPedidos, "aaron", "12/12/12", ventana);
        agregarPedido(listaPedidos, "aaron", "12/12/12", ventana);
        agregarPedido(listaPedidos, "aaron", "12/12/12", ventana);
        agregarPedido(listaPedidos, "aaron", "12/12/12", ventana);
        

        // Etiqueta de salir 
        JLabel salir = etiqueta("Salir", 50, 940, 400, 80, 40, true);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new InicioPrograma(ventana));
            }
        });
        this.add(salir);
    }
    
    // pasamos ventana para poder calcular las escalas
    private static void agregarPedido(JPanel contenedor, String cliente, String fecha, VentanaPrincipal ventana) {
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();

        JButton fila = new JButton();
        fila.setLayout(null);
        fila.setBackground(new Color(0, 76, 153));

        int yOriginal = pedidos * 110; 
        fila.setBounds(0, (int)(yOriginal * yf), (int)(1400 * xf), (int)(100 * yf));

        // etiquetas internas de la fila
        JLabel lblNom = new JLabel(cliente);
        lblNom.setFont(new Font("arial", Font.BOLD, (int)(50 * yf)));
        lblNom.setForeground(Color.WHITE);
        lblNom.setBounds((int)(30 * xf), (int)(10 * yf), (int)(600 * xf), (int)(80 * yf));
        fila.add(lblNom);

        JLabel lblFec = new JLabel(fecha);
        lblFec.setFont(new Font("arial", Font.BOLD, (int)(30 * yf)));
        lblFec.setForeground(Color.WHITE);
        lblFec.setBounds((int)(1150 * xf), (int)(10 * yf), (int)(200 * xf), (int)(80 * yf));
        fila.add(lblFec);
        fila.addActionListener(e -> { ventana.mostrarPantalla(new InformacionPedido(ventana)); });

        contenedor.add(fila);
        pedidos++;

        // actualizamos el tamaño del contenedor para que el scroll se active
        int altoContenido = (int)((pedidos * 110) * yf);
        contenedor.setPreferredSize(new Dimension((int)(1400 * xf), altoContenido));

        // refrescamos el panel para que aparezcan los cambios
        contenedor.revalidate();
        contenedor.repaint();
    }

    private JLabel etiqueta(String t, int x, int y, int w, int h, int f, boolean negrita) {
        JLabel l = new JLabel(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        l.setBounds((int)(x*xf), (int)(y*yf), (int)(w*xf), (int)(h*yf));
        l.setFont(new Font("Arial", negrita ? Font.BOLD : Font.PLAIN, (int)(f*yf)));
        l.setForeground(Color.WHITE);
        return l;
    }

    private JPanel crearPanel(int x, int y, int w, int h, Color c) {
        JPanel p = new JPanel();
        p.setLayout(null);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        p.setBounds((int)(x*xf), (int)(y*yf), (int)(w*xf), (int)(h*yf));
        p.setBackground(c);
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
}
