package com.example.android.myapplication;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<DS>
{
    // constructor for ArrayAdapter
    public WordAdapter(@NonNull Context context, ArrayList <DS> arrayList) {
        super(context, 0, arrayList);
    }

    // overriden getView() method to inflate the elementlist.xml
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //check if existing view is being reused, otherwise inflate the view:
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.elementview, parent,false);
        }

        //Creating a placeholder for holding the data temporary for a respective position
        DS temp = getItem(position);

        ImageView img = (ImageView) listItemView.findViewById(R.id.img_id);
        img.setImageResource(temp.get_image_id());

        TextView name = (TextView) listItemView.findViewById(R.id.name_req);
        name.setText(temp.getplace_name());

        TextView address = (TextView) listItemView.findViewById(R.id.address);
        address.setText(temp.get_location());

        TextView timings = (TextView) listItemView.findViewById(R.id.timings);
        timings.setText(temp.get_timing());

        return listItemView;
    }
}
