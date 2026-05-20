package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.logging.log4j.message.ReusableMessage;
import org.example.eventos.dto.LocalEventoRequestDTO;
import org.example.eventos.dto.LocalEventoResponseDTO;
import org.example.eventos.service.LocalEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Locais", description = "Rota para gerenciamento dos locais dos eventos")
@RestController
@RequestMapping("/locais")
public class LocalEventoController {

    @Autowired
    private LocalEventoService localEventoService;

    @GetMapping("/{id}")
    public LocalEventoResponseDTO buscarPorId(@PathVariable Long id){
        return localEventoService.buscarPorId(id);
    }

    @GetMapping
    public List<LocalEventoResponseDTO> listar(){
        return localEventoService.listar();
    }

    @PostMapping
    public LocalEventoResponseDTO cadastrar(@RequestBody @Valid LocalEventoRequestDTO dto){
        return localEventoService.cadastrar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        localEventoService.deletar(id);
    }

    @PutMapping("/{id}")
    public LocalEventoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid LocalEventoRequestDTO dto){
        return localEventoService.atualizar(id, dto);
    }
}
