package com.example.crudsimplespring.Controller;

import com.example.crudsimplespring.InterfacesService.IProyectoService;
import com.example.crudsimplespring.Model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IProyectoService service;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Proyecto> proyectos = service.listar();
        model.addAttribute("proyectos", proyectos);
        return "index";
    }

    @GetMapping("/nuevo")
    public String agregar(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "agregar";
    }

    @PostMapping("/guardar")
    public String guardar(@Validated Proyecto p, Model model) {
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Proyecto> proyecto = service.listarId(id);
        model.addAttribute("proyecto", proyecto);
        return "editar";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id) {
        service.delete(id);
        return "redirect:/listar";
    }
}
