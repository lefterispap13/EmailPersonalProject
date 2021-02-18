package com.papadogiannis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="receive_email")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveEmail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="receive_email_id")
    private Long receiveEmailId;

    @Column(name="message",length=10000)
    private String message;

    @Column(name="other_staff")
    private String otherStaff;

    @Column(name="date_received")
    private Date dateReceived;

    @ManyToMany(mappedBy = "receivedEmails", fetch =FetchType.LAZY)
    private Set<Account> accounts;

    public ReceiveEmail(String message, String otherStaff, Date dateReceived, Set<Account> accounts) {
        this.message = message;
        this.otherStaff = otherStaff;
        this.dateReceived = dateReceived;
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiveEmail that = (ReceiveEmail) o;

        return receiveEmailId.equals(that.receiveEmailId);
    }

    @Override
    public int hashCode() {
        return receiveEmailId.hashCode();
    }
}
