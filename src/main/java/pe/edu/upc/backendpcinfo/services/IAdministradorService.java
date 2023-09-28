package pe.edu.upc.backendpcinfo.services;

import pe.edu.upc.backendpcinfo.entities.Administrador;

import java.util.List;

public interface IAdministradorService {
    public void insert (Administrador administrador);
    List<Administrador> list();
    public void delete (int id);
    public Administrador listId(int id);
}
