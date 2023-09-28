package pe.edu.upc.backendpcinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.backendpcinfo.entities.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente,Integer> {
}
