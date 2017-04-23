package com.globallogic.dto;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Limmy on 15.04.2017.
 */
@Entity(name = "`Group`")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Group_Type")
public abstract class Group {

    @Id
    private String groupName;

    @ManyToMany(mappedBy = "groups")
    protected Collection<UserDetails> users;

    @Transient
    private UserDetails leader;

    public Group(String groupName) {
        this.groupName = groupName;
        this.users = new HashSet<>();
    }

    public Group(String groupName, UserDetails leader) {
        this(groupName);
        this.leader = leader;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupName() {
        return groupName;

    }

    public Collection<UserDetails> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDetails> users) {
        this.users = users;
    }

    public UserDetails getLeader() {
        return leader;
    }

    public void setLeader(UserDetails leader) {
        this.leader = leader;
    }

    public abstract void addUser(UserDetails user);
    public abstract void removeUser(UserDetails user);
}
