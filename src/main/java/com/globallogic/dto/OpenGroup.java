package com.globallogic.dto;

import javax.persistence.Entity;

/**
 * Created by Limmy on 22.04.2017.
 */
@Entity
public class OpenGroup extends Group {

    public OpenGroup(String groupName) {
        super(groupName);
    }

    public OpenGroup(String groupName, UserDetails leader) {
        super(groupName, leader);
    }

    @Override
    public void addUser(UserDetails user) {
        users.add(user);
    }

    @Override
    public void removeUser(UserDetails user) {
        users.remove(user);
    }
}
