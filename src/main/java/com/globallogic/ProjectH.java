package com.globallogic;


import com.globallogic.dbhelper.DataHelper;
import com.globallogic.dto.UserDetails;

/**
 * Created by Limmy on 19.03.2017.
 */
public class ProjectH {

    public static void main(String[] args) {

        DataHelper dh = new DataHelper();

        for (UserDetails ud: dh.query()) {
            System.out.println(ud.toString());
        }


        dh.close();


    }
}
