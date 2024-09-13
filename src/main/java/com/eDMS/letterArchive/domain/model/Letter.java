package com.eDMS.letterArchive.domain.model;

import jakarta.persistence.*;
import org.springframework.util.Assert;

import java.util.Date;


@Entity
public class Letter {
    @EmbeddedId
    private LetterId id;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "sender_id"))
    private SenderId senderId;
    private String content;
    private String description;
    private Date documentDate;

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
}
