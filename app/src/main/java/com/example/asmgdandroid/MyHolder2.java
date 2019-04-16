package com.example.asmgdandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class MyHolder2 extends RecyclerView.ViewHolder {
    public TextView text;
    public ImageView imgEdit;
    public ImageView imgDelete;



    public MyHolder2(@NonNull View itemView) {
        super(itemView);

        text = (TextView) itemView.findViewById(R.id.text);
        imgEdit = (ImageView) itemView.findViewById(R.id.imgEdit);
        imgDelete = (ImageView) itemView.findViewById(R.id.imgDelete);
    }
}

