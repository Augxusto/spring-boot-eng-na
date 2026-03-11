package com.rdg.school.services;

import com.rdg.school.models.AlunoModel;
import com.rdg.school.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoModel criarAluno(AlunoModel alunoModel){
        return  alunoRepository.save(alunoModel);
    }

    public List<AlunoModel> buscarTodosAlunos(){
        return  alunoRepository.findAll();
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }

    public void deletar(Long id) {
    }

    public AlunoModel atualizar(Long id, AlunoModel alunoModel){
        AlunoModel aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(alunoModel.getNome());
        aluno.setEmail(alunoModel.getEmail());

        return alunoRepository.save(aluno);
    }

}
