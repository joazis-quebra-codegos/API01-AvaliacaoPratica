package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Inscrições", description = "Rotas para gerenciamento de inscrições")
@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService service;

    @Operation(summary = "Busca uma inscrição por Id")
    @GetMapping
    public InscricaoResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @Operation(summary = "Lista todas as incrições")
    @GetMapping("/{id}")
    public List<InscricaoResponseDTO> listar(){
        return service.listarTodas();
    }

    @Operation(summary = "Cadastra uma inscrição nova")
    @PostMapping
    public InscricaoResponseDTO cadastrar(@RequestBody @Valid InscricaoRequestDTO dto){
        return service.cadastrar(dto);
    }

    @Operation(summary = "Deleta uma inscrição")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}
