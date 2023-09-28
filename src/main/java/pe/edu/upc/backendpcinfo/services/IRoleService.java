package pe.edu.upc.backendpcinfo.services;

import pe.edu.upc.backendpcinfo.entities.Role;

import java.util.List;



public interface IRoleService {
    public void insert(Role role);

    List<Role> list();

}