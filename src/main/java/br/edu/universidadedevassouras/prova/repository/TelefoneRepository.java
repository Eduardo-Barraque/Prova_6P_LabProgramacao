package br.edu.universidadedevassouras.prova.repository;

import br.edu.universidadedevassouras.prova.model.Pessoa;
import br.edu.universidadedevassouras.prova.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
