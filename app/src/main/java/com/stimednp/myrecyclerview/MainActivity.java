package com.stimednp.myrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    ArrayList<Hero> list = new ArrayList<>();
    private String appBarTitle = "HOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        showRecyclerList();
        setActionBarTitle(appBarTitle);
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(this);
        listHeroAdapter.setListHero(list);
        rvCategory.setAdapter(listHeroAdapter);
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(this);
        gridHeroAdapter.setListHero(list);
        rvCategory.setAdapter(gridHeroAdapter);
    }

    private void showRecyclerCard() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardHeroAdapter cardHeroAdapter = new CardHeroAdapter(this);
        cardHeroAdapter.setListHero(list);
        rvCategory.setAdapter(cardHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list:
                setActionBarTitle("INI MODE LIST");
                showRecyclerList();
                break;
            case R.id.action_grid:
                setActionBarTitle("INI MODE GRID");
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                setActionBarTitle("INI MODE CARD");
                showRecyclerCard();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String appBarTitle) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(appBarTitle);
        }
    }
}
