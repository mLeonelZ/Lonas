package com.mlb.Lonas.Vinilona.Controller;

import com.mlb.Lonas.Vinilona.DTO.VinilonaDTO;
import com.mlb.Lonas.Vinilona.Model.VinilonaModel;
import com.mlb.Lonas.Vinilona.Service.VinilonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinilona")
public class VinilonaController {

    private final VinilonaService vinilonaService;

    public VinilonaController(VinilonaService vinilonaService) {
        this.vinilonaService = vinilonaService;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste";
    }

    // Adicionar Lona
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody VinilonaDTO vinilona){
        System.out.println("\n LONA CRIADA COM SUCESSO! \n");
        VinilonaDTO vinilonaDTO = vinilonaService.criar(vinilona);
        return ResponseEntity.status(HttpStatus.CREATED).body("LONA CRIADA COM SUCESSO!:\n" +  vinilonaDTO);
    }


    // Listar todas as lonas da maior para a menor
    @GetMapping("/listar")
    public ResponseEntity<List<VinilonaDTO>> listar(){
        return ResponseEntity.ok(vinilonaService.listar());
    }

    // Listar por ID
    @GetMapping("listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable long id){
        if(vinilonaService.listarId(id) != null){
            return ResponseEntity.status(HttpStatus.FOUND).body(vinilonaService.listarId(id));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lona não encontrada!");
        }
    }

    // Listar lonas por comprimento x largura
    @GetMapping("/listar/{comprimento}/{largura}")
    public ResponseEntity<?> listarCompLarg(@PathVariable double comprimento,@PathVariable double largura){
        List<VinilonaDTO> lista = vinilonaService.listarCompLarg(comprimento, largura);
        if(lista != null && !lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(vinilonaService.listarCompLarg(comprimento,largura));
        }
        else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma lona: " + comprimento + " x " + largura);
        }
    }

    // Alterar lona por id
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody VinilonaDTO lonaAtualizada){
        VinilonaDTO lona = vinilonaService.listarId(id);
        if(lona != null){
            vinilonaService.alterar(id,lonaAtualizada);
            return ResponseEntity.ok("Lona antiga:\n" + lona + "\n\nLona nova:\n" + lonaAtualizada);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lona com id: " + id +" não encontrada!");
        }
    }

    // deletar lona
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        if(vinilonaService.listarId(id) != null){
            vinilonaService.deletar(id);
            return ResponseEntity.ok("Lona apagada com sucesso!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa lona não foi encontrada!");
        }
    }



}
