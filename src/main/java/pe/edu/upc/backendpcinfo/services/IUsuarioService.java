package pe.edu.upc.backendpcinfo.services;

import pe.edu.upc.backendpcinfo.dtos.UsuarioComentarioDTO;
import pe.edu.upc.backendpcinfo.dtos.UsuarioCuestionarioDTO;
import pe.edu.upc.backendpcinfo.entities.Usuario;

import java.util.List;

public interface IUsuarioService {

    public void insert(Usuario usuario);
    public void delete(int idUsuario);
    public Usuario listId(int idUsuario);
    List<Usuario> list();

    public List<UsuarioComentarioDTO> consulta01();

    public List<UsuarioComentarioDTO> consulta02();

    public List<UsuarioCuestionarioDTO> consultaAnthony02();

}
