package pe.edu.upc.backendpcinfo.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendpcinfo.dtos.UsuarioComentarioDTO;
import pe.edu.upc.backendpcinfo.dtos.UsuarioCuestionarioDTO;
import pe.edu.upc.backendpcinfo.entities.Usuario;
import pe.edu.upc.backendpcinfo.repositories.IUsuarioRepository;
import pe.edu.upc.backendpcinfo.services.IUsuarioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(int idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public Usuario listId(int idUsuario) {
        return uR.findById(idUsuario).orElse(new Usuario());
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public List<UsuarioComentarioDTO> consulta01() {
        List<String[]> countComentariosByUsuario = uR.getComentariosByUsuario();
        List<UsuarioComentarioDTO> usuarioComentarioDTOs = new ArrayList<>();

        for (String[] data: countComentariosByUsuario) {
            UsuarioComentarioDTO dto = new UsuarioComentarioDTO();
            dto.setApellidop(data[0]);
            dto.setApellidom(data[1]);
            dto.setComentarioCount(Integer.parseInt(data[2]));
            usuarioComentarioDTOs.add(dto);
        }

        return usuarioComentarioDTOs;
    }

    @Override
    public List<UsuarioComentarioDTO> consulta02() {
        List<String[]> comentariosByUsuario = uR.getComentariosByUsuario2();
        List<UsuarioComentarioDTO> usuarioComentarioDTOs = new ArrayList<>();

        for (String[] data: comentariosByUsuario) {
            UsuarioComentarioDTO dto = new UsuarioComentarioDTO();
            dto.setNombre(data[0]);
            dto.setComentario(data[1]);
            dto.setFecha(LocalDate.parse(data[2]));
            usuarioComentarioDTOs.add(dto);
        }

        return usuarioComentarioDTOs;
    }

    @Override
    public List<UsuarioCuestionarioDTO> consultaAnthony02() {
        List<String[]> countCuestionariosByUsuario = uR.getCuestionariosByUsuario();
        List<UsuarioCuestionarioDTO> usuarioCuestionarioDTO = new ArrayList<>();

        for (String[] data: countCuestionariosByUsuario) {
            UsuarioCuestionarioDTO dto = new UsuarioCuestionarioDTO();
            dto.setApellidop(data[0]);
            dto.setApellidom(data[1]);
            dto.setCuestionarioCount(Integer.parseInt(data[2]));
            usuarioCuestionarioDTO.add(dto);
        }

        return usuarioCuestionarioDTO;
    }
}
