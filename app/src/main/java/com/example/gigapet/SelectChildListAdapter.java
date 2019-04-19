package com.example.gigapet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SelectChildListAdapter extends RecyclerView.Adapter<SelectChildListAdapter.ViewHolder> {
    String[] childrenNames = ChildDao.getChildrenNames();

    public SelectChildListAdapter(){

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_name_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        childrenNames = ChildDao.getChildrenNames();
        viewHolder.tvName.setText(childrenNames[i]);
        final int pos = i;
        viewHolder.vParentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildDao.setCurrentChildId(ChildDao.getChildren().get(i).getId());
                notifyDataSetChanged();
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