package ttodorov.blubito.spring.beginnertoguru.repositories;

import org.springframework.data.repository.CrudRepository;
import ttodorov.blubito.spring.beginnertoguru.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
