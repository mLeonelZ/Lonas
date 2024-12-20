package com.mlb.Lonas.Vinilona.Service;

import com.mlb.Lonas.Vinilona.Model.VinilonaModel;
import com.mlb.Lonas.Vinilona.Repository.VinilonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinilonaService {

    // Faz a ligação do Banco de Dados com o Service
    // Permite que o Service tenha acesso ao Banco de dados
    // inicializando uma nova instância
    private VinilonaRepository vinilonaRepository;

    public VinilonaService(VinilonaRepository vinilonaRepository) {
        this.vinilonaRepository = vinilonaRepository;
    }

    // Listar todas as lonas
    public List<VinilonaModel> listar(){
         return vinilonaRepository.findAll();
    }


}
