package com.softsquared.wadiz.src.category.categoryFragment.Adapters;

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
import com.softsquared.wadiz.src.category.categoryFragment.models.Itemlist;

import java.util.ArrayList;

public class BigItemRvAdapter extends RecyclerView.Adapter<BigItemRvAdapter.ViewHolder> {

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
    public BigItemRvAdapter(ArrayList<Itemlist> list) {
        mData = list;
    }

    @NonNull
    @Override
    public BigItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.biglist_item, parent, false);
        BigItemRvAdapter.ViewHolder vh = new BigItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BigItemRvAdapter.ViewHolder holder, int position) {

            holder.ivItem.setImageResource(mData.get(position).getImage());
            holder.tvName.setText(mData.get(position).getName());
            holder.tvCompany.setText(mData.get(position).getCompany());
            holder.tvPercent.setText(mData.get(position).getPercent());
            holder.tvCategory.setText(mData.get(position).getCategory());
            holder.tvMoney.setText(mData.get(position).getMoney());
            holder.tvDay.setText(mData.get(position).getDay());

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}