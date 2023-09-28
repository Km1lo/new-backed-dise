package pe.edu.upc.backendpcinfo.dtos;

import pe.edu.upc.backendpcinfo.entities.Role;

import java.util.List;

public class UserDTO {
    private Long id;

    private String username;

    private String password;
    private Boolean enabled;

    private List<Role> roles;
}
