package pe.edu.upc.backendpcinfo.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendpcinfo.entities.Administrador;
import pe.edu.upc.backendpcinfo.repositories.IAdministradorRepository;
import pe.edu.upc.backendpcinfo.services.IAdministradorService;

import java.util.List;
@Service
public class AdministradorServiceImplement implements IAdministradorService {
    @Autowired
    private IAdministradorRepository aR;

    @Override
    public void insert(Administrador administrador) {
        aR.save(administrador);
    }

    @Override
    public List<Administrador> list() {
        return aR.findAll();
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public Administrador listId(int id) {
        return aR.findById(id).orElse(new Administrador());
    }

}
