package br.com.univille.herbario.controller;

import br.com.univille.herbario.entity.Apontamento;
import br.com.univille.herbario.service.ApontamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/apontamentos")
public class ApontamentoController {

    @Autowired
    private ApontamentoService service;

    @PostMapping
    public void save(@RequestBody Apontamento apontamento) {
        service.save(apontamento);
    }

    @GetMapping("/bydate")
    public List<Apontamento> getByDate(@RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        return service.getByDate(localDate);
    }
}