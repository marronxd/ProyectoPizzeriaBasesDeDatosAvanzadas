package Negocio.DTO;

/**
 * Empaqueta los atributos de un teléfono en un DTO
 */
public class TelefonoDTO {
    
    //Declara los atributos
    private String numero;
    private String etiqueta;

    /**
     * Constructor
     * @param numero
     * @param etiqueta 
     */
    public TelefonoDTO(String numero, String etiqueta) {
        this.numero = numero;
        this.etiqueta = etiqueta;
    }

    //Getters y setters
    public String getNumero() {
        return numero;
    } public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEtiqueta() {
        return etiqueta;
    } public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }   
}