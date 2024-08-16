package HLDataAccess.DTO;

public class HLHormigaDTO {
    private Integer idHormiga          ; 
    private Integer idCatalogoRegion   ; 
    private Integer idCatalogoProvincia; 
    private Integer idCatalogoSexo     ; 
    private Integer idCatalogoIngestaNativa    ; 
    private Integer idCatalogoGenoAlimento     ; 
    private String  tipoHormiga        ;
    private String  estado             ;
    private String  fechaCreacion      ;
    private String  fechaModifica      ;

    public HLHormigaDTO(){}

    public HLHormigaDTO(Integer idHormiga, Integer idCatalogoRegion, Integer idCatalogoProvincia,
            Integer idCatalogoSexo, Integer idCatalogoIngestaNativa, Integer idCatalogoGenoAlimento, String tipoHormiga, String estado,
            String fechaCreacion, String fechaModifica) {
        this.idHormiga              = idHormiga;
        this.idCatalogoRegion       = idCatalogoRegion;
        this.idCatalogoProvincia    = idCatalogoProvincia;
        this.idCatalogoSexo         = idCatalogoSexo;
        this.idCatalogoIngestaNativa        = idCatalogoIngestaNativa;
        this.idCatalogoGenoAlimento         = idCatalogoGenoAlimento;
        this.tipoHormiga            = tipoHormiga;
        this.estado                 = estado;
        this.fechaCreacion          = fechaCreacion;
        this.fechaModifica          = fechaModifica;
    }

    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }

    public Integer getIdCatalogoRegion() {
        return idCatalogoRegion;
    }

    public void setIdCatalogoRegion(Integer idCatalogoRegion) {
        this.idCatalogoRegion = idCatalogoRegion;
    }

    public Integer getIdCatalogoProvincia() {
        return idCatalogoProvincia;
    }

    public void setIdCatalogoProvincia(Integer idCatalogoProvincia) {
        this.idCatalogoProvincia = idCatalogoProvincia;
    }

    public Integer getIdCatalogoSexo() {
        return idCatalogoSexo;
    }

    public void setIdCatalogoSexo(Integer idCatalogoSexo) {
        this.idCatalogoSexo = idCatalogoSexo;
    }

    public Integer getIdCatalogoIngestaNativa() {
        return idCatalogoIngestaNativa;
    }

    public void setIdCatalogoIngestaNativa(Integer idCatalogoIngestaNativa) {
        this.idCatalogoIngestaNativa = idCatalogoIngestaNativa;
    }

    public Integer getIdCatalogoGenoAlimento() {
        return idCatalogoGenoAlimento;
    }

    public void setIdCatalogoGenoAlimento(Integer idCatalogoGenoAlimento) {
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
    }

    public String getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    } 

    @Override
    public String toString() {
        return  getClass().getName()
                + "\n idHormiga             "+ getIdHormiga()                      
                + "\n idCatalogoRegion      "+ getIdCatalogoRegion()
                + "\n idCatalogoProvincia   "+ getIdCatalogoProvincia()
                + "\n idCatalogoSexo        "+ getIdCatalogoSexo()
                + "\n idCatalogoIngestaNativa       "+ getIdCatalogoIngestaNativa()
                + "\n idCatalogoGenoAlimento        "+ getIdCatalogoGenoAlimento()
                + "\n tipoHormiga           "+ getTipoHormiga()
                + "\n estado                "+ getEstado()
                + "\n fechaCreacion         "+ getFechaCreacion()
                + "\n fechaModifica         "+ getFechaModifica();
    }

}
