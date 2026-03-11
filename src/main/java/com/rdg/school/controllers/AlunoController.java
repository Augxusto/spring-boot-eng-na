package com.rdg.school.controllers;

import com.rdg.school.models.AlunoModel;
import com.rdg.school.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/alunos")


public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoModel> buscarTodosAlunos(){
        return  alunoService.buscarTodosAlunos();
    }

    //@GetMapping
    //public ResponseEntity<List<AlunoModel>> findAll{
    //    List<AlunoModel> request = alunoService.findAll();
    //    return ResponseEntity.ok().body(request);
    //}

    @PostMapping
    public ResponseEntity<AlunoModel> criarAluno(@RequestBody AlunoModel alunoModel){

        AlunoModel request = alunoService.criarAluno(alunoModel);
    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(alunoModel.getId())
            .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> gdeletar(@PathVariable Long id){
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoModel> atualizar(@PathVariable Long id, @RequestBody AlunoModel alunoModel){
        AlunoModel model = alunoService.atualizar(id, alunoModel);
        return ResponseEntity.ok(model);
    }

}
