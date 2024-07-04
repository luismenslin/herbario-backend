package br.com.univille.herbario.service.impl;

import br.com.univille.herbario.entity.Apontamento;
import br.com.univille.herbario.repository.ApontamentoRepository;
import br.com.univille.herbario.service.ApontamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApontamentoServiceImpl implements ApontamentoService {

    @Autowired
    private ApontamentoRepository repository;

    @Override
    public void save(Apontamento apontamento) {
        repository.save(apontamento);
    }

    public List<Apontamento> getByDate(LocalDate date) {
        List<Apontamento> apontamentos = repository.findAll();
        List<Apontamento> apontamentosFiltrados = apontamentos.stream()
                .filter(apontamento -> apontamento.getDataCadastro().toLocalDate().isEqual(date))
                .collect(Collectors.toList());
        return apontamentosFiltrados;
    }

}