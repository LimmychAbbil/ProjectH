package com.globallogic;

import com.globallogic.dbhelper.DataGetter;
import com.globallogic.dbhelper.DataSender;
import com.globallogic.dto.Group;
import com.globallogic.dto.UserAddress;
import com.globallogic.dto.UserBan;
import com.globallogic.dto.UserDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Limmy on 19.03.2017.
 */
public class ProjectH {

    public static void main(String[] args) {


        DataSender ds = new DataSender();
        UserDetails user1 = new UserDetails();
        user1.setUserId(1);
        user1.setUsername("Test");
        UserBan userBan1 = new UserBan(user1);

        UserDetails user2 = new UserDetails();
        user2.setUserId(2);
        user2.setUsername("Child user");
        UserBan userBan2 = new UserBan(user2);
        userBan2.setBlocked(true);
        userBan2.setMessage("THIS USER IS BLOCKED");
        userBan2.setBlockedDate(new Date());
        userBan2.setUnBlockedDate(new Date(System.currentTimeMillis() + 3600));

        Group group = new Group("all_users", user1);
        group.getUsers().add(user2);

        user1.getGroups().add(group);
        user2.getGroups().add(group);

        ds.sendData(user1,user2,userBan1,userBan2);

//        DataGetter dg = new DataGetter();
//        user1 = dg.getData(1);
//
//        System.out.println(user1);
    }
}
