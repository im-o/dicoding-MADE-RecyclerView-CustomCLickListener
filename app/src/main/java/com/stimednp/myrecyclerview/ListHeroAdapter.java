package com.stimednp.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by rivaldy on 6/30/2019.
 */

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Hero> listHero;

    ListHeroAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Hero> getListHero() {
        return listHero;
    }

    void setListHero(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }

    @NonNull
    @Override
    public ListHeroAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hero, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHeroAdapter.CategoryViewHolder categoryViewHolder, int i) {
        final Hero hero = getListHero().get(i);
        categoryViewHolder.tvName.setText(hero.getName());
        categoryViewHolder.tvFrom.setText(hero.getFrom());
        Glide.with(context)
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(categoryViewHolder.imgPhoto);

        categoryViewHolder.relativeLayoutRowItem.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemlicked(View view, int postion) {
                Toast.makeText(context, "List View Click : "+hero.getName(), Toast.LENGTH_SHORT).show();
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

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayoutRowItem;
        TextView tvName, tvFrom;
        ImageView imgPhoto;
        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            relativeLayoutRowItem = itemView.findViewById(R.id.rl_row_main);
        }
    }
}
