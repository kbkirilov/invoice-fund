package com.invoicefund.models.enums;

public enum Role {
    ADMIN(1),
    VENDOR(2),
    INVESTOR(3);

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public static Role fromId(int id) {
        for (Role role : values()) {
            if (role.id == id) {
                return role;
            }
        }
        throw new IllegalArgumentException("No Role with id: " + id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.toString();
    }
}
