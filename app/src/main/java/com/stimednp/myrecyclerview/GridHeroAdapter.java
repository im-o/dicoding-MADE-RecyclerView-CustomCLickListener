package com.stimednp.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by rivaldy on 7/1/2019.
 */

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Hero> listHero;

    private ArrayList<Hero> getListHero() {
        return listHero;
    }

    void setListHero(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }

    GridHeroAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_hero, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        final Hero hero = getListHero().get(i);
        Glide.with(context)
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgItemPhoto);
        gridViewHolder.imgItemPhoto.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemlicked(View view, int postion) {
                Toast.makeText(context, "Grid View Click : "+hero.getName(), Toast.LENGTH_SHORT).show();
                //untuk pindah ke activity lain
                Intent intent = new Intent(context, DetailsActivity.class);
                context.startActivity(intent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgItemPhoto;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItemPhoto = itemView.findViewById(R.id.img_item_photo_grid);
        }
    }
}
