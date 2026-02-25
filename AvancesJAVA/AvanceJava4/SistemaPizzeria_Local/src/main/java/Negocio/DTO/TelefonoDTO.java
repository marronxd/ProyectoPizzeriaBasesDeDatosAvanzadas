package Negocio.DTO;

/**
 * Empaqueta los atributos de un teléfono en un DTO
 */
public class TelefonoDTO {
    
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
    public TelefonoDTO(Integer id, String numero, String etiqueta) {
        this.id = id;
        this.numero = numero;
        this.etiqueta = etiqueta;
    }

    /**
     * Constructor sin ID
     * @param numero
     * @param etiqueta 
     */
    public TelefonoDTO(String numero, String etiqueta) {
        this.numero = numero;
        this.etiqueta = etiqueta;
    }
    
    /**
     * Constructor vacío
     */
    public TelefonoDTO() {
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