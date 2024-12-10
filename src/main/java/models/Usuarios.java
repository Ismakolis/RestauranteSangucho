package models;

public class Usuarios {

    private Long idUsuario;
    private String nombreUsuario;
    private String correoUsuario;
    private int contrasenaUsuario;
    private String rolUsuario;
    private int cedulaUsuario;

    public Usuarios(Long idUsuario, String nombreUsuario, String cooreoUusario, int contrasenaUsuario, String rolUsuario, int cedulaUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.rolUsuario = rolUsuario;
        this.cedulaUsuario = cedulaUsuario;
    }

    public Usuarios() {

    }


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCooreoUusario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(int contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public int getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(int cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }
}
