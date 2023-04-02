package com.example.chekapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Post_Viewholder>{

    Context context;
    List<UserData> userData;

    public PostAdapter(Context context, List<UserData> userData) {
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public Post_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Post_Viewholder(LayoutInflater.from(context).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Post_Viewholder holder, int position) {

        UserData data = userData.get(position);
        holder.tittle.setText(data.getTitle());
        holder.dis.setText(data.getBody());

    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    class Post_Viewholder extends RecyclerView.ViewHolder {

        public TextView tittle,dis;

        public Post_Viewholder(@NonNull View itemView) {
            super(itemView);

            tittle=itemView.findViewById(R.id.tittle);
            dis=itemView.findViewById(R.id.dis);

        }
    }
}
