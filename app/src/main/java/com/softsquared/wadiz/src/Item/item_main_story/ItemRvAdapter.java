package com.softsquared.wadiz.src.Item.item_main_story;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.Item.item_main_story.models.Itemmainlist;

import java.util.ArrayList;

public class ItemRvAdapter extends RecyclerView.Adapter<ItemRvAdapter.ViewHolder> {

    ArrayList<Itemmainlist> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMoney;
        TextView tvName;
        TextView tvContent;
        TextView tvDelivery_money;
        TextView tvDelivery_day;
        TextView tvLimited;
        TextView tvLimited_now;
        TextView tvTotal;

        ViewHolder(View itemView) {
            super(itemView);

            tvMoney = itemView.findViewById(R.id.item_main_list_tv_money);
            tvName = itemView.findViewById(R.id.item_main_list_tv_name);
            tvContent = itemView.findViewById(R.id.item_main_list_tv_content);
            tvDelivery_day = itemView.findViewById(R.id.item_main_list_tv_delivery_day);
            tvDelivery_money = itemView.findViewById(R.id.item_main_list_tv_delivery_money);
            tvLimited = itemView.findViewById(R.id.item_main_list_tv_limited);
            tvLimited_now = itemView.findViewById(R.id.item_main_list_tv_limited_now);
            tvTotal = itemView.findViewById(R.id.item_main_list_tv_total);

            // 뷰 객체에 대한 참조. (hold strong reference)

        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    ItemRvAdapter(ArrayList<Itemmainlist> list) {
        mData = list;
    }

    @NonNull
    @Override
    public ItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_main_list, parent, false);
        ItemRvAdapter.ViewHolder vh = new ItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRvAdapter.ViewHolder holder, int position) {

            holder.tvMoney.setText(mData.get(position).Money);
            holder.tvName.setText(mData.get(position).Name);
            holder.tvContent.setText(mData.get(position).getInfoText());
            holder.tvDelivery_money.setText(mData.get(position).getMoney());
            holder.tvDelivery_day.setText(mData.get(position).getDay());
//            holder.tvLimited.setText(mData.get(position).Limited);
//            holder.tvLimited_now.setText(mData.get(position).Limited_now);
//            holder.tvTotal.setText(mData.get(position).Total);

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}