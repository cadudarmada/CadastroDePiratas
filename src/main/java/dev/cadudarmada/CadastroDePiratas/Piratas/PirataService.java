package dev.cadudarmada.CadastroDePiratas.Piratas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PirataService {

    private final PirataRepository pirataRepository;

    public PirataService(PirataRepository pirataRepository) {
        this.pirataRepository = pirataRepository;
    }

    // Criar pirata
    public PirataModel criarPirata(PirataModel pirata) {
        return pirataRepository.save(pirata);
    }

    // Buscar por id
    public Optional<PirataModel> buscarPorId(Long id) {
        return pirataRepository.findById(id);
    }

    // Listar todos
    public List<PirataModel> listarTodos() {
        return pirataRepository.findAll();
    }

    // Deletar
    public void deletarPorId(Long id) {
        pirataRepository.deleteById(id);
    }
}