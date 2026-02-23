/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holabro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class RegistroUsuario {

    
    public static void main(String[] args) {
    JFrame jf = new JFrame("Registro de usuario");
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
            
            JTextField textoContra = new JTextField(20);
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
            
            
            fondo.add(nombre);
            fondo.add(apellidoPat);
            fondo.add(apellidoMat);
            fondo.add(nombreUsuario);
            fondo.add(contra);
            fondo.add(correo);
            fondo.add(fecha);
            fondo.add(calle);
            fondo.add(numero);
            fondo.add(colonia);
            fondo.add(cp);
            fondo.add(telefono);
            fondo.add(etiqueta);
           
            fondo.add(textoNombre);
            fondo.add(textoAP);
            fondo.add(textoAM);
            fondo.add(textoNombreU);
            fondo.add(textoContra);
            fondo.add(textoCorreo);
            fondo.add(textoFecha);
            fondo.add(textoCalle);
            fondo.add(textoNumero);
            fondo.add(textoColonia);
            fondo.add(textoCp);
            fondo.add(textoTF);
            fondo.add(textoEtqt);
            
            JLabel registrar2 = new JLabel("Ya cuento con una cuenta");
            registrar2.setFont(new Font("Arial", Font.PLAIN, 30));
            registrar2.setBounds(845, 550, 400, 60);
            registrar2.setForeground(Color.WHITE);
            fondo.add(registrar2);
            
            JPanel lineaSubrayado = new JPanel();
            lineaSubrayado.setBackground(Color.WHITE);
            lineaSubrayado.setBounds(845, 600, 340, 2); 
            fondo.add(lineaSubrayado);
            
            JButton iniciarSesion = new JButton("Registrarse");
            iniciarSesion.setFont(new Font("Arial", Font.BOLD, 50));
            iniciarSesion.setBounds(720, 650, 600, 120);
            iniciarSesion.setBackground(new Color(0, 102, 204));
            iniciarSesion.setForeground(Color.WHITE);
            iniciarSesion.setFocusPainted(false);
            fondo.add(iniciarSesion);
            

    } catch (Exception e) {
        e.printStackTrace();
    }
    
   
    jf.setVisible(true);
    
    }
  
    
}
