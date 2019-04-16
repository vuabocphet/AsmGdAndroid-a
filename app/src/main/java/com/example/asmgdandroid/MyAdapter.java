package com.example.asmgdandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder2> {

    KhoanThu_Fragment context;
    List<Content> list;
    int myLayout;

    public MyAdapter(KhoanThu_Fragment context, List list,int myLayout) {
        this.context = context;
        this.list = list;
        this.myLayout = myLayout;
    }

    @NonNull
    @Override
    public MyHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item2,viewGroup,false);

        return new MyHolder2(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder2 myHolder2, final int i) {
           final Content content=list.get(i);


           myHolder2.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   context.click(list.get(i).getTen(),i);
               }
           });


        myHolder2.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.edit(content,i);

            }
        });

        myHolder2.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.delete(i);

            }
        });

        myHolder2.text.setText(list.get(i).getTen());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
