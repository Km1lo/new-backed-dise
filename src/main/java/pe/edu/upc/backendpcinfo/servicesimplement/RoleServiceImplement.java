package pe.edu.upc.backendpcinfo.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendpcinfo.entities.Role;
import pe.edu.upc.backendpcinfo.repositories.RoleRepository;
import pe.edu.upc.backendpcinfo.services.IRoleService;

import java.util.List;


@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private RoleRepository rR;

    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public List<Role> list() {
        // TODO Auto-generated method stub
        return rR.findAll();
    }
}