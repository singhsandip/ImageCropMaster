package com.sandeep.imagecropmaster.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.sandeep.imagecropmaster.R;

/**
 * Created by sandeep on 11-06-2017.
 */

public class AdapterViewHolder extends RecyclerView.ViewHolder
{
    public ImageView selectedImageView;

    public AdapterViewHolder(View itemView)
    {
        super(itemView);

        selectedImageView = (ImageView) itemView.findViewById(R.id.imageViewSelectedImage);

    }
}
