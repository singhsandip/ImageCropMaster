package com.sandeep.imagecropmaster.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandeep.imagecropmaster.R;
import com.sandeep.imagecropmaster.holder.AdapterViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sandeep on 11-06-2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<AdapterViewHolder>
{

    private List<String> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public ImageAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.imagelayout,parent,false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position)
    {
        Picasso.with(context)
                .load(list.get(position).toString())
                .into(holder.selectedImageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
