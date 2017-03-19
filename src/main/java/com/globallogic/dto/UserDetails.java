package main.java.com.globallogic.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
    @Id
    private int userId;
    private String username;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}