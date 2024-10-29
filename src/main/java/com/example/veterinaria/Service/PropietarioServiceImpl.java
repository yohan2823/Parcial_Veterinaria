package com.example.veterinaria.Service;

import com.example.veterinaria.InterfaceService.IPropietarioService;
import com.example.veterinaria.Model.Propietario;
import com.example.veterinaria.Repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements IPropietarioService {
    @Autowired
    private PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> listar() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public void eliminar(Integer id) {
        propietarioRepository.deleteById(id);
    }

    @Override
    public Propietario buscarPorId(Integer id) {
        return propietarioRepository.findById(id).orElse(null);
    }
}