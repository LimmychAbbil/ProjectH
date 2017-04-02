package com.globallogic;

import com.globallogic.dbhelper.DataGetter;
import com.globallogic.dbhelper.DataSender;
import com.globallogic.dto.UserAddress;
import com.globallogic.dto.UserDetails;

/**
 * Created by Limmy on 19.03.2017.
 */
public class ProjectH {

    public static void main(String[] args) {
        DataSender ds = new DataSender();
        UserDetails user1 = new UserDetails();
        user1.setUserId(1);
        user1.setUsername("Test");

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
