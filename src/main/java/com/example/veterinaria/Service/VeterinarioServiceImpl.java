package com.example.veterinaria.Service;

import com.example.veterinaria.InterfaceService.IVeterinarioService;
import com.example.veterinaria.Model.Veterinario;
import com.example.veterinaria.Repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioServiceImpl implements IVeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Override
    public List<Veterinario> listar() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public void eliminar(Integer id) {
        veterinarioRepository.deleteById(id);
    }

    @Override
    public Veterinario buscarPorId(Integer id) {
        return veterinarioRepository.findById(id).orElse(null);
    }
}
