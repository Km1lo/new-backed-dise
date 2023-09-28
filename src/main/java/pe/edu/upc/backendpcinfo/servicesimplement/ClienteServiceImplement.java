package pe.edu.upc.backendpcinfo.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendpcinfo.entities.Cliente;
import pe.edu.upc.backendpcinfo.repositories.IClienteRepository;
import pe.edu.upc.backendpcinfo.services.IClienteService;

import java.util.List;

@Service
public class ClienteServiceImplement implements IClienteService {
    @Autowired
    private IClienteRepository cR;
    @Override
    public void insert(Cliente cliente) {
        cR.save(cliente);
    }

    @Override
    public List<Cliente> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int idCliente) {
        cR.deleteById(idCliente);
    }

    @Override
    public Cliente listId(int idCliente) {
        return cR.findById(idCliente).orElse(new Cliente());
    }
}
