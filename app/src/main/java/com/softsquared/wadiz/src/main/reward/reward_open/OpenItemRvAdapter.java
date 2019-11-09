package com.softsquared.wadiz.src.main.reward.reward_open;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;

import java.util.ArrayList;

public class OpenItemRvAdapter extends RecyclerView.Adapter<OpenItemRvAdapter.ViewHolder> {

    ArrayList<Openlist> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        TextView tvName;
        TextView tvCompany;
        TextView tvMonth;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            ivItem = itemView.findViewById(R.id.open_iv);
            tvName = itemView.findViewById(R.id.open_tv_name);
            tvCompany = itemView.findViewById(R.id.open_tv_company);
            tvMonth = itemView.findViewById(R.id.open_tv_month);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    OpenItemRvAdapter(ArrayList<Openlist> list) {
        mData = list;
    }

    @NonNull
    @Override
    public OpenItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.open_item, parent, false);
        OpenItemRvAdapter.ViewHolder vh = new OpenItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull OpenItemRvAdapter.ViewHolder holder, int position) {

            holder.ivItem.setImageResource(mData.get(position).Image);
            holder.tvName.setText(mData.get(position).Name);
            holder.tvCompany.setText(mData.get(position).Company);
            holder.tvMonth.setText(mData.get(position).Month);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}