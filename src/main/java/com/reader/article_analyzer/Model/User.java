package com.reader.article_analyzer.Model;

public class User {
    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSlackId() {
        return slackId;
    }

    public void setSlackId(String slackId) {
        this.slackId = slackId;
    }

    private String email;
    private String slackId;
    private NotificationType notificationType;

    public User(Long id, String username, String email, String slackId, NotificationType notificationType) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.slackId = slackId;
        this.notificationType = notificationType;
    }

    // Getters and setters for other fields

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        // Convert the input string to the corresponding enum value
        this.notificationType = NotificationType.valueOf(notificationType.toUpperCase());
    }

    public enum NotificationType {
        EMAIL,
        SLACK
    }
}
