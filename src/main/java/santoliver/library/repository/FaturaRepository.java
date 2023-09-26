package santoliver.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import santoliver.library.model.Fatura;

@Repository
public interface FaturaRepository extends CrudRepository<Fatura, Integer> {

}
