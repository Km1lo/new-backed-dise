package pe.edu.upc.backendpcinfo.services;

import pe.edu.upc.backendpcinfo.entities.Cliente;

import java.util.List;

public interface IClienteService {
    public void insert(Cliente cliente);
    List<Cliente> list();
    public void delete(int idCliente);
    public Cliente listId(int idCliente);
}
