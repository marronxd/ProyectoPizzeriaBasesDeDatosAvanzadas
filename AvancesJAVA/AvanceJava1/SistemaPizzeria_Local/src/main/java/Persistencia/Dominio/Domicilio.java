package Persistencia.Dominio;

/**
 * Representa el domicilio de un cliente
 */
public class Domicilio {
    
    //Declara los atributos
    private Integer id;
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;
    
    
    
    //Constructores
    /**
     * Constructor completo
     * @param id
     * @param calle
     * @param numero
     * @param colonia
     * @param codigoPostal 
     */
    public Domicilio(Integer id, String calle, String numero, String colonia, String codigoPostal) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor sin Id
     * @param calle
     * @param numero
     * @param colonia
     * @param codigoPostal 
     */
    public Domicilio(String calle, String numero, String colonia, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }
    
    /**
     * Constructor vacío
     */
    public Domicilio() {
        
    }
    
    
    
    //Getters y setters
    public Integer getId() {
        return id;
    } public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCalle() {
        return calle;
    } public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    } public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    } public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    } public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}