package com.example.crudsimplespring.Service;

import com.example.crudsimplespring.Interfaces.IProyecto;
import com.example.crudsimplespring.InterfacesService.IProyectoService;
import com.example.crudsimplespring.Model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService implements IProyectoService {
    @Autowired
    private IProyecto data;

    @Override
    public List<Proyecto> listar() {
        return (List<Proyecto>) data.findAll();
    }

    @Override
    public Optional<Proyecto> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Proyecto p) {
        int res = 0;
        Proyecto proyecto = data.save(p);
        if (!proyecto.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
