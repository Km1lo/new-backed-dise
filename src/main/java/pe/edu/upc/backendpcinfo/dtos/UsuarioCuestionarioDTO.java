package pe.edu.upc.backendpcinfo.dtos;

public class UsuarioCuestionarioDTO {

    private int cuestionarioCount;
    private String apellidop;
    private String apellidom;
    private String nombre;

    private String marca_procesador;


    public UsuarioCuestionarioDTO() {
    }

    public UsuarioCuestionarioDTO(int cuestionarioCount, String apellidop, String apellidom, String nombre, String marca_procesador) {
        this.cuestionarioCount = cuestionarioCount;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.nombre = nombre;
        this.marca_procesador = marca_procesador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca_procesador() {
        return marca_procesador;
    }

    public void setMarca_procesador(String marca_procesador) {
        this.marca_procesador = marca_procesador;
    }

    public int getCuestionarioCount() {
        return cuestionarioCount;
    }

    public void setCuestionarioCount(int cuestionarioCount) {
        this.cuestionarioCount = cuestionarioCount;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }
}
