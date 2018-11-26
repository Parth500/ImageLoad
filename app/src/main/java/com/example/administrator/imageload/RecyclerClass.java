package com.example.administrator.imageload;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.imageload.API.FilePOJO;

import java.util.List;

public class RecyclerClass extends RecyclerView.Adapter<RecyclerClass.MyViewHolder> {

    Context context;
    List<FilePOJO> list;

    public RecyclerClass(Context context, List<FilePOJO> list) {
        this.context = context;
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Context context;
        ImageView imageView;
        TextView tv_id;
        CardView cardView;
        TextView tv_name;
        public MyViewHolder(View view, Context context) {

            super(view);
            this.context=context;
            imageView=view.findViewById(R.id.iv_image_recycler_reward_offer);
            cardView=view.findViewById(R.id.card_recycler_offer);
            tv_id=view.findViewById(R.id.tv_scheme_description_recycler_reward_offer);
            tv_name=view.findViewById(R.id.btn_view_coupon_recycler_reward_offer);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_custom, parent, false);

        return new MyViewHolder(itemView,context);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Glide.with(context).load(list.get(position).getUrl()).into(holder.imageView);
        holder.tv_id.setText(list.get(position).getId());
        holder.tv_name.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
