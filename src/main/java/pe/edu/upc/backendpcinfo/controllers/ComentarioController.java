package pe.edu.upc.backendpcinfo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendpcinfo.dtos.ComentarioDTO;
import pe.edu.upc.backendpcinfo.entities.Comentario;
import pe.edu.upc.backendpcinfo.services.IComentarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private IComentarioService cmS;

    //POST porque es para insertar
    @PostMapping
    public void insert(@RequestBody ComentarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Comentario c = m.map(dto, Comentario.class);
        cmS.insert(c);
    }

    //GET porque es para listar
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<ComentarioDTO> list() {
        return cmS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }

    //DELETE porque es para eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){    //habra una variable que queremos incluir
        cmS.delete(id);
    }

    //GET porque es para listar por id
    @GetMapping("/{id}")
    public ComentarioDTO listId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ComentarioDTO dto=m.map(cmS.listId(id),ComentarioDTO.class);
        return dto;
    }

    //PUT porque es para actualizar
    @PutMapping()
    public void goUpdate(@RequestBody ComentarioDTO dto){
        ModelMapper m = new ModelMapper();
        Comentario c = m.map(dto, Comentario.class);
        cmS.insert(c);
    }
}
