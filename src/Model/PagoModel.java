package Model;

public class PagoModel extends UsuarioModel {

    private boolean pago_usuario;

    public PagoModel() {
    }

    public PagoModel(boolean pago_usuario, int iden, int identificacion, String nombre_usuario, String apellido_usuario, String correo_usuario, int telefono, String plan, String hora_entrada, PagoModel pago_model) {
        super(iden, identificacion, nombre_usuario, apellido_usuario, correo_usuario, telefono, plan, hora_entrada);
        this.pago_usuario = pago_usuario;
    }

    public boolean isPago_usuario() {
        return pago_usuario;
    }

    public void setPago_usuario(boolean pago_usuario) {
        this.pago_usuario = pago_usuario;
    }

    @Override
    public String toString() {
        return super.toString() + "PagoModel{" + "pago_usuario=" + pago_usuario + '}';
    }
}
