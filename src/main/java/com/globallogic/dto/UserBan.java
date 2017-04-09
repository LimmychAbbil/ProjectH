package com.globallogic.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by Limmy on 09.04.2017.
 */
@Entity(name = "BANS")
public class UserBan {
    boolean isBlocked;
    String message;
    Date blockedDate;
    Date unBlockedDate;
    @OneToOne
    UserDetails user;
    @Id @GeneratedValue
    private int banRecord;

    public UserBan(UserDetails user) {
        this.user = user;
        this.isBlocked = false;
        message = "";
        blockedDate = null;
        unBlockedDate = null;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getBlockedDate() {
        return blockedDate;
    }

    public void setBlockedDate(Date blockedDate) {
        this.blockedDate = blockedDate;
    }

    public Date getUnBlockedDate() {
        return unBlockedDate;
    }

    public void setUnBlockedDate(Date unBlockedDate) {
        this.unBlockedDate = unBlockedDate;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
}
