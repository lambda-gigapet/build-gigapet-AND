package com.example.gigapet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class RemoveChildListAdapter extends RecyclerView.Adapter<RemoveChildListAdapter.ViewHolder> {
    String[] childrenNames = ChildDao.getChildrenNames();

    public RemoveChildListAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_name_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        childrenNames = ChildDao.getChildrenNames();
        viewHolder.tvName.setText(childrenNames[i]);
        final int pos = i;
        viewHolder.vParentView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ChildDao.removeChild(pos);
                notifyDataSetChanged();
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return ChildDao.getChildren().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        View vParentView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.child_name_recycler);
            vParentView = itemView.findViewById(R.id.child_list_item_view);
        }
    }
}
