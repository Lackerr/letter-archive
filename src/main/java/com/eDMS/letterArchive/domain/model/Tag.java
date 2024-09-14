package com.eDMS.letterArchive.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tag {
    @Id
    private int id;
    private String name;
}
