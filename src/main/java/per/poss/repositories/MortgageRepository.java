package per.poss.repositories;

import org.springframework.data.repository.CrudRepository;
import per.poss.models.Mortgage;

public interface MortgageRepository extends CrudRepository<Mortgage, Long> { }
