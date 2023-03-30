package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                              String dataDeNascimento ){
        return service.getAll(dataDeNascimento);
    }

    @GetMapping("/pelo-id")
    public Aluno get(@RequestParam(value = "id")Long id){
        return service.get(id);
    }

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable("id") Long id){
        return service.getAllAvaliacaoFisica(id);
    }

    @DeleteMapping
    public void deleteAluno(@RequestParam(value = "id") Long id){
        service.delete(id);
    }

    /*
    @PutMapping
    public Aluno update(@Valid @RequestBody Long id, AlunoUpdateForm form){
        return service.update(id, form);
    }*/

}
