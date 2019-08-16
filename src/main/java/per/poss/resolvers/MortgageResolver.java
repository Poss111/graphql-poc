package per.poss.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import per.poss.models.Borrower;
import per.poss.models.Mortgage;
import per.poss.repositories.BorrowerRepository;

public class MortgageResolver implements GraphQLResolver<Mortgage> {

    private BorrowerRepository borrowerRepository;

    public MortgageResolver(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public Borrower getBorrower(Mortgage mortgage) {
        return borrowerRepository.findById(mortgage.getBorrower().getId()).get();
    }
}
