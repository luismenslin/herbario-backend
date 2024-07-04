package br.com.univille.herbario.service;

import br.com.univille.herbario.entity.Apontamento;

import java.time.LocalDate;
import java.util.List;


public interface ApontamentoService {
    void save(Apontamento apontamento);
    List<Apontamento> getByDate(LocalDate date);
}
