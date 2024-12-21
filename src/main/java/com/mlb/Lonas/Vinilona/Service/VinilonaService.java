package com.mlb.Lonas.Vinilona.Service;

import com.mlb.Lonas.Vinilona.Model.VinilonaModel;
import com.mlb.Lonas.Vinilona.Repository.VinilonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VinilonaService {

    // Faz a ligação do Banco de Dados com o Service
    // Permite que o Service tenha acesso ao Banco de dados
    // inicializando uma nova instância
    private final VinilonaRepository vinilonaRepository;

    public VinilonaService(VinilonaRepository vinilonaRepository) {
        this.vinilonaRepository = vinilonaRepository;
    }

    // 1 Listar todas as lonas
    public List<VinilonaModel> listar(){
         return vinilonaRepository.findAll();
    }

    // 2 Listar por Comprimento e Largura
    public List<VinilonaModel> listarCompLarg(double comprimento, double largura){
        return vinilonaRepository.findByComprimentoAndLargura(comprimento,largura);
    }

    // 3 Adicionar uma nova lona
    public VinilonaModel criar(VinilonaModel lona){
        return vinilonaRepository.save(lona);
    }

    // 4 Remover uma lona // TEM QUE SER VOID pois nao necessita de um retorno
    public void deletar(Long id){
        System.out.println("Lona deletada");
        vinilonaRepository.deleteById(id);
    }

}
