package com.example.veterinaria.Controller;

import com.example.veterinaria.InterfaceService.IMascotaService;
import com.example.veterinaria.InterfaceService.IPropietarioService;
import com.example.veterinaria.Model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @Autowired
    private IPropietarioService propietarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("mascotas", mascotaService.listar());
        return "mascotas";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nueva Mascota");
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("propietarios", propietarioService.listar()); // Asegúrate de incluir propietarios
        return "formMascota";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Mascota mascota) {
        mascotaService.guardar(mascota);
        return "redirect:/mascotas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Mascota mascota = mascotaService.buscarPorId(id);
        model.addAttribute("mascota", mascota);
        model.addAttribute("propietarios", propietarioService.listar()); // Asegúrate de incluir propietarios
        return "formMascota";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        mascotaService.eliminar(id);
        return "redirect:/mascotas/listar";
    }
}
