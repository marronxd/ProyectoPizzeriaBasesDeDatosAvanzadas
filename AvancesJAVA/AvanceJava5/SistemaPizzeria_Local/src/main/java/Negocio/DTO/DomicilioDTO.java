package Negocio.DTO;

/**
 * Empaqueta los atributos de un domicilio en un DTO
 */
public class DomicilioDTO {
    
    //Declara los atributos
    private Integer id;
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;
    
    //Flags de rastreo de edición
    private boolean calleEditada;
    private boolean numeroEditado;
    private boolean coloniaEditada;
    private boolean codigoPostalEditado;
    
    //Constructores
    /**
     * Constructor completo
     * @param id
     * @param calle
     * @param numero
     * @param colonia
     * @param codigoPostal 
     */
    public DomicilioDTO(Integer id, String calle, String numero, String colonia, String codigoPostal) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor sin id
     * @param calle
     * @param numero
     * @param colonia
     * @param codigoPostal 
     */
    public DomicilioDTO(String calle, String numero, String colonia, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }
    
    /**
     * Constructor vacío
     */
    public DomicilioDTO() {
        
    }
    
    //Getters y setters de los atributos
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    //Getters y setters de flags
    public boolean isCalleEditada() {
        return calleEditada;
    }
    public void setCalleEditada(boolean calleEditada) {
        this.calleEditada = calleEditada;
    }

    public boolean isNumeroEditado() {
        return numeroEditado;
    }
    public void setNumeroEditado(boolean numeroEditado) {
        this.numeroEditado = numeroEditado;
    }

    public boolean isColoniaEditada() {
        return coloniaEditada;
    }
    public void setColoniaEditada(boolean coloniaEditada) {
        this.coloniaEditada = coloniaEditada;
    }

    public boolean isCodigoPostalEditado() {
        return codigoPostalEditado;
    }
    public void setCodigoPostalEditado(boolean codigoPostalEditado) {
        this.codigoPostalEditado = codigoPostalEditado;
    }
}