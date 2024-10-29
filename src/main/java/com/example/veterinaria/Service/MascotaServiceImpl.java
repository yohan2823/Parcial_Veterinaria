package com.example.veterinaria.Service;

import com.example.veterinaria.InterfaceService.IMascotaService;
import com.example.veterinaria.Model.Mascota;
import com.example.veterinaria.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> listar() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public void eliminar(Integer id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public Mascota buscarPorId(Integer id) {
        return mascotaRepository.findById(id).orElse(null);
    }
}