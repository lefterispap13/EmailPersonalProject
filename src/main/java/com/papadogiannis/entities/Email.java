package com.papadogiannis.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="send_emails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="email_id")
    private Long emailId;

    @Column(name="message",length=10000)
    private String message;

    @Column(name="other_staff")
    private String otherStaff;

    @Column(name="date_sent")
    private Date dateSent;

    @Column(name="type")
    private String type;

    @ManyToOne
    @JoinColumn(name="account_id",referencedColumnName = "account_id")
    private Account account;

    @OneToMany(mappedBy = "email", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<TypeOfEmail> typeOfEmails;

    public Email(String message, String otherStaff, Date dateSent, String type, Account account, Set<TypeOfEmail> typeOfEmails) {
        this.message = message;
        this.otherStaff = otherStaff;
        this.dateSent = dateSent;
        this.type = type;
        this.account = account;
        this.typeOfEmails = typeOfEmails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        return emailId.equals(email.emailId);
    }

    @Override
    public int hashCode() {
        return emailId.hashCode();
    }
}
