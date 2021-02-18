package com.papadogiannis.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="send_emails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendEmail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="send_email_id")
    private Long sendEmailId;

    @Column(name="message")
    private String message;

    @Column(name="other_staff")
    private String otherStaff;

    @Column(name="date_sent")
    private Date dateSent;

    @ManyToOne
    @JoinColumn(name="account_id",referencedColumnName = "account_id")
    private Account account;

    public SendEmail(String message, String otherStaff, Date dateSent, Account account) {
        this.message = message;
        this.otherStaff = otherStaff;
        this.dateSent = dateSent;
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendEmail sendEmail = (SendEmail) o;

        return sendEmailId.equals(sendEmail.sendEmailId);
    }

    @Override
    public int hashCode() {
        return sendEmailId.hashCode();
    }
}
