package com.papadogiannis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="type_of_email")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfEmail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="type_of_email_id")
    private Long typeOfEmailId;

    @Column(name="type")
    private String type;

    @ManyToOne
    @JoinColumn(name="email_id")
    private Email email;


}
