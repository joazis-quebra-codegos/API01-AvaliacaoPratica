package org.example.eventos.service;

import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.model.Evento;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.repository.LocalEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private LocalEventoRepository localEventoRepository;

    public EventoResponseDTO buscarPorId(Long id){
        return toResponse(eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado")));
    };

    public List<EventoResponseDTO> listar(){
        return eventoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private EventoResponseDTO toResponse(Evento evento){
        return new EventoResponseDTO(
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getDataEvento(),
                evento.getValorIngresso(),
                evento.getLocalEvento().getId(),
                evento.getLocalEvento().getNome(),
                evento.getLocalEvento().getEndereco()
        );
    }
}
