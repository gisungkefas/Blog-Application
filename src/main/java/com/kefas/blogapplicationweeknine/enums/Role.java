package com.kefas.blogapplicationweeknine.enums;

public enum Role {
    ADMIN("Admin"),
    USER("User");

    private String display;

    Role(String display) {
        this.display = display;
    }
}
