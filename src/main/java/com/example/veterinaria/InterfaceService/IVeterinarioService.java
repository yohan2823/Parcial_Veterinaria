package com.example.veterinaria.InterfaceService;

import com.example.veterinaria.Model.Veterinario;

import java.util.List;

public interface IVeterinarioService {
    List<Veterinario> listar();
    Veterinario guardar(Veterinario veterinario);
    void eliminar(Integer id);
    Veterinario buscarPorId(Integer id);
}
