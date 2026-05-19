package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Inscrições", description = "Aqui é onde vê as inscrições")
@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService service;

    @GetMapping
    public InscricaoResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping("/{id}")
    public List<InscricaoResponseDTO> listar(){
        return service.listarTodas();
    }

    @PostMapping
    public InscricaoResponseDTO cadastrar(@RequestBody @Valid InscricaoRequestDTO dto){
        return service.cadastrar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public InscricaoResponseDTO atualizar(@RequestBody @Valid InscricaoRequestDTO dto, @PathVariable Long id){
        return service.atualizar(id, dto);
    }

}
