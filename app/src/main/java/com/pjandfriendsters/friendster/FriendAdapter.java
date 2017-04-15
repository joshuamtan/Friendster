package com.pjandfriendsters.friendster;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jonathan Arino on 4/14/2017.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder>{

    private List<Friend> friendsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            cv = (CardView)view.findViewById(R.id.cv);
            name = (TextView) view.findViewById(R.id.name);
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Edit_Friend_Activity.class);

                    final TextView friendName = (TextView) v.findViewById(R.id.name);
                    String friend = friendName.getText().toString();
                    i.putExtra("friendName", friend);

                    v.getContext().startActivity(i);
                }
            });
        }
    }

    public FriendAdapter(List<Friend> friendsList) {
        this.friendsList = friendsList;
    }

    @Override
    public FriendAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
        MyViewHolder item = new MyViewHolder(itemView);
        return item;
    }

    @Override
    public void onBindViewHolder(FriendAdapter.MyViewHolder holder, int position) {
        Friend friend = friendsList.get(position);
        holder.name.setText(friend.getName());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }
}
