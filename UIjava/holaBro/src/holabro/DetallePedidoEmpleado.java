/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetallePedidoEmpleado extends JPanel {

    private VentanaPrincipal ventana;

    public DetallePedidoEmpleado(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));

        // Barra de navegacion superior escalada
        JPanel barra = crearPanel(0, 0, 1920, 250, new Color(0, 95, 153));
        this.add(barra);

        // Botones de navegacion
        barra.add(botonNavegacion("Pedidos", 35, 50, 350, 150, true));
        barra.add(botonNavegacion("Pizzas", 410, 50, 350, 150, false));
        barra.add(botonNavegacion("Clientes", 785, 50, 350, 150, false));
        barra.add(botonNavegacion("Cupones", 1160, 50, 350, 150, false));
        barra.add(botonNavegacion("Ventas", 1535, 50, 350, 150, false));

        // Cuadro principal de detalles
        JPanel cuadro = crearPanel(100, 300, 1720, 600, new Color(2, 128, 205));
        this.add(cuadro);

        // Estado del pedido
        JLabel lblEstado = etiqueta("Estado: PENDIENTE", 50, 30, 850, 100, 60, true);
        cuadro.add(lblEstado);

        // Botones de gestion
        JButton cancelar = boton("Cancelar", 1000, 40, 200, 80, 30);
        cancelar.addActionListener(e -> { 
            lblEstado.setText("Estado: CANCELADO"); 
            lblEstado.setForeground(Color.RED); 
        });
        cuadro.add(cancelar);

        JButton seguir = boton("Cambiar Estado", 1250, 40, 350, 80, 30);
        seguir.addActionListener(e -> {
            String estadoActual = lblEstado.getText();
            if (estadoActual.equals("Estado: PENDIENTE")) {
                lblEstado.setText("Estado: LISTO");
                lblEstado.setForeground(new Color(255, 204, 0));  
            } else if (estadoActual.equals("Estado: LISTO")) {
                lblEstado.setText("Estado: ENTREGADO");
                lblEstado.setForeground(Color.GREEN);
                seguir.setEnabled(false);
                seguir.setText("Finalizado");
            }
        });
        cuadro.add(seguir);

        // Lista detallada de productos y usa scroll
        JPanel listaContenido = new JPanel();
        listaContenido.setLayout(null);
        listaContenido.setBackground(new Color(2, 128, 205));

        JScrollPane scroll = new JScrollPane(listaContenido);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        scroll.setBounds((int)(50 * xf), (int)(150 * yf), (int)(1620 * xf), (int)(400 * yf));
        scroll.setBorder(null);
        cuadro.add(scroll);

        // agregamos una fila de ejemplo
        listaContenido.add(crearFilaDetalle("1 Pepperoni Chica", "100", 0));
        listaContenido.setPreferredSize(new Dimension((int)(1400 * xf), (int)(500 * yf)));

        // Informacion inferior de fecha y total
        cuadro.add(etiqueta("Fecha y hora: 17/02/26 09:10:20", 50, 530, 850, 100, 20, true));
        cuadro.add(etiqueta("Total: $100", 1200, 530, 400, 100, 40, true));

        // Boton para salir
        JLabel salir = etiqueta("Salir", 50, 940, 400, 80, 40, true);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new PedidosEmpleado(ventana));
            }
        });
        this.add(salir);
    }

    private JPanel botonNavegacion(String texto, int x, int y, int w, int h, boolean activo) {
        JPanel p = crearPanel(x, y, w, h, activo ? new Color(0, 76, 153) : new Color(2, 128, 205));
        JLabel l = new JLabel(texto, SwingConstants.CENTER);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        l.setFont(new Font("Arial", Font.BOLD, (int)(40 * yf)));
        l.setForeground(Color.WHITE);
        l.setBounds(0, (int)(45 * yf), (int)(w * xf), (int)(60 * yf));
        p.add(l);
        return p;
    }

    private JPanel crearFilaDetalle(String texto, String precio, int y) {
        JPanel fila = new JPanel();
        fila.setLayout(null);
        fila.setBackground(new Color(0, 76, 153));
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        fila.setBounds(0, (int)(y * yf), (int)(1400 * xf), (int)(100 * yf));

        JLabel lblNom = new JLabel(texto);
        lblNom.setFont(new Font("Arial", Font.BOLD, (int)(50 * yf)));
        lblNom.setForeground(Color.WHITE);
        lblNom.setBounds((int)(30 * xf), (int)(10 * yf), (int)(600 * xf), (int)(80 * yf));
        fila.add(lblNom);

        JLabel lblPre = new JLabel("$" + precio);
        lblPre.setFont(new Font("Arial", Font.BOLD, (int)(30 * yf)));
        lblPre.setForeground(Color.WHITE);
        lblPre.setBounds((int)(1150 * xf), (int)(10 * yf), (int)(200 * xf), (int)(80 * yf));
        fila.add(lblPre);

        return fila;
    }

    private JLabel etiqueta(String t, int x, int y, int w, int h, int f, boolean bold) {
        JLabel l = new JLabel(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        l.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        l.setFont(new Font("Arial", bold ? Font.BOLD : Font.PLAIN, (int)(f * yf)));
        l.setForeground(Color.WHITE);
        return l;
    }

    private JButton boton(String t, int x, int y, int w, int h, int f) {
        JButton b = new JButton(t);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        b.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        b.setFont(new Font("Arial", Font.BOLD, (int)(f * yf)));
        b.setBackground(new Color(0, 102, 204));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        return b;
    }

    private JPanel crearPanel(int x, int y, int w, int h, Color c) {
        JPanel p = new JPanel();
        p.setLayout(null);
        double xf = ventana.getXcorrecto(), yf = ventana.getYcorrecto();
        p.setBounds((int)(x * xf), (int)(y * yf), (int)(w * xf), (int)(h * yf));
        p.setBackground(c);
        return p;
    }
}
