package com.iamstevenliu.smarthome.CommonClass;

/**
 * Created by dinotech on 15/11/19.
 */
public class Common {

    private static Common ourInstance = new Common();

    public static Common getInstance() {
        return ourInstance;
    }

    private Common() {
    }
}
