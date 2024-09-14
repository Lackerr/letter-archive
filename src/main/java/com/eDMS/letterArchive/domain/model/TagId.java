package com.eDMS.letterArchive.domain.model;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

@Embeddable
public record TagId(int id) {
    public TagId {
        Assert.notNull(id, "id must not be null");
    }

    public TagId() {
        this(0);
    }
}
