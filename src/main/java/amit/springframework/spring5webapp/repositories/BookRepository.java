package amit.springframework.spring5webapp.repositories;

import amit.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * created by KUAM on 4/11/2020
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
