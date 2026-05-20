package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.eventos.dto.EventoRequestDTO;
import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.service.EventoService;
import org.example.eventos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Eventos", description = "Rotas para gerenciamento de eventos")
@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @Autowired
    private InscricaoService inscricaoService;

    @Operation(summary = "Lista todos os eventos")
    @GetMapping
    public List<EventoResponseDTO> listar() {
        return service.listar();
    }

    @Operation(summary = "Busca um evento por id")
    @GetMapping("/{id}")
    public EventoResponseDTO buscarPorId(@PathVariable Long idEvento) {
        return service.buscarPorId(idEvento);
    }

    @Operation(summary = "Cadastra um novo evento")
    @PostMapping
    public EventoResponseDTO cadastrar(@RequestBody @Valid EventoRequestDTO dto) {
        return service.cadastrar(dto);
    }

    @Operation(summary = "Atualiza um evento existente")
    @PutMapping("/{id}")
    public EventoResponseDTO atualizar(@PathVariable Long idEvento, @RequestBody @Valid EventoRequestDTO dto) {
        return service.atualizar(idEvento, dto);
    }

    @Operation(summary = "Remove um evento")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long idEvento) {
        service.deletar(idEvento);
    }

    @Operation(summary = "Filtra eventos pelo nome")
    @GetMapping("/nomes")
    public List<EventoResponseDTO> listarPorNome(@RequestParam String nome) {
        //TODO: ajustar o mapeamento
        return service.listarPorNome(nome);
    }

    @Operation(summary = "Lista todas as incrições de um evento")
    @GetMapping("/inscricoes/{id}")
    public List<InscricaoResponseDTO> listarIncricoesPorEvento(@PathVariable Long id) {
        return inscricaoService.listarPorEvento(id);
    }

    @Operation(summary = "Lista eventos de um determinado local")
    @GetMapping("/local/{id}")
    public List<EventoResponseDTO> listarPorLocal(@PathVariable Long idLocal) {
        //TODO: revisar para garantir que recebe o id para buscar
        return service.listarPorLocal(idLocal);
    }
}
