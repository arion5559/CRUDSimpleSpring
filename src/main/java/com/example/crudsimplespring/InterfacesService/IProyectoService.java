package com.example.crudsimplespring.InterfacesService;

import com.example.crudsimplespring.Model.Proyecto;

import java.util.List;
import java.util.Optional;

public interface IProyectoService {
    public List<Proyecto> listar();
    public Optional<Proyecto> listarId(int id);
    public int save(Proyecto p);
    public void delete(int id);
}
