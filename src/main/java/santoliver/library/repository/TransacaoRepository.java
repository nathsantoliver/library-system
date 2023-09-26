package santoliver.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import santoliver.library.model.Transacao;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Integer> {

}
