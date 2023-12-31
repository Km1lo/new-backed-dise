package pe.edu.upc.backendpcinfo.servicesimplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backendpcinfo.dtos.RecomendacionCuestionarioDTO;
import pe.edu.upc.backendpcinfo.entities.Recomendacion;
import pe.edu.upc.backendpcinfo.repositories.IRecomendacionRepository;
import pe.edu.upc.backendpcinfo.services.IRecomendacionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecomendacionServiceImplement implements IRecomendacionService {

    @Autowired
    private IRecomendacionRepository rR;
    @Override
    public void insert(Recomendacion recomendacion) {
        rR.save(recomendacion);
    }

    @Override
    public List<Recomendacion> list() {
        return rR.findAll();
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Recomendacion listId(int id) {
        return rR.findById(id).orElse(new Recomendacion());
    }

    @Override
    public List<RecomendacionCuestionarioDTO> consulta02() {
        List<String []> topProgramasUsed=rR.getRecomendacionxCuestionario();
        List<RecomendacionCuestionarioDTO> recomendacionCuestionarioDTOS=new ArrayList<>();

        for (String [] data:topProgramasUsed){
            RecomendacionCuestionarioDTO dto=new RecomendacionCuestionarioDTO();
            dto.setValoracion_user(Integer.parseInt(data[0]));
            dto.setProgramas_used(data[1]);
            recomendacionCuestionarioDTOS.add(dto);
        }
        return recomendacionCuestionarioDTOS;
    }

    @Override
    public List<RecomendacionCuestionarioDTO> consulta01() {
        List<String[]> promRecomendCuest=rR.getPromedioRecomendacion();
        List<RecomendacionCuestionarioDTO> recomendacionCuestionarioDTOS=new ArrayList<>();

        for (String[] data:promRecomendCuest)
        {
            RecomendacionCuestionarioDTO dto=new RecomendacionCuestionarioDTO();
            dto.setTipo_form(data[0]);
            dto.setPromedio_valoracion(Double.parseDouble(data[1]));
            recomendacionCuestionarioDTOS.add(dto);
        }
        return recomendacionCuestionarioDTOS;
    }
}
