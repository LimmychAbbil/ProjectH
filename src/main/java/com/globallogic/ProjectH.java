package main.java.com.globallogic;

import main.java.com.globallogic.dbhelper.DataSender;
import main.java.com.globallogic.dto.UserDetails;

/**
 * Created by Limmy on 19.03.2017.
 */
public class ProjectH {

    public static void main(String[] args) {
        DataSender ds = new DataSender();
        UserDetails user1 = new UserDetails();
        user1.setUserId(1);
        user1.setUsername("Test");
        ds.sendData(user1);
    }
}
