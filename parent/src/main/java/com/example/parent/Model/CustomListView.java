package com.example.parent.Model;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parent.R;

/**
 * Created by Duy Anh on 10/27/2018
 **/
public class CustomListView extends ArrayAdapter<String> {

    String[] UserName;
    String[] Description;
    Integer[] ImageId;
    Activity Context;

    public CustomListView(Activity context, String[] userName, String[] description, Integer[] imageId) {
        super(context, R.layout.listview_layout, userName);

        this.Context = context;
        this.UserName = userName;
        this.Description = description;
        this.ImageId = imageId;
        //this.IsChoise = isChoise;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        Viewholder viewholder = null;
        if (r == null) {
            LayoutInflater layoutInflater = Context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_layout, null, true);
            viewholder=new Viewholder(r);
            r.setTag(viewholder);
        }
        else
        {
            viewholder=(Viewholder) r.getTag();
        }
        viewholder.ivm.setImageResource(ImageId[position]);
        viewholder.tvw1.setText(UserName[position]);
        viewholder.tvw2.setText(Description[position]);

        return r;
    }

    class Viewholder {
        TextView tvw1;
        TextView tvw2;
        ImageView ivm;

        Viewholder(View v) {
            tvw1 = v.findViewById(R.id.tvusername);
            tvw2 = v.findViewById(R.id.tvdescription);
            ivm = v.findViewById(R.id.imageView);
        }
    }
}
