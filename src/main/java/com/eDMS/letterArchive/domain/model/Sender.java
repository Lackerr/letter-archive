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

    Sender() {
    }

    public Sender(String name, String eMail, AddressId addressId) {
        this.id = new SenderId();
        this.name = name;
        this.eMail = eMail;
        this.addressId = addressId;
    }

    public SenderId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEMail() {
        return eMail;
    }

    public AddressId getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sender sender = (Sender) o;
        return id.equals(sender.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
