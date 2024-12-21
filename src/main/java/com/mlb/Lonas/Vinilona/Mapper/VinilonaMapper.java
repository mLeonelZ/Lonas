package com.mlb.Lonas.Vinilona.Mapper;

import com.mlb.Lonas.Vinilona.DTO.VinilonaDTO;
import com.mlb.Lonas.Vinilona.Model.VinilonaModel;
import org.springframework.stereotype.Component;

@Component
public class VinilonaMapper {

    public VinilonaModel map(VinilonaDTO vinilonaDTO){

        VinilonaModel vinilonaModel = new VinilonaModel();

        vinilonaModel.setId(vinilonaDTO.getId());
        vinilonaModel.setCor(vinilonaDTO.getCor());
        vinilonaModel.setComprimento(vinilonaDTO.getComprimento());
        vinilonaModel.setLargura(vinilonaDTO.getLargura());
        vinilonaModel.setPedido(vinilonaDTO.getPedido());

        return vinilonaModel;
    }

    public VinilonaDTO map(VinilonaModel vinilonaModel){

        VinilonaDTO vinilonaDTO = new VinilonaDTO();

        vinilonaDTO.setId(vinilonaModel.getId());
        vinilonaDTO.setCor(vinilonaModel.getCor());
        vinilonaDTO.setComprimento(vinilonaModel.getComprimento());
        vinilonaDTO.setLargura(vinilonaModel.getLargura());
        vinilonaDTO.setPedido(vinilonaModel.getPedido());

        return vinilonaDTO;
    }



}
