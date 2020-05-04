package com.example.testProject.entity.util;

import com.example.testProject.entity.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}
