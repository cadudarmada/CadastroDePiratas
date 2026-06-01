package dev.cadudarmada.CadastroDePiratas.Missoes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    // Criar missão
    @PostMapping
    public ResponseEntity<MissaoModel> criar(@RequestBody MissaoModel missao) {
        return ResponseEntity.ok(missaoService.criarMissao(missao));
    }

    // Listar todas
    @GetMapping
    public ResponseEntity<List<MissaoModel>> listar() {
        return ResponseEntity.ok(missaoService.listarTodas());
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<MissaoModel> buscar(@PathVariable Long id) {
        return missaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}