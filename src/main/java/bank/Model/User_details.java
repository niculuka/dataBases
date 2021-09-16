package bank.Model;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "user_details")
public class User_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    private String birthday;

    //---------------------------------------------------------------
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    //---------------------------------------------------------------

    public User_details() {
    }

    public User_details(String address, String phone, String birthday, User user) {
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.user = user;
    }
}
