package per.poss.repositories;

import org.springframework.data.repository.CrudRepository;
import per.poss.models.Borrower;

public interface BorrowerRepository extends CrudRepository<Borrower, Long> { }
