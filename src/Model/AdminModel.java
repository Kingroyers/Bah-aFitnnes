package Model;

public class AdminModel {

    private int id_admin;
    private String usuario_admin;
    private String pass_admin;

    public AdminModel() {
    }

    public AdminModel(int id_admin, String usuario_admin, String pass_admin) {
        this.id_admin = id_admin;
        this.usuario_admin = usuario_admin;
        this.pass_admin = pass_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getUsuario_admin() {
        return usuario_admin;
    }

    public void setUsuario_admin(String usuario_admin) {
        this.usuario_admin = usuario_admin;
    }

    public String getPass_admin() {
        return pass_admin;
    }

    public void setPass_admin(String pass_admin) {
        this.pass_admin = pass_admin;
    }

}
