package com.mlb.Lonas.Vinilona.Controller;

import com.mlb.Lonas.Vinilona.Model.VinilonaModel;
import com.mlb.Lonas.Vinilona.Service.VinilonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinilona")
public class VinilonaController {

    private VinilonaService vinilonaService;

    public VinilonaController(VinilonaService vinilonaService) {
        this.vinilonaService = vinilonaService;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste";
    }

    // Adicionar Lona
    @PostMapping("/criar")
    public String criar(){
        return "lona criada";
    }


    // Listar todas as lonas da maior para a menor
    @GetMapping("/listar")
    public List<VinilonaModel> listar(){
        return vinilonaService.listar();
    }


    // Listar lonas por comprimento x largura
    @GetMapping("/listarComp")
    public String listarCompLarg(){
        return "lona criada";
    }


    // Alterar lona por id
    @PutMapping("/alterarID")
    public String alterar(){
        return "lona alterada";
    }

    // deletar lona
    @DeleteMapping("/deletarID")
    public String deletar(){
        return "lona deletada";
    }



}
