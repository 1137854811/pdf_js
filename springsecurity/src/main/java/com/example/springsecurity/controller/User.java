package com.example.springsecurity.controller;

/**
 * @Author: Tz
 * @date: 2020/9/14 14:28
 */

public class User {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
