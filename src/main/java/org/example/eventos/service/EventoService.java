package org.example.eventos.service;

import org.example.eventos.dto.EventoRequestDTO;
import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.example.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private LocalEventoService localEventoService;

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

    public EventoResponseDTO cadastrar(EventoRequestDTO dto){
        Evento evento = toEntity(dto);

        Evento salva = eventoRepository.save(evento);

        return toResponse(salva);
    }

    public void deletar(Long id){
        eventoRepository.deleteById(id);
    }

    public EventoResponseDTO atualizar(Long id, EventoRequestDTO dto){
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não foi encontrado"));

        LocalEvento localEvento = localEventoService.buscarEntidade(dto.localId());

        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());
        evento.setValorIngresso(dto.valorIngresso());
        evento.setLocalEvento(localEvento);

        return toResponse(evento);

    }

    public Evento buscarEntidade(Long id){
        return eventoRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }

    private Evento toEntity(EventoRequestDTO dto){
        LocalEvento localEvento = localEventoService.buscarEntidade(dto.localId());
        Evento evento = new Evento();
        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());
        evento.setValorIngresso(dto.valorIngresso());
        evento.setLocalEvento(localEvento);

        return evento;
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
