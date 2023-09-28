package pe.edu.upc.backendpcinfo.services;

import pe.edu.upc.backendpcinfo.entities.Users;

import java.util.List;


public interface IUserService {
    public Integer insert(Users user);

    List<Users> list();

}