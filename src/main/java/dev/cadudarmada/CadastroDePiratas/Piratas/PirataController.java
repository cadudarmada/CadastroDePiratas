package dev.cadudarmada.CadastroDePiratas.Piratas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piratas")
public class PirataController {

    private final PirataService pirataService;

    public PirataController(PirataService pirataService) {
        this.pirataService = pirataService;
    }

    // Criar pirata
    @PostMapping
    public ResponseEntity<PirataModel> criar(@RequestBody PirataModel pirata) {
        PirataModel salvo = pirataService.criarPirata(pirata);
        return ResponseEntity.ok(salvo);
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<PirataModel> buscarPorId(@PathVariable Long id) {
        return pirataService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<PirataModel>> listarTodos() {
        return ResponseEntity.ok(pirataService.listarTodos());
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pirataService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}