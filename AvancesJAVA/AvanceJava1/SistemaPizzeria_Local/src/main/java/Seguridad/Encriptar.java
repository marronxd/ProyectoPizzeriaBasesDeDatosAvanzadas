/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Clase auxiliar encargada meramente a encriptar los pines que se generan en el sistema
 * para los pedidos express
 * @author aaron
 */
public class Encriptar {
    public static String encriptar(int pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // se recibe el mensaje y se encripta en este formato
            byte[] digest = md.digest(String.valueOf(pin).getBytes()); //aca se parcean los valores
            // Convierte los bytes a un String alfanumérico legible
            return String.format("%064x", new BigInteger(1, digest)); // ahora si se encripta
        } catch (Exception e) {
            return null; 
        }
    }
}
