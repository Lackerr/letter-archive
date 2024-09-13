package com.eDMS.letterArchive.domain.model;

import org.springframework.util.Assert;

import java.util.UUID;

public record SenderId(UUID id) {

    public SenderId {
        Assert.notNull(id, "id must not be null");
    }

    public SenderId() {
        this(UUID.randomUUID());
    }
}
