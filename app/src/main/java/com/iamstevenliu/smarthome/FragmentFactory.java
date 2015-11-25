package com.iamstevenliu.smarthome;

import android.support.v4.app.Fragment;

import com.iamstevenliu.smarthome.fragments.fragment_weather;

/**
 * Created by steven on 11/24/15.
 */
public class FragmentFactory {
    public static Fragment create (int id){
        Fragment fragment=null;
        switch (id) {
            case 0:
                fragment=new fragment_weather();
                break;
            case 1:
                fragment=new fragment_weather();
                break;
            case 2:
                fragment=new fragment_weather();
                break;
            case 3:
                fragment=new fragment_weather();
                break;
            default:
                ;
        }
        return fragment;
    }
}
