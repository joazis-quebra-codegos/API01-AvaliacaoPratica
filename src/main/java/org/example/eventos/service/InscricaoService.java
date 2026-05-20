package org.example.eventos.service;

import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.exception.RecursoNaoEncontradoException;
import org.example.eventos.model.Evento;
import org.example.eventos.model.Inscricao;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private EventoService eventoService;

    public List<InscricaoResponseDTO> listarTodas() {
        return inscricaoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public InscricaoResponseDTO buscarPorId(Long id) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Inscrição não encontrada"));

        return toResponse(inscricao);
    }

    public InscricaoResponseDTO cadastrar(InscricaoRequestDTO dto) {
        //Buscar evento aqui não é mais necessário devido ao toEntity(), mesmo para as outras classes
        Inscricao inscricao = toEntity(dto);

        Inscricao salva = inscricaoRepository.save(inscricao);

        return toResponse(salva);
    }

    public void deletar(Long id) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));

        inscricaoRepository.deleteById(id);
    }

    public List<InscricaoResponseDTO> listarPorEvento(Long idEvento) {
        return inscricaoRepository.findByEventoId(idEvento)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private Inscricao toEntity(InscricaoRequestDTO dto){
        Evento evento = eventoService.buscarEntidade(dto.idEvento());
        Inscricao inscricao = new Inscricao();
        inscricao.setNomeParticipante(dto.nome());
        inscricao.setEmailParticipante(dto.email());
        inscricao.setStatus(dto.status());
        inscricao.setEvento(evento);

        return inscricao;
    }

    private InscricaoResponseDTO toResponse(Inscricao inscricao) {
        return new InscricaoResponseDTO(
                inscricao.getId(),
                inscricao.getNomeParticipante(),
                inscricao.getEmailParticipante(),
                inscricao.getStatus(),
                inscricao.getEvento().getId(),
                inscricao.getEvento().getNome()
        );
    }
}