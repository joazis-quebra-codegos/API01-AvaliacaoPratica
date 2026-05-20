package org.example.eventos.service;

import org.example.eventos.dto.LocalEventoRequestDTO;
import org.example.eventos.dto.LocalEventoResponseDTO;
import org.example.eventos.model.LocalEvento;
import org.example.eventos.repository.LocalEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalEventoService {

    @Autowired
    private LocalEventoRepository localEventoRepository;

    public LocalEventoResponseDTO buscarPorId(Long id) {
        return toResponse(localEventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local do evento não encontrado")));
    }

    public List<LocalEventoResponseDTO> listar(){
        return localEventoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public LocalEventoResponseDTO cadastrar(LocalEventoRequestDTO dto){
        LocalEvento localEvento = toEntity(dto);

        LocalEvento salva = localEventoRepository.save(localEvento);

        return toResponse(salva);
    }

    public void deletar(Long id){
        localEventoRepository.deleteById(id);
    }

    public LocalEventoResponseDTO atualizar(Long id, LocalEventoRequestDTO dto){
        LocalEvento localEvento = localEventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local do evento não encontrado"));

        localEvento.setNome(dto.nome());
        localEvento.setEndereco(dto.endereco());
        localEvento.setCapacidade(dto.capacidade());

        return toResponse(localEvento);
    }

    public LocalEvento buscarEntidade(Long id){
        return localEventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local do evento não encontrado"));
    }

    private LocalEvento toEntity(LocalEventoRequestDTO dto){
        LocalEvento localEvento = new LocalEvento();

        localEvento.setNome(dto.nome());
        localEvento.setEndereco(dto.endereco());
        localEvento.setCapacidade(dto.capacidade());

        return localEvento;
    }

    private LocalEventoResponseDTO toResponse(LocalEvento localEvento){
        return new LocalEventoResponseDTO(
                localEvento.getId(),
                localEvento.getNome(),
                localEvento.getEndereco(),
                localEvento.getCapacidade()
        );
    }
}
