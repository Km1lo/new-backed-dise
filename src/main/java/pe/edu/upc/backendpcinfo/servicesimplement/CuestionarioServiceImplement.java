package pe.edu.upc.backendpcinfo.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendpcinfo.dtos.UsuarioCuestionarioDTO;
import pe.edu.upc.backendpcinfo.entities.Cuestionario;
import pe.edu.upc.backendpcinfo.repositories.ICuestionarioRepository;
import pe.edu.upc.backendpcinfo.services.ICuestionarioService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuestionarioServiceImplement implements ICuestionarioService {
    @Autowired
    private ICuestionarioRepository cR;

    @Override
    public void insert(Cuestionario cuestionario) {
        cR.save(cuestionario);
    }

    @Override
    public List<Cuestionario> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public Cuestionario listId(int id) {
        return cR.findById(id).orElse(new Cuestionario());
    }

    @Override
    public List<UsuarioCuestionarioDTO> consulta04() {
        List<String[]> countCuestionarioByUsuario = cR.getCuestionarioByUsuario();
        List<UsuarioCuestionarioDTO> usuarioCuestionarioDTOs = new ArrayList<>();

        for (String[] data : countCuestionarioByUsuario) {
            UsuarioCuestionarioDTO dto = new UsuarioCuestionarioDTO();
            dto.setApellidop(data[0]);
            dto.setApellidom(data[1]);
            dto.setCuestionarioCount(Integer.parseInt(data[2]));
            usuarioCuestionarioDTOs.add(dto);
        }

        return usuarioCuestionarioDTOs;
    }

    @Override
    public List<UsuarioCuestionarioDTO> consulta05() {
        List<String[]> Cuestionario1ByUsuario = cR.getCuestionario1EstadoByUsuario();
        List<UsuarioCuestionarioDTO> UsuarioCuestionarioDTOss = new ArrayList<>();
        for (String[] data : Cuestionario1ByUsuario) {
            UsuarioCuestionarioDTO dto = new UsuarioCuestionarioDTO();
            dto.setNombre(data[0]);
            dto.setApellidop(data[1]);
            dto.setApellidom(data[2]);
            dto.setMarca_procesador(data[3]);
            UsuarioCuestionarioDTOss.add(dto);
        }

        return UsuarioCuestionarioDTOss;
    }

    @Override
    public List<UsuarioCuestionarioDTO> consulta06() {
        List<String[]> Cuestionario2ByUsuario = cR.getCuestionario2ByUsuario();
        List<UsuarioCuestionarioDTO> UsuarioCuestionarioDTOs = new ArrayList<>();

        for (String[] data : Cuestionario2ByUsuario) {
            UsuarioCuestionarioDTO dto = new UsuarioCuestionarioDTO();
            dto.setNombre(data[0]);
            dto.setApellidop(data[1]);
            dto.setApellidom(data[2]);
            dto.setMarca_procesador(data[3]);
            UsuarioCuestionarioDTOs.add(dto);
        }

        return UsuarioCuestionarioDTOs;
    }
}
