package pe.edu.upc.backendpcinfo.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendpcinfo.entities.Componente;
import pe.edu.upc.backendpcinfo.repositories.IComponenteRepository;
import pe.edu.upc.backendpcinfo.services.IComponenteService;

import java.util.List;


@Service
public class ComponenteServiceImplement implements IComponenteService {

    @Autowired
    private IComponenteRepository cmR;

    @Override
    public void insert(Componente componente) {
        cmR.save(componente);
    }

    @Override
    public List<Componente> list() {
        return cmR.findAll();
    }

    @Override
    public void delete(int idComponente) {
        cmR.deleteById(idComponente);
    }

    @Override
    public Componente listId(int idComponente) {
        return cmR.findById(idComponente).orElse(new Componente());
    }
}
