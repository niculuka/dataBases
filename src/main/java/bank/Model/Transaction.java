package bank.Model;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaction;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @Column(name = "sum")
    private int sum;

    //---------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "source_account")
    private Account source_account;

    //---------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "destination_account")
    private Account destination_account;

    //---------------------------------------------------------------

    public Transaction() {
    }

    public Transaction(String title, String date, int sum, Account source_account, Account destination_account) {
        this.title = title;
        this.date = date;
        this.sum = sum;
        this.source_account = source_account;
        this.destination_account = destination_account;
    }
}
