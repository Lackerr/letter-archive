package com.eDMS.letterArchive.domain.model;

import jakarta.persistence.*;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Entity
public class Letter {
    @EmbeddedId
    private LetterId id;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "sender_id"))
    private SenderId senderId;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Date documentDate;
    @ElementCollection
    private Set<TagId> tags;

    Letter() {
    }

    public Letter(SenderId senderId, String content, String description, Date documentDate) {
        Assert.notNull(senderId, "senderId must not be null");
        Assert.notNull(content, "content must not be null");
        Assert.notNull(description, "description must not be null");
        Assert.notNull(documentDate, "documentDate must not be null");

        this.id = new LetterId();
        this.senderId = senderId;
        this.content = content;
        this.description = description;
        this.documentDate = documentDate;
    }

    public LetterId getId() {
        return id;
    }

    public SenderId getSenderId() {
        return senderId;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return id.equals(letter.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
