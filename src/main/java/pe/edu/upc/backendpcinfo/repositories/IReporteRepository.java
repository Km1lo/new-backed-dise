package pe.edu.upc.backendpcinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backendpcinfo.entities.Reporte;

import java.util.List;

@Repository
public interface IReporteRepository extends JpaRepository<Reporte,Integer> {

    @Query(value = "\n" +
            "SELECT usuario.nombre, usuario.apellidop, reporte.descripcion\n" +
            "FROM usuario\n" +
            "INNER JOIN reporte ON usuario.id = reporte.id_usuario;", nativeQuery = true)
    List<String[]> getReporteByUsuario();

    @Query(value = "SELECT a.nombre,a.apellidop, COUNT(b.id) AS TotalReportes \n" +
            "            FROM reporte b\n" +
            "            JOIN usuario a ON b.id_usuario = a.id\n" +
            "            GROUP BY a.nombre,a.apellidop\n" +
            "            ORDER BY COUNT(b.id) DESC\t", nativeQuery = true)
    List<String[]> getCountReporteByUsuario();

    @Query(value = "SELECT U.nombre,U.apellidop,U.apellidom, Count(R.id) AS Cant_Reportes\n" +
            "FROM usuario U\n" +
            "\tinner join reporte R ON U.id = R.id_usuario\n" +
            "where R.estado= 'Finalizado'\n" +
            "group by u.nombre,U.apellidop,U.apellidom", nativeQuery = true)
    List<String[]> getReporteEstadoByUsuario();


}
