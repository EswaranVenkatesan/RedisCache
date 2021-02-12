package com.app.user.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 7156526077883281625L;

    private int userId;
    private String userName;
    private int age;

    public User (int userId, String userName, int age) {
        this.userId = userId;
        this.userName = userName;
            this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDAO{" +
                "useId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
