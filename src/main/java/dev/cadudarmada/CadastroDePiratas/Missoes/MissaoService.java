package dev.cadudarmada.CadastroDePiratas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    // Criar missão
    public MissaoModel criarMissao(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    // Buscar por id
    public Optional<MissaoModel> buscarPorId(Long id) {
        return missaoRepository.findById(id);
    }

    // Listar todas as missões
    public List<MissaoModel> listarTodas() {
        return missaoRepository.findAll();
    }

    // Deletar missão
    public void deletarPorId(Long id) {
        missaoRepository.deleteById(id);
    }
}
