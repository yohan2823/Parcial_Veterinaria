package com.example.veterinaria.Controller;

import com.example.veterinaria.InterfaceService.IConsultaService;
import com.example.veterinaria.InterfaceService.IMascotaService;
import com.example.veterinaria.InterfaceService.IVeterinarioService;
import com.example.veterinaria.Model.Consulta;
import com.example.veterinaria.Model.Mascota;
import com.example.veterinaria.Model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService consultaService;

    @Autowired
    private IMascotaService mascotaService;

    @Autowired
    private IVeterinarioService veterinarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("consultas", consultaService.listar());
        return "consultas";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nueva Consulta");
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("mascotas", mascotaService.listar());      // Agregar lista de mascotas
        model.addAttribute("veterinarios", veterinarioService.listar()); // Agregar lista de veterinarios
        return "formConsulta";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Consulta consulta) {
        // Recuperar el objeto Mascota por ID
        Mascota mascota = mascotaService.buscarPorId(consulta.getMascota().getId());
        consulta.setMascota(mascota);

        // Recuperar el objeto Veterinario por ID
        Veterinario veterinario = veterinarioService.buscarPorId(consulta.getVeterinario().getId());
        consulta.setVeterinario(veterinario);

        // Guardar la consulta con los objetos completos de Mascota y Veterinario
        consultaService.guardar(consulta);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Consulta consulta = consultaService.buscarPorId(id);
        model.addAttribute("consulta", consulta);
        model.addAttribute("mascotas", mascotaService.listar());       // Agregar lista de mascotas
        model.addAttribute("veterinarios", veterinarioService.listar()); // Agregar lista de veterinarios
        return "formConsulta";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        consultaService.eliminar(id);
        return "redirect:/consultas/listar";
    }
}
