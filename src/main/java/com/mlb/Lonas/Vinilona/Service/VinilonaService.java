package com.mlb.Lonas.Vinilona.Service;

import com.mlb.Lonas.Vinilona.DTO.VinilonaDTO;
import com.mlb.Lonas.Vinilona.Mapper.VinilonaMapper;
import com.mlb.Lonas.Vinilona.Model.VinilonaModel;
import com.mlb.Lonas.Vinilona.Repository.VinilonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VinilonaService {

    // Faz a ligação do Banco de Dados com o Service
    // Permite que o Service tenha acesso ao Banco de dados
    // inicializando uma nova instância
    private final VinilonaRepository vinilonaRepository;
    private final VinilonaMapper vinilonaMapper;

    public VinilonaService(VinilonaRepository vinilonaRepository, VinilonaMapper vinilonaMapper) {
        this.vinilonaRepository = vinilonaRepository;
        this.vinilonaMapper = vinilonaMapper;
    }

    // 1 Listar todas as lonas
    public List<VinilonaDTO> listar(){
         List<VinilonaModel> lonas = vinilonaRepository.findAll();

         return lonas.stream()
                 .map(vinilonaMapper::map)
                 .collect(Collectors.toList());

    }

    // 2 Listar por Comprimento e Largura
    public List<VinilonaDTO> listarCompLarg(double comprimento, double largura){
        List<VinilonaModel> lonas = vinilonaRepository.findByComprimentoAndLargura(comprimento,largura);
        return lonas.stream().map(vinilonaMapper::map).collect(Collectors.toList());
    }

    // 3 Listar por Id
    public VinilonaDTO listarId(Long id){
        Optional<VinilonaModel> lona = vinilonaRepository.findById(id);
        return lona.map(vinilonaMapper::map).orElse(null);
    }

    // 4 Adicionar uma nova lona
    public VinilonaDTO criar(VinilonaDTO lonaDTO){
        VinilonaModel lona = vinilonaMapper.map(lonaDTO);
        lona = vinilonaRepository.save(lona);
        return vinilonaMapper.map(lona);
    }

    // 5 Remover uma lona // TEM QUE SER VOID pois nao necessita de um retorno
    public void deletar(Long id){
        System.out.println("Lona deletada");
        vinilonaRepository.deleteById(id);
    }

    // 6 Alterar uma lona
    public VinilonaDTO alterar(Long id, VinilonaDTO vinilonaDTO){
        Optional<VinilonaModel> lonaExistente = vinilonaRepository.findById(id);
        if (lonaExistente.isPresent()) {
            VinilonaModel lonaAtualizada = vinilonaMapper.map(vinilonaDTO);
            lonaAtualizada.setId(id);
            VinilonaModel lonaSalva = vinilonaRepository.save(lonaAtualizada);
            return vinilonaMapper.map(lonaSalva);
        }
        return null;
    }

}
