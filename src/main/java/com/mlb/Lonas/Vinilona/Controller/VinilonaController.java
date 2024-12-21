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
    public VinilonaModel criar(@RequestBody VinilonaModel vinilonaModel){
        System.out.println("\n LONA CRIADA COM SUCESSO! \n");
        return vinilonaService.criar(vinilonaModel);
    }


    // Listar todas as lonas da maior para a menor
    @GetMapping("/listar")
    public List<VinilonaModel> listar(){
        return vinilonaService.listar();
    }


    // Listar lonas por comprimento x largura
    @GetMapping("/listar/{comprimento}/{largura}")
    public List<VinilonaModel> listarCompLarg(@PathVariable double comprimento,@PathVariable double largura){
        return vinilonaService.listarCompLarg(comprimento,largura);
    }


    // Alterar lona por id
    @PutMapping("/alterar/{id}")
    public VinilonaModel alterar(@PathVariable Long id, @RequestBody VinilonaModel lonaAtualizada){
        return vinilonaService.alterar(id, lonaAtualizada);
    }

    // deletar lona
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        vinilonaService.deletar(id);
    }



}
