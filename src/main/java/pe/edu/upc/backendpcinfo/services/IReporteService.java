package pe.edu.upc.backendpcinfo.services;

import pe.edu.upc.backendpcinfo.dtos.UsuarioReporteDTO;
import pe.edu.upc.backendpcinfo.entities.Reporte;

import java.util.List;

public interface IReporteService{
        public void insert(Reporte reporte);
        List<Reporte> list();
        public void delete(int id);
        public Reporte listId(int id);
        public List<UsuarioReporteDTO> consulta01();
        public List<UsuarioReporteDTO> consulta02();

        public List<UsuarioReporteDTO> consulta03();
}
