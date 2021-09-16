package bank.Model;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "account_type")
public class Account_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "types")
    private String types;

    //---------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "account_IBAN")
    private Account account;
    //---------------------------------------------------------------

    public Account_type() {
    }

    public Account_type(String types, Account account) {
        this.types = types;
        this.account = account;
    }
}
