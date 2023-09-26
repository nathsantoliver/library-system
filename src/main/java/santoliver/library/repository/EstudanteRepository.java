package santoliver.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import santoliver.library.model.Estudante;

@Repository
public interface EstudanteRepository extends CrudRepository<Estudante, Integer>{

}
