/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class RegistroUsuario extends JPanel {

    private VentanaPrincipal ventana;
    
    public RegistroUsuario(VentanaPrincipal ventana){
        this.ventana = ventana;
        
        this.setLayout(null);
        this.setBackground(new Color(0, 102, 180));
        this.setBounds(0, 0, 1920, 1080);
        
        
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setFont(new Font("Arial", Font.PLAIN, 40));
        nombre.setBounds(140, 110, 300, 60);

        JTextField textoNombre = new JTextField(20);
        textoNombre.setBounds(310, 110, 350, 50);
        textoNombre.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel apellidoPat = new JLabel("Apellido Paterno: ");
        apellidoPat.setFont(new Font("Arial", Font.PLAIN, 27));
        apellidoPat.setBounds(677, 110, 350, 60);

        JTextField textoAP = new JTextField(20);
        textoAP.setBounds(890, 110, 300, 50);
        textoAP.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel apellidoMat = new JLabel("Apellido Materno: ");
        apellidoMat.setFont(new Font("Arial", Font.PLAIN, 27));
        apellidoMat.setBounds(1205, 110, 350, 60);

        JTextField textoAM = new JTextField(20);
        textoAM.setBounds(1425, 110, 300, 50);
        textoAM.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel nombreUsuario = new JLabel("Usuario: ");
        nombreUsuario.setFont(new Font("Arial", Font.PLAIN, 40));
        nombreUsuario.setBounds(150, 210, 300, 60);

        JTextField textoNombreU = new JTextField(20);
        textoNombreU.setBounds(310, 210, 350, 50);
        textoNombreU.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel contra = new JLabel("Contraseña: ");
        contra.setFont(new Font("Arial", Font.PLAIN, 35));
        contra.setBounds(672, 210, 350, 60);

        JPasswordField textoContra = new JPasswordField(20);
        textoContra.setBounds(890, 210, 300, 50);
        textoContra.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel correo = new JLabel("Correo: ");
        correo.setFont(new Font("Arial", Font.PLAIN, 40));
        correo.setBounds(1230, 210, 350, 60);

        JTextField textoCorreo = new JTextField(20);
        textoCorreo.setBounds(1375, 210, 350, 50);
        textoCorreo.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel fecha = new JLabel("Fecha de Nacimiento: ");
        fecha.setFont(new Font("Arial", Font.PLAIN, 25));
        fecha.setBounds(150, 310, 300, 60);

        JTextField textoFecha = new JTextField(20);
        textoFecha.setBounds(407, 310, 350, 50);
        textoFecha.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel calle = new JLabel("Calle: ");
        calle.setFont(new Font("Arial", Font.PLAIN, 35));
        calle.setBounds(775, 310, 350, 60);

        JTextField textoCalle = new JTextField(20);
        textoCalle.setBounds(875, 310, 300, 50);
        textoCalle.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel numero = new JLabel("Numero: ");
        numero.setFont(new Font("Arial", Font.PLAIN, 40));
        numero.setBounds(1200, 310, 350, 60);

        JTextField textoNumero = new JTextField(20);
        textoNumero.setBounds(1375, 310, 150, 50);
        textoNumero.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel colonia = new JLabel("Colonia: ");
        colonia.setFont(new Font("Arial", Font.PLAIN, 40));
        colonia.setBounds(150, 410, 300, 60);

        JTextField textoColonia = new JTextField(20);
        textoColonia.setBounds(307, 410, 450, 50);
        textoColonia.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel cp = new JLabel("CP: ");
        cp.setFont(new Font("Arial", Font.PLAIN, 35));
        cp.setBounds(775, 410, 350, 60);

        JTextField textoCp = new JTextField(20);
        textoCp.setBounds(842, 410, 150, 50);
        textoCp.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel telefono = new JLabel("Telefono: ");
        telefono.setFont(new Font("Arial", Font.PLAIN, 40));
        telefono.setBounds(1000, 410, 350, 60);

        JTextField textoTF = new JTextField(20);
        textoTF.setBounds(1175, 410, 250, 50);
        textoTF.setFont(new Font("Arial", Font.PLAIN, 40));

        JLabel etiqueta = new JLabel("Etiqueta: ");
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 40));
        etiqueta.setBounds(1427, 410, 350, 60);

        JTextField textoEtqt = new JTextField(20);
        textoEtqt.setBounds(1585, 410, 150, 50);
        textoEtqt.setFont(new Font("Arial", Font.PLAIN, 40));


        this.add(nombre);
        this.add(apellidoPat);
        this.add(apellidoMat);
        this.add(nombreUsuario);
        this.add(contra);
        this.add(correo);
        this.add(fecha);
        this.add(calle);
        this.add(numero);
        this.add(colonia);
        this.add(cp);
        this.add(telefono);
        this.add(etiqueta);

        this.add(textoNombre);
        this.add(textoAP);
        this.add(textoAM);
        this.add(textoNombreU);
        this.add(textoContra);
        this.add(textoCorreo);
        this.add(textoFecha);
        this.add(textoCalle);
        this.add(textoNumero);
        this.add(textoColonia);
        this.add(textoCp);
        this.add(textoTF);
        this.add(textoEtqt);

        JLabel regresar = new JLabel("Ya cuento con una cuenta");
        regresar.setFont(new Font("Arial", Font.PLAIN, 30));
        regresar.setBounds(845, 550, 400, 60);
        regresar.setForeground(Color.WHITE);
        
        regresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPantalla(new InicioSesion(ventana)); }});
        this.add(regresar);

        JPanel lineaSubrayado = new JPanel();
        lineaSubrayado.setBackground(Color.WHITE);
        lineaSubrayado.setBounds(845, 600, 340, 2); 
        this.add(lineaSubrayado);

        JButton iniciarSesion = new JButton("Registrarse");
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 50));
        iniciarSesion.setBounds(720, 650, 600, 120);
        iniciarSesion.setBackground(new Color(0, 102, 204));
        iniciarSesion.setForeground(Color.WHITE);
        iniciarSesion.setFocusPainted(false);
        iniciarSesion.addActionListener(e -> { ventana.mostrarPantalla(new InicioSesion(ventana));});

        this.add(regresar);
        this.add(iniciarSesion);
        
    }
   
    
    
  
    
}
