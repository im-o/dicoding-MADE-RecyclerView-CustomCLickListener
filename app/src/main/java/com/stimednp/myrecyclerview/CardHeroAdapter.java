package com.stimednp.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by rivaldy on 7/6/2019.
 */

public class CardHeroAdapter extends RecyclerView.Adapter<CardHeroAdapter.CardViewHolder> {
    private ArrayList<Hero>listHero;
    private Context context;

    private ArrayList<Hero> getListHero() {
        return listHero;
    }

    void setListHero(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }

    CardHeroAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardHeroAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_hero, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHeroAdapter.CardViewHolder cardViewHolder, int i) {
        final Hero hero = getListHero().get(i);
        Glide.with(context)
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewHolder.imgViewPhoto);
        cardViewHolder.tvTittle.setText(hero.getName());
        cardViewHolder.tvFrom.setText(hero.getFrom());

        cardViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemlicked(View view, int postion) {
                Toast.makeText(context, "Tombol Share Click : "+hero.getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewHolder.btnDetails.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemlicked(View view, int postion) {
                Toast.makeText(context, "Tombol Details Click : "+hero.getName(), Toast.LENGTH_SHORT).show();
                //untuk pindah ke activity lain misal btn Details
                Intent intent = new Intent(context, DetailsActivity.class);
                context.startActivity(intent);
            }
        }));


    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgViewPhoto;
        TextView tvTittle, tvFrom;
        Button btnDetails, btnShare;
        CardViewHolder(@NonNull View view) {
            super(view);
            imgViewPhoto = view.findViewById(R.id.img_item_photo_card);
            tvTittle = view.findViewById(R.id.tv_item_name_card);
            tvFrom = view.findViewById(R.id.tv_item_form_card);
            btnDetails = view.findViewById(R.id.btn_set_more_cardview);
            btnShare = view.findViewById(R.id.btn_set_share_cardview);
        }
    }
}
