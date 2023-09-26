package santoliver.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import santoliver.library.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer>{

}
