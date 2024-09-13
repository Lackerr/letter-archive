package com.eDMS.letterArchive.domain.model;

import org.springframework.util.Assert;

import java.util.UUID;

public record LetterId(UUID id){

    public LetterId{
        Assert.notNull(id, "id must not be null");
    }

    public LetterId(){
        this(UUID.randomUUID());
    }
}
