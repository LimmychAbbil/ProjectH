package com.globallogic;

import com.globallogic.dbhelper.DataGetter;
import com.globallogic.dbhelper.DataSender;
import com.globallogic.dto.UserAddress;
import com.globallogic.dto.UserDetails;

import java.util.ArrayList;
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

        UserDetails user2 = new UserDetails();
        user2.setUserId(2);
        user2.setUsername("Child user");

        List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
        userDetailsList.add(user2);

//        user1.setInvitedUsers(userDetailsList);

        UserAddress homeAddress = new UserAddress();
        homeAddress.setFullAddress("Ukraine Kyiv V.Lypkivskoho str.");

        UserAddress workAddress = new UserAddress();
        workAddress.setFullAddress("Ukraine Kyiv M.Hrinchenka str., GlobalLogic");

        user1.setHomeAddress(homeAddress);
        user1.setWorkAddress(workAddress);

        ds.sendData(user1);

//        DataGetter dg = new DataGetter();
//        user1 = dg.getData(1);
//
//        System.out.println(user1);
    }
}
