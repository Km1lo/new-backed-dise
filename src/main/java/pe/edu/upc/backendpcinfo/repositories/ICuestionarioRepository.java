package pe.edu.upc.backendpcinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendpcinfo.entities.Cuestionario;

import java.util.List;

@Repository

public interface ICuestionarioRepository extends JpaRepository<Cuestionario,Integer> {


    @Query(value = "\n" +
            "SELECT usuario.nombre, usuario.apellidop, reporte.descripcion\n" +
            "FROM usuario\n" +
            "INNER JOIN reporte ON usuario.id = reporte.id_usuario;", nativeQuery = true)
    List<String[]> getCuestionarioByUsuario();

    @Query(value = "SELECT U.nombre,U.apellidop,U.apellidom, Count(R.id) AS Cant_Procesador\n" +
            "FROM usuario U\n" +
            "\tinner join cuestionario R ON U.id = R.id_usuario\n" +
            "where R.marca_procesador= 'AMD'\n" +
            "group by u.nombre,U.apellidop,U.apellidom", nativeQuery = true)
    List<String[]> getCuestionario1EstadoByUsuario();

    @Query(value = "SELECT U.nombre,U.apellidop,U.apellidom, Count(R.id) AS Cant_Procesador\n" +
            "FROM usuario U\n" +
            "\tinner join cuestionario R ON U.id = R.id_usuario\n" +
            "where R.marca_procesador= 'Intel'\n" +
            "group by u.nombre,U.apellidop,U.apellidom", nativeQuery = true)
    List<String[]> getCuestionario2ByUsuario();


}
