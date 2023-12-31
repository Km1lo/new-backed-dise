package pe.edu.upc.backendpcinfo.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendpcinfo.dtos.RecomendacionCuestionarioDTO;
import pe.edu.upc.backendpcinfo.dtos.RecomendacionDTO;
import pe.edu.upc.backendpcinfo.entities.Recomendacion;
import pe.edu.upc.backendpcinfo.services.IRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendacion")
public class RecomendacionController {

    @Autowired
    private IRecomendacionService rS;


    @PostMapping
    public void insert(@RequestBody RecomendacionDTO dto){
        ModelMapper m=new ModelMapper();
        Recomendacion c=m.map(dto,Recomendacion.class);
        rS.insert(c);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<RecomendacionDTO> list(){
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        rS.delete(id);
    }
    @GetMapping("{id}")
    public RecomendacionDTO listId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        RecomendacionDTO dto=m.map(rS.listId(id),RecomendacionDTO.class);
        return dto;
    }
    @PutMapping
    public void goUpdate(@RequestBody RecomendacionDTO dto){
        ModelMapper m=new ModelMapper();
        Recomendacion c=m.map(dto,Recomendacion.class);
        rS.insert(c);
    }

    @GetMapping("/recomendacion-cuestionario-list")
    public List<RecomendacionCuestionarioDTO> getRecomendacionCuestionario(){
        List<RecomendacionCuestionarioDTO> recomendacionCuestionarioDTOS=rS.consulta02();
        return recomendacionCuestionarioDTOS;
    }

    @GetMapping("/recomendacion-promedio-list")
    public List<RecomendacionCuestionarioDTO> getPromedioRecomendacion(){
        List<RecomendacionCuestionarioDTO> recomendacionCuestionarioDTOS=rS.consulta01();
        return recomendacionCuestionarioDTOS;
    }
}
