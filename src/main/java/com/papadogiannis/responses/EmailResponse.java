package com.papadogiannis.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.papadogiannis.entities.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailResponse extends Response{

    private List<Email> emails;
    private Email email;

    public EmailResponse(String msg, List<Email> emails) {
        super(msg);
        this.emails = emails;
    }

    public EmailResponse(String msg, Email email) {
        super(msg);
        this.email = email;
    }
}
