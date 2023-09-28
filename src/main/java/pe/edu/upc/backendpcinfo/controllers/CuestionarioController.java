package pe.edu.upc.backendpcinfo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendpcinfo.dtos.CuestionarioDTO;
import pe.edu.upc.backendpcinfo.dtos.UsuarioCuestionarioDTO;
import pe.edu.upc.backendpcinfo.entities.Cuestionario;
import pe.edu.upc.backendpcinfo.services.ICuestionarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuestionario")
public class CuestionarioController {
    @Autowired
    private ICuestionarioService cS;
    @PostMapping
    public void insert(@RequestBody CuestionarioDTO dto){
        ModelMapper m=new ModelMapper();
        Cuestionario c=m.map(dto,Cuestionario.class);
        cS.insert(c);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<CuestionarioDTO>list(){
        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CuestionarioDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        cS.delete(id);
    }
    @GetMapping("{id}")
    public CuestionarioDTO listId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        CuestionarioDTO dto=m.map(cS.listId(id),CuestionarioDTO.class);
        return dto;
    }
    @PutMapping
    public void goUpdate(@RequestBody CuestionarioDTO dto){
        ModelMapper m=new ModelMapper();
        Cuestionario c=m.map(dto,Cuestionario.class);
        cS.insert(c);
    }



    @GetMapping("/cuestionario-count")
    public List<UsuarioCuestionarioDTO> getCuestionarioByUsuario() {
        List<UsuarioCuestionarioDTO> usuarioCuestionarioDTOs = cS.consulta04();
        return usuarioCuestionarioDTOs;
    }

    @GetMapping("/cuestionario-procesador")
    public List<UsuarioCuestionarioDTO> getCuestionario1EstadoByUsuario() {
        List<UsuarioCuestionarioDTO> UsuarioCuestionarioDTOss = cS.consulta05();
        return UsuarioCuestionarioDTOss;}

    @GetMapping("/cuestionario-procesador2")
    public List<UsuarioCuestionarioDTO> getCuestionario2EstadoByUsuario() {
        List<UsuarioCuestionarioDTO> UsuarioCuestionarioDTOs = cS.consulta06();
        return UsuarioCuestionarioDTOs;}
}
