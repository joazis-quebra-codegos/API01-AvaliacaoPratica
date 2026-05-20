package org.example.eventos.service;

import org.example.eventos.model.LocalEvento;
import org.example.eventos.repository.LocalEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalEventoService {

    @Autowired
    private LocalEventoRepository localEventoRepository;

    public LocalEvento buscarEntidade(Long id){
        return localEventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local do evento não encontrado"));
    }
}
