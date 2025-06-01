package Model;

public class UsuarioModel {

    private int iden;
    private int identificacion;
    private String nombre_usuario;
    private String apellido_usuario;
    private String correo_usuario;
    private int telefono;
    private String plan;
    private String hora_entrada;

    public UsuarioModel() {
    }

    public UsuarioModel(int iden, int identificacion, String nombre_usuario, String apellido_usuario, String correo_usuario, int telefono, String plan, String hora_entrada) {
        this.iden = iden;
        this.identificacion = identificacion;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono = telefono;
        this.plan = plan;
        this.hora_entrada = hora_entrada;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" + "iden=" + iden + ", identificacion=" + identificacion + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", correo_usuario=" + correo_usuario + ", telefono=" + telefono + ", plan=" + plan + ", hora_entrada=" + hora_entrada + '}';
    }
}
