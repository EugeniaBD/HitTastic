package com;

import java.time.LocalDateTime;
public class Comment {
    private int id;
    private String user;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedat;

    public Comment(int id, String user, String comment) {
        this.id = id;
        this.user = user;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
        this.updatedat = LocalDateTime.now();
    }
    
    public void update(String comment) {
        this.comment = comment;
        this.updatedat = LocalDateTime.now();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }
    
    
}
