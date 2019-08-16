package per.poss.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import per.poss.exceptions.MortgageNotFoundException;
import per.poss.models.Borrower;
import per.poss.models.Mortgage;
import per.poss.repositories.BorrowerRepository;
import per.poss.repositories.MortgageRepository;

public class Mutation implements GraphQLMutationResolver {

    private MortgageRepository mortgageRepository;
    private BorrowerRepository borrowerRepository;

    public Mutation(MortgageRepository mortgageRepository, BorrowerRepository borrowerRepository) {
        this.mortgageRepository = mortgageRepository;
        this.borrowerRepository = borrowerRepository;
    }

    public Borrower newBorrower(String name) {
        Borrower borrower = new Borrower();
        borrower.setName(name);

        borrowerRepository.save(borrower);
        return borrower;
    }

    public Mortgage newMortgage(String type, Long borrower) {
        Mortgage mortgage = new Mortgage();
        mortgage.setBorrower(new Borrower(borrower));
        mortgage.setType(type);

        mortgageRepository.save(mortgage);

        return mortgage;
    }

    public boolean deleteMortgage(Long id) {
        mortgageRepository.delete(new Mortgage(id));
        return true;
    }

    public Mortgage updateMortgage(String type, Long id) {
        Mortgage mortgage = mortgageRepository.findById(id).get();
        if (mortgage == null) {
            throw new MortgageNotFoundException("The mortgage Id does not exists!", id);
        }
        mortgage.setType(type);

        mortgageRepository.save(mortgage);

        return mortgage;
    }

}
