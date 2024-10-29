package com.example.veterinaria.InterfaceService;
import com.example.veterinaria.Model.Propietario;
import java.util.List;

public interface IPropietarioService {
    List<Propietario> listar();
    Propietario guardar(Propietario propietario);
    void eliminar(Integer id);
    Propietario buscarPorId(Integer id);
}