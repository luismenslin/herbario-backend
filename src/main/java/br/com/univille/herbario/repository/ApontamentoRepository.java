package br.com.univille.herbario.repository;

import br.com.univille.herbario.entity.Apontamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ApontamentoRepository extends JpaRepository<Apontamento, Long> {
}