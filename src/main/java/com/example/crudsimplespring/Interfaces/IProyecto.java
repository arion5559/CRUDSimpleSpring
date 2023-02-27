package com.example.crudsimplespring.Interfaces;

import com.example.crudsimplespring.Model.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyecto extends CrudRepository<Proyecto, Integer> {
}
