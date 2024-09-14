package com.eDMS.letterArchive.domain.model;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.UUID;

@Embeddable
public record SenderId(UUID id) {

    public SenderId {
        Assert.notNull(id, "id must not be null");
    }

    public SenderId() {
        this(UUID.randomUUID());
    }
}
