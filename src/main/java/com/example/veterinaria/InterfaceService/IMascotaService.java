package com.example.veterinaria.InterfaceService;

import com.example.veterinaria.Model.Mascota;

import java.util.List;

public interface IMascotaService {
    List<Mascota> listar();
    Mascota guardar(Mascota mascota);
    void eliminar(Integer id);
    Mascota buscarPorId(Integer id);
}