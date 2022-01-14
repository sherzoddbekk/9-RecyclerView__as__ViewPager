package com.example.a9_recyclerviewasviewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a9_recyclerviewasviewpager.R;
import com.example.a9_recyclerviewasviewpager.medel.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   List<Member> members;
   Context context;

    public CustomAdapter(List<Member> members, Context context) {
        this.members = members;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view,parent,false);
        return new CustomHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);
        if (holder instanceof CustomHolderView){
            TextView first_name = ((CustomHolderView) holder).firstName;
            first_name.setText(member.getFirstName());
            TextView last_name = ((CustomHolderView) holder).lastName;
            last_name.setText(member.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
    private  class CustomHolderView extends RecyclerView.ViewHolder{

        View view;
        TextView firstName, lastName;
        public CustomHolderView(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            firstName = itemView.findViewById(R.id.firstName);
            lastName = itemView.findViewById(R.id.lastName);
        }
    }
}
