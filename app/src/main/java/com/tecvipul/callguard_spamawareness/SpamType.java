package com.tecvipul.callguard_spamawareness;

public class SpamType {
    private String title;
    private String description;

    public SpamType(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // Optional: aliases for backward compatibility
    public String getType() {
        return title;
    }

    public String getCause() {
        return description;
    }
}
