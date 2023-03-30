package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaServiceImpl matriculaService;

    @PostMapping
    public Matricula createMatricula(@Valid @RequestBody MatriculaForm form){
        return matriculaService.create(form);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return matriculaService.getAll(bairro);
    }

    @GetMapping("/pelo-id")
    public Matricula getMatricula(@RequestParam(value = "id") Long id){
        return matriculaService.get(id);
    }

    @DeleteMapping
    public void deleteMatricula(@RequestParam(value = "id") Long id){
        matriculaService.delete(id);
    }
}
