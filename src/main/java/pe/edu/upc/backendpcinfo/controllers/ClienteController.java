package pe.edu.upc.backendpcinfo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendpcinfo.dtos.ClienteDTO;
import pe.edu.upc.backendpcinfo.entities.Cliente;
import pe.edu.upc.backendpcinfo.services.IClienteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private IClienteService cS;
    @PostMapping
    public void insert (@RequestBody ClienteDTO dto){
        ModelMapper m = new ModelMapper();
        Cliente c = m.map(dto, Cliente.class);
        cS.insert(c);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<ClienteDTO> list()
    {
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ClienteDTO.class);
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        cS.delete(id);
    }

    @PutMapping()
    public void goUpdate(@RequestBody ClienteDTO dto){
        ModelMapper m = new ModelMapper();
        Cliente c = m.map(dto, Cliente.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public ClienteDTO listId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ClienteDTO dto = m.map(cS.listId(id), ClienteDTO.class);
        return dto;
    }

}
