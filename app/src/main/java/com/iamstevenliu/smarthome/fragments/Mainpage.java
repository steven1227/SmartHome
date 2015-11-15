package com.iamstevenliu.smarthome.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.iamstevenliu.smarthome.R;
import com.iamstevenliu.smarthome.adapter.MainGridAdap;

/**
 * Created by steven on 11/14/15.
 */
public class Mainpage extends Fragment{
    private GridView gridview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        gridview = (GridView)view.findViewById(R.id.gridview);
        gridview.setAdapter(new MainGridAdap(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}
