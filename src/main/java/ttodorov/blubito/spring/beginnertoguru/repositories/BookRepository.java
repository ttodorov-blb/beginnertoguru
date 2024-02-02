package ttodorov.blubito.spring.beginnertoguru.repositories;

import org.springframework.data.repository.CrudRepository;
import ttodorov.blubito.spring.beginnertoguru.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
