package com.eDMS.letterArchive.domain.model;

import jakarta.persistence.*;

@Entity
public class Sender {
    @EmbeddedId
    private SenderId id;
    private String name;
    private String eMail;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "address_id"))
    private AddressId addressId;
}
