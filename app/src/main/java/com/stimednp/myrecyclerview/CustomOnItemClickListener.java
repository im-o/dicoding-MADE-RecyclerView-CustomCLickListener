package com.stimednp.myrecyclerview;

import android.view.View;

/**
 * Created by rivaldy on 7/6/2019.
 */

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;

    public CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View v) {
        onItemClickCallback.onItemlicked(v, position);
    }

    interface OnItemClickCallback {
        void onItemlicked(View view, int postion);
    }
}
