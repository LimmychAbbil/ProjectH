package com.globallogic;


import com.globallogic.dbhelper.DataHelper;
import com.globallogic.dto.UserDetails;

/**
 * Created by Limmy on 19.03.2017.
 */
public class ProjectH {

    public static void main(String[] args) {

        DataHelper dh = new DataHelper();
        UserDetails ud = new UserDetails();
        ud.setUserId(2);
        ud.setUsername("Some UserName");
        dh.sendData(ud);

        UserDetails getUd = (UserDetails) dh.getData(UserDetails.class, 2);
        System.out.println(getUd.getUsername());

        getUd.setUsername("New username");
        dh.updateData(getUd);

        System.out.println("Update user?");

        dh.deleteData(getUd);


        dh.close();


    }
}
