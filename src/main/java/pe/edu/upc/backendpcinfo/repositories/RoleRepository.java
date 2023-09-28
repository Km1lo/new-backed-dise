package pe.edu.upc.backendpcinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendpcinfo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}