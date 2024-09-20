package com.android_get_api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.GetViewHolder> {
        private List<UserModel> getlist;

    public Adapter(List<UserModel> getlist) {
            this.getlist = getlist;
        }

        @NonNull
        @Override
        public GetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_get, parent, false);
            return new GetViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GetViewHolder holder, int position) {
            UserModel user = getlist.get(position);
            holder.title.setText(user.getTitle());
            holder.body.setText(user.getBody());
        }

        @Override
        public int getItemCount() {
            return getlist.size();
        }

        static class GetViewHolder extends RecyclerView.ViewHolder {
            TextView title;
            TextView body;

            public GetViewHolder(@NonNull View itemView) {
                super(itemView);
                //   user = itemView.findViewById(R.id.text_user);
                title = itemView.findViewById(R.id.text_title);
                body = itemView.findViewById(R.id.text_body);
            }
        }
    }