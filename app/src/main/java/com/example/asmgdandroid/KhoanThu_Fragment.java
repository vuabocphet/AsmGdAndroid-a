package com.example.asmgdandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class KhoanThu_Fragment extends Fragment {
    private View view;
    private ArrayList<Content> contents = new ArrayList<>();
    private RecyclerView recyclerView;
    MyAdapter myAdapter;
    MyHolder2 myHolder2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.khoanthu_fragment,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.lvView_khoanthu);
        addrecyclerview();

        contents.add(new Content("Lãi ngân hàng"));
        contents.add(new Content("Lương"));
        contents.add(new Content("Bán hàng"));
        contents.add(new Content("Đòi nợ"));
        myAdapter.notifyDataSetChanged();

        view.findViewById(R.id.fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.app.AlertDialog.Builder builder
                        = new android.support.v7.app.AlertDialog.Builder(getContext());


                builder.setTitle("LOẠI");
                //builder.setMessage("Hello SEO410??");

                LayoutInflater layoutInflater = getActivity().getLayoutInflater();

                View view_a = layoutInflater.inflate(R.layout.my_dialog, null);
                builder.setView(view_a);
                final EditText editText =view_a.findViewById(R.id.editText);


                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       if (!editText.getText().toString().trim().equals("")){
                           addlist(editText.getText().toString().trim());
                       }else {
                           editText.setError("Không để trống");
                           return;
                       }
                        }
                });

                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),
                                "ban vua bam cancel!", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();
            }
        });



        return view;
    }



    private void addrecyclerview(){
        myAdapter = new MyAdapter(KhoanThu_Fragment.this,contents,R.layout.item2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }



    public void click(String txt ,int i){
        Toast.makeText(getContext(), "Text là " + txt + "\tTại vị trí " + i, Toast.LENGTH_SHORT).show();
    }



    public void edit(Content content, final int i){

        final Dialog dialog=new Dialog(getContext());
        dialog.setContentView(R.layout.customdialog);
        final EditText editText=dialog.findViewById(R.id.txtkt);
        editText.setText(content.getTen());
        dialog.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt=editText.getText().toString().trim();
                if (txt.equals("")){
                    editText.setError("Không được để trống");
                    return;
                }
                contents.set(i,new Content(txt));
                myAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void delete(int i){
        contents.remove(i);
        myAdapter.notifyDataSetChanged();
    }

    private void addlist(String txt){
        contents.add(new Content(txt));
        myAdapter.notifyDataSetChanged();
    }

}
