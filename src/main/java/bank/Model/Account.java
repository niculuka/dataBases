package bank.Model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "account")
public class Account {

    @Id
    private int IBAN  = (int) (Math.random() * 10000);

    @Column(name = "friendly_name")
    private String friendly_name;

    @Column(name = "balance")
    private int balance;
    //---------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //---------------------------------------------------------------
    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Account> account= new ArrayList<>();;

    //---------------------------------------------------------------
    @OneToMany(mappedBy = "source_account",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Account> source_account = new ArrayList<>();
    //---------------------------------------------------------------
    @OneToMany(mappedBy = "destination_account",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Account> destination_account = new ArrayList<>();

    //---------------------------------------------------------------

    public Account() {
    }

    public Account(String friendly_name, int balance, User user) {
        this.friendly_name = friendly_name;
        this.balance = balance;
        this.user = user;
    }



}
