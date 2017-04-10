package com.example.allen.hw3.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.example.allen.hw3.R;
import com.example.allen.hw3.model.Listitem;
import com.example.allen.hw3.ui.MainActivity;

import java.util.List;
import java.util.Vector;

/**
 * Created by Allen on 05/04/2017.
 */


public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder> {
    Vector<Boolean> vector = new Vector<>();
    private List<Listitem> listData;
    private LayoutInflater inflater;
    final private ListItemClickListener mOnClickListener;


    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }



    public DerpAdapter (List<Listitem> listData, Context c, ListItemClickListener listener)
    {
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
        mOnClickListener = listener;
    }

    @Override
    public DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new DerpHolder(view);
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        Listitem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DerpHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView title;
        private ImageView icon;
        private View container;


        public DerpHolder(View itemView)
        {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            title.setOnClickListener(this);
            icon = (ImageView)itemView.findViewById(R.id.im_item_icon);
            container = itemView.findViewById(R.id.cont_item_root);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }

}

