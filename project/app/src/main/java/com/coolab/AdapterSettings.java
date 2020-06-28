package com.coolab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class AdapterSettings extends ArrayAdapter<SettingDetails> {


    public AdapterSettings(@NonNull Context context,ArrayList<SettingDetails> details, int resource) {
        super(context, resource, details);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem==null)
        {
            listItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        SettingDetails currentSettings =getItem(position);

        TextView mainText =listItem.findViewById(R.id.mainText);
        mainText.setText(currentSettings.getMainText());

        TextView subText = listItem.findViewById(R.id.subText);
        subText.setText(currentSettings.getSubText());

        ImageView image = listItem.findViewById(R.id.ImageSettings);
        image.setImageResource(currentSettings.getImgId());


        return listItem;


    }
}
