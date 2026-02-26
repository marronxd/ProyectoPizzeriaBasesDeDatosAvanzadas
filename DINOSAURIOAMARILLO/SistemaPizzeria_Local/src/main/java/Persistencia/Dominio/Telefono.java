package Persistencia.Dominio;

/**
 * Representa un teléfono asociado a un cliente en el sistema
 */
public class Telefono {
    
    //Declara los atributos
    private Integer id;
    private String numero;
    private String etiqueta;

    
    
    //Constructores
    /**
     * Constructor completo
     * @param id
     * @param numero
     * @param etiqueta 
     */
    public Telefono(Integer id, String numero, String etiqueta) {
        this.id = id;
        this.numero = numero;
        this.etiqueta = etiqueta;
    }
    
    /**
     * Constructor sin Id
     * @param numero
     * @param etiqueta 
     */
    public Telefono(String numero, String etiqueta) {
        this.id = id;
        this.numero = numero;
        this.etiqueta = etiqueta;
    }

    /**
     * Constructor vacío
     */
    public Telefono() {
        
    }
    
    
    
    //Getters y setters
    public Integer getId() {
        return id;
    } public void setId(Integer id) {
        this.id = id;
    }
    
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