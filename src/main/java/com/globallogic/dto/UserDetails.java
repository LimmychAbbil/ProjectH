package com.globallogic.dto;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class UserDetails {
    @Id
    private int userId;
    private String username;
    @Embedded
    @AttributeOverride(name = "fullAddress", column = @Column(name = "Home_Address"))
    private UserAddress homeAddress;
    @Embedded
    @AttributeOverride(name = "fullAddress", column = @Column(name = "Work_Address"))
    private UserAddress workAddress;

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

    public UserAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(UserAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public UserAddress getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(UserAddress workAddress) {
        this.workAddress = workAddress;
    }
}
