package per.poss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import per.poss.repositories.BorrowerRepository;
import per.poss.repositories.MortgageRepository;
import per.poss.resolvers.MortgageResolver;
import per.poss.resolvers.Mutation;
import per.poss.resolvers.Query;

@SpringBootApplication
public class Driver {

    public static void main(String... args) {
        SpringApplication.run(Driver.class, args);
    }

    @Bean
    public MortgageResolver mortgageResolver(BorrowerRepository borrowerRepository) {
        return new MortgageResolver(borrowerRepository);
    }

    @Bean
    public Query query(BorrowerRepository borrowerRepository, MortgageRepository mortgageRepository) {
        return new Query(mortgageRepository, borrowerRepository);
    }

    @Bean
    public Mutation mutation(BorrowerRepository borrowerRepository, MortgageRepository mortgageRepository) {
        return new Mutation(mortgageRepository, borrowerRepository);
    }
}
