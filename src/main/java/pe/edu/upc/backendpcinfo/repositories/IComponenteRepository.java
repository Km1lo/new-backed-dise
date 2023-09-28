package pe.edu.upc.backendpcinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendpcinfo.entities.Componente;

@Repository
public interface IComponenteRepository extends JpaRepository<Componente,Integer> {
}
