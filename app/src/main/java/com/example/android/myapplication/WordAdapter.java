package com.example.android.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class WordAdapter extends ArrayAdapter<DS>
{
    Context context ;
    // constructor for ArrayAdapter
    public WordAdapter(@NonNull Context context, ArrayList <DS> arrayList) {
        super(context, 0, arrayList);
        this.context = context;
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

        ImageView loc_img = (ImageView) listItemView.findViewById(R.id.loc_icon);
        loc_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse(temp.get_geo_location());
                intent.setData(uri);
                if(intent.resolveActivity(context.getPackageManager())!= null)
                {
                    startActivity(context, intent ,null);
                }
            }
        });

//        LinearLayout linearLayout = listItemView.findViewById(R.id.innerLinearLayout);
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, Detail.class);
//                startActivity(context, intent, null);
//            }
//        });

        return listItemView;
    }
}
