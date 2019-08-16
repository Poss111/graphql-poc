package per.poss.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import per.poss.models.Borrower;
import per.poss.models.Mortgage;
import per.poss.repositories.BorrowerRepository;
import per.poss.repositories.MortgageRepository;

public class Query implements GraphQLQueryResolver {

    private MortgageRepository mortgageRepository;
    private BorrowerRepository borrowerRepository;

    public Query(MortgageRepository mortgageRepository, BorrowerRepository borrowerRepository) {
        this.mortgageRepository = mortgageRepository;
        this.borrowerRepository = borrowerRepository;
    }

    public Iterable<Mortgage> findAllMortgages() {
        return mortgageRepository.findAll();
    }

    public Iterable<Borrower> findAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public long countMortgages() {
        return mortgageRepository.count();
    }

    public long countBorrowers() {
        return borrowerRepository.count();
    }
}
