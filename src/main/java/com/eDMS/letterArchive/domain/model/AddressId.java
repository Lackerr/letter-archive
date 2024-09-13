package com.eDMS.letterArchive.domain.model;

import org.springframework.util.Assert;

import java.util.UUID;

public record AddressId(UUID id) {
    public AddressId {
        Assert.notNull(id, "id must not be null");
    }

    public AddressId() {
        this(UUID.randomUUID());
    }
}
