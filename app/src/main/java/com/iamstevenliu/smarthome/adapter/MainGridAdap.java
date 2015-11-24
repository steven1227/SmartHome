package com.iamstevenliu.smarthome.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.iamstevenliu.smarthome.R;

/**
 * Created by steven on 11/14/15.
 */
public class MainGridAdap extends BaseAdapter{
    private Context mContext;
    private String[] images={"control","weather","location","energy"};
    public MainGridAdap(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView textView;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.card_component, parent, false);
            imageView=(ImageView)convertView.findViewById(R.id.myImageView);
            textView =(TextView)convertView.findViewById(R.id.myImageViewText);
            imageView.setImageResource(mContext.getResources().getIdentifier(images[position], "drawable", mContext.getPackageName()));
            textView.setText(images[position]);

        }
//       imageView.setImageResource(mContext.getResources().getIdentifier("location", "drawable", mContext.getPackageName()));
        return convertView;
    }
}
