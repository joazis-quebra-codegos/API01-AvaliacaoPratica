package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Locais", description = "Aqui é possível ver os locais para os eventos")
@RestController
@RequestMapping("/locais")
public class LocalEventoController {

}
