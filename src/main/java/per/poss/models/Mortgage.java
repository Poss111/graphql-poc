package per.poss.models;

import javax.persistence.*;

@Entity
public class Mortgage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @ManyToOne
    @JoinColumn(name = "mortgage_id",
        nullable = false, updatable = false)
    private Borrower borrower;

    public Mortgage() { super(); }

    public Mortgage(Long id) {
        this.id = id;
    }

    public Mortgage(String type, Borrower borrower) {
        this.type = type;
        this.borrower = borrower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

}
