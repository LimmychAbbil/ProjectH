package com.globallogic.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created by Limmy on 22.04.2017.
 */
@Entity
public class ClosedGroup extends Group {

    public ClosedGroup(String groupName) {
        super(groupName);
    }

    public ClosedGroup(String groupName, UserDetails leader) {
        super(groupName, leader);
    }

    @Override
    public void addUser(UserDetails user) {
        throwUnsupportedOperation();
    }

    @Override
    public void removeUser(UserDetails user) {
        throwUnsupportedOperation();
    }

    private void throwUnsupportedOperation() {
        throw new RuntimeException("This group is closed");
    }
}
