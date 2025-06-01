package Interfaces;

import Model.PagoModel;

public interface CrudUsuariosInterfaces {

    public void agregar(PagoModel usuario);

    public void modificar(PagoModel usuario);

    public void eliminar(int idusuarios);

    public PagoModel getUserById(int idusuarios);
}
