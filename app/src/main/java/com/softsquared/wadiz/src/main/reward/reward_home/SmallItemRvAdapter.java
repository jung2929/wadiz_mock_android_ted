package com.softsquared.wadiz.src.main.reward.reward_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;

import java.util.ArrayList;

public class SmallItemRvAdapter extends RecyclerView.Adapter<SmallItemRvAdapter.ViewHolder> {

    ArrayList<Itemlist> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        TextView tvName;
        TextView tvCompany;
        TextView tvPercent;
        TextView tvMoney;
        TextView tvDay;
        TextView tvCategory;
        ProgressBar pb;

        ViewHolder(View itemView) {
            super(itemView);


            // 뷰 객체에 대한 참조. (hold strong reference)
            ivItem = itemView.findViewById(R.id.item_iv);
            tvName = itemView.findViewById(R.id.item_tv_name);
            tvCompany = itemView.findViewById(R.id.item_tv_company);
            tvPercent = itemView.findViewById(R.id.item_tv_percent);
            tvMoney = itemView.findViewById(R.id.item_tv_money);
            tvDay = itemView.findViewById(R.id.item_tv_day);
            tvCategory = itemView.findViewById(R.id.item_tv_category);
            pb = itemView.findViewById(R.id.item_progress);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    SmallItemRvAdapter(ArrayList<Itemlist> list) {
        mData = list;
    }

    @NonNull
    @Override
    public SmallItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.smalllist_item, parent, false);
        SmallItemRvAdapter.ViewHolder vh = new SmallItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SmallItemRvAdapter.ViewHolder holder, int position) {

            holder.ivItem.setImageResource(mData.get(position).Image);
            holder.tvName.setText(mData.get(position).Name);
            holder.tvCompany.setText(mData.get(position).Company);
            holder.tvPercent.setText(mData.get(position).Percent);
            holder.tvCategory.setText(mData.get(position).Category);
            holder.tvMoney.setText(mData.get(position).Money);
            holder.tvDay.setText(mData.get(position).Day);


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }
}