package com.mlb.Lonas.Vinilona.Service;

import com.mlb.Lonas.Vinilona.Model.VinilonaModel;
import com.mlb.Lonas.Vinilona.Repository.VinilonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VinilonaService {

    // Faz a ligação do Banco de Dados com o Service
    // Permite que o Service tenha acesso ao Banco de dados
    // inicializando uma nova instância
    private VinilonaRepository vinilonaRepository;

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


}
