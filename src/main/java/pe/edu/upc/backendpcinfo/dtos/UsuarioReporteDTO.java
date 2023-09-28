package pe.edu.upc.backendpcinfo.dtos;

public class UsuarioReporteDTO {
    private String nombre;
    private int reporteCount;
    private String apellidop;
    private String descripcion;

    private String estado;
    private String apellidom;

    public UsuarioReporteDTO() {
    }

    public UsuarioReporteDTO(String nombre, int reporteCount, String apellidop, String descripcion, String estado, String apellidom) {
        this.nombre = nombre;
        this.reporteCount = reporteCount;
        this.apellidop = apellidop;
        this.descripcion = descripcion;
        this.estado = estado;
        this.apellidom = apellidom;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getReporteCount() {
        return reporteCount;
    }

    public void setReporteCount(int reporteCount) {
        this.reporteCount = reporteCount;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }
}
