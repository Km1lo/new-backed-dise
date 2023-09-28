package pe.edu.upc.backendpcinfo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendpcinfo.dtos.UsuarioComentarioDTO;
import pe.edu.upc.backendpcinfo.dtos.UsuarioCuestionarioDTO;
import pe.edu.upc.backendpcinfo.dtos.UsuarioDTO;
import pe.edu.upc.backendpcinfo.entities.Usuario;
import pe.edu.upc.backendpcinfo.services.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @PostMapping
    public void insert(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.insert(u);

    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<UsuarioDTO> list(){
        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        uS.delete(id);
    }

    @GetMapping("{id}")
    public UsuarioDTO listId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsuarioDTO dto=m.map(uS.listId(id),UsuarioDTO.class);
        return dto;
    }

    @PutMapping()
    public void goUpdate(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.insert(u);
    }


    @GetMapping("/usuario-comentario-count")
    public List<UsuarioComentarioDTO> getUsuarioComentarioCount() {
        List<UsuarioComentarioDTO> usuarioComentarioDTOs = uS.consulta01();
        return usuarioComentarioDTOs;
    }


    @GetMapping("/usuario-comentario-fecha")
    public List<UsuarioComentarioDTO> getUsuarioComentarioFecha(){
        List<UsuarioComentarioDTO> usuarioComentarioDTOs = uS.consulta02();
        return usuarioComentarioDTOs;
    }


    @GetMapping("/usuario-cuestionario-count")
    public List<UsuarioCuestionarioDTO> getUsuarioCuestionarioCount(){
        List<UsuarioCuestionarioDTO> usuarioCuestionarioDTOS = uS.consultaAnthony02();
        return usuarioCuestionarioDTOS;
    }


}
