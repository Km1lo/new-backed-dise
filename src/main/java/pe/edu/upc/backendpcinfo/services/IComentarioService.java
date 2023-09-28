package pe.edu.upc.backendpcinfo.services;

import pe.edu.upc.backendpcinfo.entities.Comentario;

import java.util.List;

public interface IComentarioService {


    public void insert(Comentario comentario);

    List<Comentario> list();

    public void delete(int idComentario);

    public Comentario listId(int idComentario);



}
