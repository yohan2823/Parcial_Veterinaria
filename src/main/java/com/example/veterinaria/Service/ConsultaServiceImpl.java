package com.example.veterinaria.Service;

import com.example.veterinaria.InterfaceService.IConsultaService;
import com.example.veterinaria.Model.Consulta;
import com.example.veterinaria.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta guardar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public void eliminar(Integer id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        return consultaRepository.findById(id).orElse(null);
    }
}

