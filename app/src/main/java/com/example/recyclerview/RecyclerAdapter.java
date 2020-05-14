package com.example.recyclerview;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageView> {

    private List<String> images;
    private LayoutInflater layoutIN;

    RecyclerAdapter(Context context, List<String> image) {
        this.layoutIN = LayoutInflater.from(context);
        this.images = image;
    }
    public class ImageView extends RecyclerView.ViewHolder {

        android.widget.ImageView myImageView;
        ImageView(View v) {
            super(v);
            myImageView = v.findViewById(R.id.image);

        }
    }



    @Override
    public ImageView onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutIN.inflate(R.layout.recycle_list, viewGroup, false);
        return new ImageView(view);
    }

    @Override
    public void onBindViewHolder(ImageView view, int position) {
        String url = images.get(position);
        Picasso.get().load(url).into(view.myImageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
